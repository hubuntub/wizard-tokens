package com.mycompany.example.client.tokens;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class TokenLayout extends Composite {

	FlowPanel flowPanel = new FlowPanel();

	public TokenLayout() {
		flowPanel.setWidth("100%");
		flowPanel.setHeight("50px");
		initWidget(flowPanel);
	}

	public void addToken(TokenField tokenField) {
		if (!tokenField.isAttached()) {
			flowPanel.add(tokenField);
		}
	}

	public void removeToken(TokenField tokenField) {
		flowPanel.remove(tokenField);
	}
}
