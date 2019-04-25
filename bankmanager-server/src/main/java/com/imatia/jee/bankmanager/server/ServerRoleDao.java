package com.imatia.jee.bankmanager.server;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "ServerRoleDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/ServerRoleDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class ServerRoleDao extends OntimizeJdbcDaoSupport {

	// Queries
	public static final String ID_SERVER_ROLE_ALL_QUERY = "id_serverRole_all";
	public static final String ID_SERVER_ROLE_QUERY = "id_serverRole";

	public ServerRoleDao() {

		super();
	}
}
