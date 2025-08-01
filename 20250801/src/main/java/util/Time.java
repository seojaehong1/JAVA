package util;

import java.io.Serializable;

public class Time implements Serializable{
	private static final long serialVersionUID =1L;
	private int[] starttime = new int[4];
	private int[] presenttime = new int[4];
	private int[] endtime= new int[4];
	
	
	public int[] timechange() {		
		java.time.LocalDateTime now = java.time.LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		int time = 0;
		int[] x = new int[4];
		x[0] = hour*3600;
		x[1] = minute*60;
		x[2] = second;
		x[3] = x[0] + x[1] + x[2];
		return x;
	}
	
	public void stime() {
		this.starttime = this.timechange(); 
	}
	
	public void ptime() {
		this.presenttime = this.timechange();
	}
	
	public void etime() {
		this.endtime = this.timechange();
		
	}
		
	public int setSpcomputed() {
		
		return presenttime[3] - starttime[3]; 	
	}
	
	public int setPecomputed() {
		return endtime[3] - starttime[3];
	}
	
	
	
	
	
	
}
