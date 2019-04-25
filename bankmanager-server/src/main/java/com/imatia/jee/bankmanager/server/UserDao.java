package com.imatia.jee.bankmanager.server;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "UserDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/UserDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class UserDao extends OntimizeJdbcDaoSupport {

	public UserDao() {

		super();
	}
}
