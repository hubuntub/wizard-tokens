package com.mycompany.example.client.wizard.bis;

public interface WizardProgressHandler {
	/**
	 * 
	 * @param event
	 */
	void wizardAdvance(WizardAdvanceEvent event);
	
	/**
	 * 
	 * @param event
	 */
	void wizardCancel(WizardCancelEvent event);
}
