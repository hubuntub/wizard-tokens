package com.mycompany.example.client.wizard;

import com.google.gwt.event.dom.client.KeyCodeEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.client.tokens.TokenField;
import com.mycompany.example.shared.MyCompanyEvent;

public abstract class WizardStep<T> {
	protected TextBox searchInput = new TextBox();

	public Widget getAllWidget() {
		searchInput.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					MyCompanyEvent.BUS.fireEvent(new WizardAdvanceEvent(WizardStep.this));
				}
			}

		});
		return getContentStep();
	}

	/**
	 * 
	 * @return True if we can move to the next step
	 */
	abstract boolean nextStep();

	/**
	 * @return True if we can move back to the previous step
	 */
	abstract boolean previousStep();

	/**
	 * 
	 * @return the description above the step
	 */
	abstract String getDesciptionStep();

	/**
	 * 
	 * @return the widget showed in the step
	 */
	abstract Widget getContentStep();

	/**
	 * 
	 * @return the Object (BO, DocType ...)
	 */
	abstract T getObject();

	public TokenField getTokenField() {
		return new TokenField(searchInput.getText());
	}
}
