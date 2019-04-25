package com.imatia.jee.bankmanager.server;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "RoleDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/RoleDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class RoleDao extends OntimizeJdbcDaoSupport {

	public RoleDao() {

		super();
	}
}