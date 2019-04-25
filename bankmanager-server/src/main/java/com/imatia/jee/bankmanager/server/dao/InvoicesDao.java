package com.imatia.jee.bankmanager.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "InvoicesDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/InvoicesDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class InvoicesDao extends OntimizeJdbcDaoSupport {
	
	public static final String ATTR_ID = "INVOICESID";
	public static final String ATTR_CUSTOMERID = "CUSTOMERID";
	public static final String ATTR_INVOICE_NAME = "INVOICE_NAME";
	public static final String ATTR_AMOUNT = "AMOUNT";
	public static final String ATTR_INVOICE_FILE = "INVOICE_FILE";
	
	public InvoicesDao() {

		super();
	}
	
	@Override
	public EntityResult query(Map<?, ?> keysValues, List<?> attributes, List<?> sort, String queryId) {
		// TODO Auto-generated method stub
		return super.query(keysValues, attributes, sort, queryId);
	}
	
	@Override
	public <T> List<T> query(Map<?, ?> keysValues, List<?> sort, String queryId, Class<T> clazz) {
		// TODO Auto-generated method stub
		return super.query(keysValues, sort, queryId, clazz);
	}
}