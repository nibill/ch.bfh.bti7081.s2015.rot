package ch.bfh.bti7081.s2015.red.PatientApp.lifeUp;

import java.util.Calendar;
import java.util.Date;

import ch.bfh.bti7081.s2015.red.PatientApp.Model.Activity;

public class TimeActivityReady extends TimeActivity {
  
	volatile TimeActivityManager manager;
	
	public TimeActivityReady(Activity activity) {  
		this.activity = activity; 
		System.out.println(activity);
		manager = TimeActivityManager.getInstance();
		manager.chooseActivity(activity);
		manager.setActivityState(this);
		
		//setActivityState(this);  
		startProcess();
	}	
	 
	private void startProcess() {  
		new InProgress(activity); 
		// (new Thread(this.timeActivityManager)).start();
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
	}

}