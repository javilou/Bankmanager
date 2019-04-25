package com.imatia.jee.bankmanager.common.base.services;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ICustomerService {

	// ---- CUSTOMER ----

	public EntityResult customerQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	public EntityResult customerInsert(Map<?, ?> attributes) throws OntimizeJEERuntimeException;

	public EntityResult customerUpdate(Map<?, ?> attributes, Map<?, ?> KeyValues) throws OntimizeJEERuntimeException;

	public EntityResult customerDelete(Map<?, ?> keyValues) throws OntimizeJEERuntimeException;

	// ---- CUSTOMER TYPE ----

	public EntityResult customerTypeQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	public EntityResult customerTypeInsert(Map<?, ?> attributes) throws OntimizeJEERuntimeException;

	public EntityResult customerTypeUpdate(Map<?, ?> attributes, Map<?, ?> KeyValues)
			throws OntimizeJEERuntimeException;

	public EntityResult customerTypeDelete(Map<?, ?> keyValues) throws OntimizeJEERuntimeException;

	// ---- CUSTOMER ACCOUNT ----

	public EntityResult customerAccountQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException;

	public EntityResult customerAccountInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException;

	public EntityResult customerAccountUpdate(Map<String, Object> attributes, Map<String, Object> KeyValues)
			throws OntimizeJEERuntimeException;

	public EntityResult customerAccountDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException;

	// ---- VCUSTOMERACCOUNT ----

	public EntityResult vCustomerAccountQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException;

	public EntityResult vCustomerAccountDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException;
	
}