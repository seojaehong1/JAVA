package _20250726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.Scanner;

public class EmployeeSalaryTracker {
	public static void main(String[] args) {
		Connection con = null;
		Scanner scan = new Scanner(System.in);
		int hour =0;
		int minute =0;
		int second =0;
		try {
			String id = "spring5";
			String pw = "spring5";
			String url = "jdbc:mysql://localhost:3305/spring5fs";
			int start = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, id, pw);
			Statement stmt = con.createStatement();
			System.out.println("이름을 입력하세요");
			String sql = scan.nextLine();
			boolean x = true;
			int sal =0;
			int sal1 =0;
			double ss = 0;
			
			double sum = 0;
			double secondsum =0;
			ResultSet rs = stmt.executeQuery("select sal from emp where ename = '" + sql + "'");
			if(rs.next()) {
				sal = rs.getInt("sal");
				System.out.println("월급은" + sal*1300 + "원");
				
			} else {
				System.out.println("해당이름의 직원이 없습니다.");
			}
			
			while(x) {
			System.out.println("업무시작1 실시간급여2 업무종료3 오늘급여4 총급여계산기5 입력주세요");
			String choice = scan.nextLine();
			start = Integer.parseInt(choice);
			
			
		
			
			
		
			if (start==1) {
				hour =0;
				minute =0;
				second=0;
				java.time.LocalDateTime now = java.time.LocalDateTime.now();
				hour = now.getHour();
				minute = now.getMinute();
				second = now.getSecond();
				
				System.out.println(now);
				System.out.printf("시작시간 %d시 %d분 %d초\n", hour, minute, second);
		
				
			} 
			if (start==2) {
				int sum1 = hour*3600+minute*60+second; //시작시간을 초로 변환
				java.time.LocalDateTime now = java.time.LocalDateTime.now();
				int endhour1 = now.getHour();
				int endminute1 = now.getMinute();
				int endsecond1 = now.getSecond();
				int sum2 = endhour1*3600+endminute1*60+endsecond1;  //현재시간 초로 변환
				int sum3 = sum2-sum1;
				ss = (double)sal / 20 / 8 / 60 / 60 * sum3 *1300;
				System.out.printf("실시간업무시간 %d시 %d분 %d초\n실시간급여 %f원\n", sum3/3600,
						sum3%3600/60, sum3%3600%60, ss);
			}
			if (start==3) {
				java.time.LocalDateTime now = java.time.LocalDateTime.now();
				int endhour = now.getHour();
				int endminute = now.getMinute();
				int endsecond = now.getSecond();
				secondsum = (double)(endhour-hour)*3600 +(double)(endminute-minute)*60 + (double)(endsecond-second);
				int secondtohour = endhour*3600;
				int secondtominute = endminute*60;
				int secondtosecond =endsecond;
				
				hour = hour*3600;
				minute = minute*60;
				
				int endsecondplus = secondtohour + secondtominute + secondtosecond;
				int secondplus = hour + minute+second;
				int total = endsecondplus - secondplus;
				
				System.out.printf("종료시간 %d시 %d분 %d초\n총업무시간 %d시 %d분 %d초\n", endhour,
						endminute, endsecond, total/3600, total%3600/60, total%3600%60);
			
				ss = (double)sal / 20 / 8 / 60 / 60 * secondsum *1300;
			}
			if (start==4) {
				 
				System.out.printf("오늘의 급여%f \n",ss);
				
			}
			if (start==5) {
				sum += ss;
				System.out.printf("총 급여 %f \n",sum);
			}
			}
		
			
			
			
			
			
			
		} catch(Exception e) {
			System.out.println("로딩실패");
			e.printStackTrace();
		}
	}	
			
			
			
}
 