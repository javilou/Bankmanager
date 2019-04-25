package com.imatia.jee.bankmanager.common.base.services;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

/**
 * The Interface UserRoleService.
 */
public interface IUserAndRoleService {

	/**
	 * Users query.
	 *
	 * @param keysValues
	 *            the keys values
	 * @param attributes
	 *            the attributes
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult userQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * Users update.
	 *
	 * @param attributesValues
	 *            the attributes values
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult userUpdate(Map<?, ?> attributesValues, Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Users delete.
	 *
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult userDelete(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Users insert.
	 *
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */

	EntityResult userInsert(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Role query.
	 *
	 * @param keysValues
	 *            the keys values
	 * @param attributes
	 *            the attributes
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult roleQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * Role update.
	 *
	 * @param attributesValues
	 *            the attributes values
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult roleUpdate(Map<?, ?> attributesValues, Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Role delete.
	 *
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult roleDelete(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Role insert.
	 *
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult roleInsert(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * User roles query.
	 *
	 * @param keysValues
	 *            the keys values
	 * @param attributes
	 *            the attributes
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult rolesForUserQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * User role update.
	 *
	 * @param attributesValues
	 *            the attributes values
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult rolesForUserUpdate(Map<?, ?> attributesValues, Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException;

	/**
	 * Server role query.
	 *
	 * @param keysValues
	 *            the keys values
	 * @param attributes
	 *            the attributes
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult serverRoleQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * Server role update.
	 *
	 * @param attributesValues
	 *            the attributes values
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws Exception
	 *             the exception
	 */
	EntityResult serverRoleUpdate(Map<?, ?> attributesValues, Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Search users query.
	 *
	 * @param keysValues
	 *            the keys values
	 * @param attributes
	 *            the attributes
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult searchUsersQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * Search users update.
	 *
	 * @param attributes
	 *            the attributes
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult searchUsersUpdate(Map<?, ?> attributes, Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Search users delete.
	 *
	 * @param keysValues
	 *            the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException
	 *             the ontimize jee exception
	 */
	EntityResult searchUsersDelete(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

}