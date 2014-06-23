package com.mycompany.example.client;

import com.mycompany.example.client.wizard.BusinessObjectStep;
import com.mycompany.example.client.wizard.DocTypeStep;
import com.mycompany.example.client.wizard.WizardWidget;

public class ClassificationWizard extends WizardWidget {

	public ClassificationWizard() {
		addStep(new DocTypeStep());
		addStep(new BusinessObjectStep());
		addStep(new BusinessObjectStep());
		addStep(new BusinessObjectStep());
		addStep(new BusinessObjectStep());
		addStep(new BusinessObjectStep());
		
	}
}
