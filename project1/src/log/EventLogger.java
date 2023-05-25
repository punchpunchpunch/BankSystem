package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EventLogger {
	FileWriter fileWriter;
	PrintWriter fileOut;
	LogManager logManager;
	Logger logger;
	
	public EventLogger(String fileName) {
		try {
			logManager = LogManager.getLogManager();
			logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
			fileOut = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
