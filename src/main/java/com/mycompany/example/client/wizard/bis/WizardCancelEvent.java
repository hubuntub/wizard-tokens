package com.mycompany.example.client.wizard.bis;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event.Type;

public class WizardCancelEvent extends GwtEvent<WizardCancelHandler> {
	public static final Type<WizardCancelHandler> TYPE = new Type<WizardCancelHandler>();
	private Step step;

	public WizardCancelEvent(Step step) {
		this.step = step;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<WizardCancelHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(WizardCancelHandler handler) {
		handler.cancel(this);
	}

	public Step getStep() {
		return step;
	}

}
