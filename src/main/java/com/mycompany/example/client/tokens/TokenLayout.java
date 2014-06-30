package com.mycompany.example.client.tokens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.mycompany.example.client.tokens.TokenField.Color;
import com.mycompany.example.client.wizard.WizardCancelEvent;
import com.mycompany.example.client.wizard.WizardStep;
import com.mycompany.example.shared.MyCompanyEvent;

public class TokenLayout extends Composite {

	FlowPanel flowPanel = new FlowPanel();
	private Map<WizardStep,TokenField> wizardsByToken = new LinkedHashMap<>();
	public TokenLayout() {
		flowPanel.setWidth("100%");
		flowPanel.setHeight("50px");
		initWidget(flowPanel);
	}

	public void addToken(final WizardStep wizardStep) {
		Color color = wizardStep.getColor();
		String content =  wizardStep.getContent();
		TokenField tokenField = new TokenField(content, color);
		wizardsByToken.put(wizardStep, tokenField);
		tokenField.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MyCompanyEvent.BUS.fireEvent(new WizardCancelEvent(wizardStep));

			}
		});
		if (!tokenField.isAttached()) {
			flowPanel.add(tokenField);
		}
	}

	
	public void removeToken(final WizardStep wizardStep) {
		flowPanel.clear();
		
		
		removeTokensAfter(wizardStep);
		for(TokenField tokenField : wizardsByToken.values()){
			if (!tokenField.isAttached()) {
				flowPanel.add(tokenField);
			}
		}
	}

	private void removeTokensAfter(WizardStep wizardStep) {
		Iterator<Entry<WizardStep, TokenField>> iter = wizardsByToken.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<WizardStep, TokenField> entry = iter.next();
			if (wizardStep.equals(entry.getKey())) {
				iter.remove();
				break;
			} 
		}
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
		}
	}
}
