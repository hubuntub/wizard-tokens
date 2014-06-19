package com.mycompany.example.client.wizard;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.shared.BusinessObject;

public class BusinessObjectStep  implements WizardStep<BusinessObject> {

	private TextBox searchInput = new TextBox();

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
		mainPanel.setWidth("100%");
		searchInput.setWidth("200px");
		searchInput.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(final KeyUpEvent event) {
//				MDMEventBus.BUS.fireEvent(new GlobalSearchEvent());
			}
		});


		mainPanel.add(searchInput);

		return mainPanel;
	}

	@Override
	public Widget getContentNextStep() {
		HorizontalPanel mainPanel = new HorizontalPanel();
		mainPanel.setWidth("100%");
		
		final Label label = new Label(searchInput.getText());
		mainPanel.add(label);
		return mainPanel;
	}

	@Override
	public BusinessObject getObject() {
		// TODO Auto-generated method stub
		return null;
	}

}

