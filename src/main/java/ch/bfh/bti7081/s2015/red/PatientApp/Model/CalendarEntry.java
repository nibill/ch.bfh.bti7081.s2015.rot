package ch.bfh.bti7081.s2015.red.PatientApp.Model;

import ch.bfh.bti7081.s2015.red.PatientApp.Db.Persistable;

import java.util.Date;

import com.google.gson.annotations.Expose;

public abstract class CalendarEntry implements Persistable{
	
	public abstract String display();
	

	@Expose protected Date endTime;
	@Expose protected String shortName;
	@Expose protected String description;
	@Expose protected Date startTime;


	public CalendarEntry(){}
	public CalendarEntry(String shortName,String description)
	{
		this.shortName = shortName;
		this.description = description;
	}
	public CalendarEntry(String shortName,String description,Date start, Date end)
	{
		this(shortName,description);
		this.startTime = start;
		this.endTime = end;
		
	}
	public CalendarEntry(String id){this.id = id;}
	public abstract String getUrl();
	
	@Expose protected String id =""; //unique id, necessary for db storage
	/*
	 * class type, necessary for type specific search in the database
	 */
	@Expose private String type = this.getClass().toString(); 
	
	/**
	 * for testing only
	 */
	@Expose protected String display;
	
	/**
	 * for testing only 
	 */
	public abstract void setDisplay(String data);

	/*
	 * Getter's and Setters 
	 */
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}

}
