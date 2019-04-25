package com.imatia.jee.bankmanager.common.base.services;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IInvoices {
	
	// ---- GASTOS ----
		public EntityResult invoicesQuery(Map<String, Object> keysValues, List<String> attributes)
				throws OntimizeJEERuntimeException;

		public EntityResult invoicesInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException;

		public EntityResult invoicesUpdate(Map<String, Object> attributes, Map<String, Object> keyValues)
				throws OntimizeJEERuntimeException;

		public EntityResult invoicesDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException;

}
