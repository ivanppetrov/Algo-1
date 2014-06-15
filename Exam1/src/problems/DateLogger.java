package problems;

import java.util.Date;

public class DateLogger extends Logger{
	
	@Override
	public void log(String message) {
		if (getLevel() >= DEFAULTLEVEL) {
			System.out.print("[" + new Date() + "] ");
			System.out.printf("%d => %s\n", getLevel(), message);
		}
	}
	
	@Override
	public void log(int level, String message) {
		if (level <= getLevel()) {
			System.out.print("[" + new Date() + "] ");
			System.out.printf("%d => %s\n", level, message);
		}
	}
}
