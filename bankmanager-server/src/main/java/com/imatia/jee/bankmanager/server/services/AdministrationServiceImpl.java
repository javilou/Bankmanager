package com.imatia.jee.bankmanager.server.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontimize.db.EntityResult;
import com.imatia.jee.bankmanager.common.base.constants.entities.Test;
import com.imatia.jee.bankmanager.common.base.services.IAdministrationService;
import com.imatia.jee.bankmanager.server.UserRoleDao;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.security.PermissionsProviderSecured;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("AdministrationService")
@Transactional(rollbackFor = Exception.class)
public class AdministrationServiceImpl implements IAdministrationService {

	private static final String INSERT_INTO_TROLE_SERVER_PERMISSION = "insert into TROLE_SERVER_PERMISSION (id_role,id_server_permission) select 1 as id_role,id_server_permission from TSERVER_PERMISSION;";
	private static final String DELETE_FROM_TSERVER_PERMISSION = "delete from TSERVER_PERMISSION;";
	private static final String DELETE_FROM_TROLE_SERVER_PERMISSION = "delete from TROLE_SERVER_PERMISSION;";
	private static final String INSERT_INTO_TSERVER_PERMISSION = "insert into TSERVER_PERMISSION(permission_name) values('%s');";
	private static final String COM_ONTIMIZE = "com.ontimize";
	private static final String SERVICE2_CLASS = "Service2.class";
	private static final String SERVICE_CLASS = "Service.class";
	private static final String COM_IMATIA = "com.imatia";
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationServiceImpl.class);

	@Autowired
	protected UserRoleDao userRoleDao;
	
	/** The DAO helper. */
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	@Override
	public EntityResult userRoleQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException {
		return this.userRoleDao.query(keysValues, attributes, (List<?>) null, UserRoleDao.ROLES_WITH_USER_QUERY);
	}
	
	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public String getServerPermissionsSql() {
		StringBuffer sql = new StringBuffer();

//		List<List<String>> find = ClassPathSeeker.find(new IClassPathEntryChecker<List<String>>() {
//
//			@Override
//			public List<String> check(String pckgName, String file) {
//
//				List<String> res = new ArrayList<>();
//
//				if (pckgName.startsWith(AdministrationServiceImpl.COM_IMATIA) || pckgName.startsWith(AdministrationServiceImpl.COM_ONTIMIZE)) {
//
//					if (file.startsWith(ApplicationConstants.SLASH)) {
//
//						file = file.substring(1);
//					}
//
//					if (file.endsWith(AdministrationServiceImpl.SERVICE_CLASS) || file.endsWith(AdministrationServiceImpl.SERVICE2_CLASS)) {
//
//						try {
//
//							String className = file.substring(ApplicationConstants.ZERO, file.length() - ApplicationConstants.SIX);
//							String fullClassName = pckgName + ApplicationConstants.POINT + className;
//							Class<?> cl = Class.forName(fullClassName);
//
//							if (cl.isInterface()) {
//
//								Method[] declaredMethods = cl.getDeclaredMethods();
//								String string;
//
//								for (Method method : declaredMethods) {
//
//									string = fullClassName + ApplicationConstants.SLASH + method.getName();
//
//									if (!res.contains(string)) {
//
//										res.add(string);
//									}
//								}
//							}
//						} catch (ClassNotFoundException e) {
//
//							AdministrationServiceImpl.LOGGER.info(e.getMessage(), e);
//						}
//					}
//				}
//
//				return res.isEmpty() ? null : res;
//			}
//		});
//
//		String template = AdministrationServiceImpl.INSERT_INTO_TSERVER_PERMISSION;
//
//		sql.append(AdministrationServiceImpl.DELETE_FROM_TROLE_SERVER_PERMISSION);
//		sql.append(ApplicationConstants.NEW_LINE);
//		sql.append(AdministrationServiceImpl.DELETE_FROM_TSERVER_PERMISSION);
//		sql.append(ApplicationConstants.NEW_LINE);
//
//		for (List<String> ls : find) {
//
//			for (String s : ls) {
//
//				sql.append(String.format(template, s));
//				sql.append(ApplicationConstants.NEW_LINE);
//			}
//		}
//
//		sql.append(AdministrationServiceImpl.INSERT_INTO_TROLE_SERVER_PERMISSION);
//
		return sql.toString();
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public Test test(String who) {

		return new Test(who);
	}
}