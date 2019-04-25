package com.imatia.jee.bankmanager.server.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "CustomerAccountDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/CustomerAccountDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class CustomerAccountDao extends OntimizeJdbcDaoSupport {

	public static final String QUERY_VCUSTOMERACCOUNT = "CUSTOMERACCOUNT";
	
	public CustomerAccountDao() {
		super();
	}
}
