package com.imatia.jee.bankmanager.server.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.jee.bankmanager.common.base.services.IInvoices;
import com.imatia.jee.bankmanager.server.dao.InvoicesDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("InvoicesService")
public class InvoicesService implements IInvoices {
	
	public static final String INVOICE_KEY_ATT = InvoicesDao.ATTR_ID;
	private static final Logger logger = LoggerFactory.getLogger(InvoicesService.class);
	
	@Autowired
	private InvoicesDao invoicesDao;
	
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	// ---- GASTOS ----
	
	@Override
	public EntityResult invoicesQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.invoicesDao, keysValues, attributes);
	}
	
	@Override
	public EntityResult invoicesInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.invoicesDao, attributes);
	}
	
	@Override
	public EntityResult invoicesUpdate(Map<String, Object> attributes, Map<String, Object> keyValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.invoicesDao, attributes, keyValues);
	}
	
	@Override
	public EntityResult invoicesDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.invoicesDao, keyValues);
	}



}
