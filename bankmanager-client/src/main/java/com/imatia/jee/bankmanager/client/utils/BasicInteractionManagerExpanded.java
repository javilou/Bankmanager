package com.imatia.jee.bankmanager.client.utils;

import com.ontimize.gui.BasicInteractionManager;
import com.ontimize.gui.Form;
import com.ontimize.gui.FormManager;
import com.ontimize.gui.manager.IFormManager;
import com.ontimize.gui.tree.Tree;

public class BasicInteractionManagerExpanded extends BasicInteractionManager {

	@Override
	public void registerInteractionManager(Form form, IFormManager formManager) {
		super.registerInteractionManager(form, formManager);
		try {
			Tree tree = ((FormManager) formManager).getTree();
			tree.expandRow(0);
		} catch (Exception e) {}
	}

}