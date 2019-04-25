package com.imatia.jee.bankmanager.server.dao.setup;

import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import com.ontimize.jee.server.services.management.dao.IRequestStatisticsDao;

//@Repository(value = "OCRequestStatisticsDao")
//@Lazy
//@ConfigurationFile(configurationFile = "base-dao/setup/OCRequestStatisticsDao.xml", configurationFilePlaceholder = "base-dao/placeholders.properties")
public class OCRequestStatisticsDao extends OntimizeJdbcDaoSupport implements IRequestStatisticsDao {

	public OCRequestStatisticsDao() {

		super();
	}
}