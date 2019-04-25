package com.imatia.jee.bankmanager.server.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.jee.bankmanager.common.base.services.IMovementService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/movements")
public class MovementRestController extends ORestController<IMovementService> {

	@Autowired
	private IMovementService movementService;

	@Override
	public IMovementService getService() {
		return this.movementService;
	}
}