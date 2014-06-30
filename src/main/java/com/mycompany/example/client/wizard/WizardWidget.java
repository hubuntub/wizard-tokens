<<<<<<< HEAD
package com.mycompany.example.client.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.client.tokens.TokenField;
import com.mycompany.example.client.tokens.TokenLayout;
import com.mycompany.example.shared.MyCompanyEventBus;

public abstract class WizardWidget extends Composite implements
		WizardProgressHandler {


	private static final String WIZARD_WIDGET = "wizard-widget";
	private VerticalPanel mainPanel = new VerticalPanel();
	protected List<WizardStep> steps = new ArrayList<WizardStep>();
	protected final Map<String, WizardStep> idMap = new HashMap<String, WizardStep>();

	protected TokenLayout layout = new TokenLayout();
	protected WizardStep currentStep;
	private int indexStep = 0;

	public WizardWidget() {
		mainPanel.setHeight("100%");
		mainPanel.addStyleName(WIZARD_WIDGET);
		layout.setHeight("50px");
		layout.setWidth("100%");
		initWidget(mainPanel);
		wireTokens();
		
	}

	public void build() {
		 updatePanelWithCurrentStep();
		
	}

	private void updatePanelWithCurrentStep() {
		mainPanel.clear();
		 mainPanel.add(layout);
		 mainPanel.add(getWidget(currentStep));
	}

	private void wireTokens() {
		MyCompanyEventBus.BUS.addHandler(WizardAdvanceEvent.TYPE, new WizardAdvanceHandler() {
			
			@Override
			public void advance(WizardAdvanceEvent event) {
				WizardStep step = event.getStep();
				TokenField tokenField = step.getTokenField();
				if (tokenField != null && !tokenField.getText().equals("")){
					layout.addToken(tokenField);	
				}
				advanceStep(step);
			}
		});
	}



	private Widget getWidget(final WizardStep step) {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setWidth("100%");
			Widget w = step.getAllWidget();
			w.setWidth("100%");
			w.setHeight("100%");
			horizontalPanel.add(w);
		Button cancelButton = new Button("cancel");
		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				cancelStep(step);
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
		updatePanelWithCurrentStep();
		
	}

	@Override
	public void wizardAdvance(WizardAdvanceEvent event) {
		//advanceStep(event.getStep());

	}

	private void advanceStep(WizardStep step) {
		int index = steps.indexOf(step);
		String newIndex = "index-step" + ++index;
		if (index <= steps.size()) {

			WizardStep newStep = idMap.get(newIndex);
			if (newStep != null && idMap.containsValue(newStep)) {
				activeStep(newStep);
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

=======
package com.mycompany.example.client.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mycompany.example.client.tokens.TokenLayout;
import com.mycompany.example.shared.MyCompanyEvent;

public abstract class WizardWidget extends Composite implements
		WizardProgressHandler {

	private static final String WIZARD_WIDGET = "wizard-widget";
	private VerticalPanel mainPanel = new VerticalPanel();
	protected List<WizardStep> steps = new ArrayList<WizardStep>();
	protected final Map<String, WizardStep> idMap = new HashMap<String, WizardStep>();

	protected TokenLayout tokensLayout = new TokenLayout();
	protected WizardStep currentStep;
	private int indexStep = 0;

	public WizardWidget() {
		mainPanel.setHeight("100%");
		mainPanel.addStyleName(WIZARD_WIDGET);
		tokensLayout.setHeight("50px");
		tokensLayout.setWidth("100%");
		initWidget(mainPanel);
		wireTokens();

	}

	public void build() {
		updatePanelWithCurrentStep();

	}

	private void updatePanelWithCurrentStep() {
		mainPanel.clear();
		mainPanel.add(tokensLayout);
		mainPanel.add(getWidget(currentStep));
	}

	private void wireTokens() {
		MyCompanyEvent.BUS.addHandler(WizardAdvanceEvent.TYPE,
				new WizardAdvanceHandler() {

					@Override
					public void advance(WizardAdvanceEvent event) {
						WizardStep step = event.getStep();
						tokensLayout.addToken(step);
						advanceStep(step);
					}
				});
		MyCompanyEvent.BUS.addHandler(WizardCancelEvent.TYPE,
				new WizardCancelHandler() {

					@Override
					public void cancel(WizardCancelEvent event) {
						WizardStep step = event.getStep();
						tokensLayout.removeToken(step);
						cancelStep(step);

					}
				});
	}

	private Widget getWidget(final WizardStep step) {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setWidth("100%");
		Widget w = step.getAllWidget();
		w.setWidth("100%");
		w.setHeight("100%");
		horizontalPanel.add(w);
		Button cancelButton = new Button("cancel");
		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				cancelStep(step);
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
		updatePanelWithCurrentStep();

	}

	@Override
	public void wizardAdvance(WizardAdvanceEvent event) {
		
	}

	private void advanceStep(WizardStep step) {
		int index = steps.indexOf(step);
		String newIndex = "index-step" + ++index;
		if (index <= steps.size()) {

			WizardStep newStep = idMap.get(newIndex);
			if (newStep != null && idMap.containsValue(newStep)) {
				activeStep(newStep);
			}
		}
	}

	@Override
	public void wizardCancel(WizardCancelEvent event) {
		

	}

	private void cancelStep(WizardStep step) {
		int index = steps.indexOf(step);

		if (index >= 0) {
			if (step != null && idMap.containsValue(step)) {
				activeStep(step);
			}
		}
	}

>>>>>>> ff5c5e2a9b115c6f4a4c601d45860efd09c98043
}