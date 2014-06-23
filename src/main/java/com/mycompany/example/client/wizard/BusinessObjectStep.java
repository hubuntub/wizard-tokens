package com.mycompany.example.client.wizard;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.shared.BusinessObject;

public class BusinessObjectStep extends WizardStep<BusinessObject> {


	@Override
	public boolean nextStep() {
		if (!"".equals(searchInput.getText())){
			return true;
		}
		return false;
	}

	@Override
	public boolean previousStep() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDesciptionStep() {
		return "selectCategory";
	}

	@Override
	public Widget getContentStep() {
		HorizontalPanel mainPanel = new HorizontalPanel();
		Label label = new Label("business");
		mainPanel.add(label);
		mainPanel.setWidth("100%");
		searchInput.setWidth("200px");


		mainPanel.add(searchInput);

		return mainPanel;
	}

	@Override
	public BusinessObject getObject() {
		// TODO Auto-generated method stub
		return null;
	}

}

