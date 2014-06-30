package com.mycompany.example.client.wizard;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.client.tokens.TokenField.Color;
import com.mycompany.example.shared.DocType;

public class DocTypeStep extends WizardStep<DocType> {


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


	

		mainPanel.add(searchInput);

		return mainPanel;
	}



	@Override
	public DocType getObject() {
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.RED;
	}

}
