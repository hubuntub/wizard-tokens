package com.mycompany.example.client.wizard.bis;

import java.util.List;

import com.google.gwt.thirdparty.guava.common.util.concurrent.ServiceManager;
import com.mycompany.example.client.tokens.TokenField;
import com.mycompany.example.shared.MyCompanyEventBus;

public class Wizard {

	List<Step> steps;
	ServiceManager serviceManager;

	public Wizard() {
		MyCompanyEventBus.BUS.addHandler(WizardAdvanceEvent.TYPE,
				new WizardAdvanceHandler() {

					@Override
					public void advance(WizardAdvanceEvent event) {
						Step step = event.getStep();
						handleStepAndAdvance(step);
					}
				});
	}

	protected void handleStepAndAdvance(Step step) {
		StepType type = step.getType();
		String value = step.getValue();
		switch (type) {
		case DOC_TYPE:
			addToken(type.getColor(), value);
			createStep(StepType.BO_TYPE, new SelectTypeStep(serviceManager), value);
			break;
		case BO_TYPE:
			if (step instanceof SelectTypeStep) {
				createStep(StepType.BO_TYPE, new SelectValueStep(serviceManager), value);
			} else {
				addToken(type.getColor(), value);
				if (hasPrimaryBoType(value)) {
					createStep(StepType.PRIMARY_BO_TYPE, new SelectTypeStep(serviceManager),
							value);
				}
			}
			break;
		case PRIMARY_BO_TYPE:
			if (step instanceof SelectTypeStep) {
				createStep(StepType.PRIMARY_BO_TYPE, new SelectValueStep(serviceManager), value);
			} else {
				addToken(type.getColor(), value);
				// TODO what now ?
			}
			break;
		default:
			break;
		}
	}

	private boolean hasPrimaryBoType(String value) {
		// TODO Call services to check
		return false;
	}

	private void addToken(String color, String value) {
		// TODO Add a token to the token layout
		// Put most of the code in the token layout
	}

	// Start the wizard (first step)
	public void start() {
		Step firstStep = createStep(StepType.DOC_TYPE, new SelectValueStep(serviceManager), null);
		// TODO wire, display
	}

	private Step createStep(StepType docType, Step step, String value) {
		step.setType(docType);
		step.setPreviousValue(value);
		return step;
	}

}
