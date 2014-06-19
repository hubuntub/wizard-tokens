package com.mycompany.example.client.wizard;

import com.google.gwt.user.client.ui.Widget;

public interface WizardStep<T> {
	/**
	 * 
	 * @return True if we can move to the next step
	 */
	boolean nextStep();
	/**
	 * @return True if we can move back to the previous step
	 */
	boolean previousStep();
	/**
	 * 
	 * @return the description above the step
	 */
	String getDesciptionStep();
	/**
	 * 
	 * @return the widget showed in the step
	 */
	Widget getContentStep();
	/**
	 * 
	 * @return the widget showed when we hit the next step
	 */
	Widget getContentNextStep();
	
	/**
	 * 
	 * @return the Object (BO, DocType ...)
	 */
	T getObject();
}
