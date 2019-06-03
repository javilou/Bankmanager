package com.imatia.jee.bankmanager.server.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "InvoicesTypeDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/InvoicesTypeDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class InvoicesTypeDao extends OntimizeJdbcDaoSupport {
	
	public static final String ATTR_ID = "INVOICESTYPEID";
	public static final String ATTR_INVOICESTYPENAME = "INVOICESTYPENAME";
	public static final String ATTR_INVOICESTYPEDESC = "INVOICESTYPEDESC";
	
	public InvoicesTypeDao() {
		
		super();
	}
	
}
