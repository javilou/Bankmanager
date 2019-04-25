package com.imatia.jee.bankmanager.server.services.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Types;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ontimize.jee.server.rest.InsertParameter;
import com.ontimize.jee.server.rest.ORestController;
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
	public ResponseEntity<EntityResult> update(@PathVariable("name") String name, @RequestBody UpdateParameter updateParameter) {

		if (updateParameter.getFilter().containsKey(InvoicesService.INVOICE_KEY_ATT) 
				&& updateParameter.getFilter().get(InvoicesService.INVOICE_KEY_ATT)!=null) {
			updateParameter.getSqltypes().put("AMOUNT", Types.DOUBLE);
			return super.update(name, updateParameter);
		} else {
			InsertParameter insertParam = new InsertParameter();
			insertParam.setData(updateParameter.getData());
			insertParam.setSqltypes(updateParameter.getSqltypes());
			return super.insert(name, insertParam);
		}
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
		
			File ruta = new File("C:\\FileTemp");
			
		for (int i = 0; i < files.length; i++) {
			InputStream fileContent = files[i].getInputStream();
			System.out.println("Nombre original del archivo: " + files[i].getOriginalFilename());
			System.out.println("Tamaño del archivo: " + files[i].getSize());
			System.out.println("Numero de archivos: " + files.length);
			
			File file = new File(ruta, files[i].getOriginalFilename());
			Files.copy(fileContent, file.toPath());
			
		}
		return ResponseEntity.ok("-----SE SUBIO EL ARCIHVO-----");
	}
}
