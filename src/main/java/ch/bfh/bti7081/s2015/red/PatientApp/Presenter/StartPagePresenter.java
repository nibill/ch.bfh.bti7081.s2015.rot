package ch.bfh.bti7081.s2015.red.PatientApp.Presenter;

import java.util.ArrayList;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Appointment;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.CalendarEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.Model.MedicationEntry;
import ch.bfh.bti7081.s2015.red.PatientApp.View.StartScreenView;
import ch.bfh.bti7081.s2015.red.PatientApp.View.View;

public class StartPagePresenter  extends BasePresenter<CalendarEntry> implements ViewListener<CalendarEntry>{

	private CalendarEntry[] model;
	
	public StartPagePresenter(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void init(CalendarEntry data) {
		
		//((StartScreenView)this.view).update(model.getCollection());
		
	}



	@Override
	public void buttonClick(String property, CalendarEntry data) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void triggerEvent(String event, CalendarEntry data) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void buttonClick(String property, ArrayList<CalendarEntry> data) {
		
/*
		if(property.equals("UPDATE"))
		{
			this.model.update();
			for(CalendarEntry entry : this.model.getCollection())
				System.out.println(entry.display());
		}*/
		
	}

}
