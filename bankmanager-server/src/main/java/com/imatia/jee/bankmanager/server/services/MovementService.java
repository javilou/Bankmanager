package com.imatia.jee.bankmanager.server.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.jee.bankmanager.common.base.services.IMovementService;
import com.imatia.jee.bankmanager.server.dao.MovementDao;
import com.imatia.jee.bankmanager.server.dao.MovementTypeDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("MovementService")
public class MovementService implements IMovementService {

	private static final Logger logger = LoggerFactory.getLogger(MovementService.class);

	@Autowired
	private MovementDao movementDao;

	@Autowired
	private MovementTypeDao movementTypeDao;

	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	// ---- MOVEMENTS ----

	@Override
	public EntityResult movementQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.movementDao, keysValues, attributes);
	}

	@Override
	public EntityResult movementInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.movementDao, attributes);
	}

	@Override
	public EntityResult movementUpdate(Map<String, Object> attributes, Map<String, Object> keyValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.movementDao, attributes, keyValues);
	}

	@Override
	public EntityResult movementDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.movementDao, keyValues);
	}

	// ---- MOVEMENTTYPE ----

	@Override
	public EntityResult movementTypeQuery(Map<String, Object> keysValues, List<String> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.movementTypeDao, keysValues, attributes);
	}

	@Override
	public EntityResult movementTypeInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.movementTypeDao, attributes);
	}

	@Override
	public EntityResult movementTypeUpdate(Map<String, Object> attributes, Map<String, Object> keyValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.movementTypeDao, attributes, keyValues);
	}

	@Override
	public EntityResult movementTypeDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.movementTypeDao, keyValues);
	}
}