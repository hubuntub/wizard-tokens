package com.mycompany.example.client.wizard;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event.Type;

public class WizardCancelEvent extends GwtEvent<WizardCancelHandler> {
	public static final Type<WizardCancelHandler> TYPE = new Type<WizardCancelHandler>();
	private WizardStep step;

	public WizardCancelEvent(WizardStep step) {
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

	public WizardStep getStep() {
		return step;
	}

}
