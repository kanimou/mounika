package GettingData;

import java.sql.Date;
import java.sql.Time;

public class EmployeeDetails {
	
	private int id;
	 private Date date;
	 private Time time;
    private boolean flag;
    
			
 public EmployeeDetails(int id, String date, String time, String flag) {
		this.id = id;
		this.date = Date.valueOf(date);
		this.time = Time.valueOf(time);
		this.flag = Boolean.parseBoolean(flag);;
	}


public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(String date) {
		 this.date =Date.valueOf(date);
	}



	public Time getTime() {
		return time;
	}



	public void setTime(String time) {
	 this.time =Time.valueOf(time);;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	



		
}
