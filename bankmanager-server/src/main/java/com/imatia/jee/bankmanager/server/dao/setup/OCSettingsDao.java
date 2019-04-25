package com.imatia.jee.bankmanager.server.dao.setup;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "OCSettingsDao")
@Lazy
@ConfigurationFile(configurationFile = "base-dao/setup/OCSettingsDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class OCSettingsDao extends OntimizeJdbcDaoSupport {

	public OCSettingsDao() {

		super();
	}
}
