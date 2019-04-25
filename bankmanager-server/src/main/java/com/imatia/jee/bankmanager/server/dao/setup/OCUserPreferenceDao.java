package com.imatia.jee.bankmanager.server.dao.setup;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "OCUserPreferenceDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/setup/OCUserPreferenceDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class OCUserPreferenceDao extends OntimizeJdbcDaoSupport {

	public OCUserPreferenceDao() {

		super();
	}
}
