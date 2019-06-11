package com.imatia.jee.bankmanager.server.services.rest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imatia.jee.bankmanager.common.base.services.IInvoices;
import com.imatia.jee.bankmanager.server.services.InvoicesService;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.tools.CheckingTools;
import com.ontimize.jee.common.tools.ReflectionTools;
import com.ontimize.jee.server.rest.InsertParameter;
import com.ontimize.jee.server.rest.ORestController;
import com.ontimize.jee.server.rest.QueryParameter;
import com.ontimize.jee.server.rest.UpdateParameter;

@RestController
@RequestMapping("/invoices")
public class InvoicesRestController extends ORestController<IInvoices> {

	@Autowired
	private IInvoices invoices;

	@Override
	public IInvoices getService() {
		return this.invoices;
	}

	@Override
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntityResult> update(@PathVariable("name") String name,
			@RequestBody UpdateParameter updateParameter) {

		if (updateParameter.getFilter().containsKey(InvoicesService.INVOICE_KEY_ATT)
				&& updateParameter.getFilter().get(InvoicesService.INVOICE_KEY_ATT) != null) {
			updateParameter.getSqltypes().put("AMOUNT", Types.DOUBLE);
			return super.update(name, updateParameter);
		} else {
			InsertParameter insertParam = new InsertParameter();
			insertParam.setData(updateParameter.getData());
			insertParam.setSqltypes(updateParameter.getSqltypes());
			return super.insert(name, insertParam);

		}
	}
	
	@Override
	@RequestMapping(value = "/{name}/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntityResult> query(@PathVariable("name") String name, @RequestBody QueryParameter queryParameter) throws Exception {
		queryParameter.getSqltypes().put("INVOICESID", Types.INTEGER);
		return super.query(name, queryParameter);
	}

	@PostMapping(value = "upload")
	public ResponseEntity<String> upload(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files, @RequestParam(name = "data", required = false) String data)
			throws JsonParseException, JsonMappingException, IOException {

		HashMap<String, Object> extraData = new HashMap<>();

		if (data != null) {
			extraData = new ObjectMapper().readValue(data, HashMap.class);
		}
		
		System.out.println("----- SE RECIBIO EL ARCHIVO -----");
		

//		File ruta = new File("C:\\FileTemp");
//
//		for (int i = 0; i < files.length; i++) {
//			InputStream fileContent = files[i].getInputStream();
//			System.out.println("Nombre original del archivo: " + files[i].getOriginalFilename());
//			System.out.println("Tamaño del archivo: " + files[i].getSize());
//			System.out.println("Numero de archivos: " + files.length);
//
//			File file = new File(ruta, files[i].getOriginalFilename());
//			Files.copy(fileContent, file.toPath());
//		}

		// Implementacion de la factory
		SessionFactory factory = SessionFactoryImpl.newInstance();
		HashMap<String, String> parameter = new HashMap<String, String>();

		// Credenciales Usuario
		parameter.put(SessionParameter.USER, "admin");
		parameter.put(SessionParameter.PASSWORD, "root");

		// Ajustes Conexion
		parameter.put(SessionParameter.ATOMPUB_URL,
				"http://127.0.0.1:8079/alfresco/api/-default-/public/cmis/versions/1.1/atom");
		parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());

		// Crear Sesion
		Session session = factory.getRepositories(parameter).get(0).createSession();
		Folder root = session.getRootFolder();

		// Propiedades
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
		properties.put(PropertyIds.NAME,"Documentos subidos con id");

		Folder parent = root.createFolder(properties);
		String name = files[0].getOriginalFilename();

		// Propiedades
		Map<String, Object> properties1 = new HashMap<String, Object>();
		properties1.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
		properties1.put(PropertyIds.NAME, name);

		// content
		InputStream fileContent = files[0].getInputStream(); 
		byte[] content = IOUtils.toByteArray(fileContent);
		ByteArrayInputStream stream = new ByteArrayInputStream(content);
		ContentStream contentStream = new ContentStreamImpl(name, BigInteger.valueOf(content.length), "text/plain",
				stream);

		Document newDoc = parent.createDocument(properties1, contentStream, VersioningState.MAJOR);
		String idFichero=newDoc.getId();
		String urlFichero=newDoc.getContentUrl();
		Map<String,Object>attributes=new HashMap<String,Object>();
		Map<String,Object>keyValues=new HashMap<String,Object>();
		attributes.put("INVOICE_FILE_URL", urlFichero);
		keyValues.put( "INVOICESID",extraData.get("invoiceId"));
		this.invoices.invoicesUpdate(attributes, keyValues);
	
		return ResponseEntity.ok("-----SE SUBIO EL ARCIHVO-----");
	}
	
}
