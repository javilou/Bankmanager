package com.imatia.jee.bankmanager.client;

import java.util.Hashtable;

import com.ontimize.gui.ClientWatch;
import com.ontimize.jee.desktopclient.locator.OJeeClientPermissionLocator;

public class ClientReferenceLocator extends OJeeClientPermissionLocator {

	public ClientReferenceLocator(Hashtable params) {
		super(params);
	}

	@Override
	public int startSession(String user, String password, ClientWatch cw) throws Exception {
		int sesId = super.startSession(user, password, cw);
		return sesId;
	}

}
