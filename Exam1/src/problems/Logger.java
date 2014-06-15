package problems;

public class Logger {
	private int level;
	protected static final int DEFAULTLEVEL = 3;
	
	public Logger() {
		this.level = DEFAULTLEVEL;
	}
	
	public Logger(int level) {
		setLevel(level);
	}
	
	public void setLevel(int level) {
		if (level > 0) {
			this.level = level;
		} else {
			System.out.println("The level should be > 0.");
		}
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void log(String message) {
		if (getLevel() >= DEFAULTLEVEL) {
			System.out.printf("%d => %s\n", getLevel(), message);
		}
	}
	
	public void log(int level, String message) {
		if (level <= getLevel()) {
			System.out.printf("%d => %s\n", level, message);
		}
	}
}
