package com.imatia.jee.bankmanager.client.managers.accounts;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imatia.jee.bankmanager.client.utils.BasicInteractionManagerExpanded;
import com.ontimize.annotation.FormComponent;
import com.ontimize.gui.Form;
import com.ontimize.gui.field.MaskDataField;
import com.ontimize.gui.field.ReferenceExtDataField;
import com.ontimize.gui.manager.IFormManager;

public class IMAccounts extends BasicInteractionManagerExpanded {

	private static final Logger logger = LoggerFactory.getLogger(IMAccounts.class);

	@FormComponent(attr = "OFFICEID")
	protected MaskDataField officeMask;
	@FormComponent(attr = "ENTITYID")
	protected MaskDataField entityMask;
	@FormComponent(attr = "OFFICEID_COMBO")
	protected ReferenceExtDataField officeCombo;

	@Override
	public void registerInteractionManager(Form form, IFormManager formManager) {
		super.registerInteractionManager(form, formManager);
		managedForm.getDataComponentList().remove("OFFICEID_COMBO");
	}

	@Override
	public void setInsertMode() {
		super.setInsertMode();
		if (officeCombo != null) {
			officeCombo.setEnabled(true);
			officeCombo.setRequired(true);
			officeCombo.setVisible(true);
		}
	}

	@Override
	public void setQueryInsertMode() {
		super.setQueryInsertMode();
		if (officeCombo != null) {
			officeCombo.setEnabled(false);
			officeCombo.setVisible(false);
		}
	}

	@Override
	public void setQueryMode() {
		super.setQueryMode();
		if (officeCombo != null) {
			officeCombo.setEnabled(false);
			officeCombo.setVisible(false);
		}
	}

	@Override
	public void setUpdateMode() {
		super.setUpdateMode();
		if (officeCombo != null) {
			officeCombo.setEnabled(false);
			officeCombo.setVisible(false);
		}

	}

	@Override
	public boolean checkInsert() {
		if (officeCombo != null && officeMask != null) {
			if (!officeCombo.isEmpty()) {
				this.setValueChangeEventListenerEnabled(false);
				entityMask.setValue(2095);
				officeMask.setValue(officeCombo.getValue());
				officeCombo.deleteData();
				officeCombo.setRequired(false);
				this.setValueChangeEventListenerEnabled(true);
			} else {
				this.managedForm.setStatusBarText("SELECT_BRANCH_FOR_NEW_ACCOUNT", 1500, true);
				return false;
			}
		}
		return super.checkInsert();
	}
}