package ch.bfh.bti7081.s2015.red.PatientApp.LifeUp;

import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

/**
 * The state InProgress is a TimeActivity state. 
 * Every progress which is running goes here. 
 * @author Stefan Tanner
 *
 */	
public class InProgress extends TimeActivity { 
				
	// Empty Constructor for GSON-Libary for deserialisation
	public InProgress() {
		// nothing to be done
	}		
	
	volatile TimeActivityManager manager;
	
	public InProgress(Activity activity) {  
		this.activity = activity;  
		manager = TimeActivityManager.getInstance();
		manager.chooseActivity(activity);
		manager.setActivityState(this);	 
		storeState();
	}	 
	
	@Override
	protected void OnEnter() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void OnExit() {
		// TODO Auto-generated method stub
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub  
		Date now = new Date();
		int softTimeLimitRest = (int) ((activity.getSoftTimeLimit().getTime()-now.getTime()) / 1000);
		int hardTimeLimitRest = (int) ((activity.getHardTimeLimit().getTime()-now.getTime()) / 1000); 
		
		if ( softTimeLimitRest > 0 ) {
			new FinishedInTime(activity);
		}
		else {
			if ( hardTimeLimitRest > 0 ) {
				new FinishedTooLate(activity);
			}
			else {
				new Failed(activity); 
			}
		}
		 
	}

}
