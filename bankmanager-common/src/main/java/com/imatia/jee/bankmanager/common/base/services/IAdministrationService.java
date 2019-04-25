package com.imatia.jee.bankmanager.common.base.services;

import java.util.List;
import java.util.Map;

import com.imatia.jee.bankmanager.common.base.constants.entities.Test;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IAdministrationService {

	String getServerPermissionsSql();

	Test test(String who);
	
	public EntityResult userRoleQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;
	
}
