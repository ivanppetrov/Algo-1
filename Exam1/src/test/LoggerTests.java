package test;

import problems.DateLogger;
import problems.Logger;

public class LoggerTests {

	public static void main(String[] args) {
//		Logger logger = new Logger();
//		Logger loggerLevel = new Logger(4);
//		Logger dateLogger = new DateLogger();
//		
//		System.out.println("Logger: " + logger.getLevel());
//		logger.log(2, "Logger: Somewhat important message"); //gets logged as "2 => Somewhat important message"
//		logger.log(3, "Logger: Less important message"); // also gets logged!
//		logger.log(4, "Logger: Not important"); //this is less important than LEVEL, so it will **not be logged**.
//		logger.log("Logger: Meh"); //overload without a LEVEL parameter, use 3 as default.
//		
//		logger.setLevel(2);
//		System.out.println("Logger: " + logger.getLevel());
//		logger.log("Logger: My message"); //does not get printed!
//		
//		
//		System.out.println("Loggerlevel: " + loggerLevel.getLevel());
//		loggerLevel.log(2, "Loggerlevel: Somewhat important message"); //gets logged as "2 => Somewhat important message"
//		loggerLevel.log(3, "Loggerlevel: Less important message"); // also gets logged!
//		loggerLevel.log(4, "Loggerlevel: Not important"); //this is less important than LEVEL, so it will **not be logged**.
//		loggerLevel.log("Loggerlevel: Meh"); //overload without a LEVEL parameter, use 3 as default.
//		
//		loggerLevel.setLevel(4);
//		System.out.println("Loggerlevel: " + loggerLevel.getLevel());
//		loggerLevel.log("Loggerlevel: My message"); //get printed!
//		
//		
//		
//		System.out.println("DateLogger: " + dateLogger.getLevel());
//		dateLogger.log(2, "Datelogger: Somewhat important message"); //gets logged as "2 => Somewhat important message"
//		dateLogger.log(3, "Datelogger: Less important message"); // also gets logged!
//		dateLogger.log(4, "Datelogger: Not important"); //this is less important than LEVEL, so it will **not be logged**.
//		dateLogger.log("Datelogger: Meh"); //overload without a LEVEL parameter, use 3 as default.
//		
//		dateLogger.setLevel(-11);
//		System.out.println("DateLogger: " + dateLogger.getLevel());
//		dateLogger.log("Datelogger: My message"); //get printed!

		
		Logger logger = new Logger();
        logger.log("This should get printed");
        logger.log(4, "This should not get printed");
        
        logger.log(1, "This is very important");
        
        DateLogger dateLogger = new DateLogger();
        dateLogger.log("prints everything, so I get printed");
        
        dateLogger.setLevel(1);
        dateLogger.log(2,"won't get printed");
	}

}
