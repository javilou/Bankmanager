package com.imatia.jee.bankmanager.server;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "UserRoleDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/UserRoleDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class UserRoleDao extends OntimizeJdbcDaoSupport {

	// Queries
	public static final String ROLES_WITHOUT_USER_QUERY = "rolesWithoutUser";
	public static final String ROLES_WITH_USER_QUERY = "fullRolesWithUser";
	public static final String DEFAULT_QUERY = "default";

	public UserRoleDao() {

		super();
	}
}
