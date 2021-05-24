package com.manerajona.jvm.performance.codingchoises;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {

	Logger logger = Logger.getLogger("My Logger");

	public void exampleMethod() {

		String id = "1";
		String username = "Foo";
		String app = "Bar";
		String loc = "server1";


		try {
			//some code
		}
		catch (NumberFormatException e) {
			if (logger.isLoggable(Level.INFO)) {
				logger.log(Level.INFO, "NFE in exampleMethod. "
						+ "error was : " + e.getMessage() +
						" user was : " + id + " " + username +
						" system was : " + app + " "  + loc);
			}
		}
	}

}
