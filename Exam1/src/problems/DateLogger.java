package problems;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLogger extends Logger{
	private SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss dd.M.yyyy");
	
	@Override
	public void log(int level, String message) {
		System.out.print("[" + date.format(new Date()) + "] ");
		super.log(level, message);
	}	
}
