package com.imatia.jee.bankmanager.server.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.jee.bankmanager.common.base.services.ICustomerService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/customers")
public class CustomerRestController extends ORestController<ICustomerService> {

	@Autowired
	private ICustomerService customerService;

	@Override
	public ICustomerService getService() {
		return this.customerService;
	}
}