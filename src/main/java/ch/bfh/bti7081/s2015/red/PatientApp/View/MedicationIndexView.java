package ch.bfh.bti7081.s2015.red.PatientApp.View;

import java.util.ArrayList;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import ch.bfh.bti7081.s2015.red.PatientApp.App.MedicationEntry;


@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2015.red.PatientApp.MyAppWidgetset")
public class MedicationIndexView extends BaseView<MedicationEntry>
{
	


	@Override
	public void enter(ViewChangeEvent event) {
		
        //setContent(layout);

        Label label = new Label("Medication");
        addComponent(label);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MedicationEntry model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArrayList<MedicationEntry> data) {
		// TODO Auto-generated method stub
		
	}



}