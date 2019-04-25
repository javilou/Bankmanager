package com.imatia.jee.bankmanager.server.services.rest;

import java.sql.SQLType;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.jee.bankmanager.common.base.services.IInvoices;
import com.imatia.jee.bankmanager.common.base.services.IMovementService;
import com.imatia.jee.bankmanager.server.dao.InvoicesDao;
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
}
