package com.mycompany.example.client.wizard.bis;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class WizardAdvanceEvent  extends GwtEvent<WizardAdvanceHandler> {
	public static final Type<WizardAdvanceHandler> TYPE = new Type<WizardAdvanceHandler>();

	private Step step;
	public WizardAdvanceEvent(Step step){
		this.step = step;
	}
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<WizardAdvanceHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(WizardAdvanceHandler handler) {
		handler.advance(this);
	}
	public Step getStep() {
		return step;
	}

}