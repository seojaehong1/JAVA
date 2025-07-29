package yoho;

import java.io.Serializable;

public class MyOrder implements Serializable{
	private static final long serialVersionUID =1L;
	private int[] starttime = new int[3];
	private int[] presenttime = new int[3];
	private int[] endtime= new int[3];
	private int computed;
	
	

	public int[] getStarttime() {
		return starttime;
	}
	
	public int timechange() {		
		java.time.LocalDateTime now = java.time.LocalDateTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		int time = 0;
		int[] x = new int[3];
		x[0] = hour*3600;
		x[1] = minute*60;
		x[2] = second;
		for(int i=0; i<3; i++) {
			 time += x[i];
		}		
		return time;
	}
	public int stime() {
		return this.timechange();
	}
	
	public int ptime() {
		return this.timechange();
	}
	public int[] getEndtime() {
		return endtime;
	}
	public int etime() {
		return this.timechange();
		
	}
	
	public int setSpcomputed(int stime, int ptime) {
		
		int sum = ptime-stime;
		return sum;
		
		
	}
	
	public int setPecomputed(int ptime, int etime) {
		int sum = ptime-etime;
		return sum;
	}
	
	
	
	public int[] getPresenttime() {
		return presenttime;
	}
	public void setPresenttime(int[] presenttime) {
		this.presenttime = presenttime;
	}
	public int getSpcomputed() {
		return spcomputed;
	}
	public void setSpcomputed(int spcomputed) {
		this.spcomputed = spcomputed;
	}
	public int getPecomputed() {
		return pecomputed;
	}
	public void setPecomputed(int pecomputed) {
		this.pecomputed = pecomputed;
	}
	public void setStarttime(int[] starttime) {
		this.starttime = starttime;
	}
	public void setEndtime(int[] endtime) {
		this.endtime = endtime;
	}
	
	
	
	
	
}
