package com.imatia.jee.bankmanager.client.managers.customers;

import com.imatia.jee.bankmanager.client.utils.BasicInteractionManagerExpanded;
import com.ontimize.annotation.FormComponent;
import com.ontimize.gui.Form;
import com.ontimize.gui.manager.IFormManager;
import com.ontimize.gui.table.Table;

public class IMCustomerTable extends BasicInteractionManagerExpanded {

	@FormComponent(attr = "CustomerService.customer")
	protected Table customerTable;

	@Override
	public void registerInteractionManager(Form form, IFormManager formManager) {
		// TODO Auto-generated method stub
		super.registerInteractionManager(form, formManager);
	}

	@Override
	public void setQueryInsertMode() {
		super.setQueryInsertMode();
		if (this.customerTable != null) {
			this.customerTable.setEnabled(true);
			this.customerTable.refresh();
		}
	}
}