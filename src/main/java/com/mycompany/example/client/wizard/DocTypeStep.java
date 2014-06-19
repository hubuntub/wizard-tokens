package com.mycompany.example.client.wizard;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.shared.DocType;

public class DocTypeStep implements WizardStep<DocType> {

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
		return "select doctype";
	}

	@Override
	public Widget getContentStep() {
		HorizontalPanel mainPanel = new HorizontalPanel();
		Label label = new Label("doctype");
		mainPanel.add(label);
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
	
		
		final Label label = new Label("label nextStep");
		mainPanel.add(label);
		return mainPanel;
	}

	@Override
	public DocType getObject() {
		return null;
	}

}
