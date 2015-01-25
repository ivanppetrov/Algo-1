package task2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private int hours;
	private int minutes;
	private int seconds;
	private int day;
	private int month;
	private int year;
	
	public Time(int hours, int minutes, int seconds, int day, int month, int year) {		
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return String.format("%s:%s:%s %s.%s.%s", hours, minutes, seconds, day, month, year);
	}
	
	public String now() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH	:mm:ss dd.MM.YY");
		return sdf.format(new Date());
	}
	
	public static void main(String args[]) {
		Time time = new Time(12, 33, 34, 14, 9, 14);
		System.out.println(time.toString());
		System.out.println(time.now());
		
	}
}