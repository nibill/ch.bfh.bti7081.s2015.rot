package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;
 
public class Closed extends ActivityState {

	public Closed(ActivityState lastState, Activity activity) {
		this.activity = activity;
		setActivityState(this); 
	} 
	
	@Override
	public void handle() {
		// TODO Auto-generated method stub
	}	 
 
	@Override
	protected void OnEnter() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void OnExit() {
		// TODO Auto-generated method stub
	}
	
}