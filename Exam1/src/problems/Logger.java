package problems;

public class Logger {
	private int level;
	protected static final int DEFAUL_TLEVEL = 3;
	
	public Logger() {
		this.level = DEFAUL_TLEVEL;
	}
	
	public Logger(int level) {
		setLevel(level);
	}
	
	public void setLevel(int level) {
		if (level > 0) {
			this.level = level;
		} else {
			throw new InvalidLogLevelException(level);
		}
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void log(String message) {
		log(DEFAUL_TLEVEL, message);
	}
	
	public void log(int level, String message) {
		if (level <= getLevel()) {
			System.out.printf("%d => %s\n", level, message);
		}
	}
	
	private static class InvalidLogLevelException extends RuntimeException {
		private static final long serialVersionUID = 1l;
		
		public InvalidLogLevelException(int level) {
			super("Level should be > 0. Given level: " + level);
		}
		
	}
}
