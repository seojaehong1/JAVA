package spring;

public class Timemember {

	private int id;
	private String password;
	private long starttime;
	private long endtime;
	private long totaltime;
	private int rank1;
	
	
	
	public Timemember(int id, String password, long starttime, long endtime, long totaltime, int rank1) {
		super();
		this.id = id;
		this.password = password;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totaltime = totaltime;
		this.rank1 = rank1;
	}


	public Timemember(int id, String password) {
		this.id = id;
		this.password = password;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getStarttime() {
		return starttime;
	}


	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}


	public long getEndtime() {
		return endtime;
	}


	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}


	public long getTotaltime() {
		return totaltime;
	}


	public void setTotaltime(long totaltime) {
		this.totaltime = totaltime;
	}


	public int getRank1() {
		return rank1;
	}


	public void setRank1(int rank1) {
		this.rank1 = rank1;
	}


	@Override
	public String toString() {
		return "Timemember [id=" + id + ", password=" + password + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", totaltime=" + totaltime + ", rank1=" + rank1 + "]";
	}
	
	
	
}
