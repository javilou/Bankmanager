package com.imatia.jee.bankmanager.server.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.jee.bankmanager.common.base.services.IUserAndRoleService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/users")
public class UsersRestController extends ORestController<IUserAndRoleService> {

	private static final String LOGIN = "login";

	@Autowired
	private IUserAndRoleService iUserAndRoleService;

	@Override
	public IUserAndRoleService getService() {

		return this.iUserAndRoleService;
	}

	@RequestMapping(value = UsersRestController.LOGIN, method = RequestMethod.POST)
	public ResponseEntity<Void> login() {

		return ResponseEntity.ok().build();
	}
}