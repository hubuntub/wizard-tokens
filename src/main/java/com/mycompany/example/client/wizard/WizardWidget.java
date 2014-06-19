package com.mycompany.example.client.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class WizardWidget extends Composite implements
		WizardProgressHandler {

	private HandlerManager handlerManager;

	private static final String WIZARD_WIDGET = "wizard-widget";
	private VerticalPanel mainPanel = new VerticalPanel();
	protected List<WizardStep> steps = new ArrayList<WizardStep>();
	protected final Map<String, WizardStep> idMap = new HashMap<String, WizardStep>();

	protected WizardStep currentStep;
	private int indexStep = 0;

	public WizardWidget() {
		handlerManager = new HandlerManager(this);
		mainPanel.setHeight("100%");
		mainPanel.addStyleName(WIZARD_WIDGET);
		initWidget(mainPanel);

	}

	public void build() {
		 mainPanel.clear();
		int indexCurrenStep = steps.indexOf(currentStep);
		for (int i = 0; i < indexCurrenStep; i++) {
			WizardStep step = steps.get(i);
			mainPanel.add(nextOrCancelWidget(step, false));
		}
		mainPanel.add(nextOrCancelWidget(currentStep));

	}

	private Widget nextOrCancelWidget(WizardStep step) {
		return nextOrCancelWidget(step, true);
	}

	private Widget nextOrCancelWidget(final WizardStep step, boolean next) {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setWidth("100%");
		if (next) {
			Widget w = step.getContentStep();
			w.setWidth("100%");
			w.setHeight("100%");
			horizontalPanel.add(w);
		} else {
			Widget w = step.getContentNextStep();
			w.setWidth("100%");
			w.setHeight("100%");
			horizontalPanel.add(w);
		}
		if (next) {
			Button nextButton = new Button("next");
			nextButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					advanceStep(step);
					System.out.println(step);
				}
			});

			horizontalPanel.add(nextButton);
			horizontalPanel.setCellVerticalAlignment(nextButton,
					HasAlignment.ALIGN_TOP);
		}
		Button cancelButton = new Button("cancel");
		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				cancelStep(step);
				System.out.println(step);
			}
		});

		horizontalPanel.add(cancelButton);
		horizontalPanel.setSpacing(10);
		horizontalPanel.setCellVerticalAlignment(cancelButton,
				HasAlignment.ALIGN_TOP);

		return horizontalPanel;
	}

	public void addStep(WizardStep step) {
		addStep(step, "index-step" + indexStep++);

	}

	private void addStep(WizardStep step, String index) {
		if (idMap.containsKey(index)) {
			// throw an exception
		}
		steps.add(step);
		idMap.put(index, step);

		if (currentStep == null) {
			activeStep(step);
		}
	}

	private void activeStep(WizardStep step) {

		currentStep = step;

	}

	@Override
	public void wizardAdvance(WizardAdvanceEvent event) {
		advanceStep(event.getStep());

	}

	private void advanceStep(WizardStep step) {
		int index = steps.indexOf(step);
		String newIndex = "index-step" + ++index;
		if (index <= steps.size()) {

			WizardStep newStep = idMap.get(newIndex);
			if (newStep != null && idMap.containsValue(newStep)) {
				activeStep(newStep);
				build();
			}
		}
	}

	@Override
	public void wizardCancel(WizardCancelEvent event) {
		cancelStep(event.getStep());

	}

	private void cancelStep(WizardStep step) {
		int index = steps.indexOf(step);
		String newIndex = "index-step" + --index;
		WizardStep newStep = idMap.get(newIndex);
		if (index >= 0) {
			if (newStep != null && idMap.containsValue(newStep)) {
				activeStep(newStep);
				build();
			}
		}
	}

}