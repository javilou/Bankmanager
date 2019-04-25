package com.imatia.jee.bankmanager.server.services;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.jee.bankmanager.common.base.services.ICustomerService;
import com.imatia.jee.bankmanager.server.dao.CustomerAccountDao;
import com.imatia.jee.bankmanager.server.dao.CustomerDao;
import com.imatia.jee.bankmanager.server.dao.CustomerTypeDao;
import com.imatia.jee.bankmanager.server.dao.InvoicesDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.util.remote.BytesBlock;

@Service("CustomerService")
public class CustomerService implements ICustomerService {

	/** The user roles dao. */
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CustomerTypeDao customerTypeDao;

	/** The DAO helper. */
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Autowired
	private CustomerAccountDao customerAccountDao;
	
	@Autowired
	private InvoicesDao customerGastosDao;
	

	public Map<?, ?> adaptBase64ImageField(String field, Map<?, ?> attributes) {
		if (attributes.get(field) instanceof String) {
			String objectPhoto = (String) attributes.remove(field);
			Map<String, Object> mapAttr = new HashMap<>();
			mapAttr.putAll((Map<? extends String, ? extends Object>) attributes);
			mapAttr.put(field, Base64.getDecoder().decode(objectPhoto));
			return mapAttr;
		} else {
			return attributes;
		}
	}

	// ---- CUSTOMER ----

	@Override
	public EntityResult customerQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.customerDao, keysValues, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult customerInsert(Map<?, ?> attributes) throws OntimizeJEERuntimeException {
		attributes = this.adaptBase64ImageField(CustomerDao.ATTR_PHOTO, attributes);
		return this.daoHelper.insert(this.customerDao, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult customerUpdate(Map<?, ?> attributes, Map<?, ?> keyValues) throws OntimizeJEERuntimeException {

		attributes = this.adaptBase64ImageField(CustomerDao.ATTR_PHOTO, attributes);
		return this.daoHelper.update(this.customerDao, attributes, keyValues);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult customerDelete(Map<?, ?> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.customerDao, keyValues);
	}

	// ---- CUSTOMER TYPE ----

	@Override
	public EntityResult customerTypeQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.customerTypeDao, keysValues, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult customerTypeInsert(Map<?, ?> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.customerTypeDao, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult customerTypeUpdate(Map<?, ?> keyValues, Map<?, ?> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.customerTypeDao, keyValues, attributes);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EntityResult customerTypeDelete(Map<?, ?> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.customerTypeDao, keyValues);
	}

	// ---- CUSTOMER ACCOUNT ----

	@Override
	public EntityResult customerAccountQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.customerAccountDao, keysValues, attributes);
	}

	@Override
	public EntityResult customerAccountInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.customerAccountDao, attributes);
	}

	@Override
	public EntityResult customerAccountUpdate(Map<String, Object> attributes, Map<String, Object> KeyValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.customerAccountDao, attributes, attributes);
	}

	@Override
	public EntityResult customerAccountDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.customerAccountDao, keyValues);
	}

	// ---- CUSTOMER ACCOUNT BALANCE ----
	@Override
	public EntityResult vCustomerAccountQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.customerAccountDao, keysValues, attributes,
				CustomerAccountDao.QUERY_VCUSTOMERACCOUNT);
	}

	@Override
	public EntityResult vCustomerAccountDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.customerGastosDao, keyValues);
	}
	
}