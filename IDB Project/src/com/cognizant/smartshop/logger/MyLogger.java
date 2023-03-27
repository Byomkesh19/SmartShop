package com.cognizant.smartshop.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    
	 public static Logger getlogger(String className) {
	 
	        final Logger LOGGER = Logger.getLogger(className);
	        Handler consoleHandler = new ConsoleHandler();
	        consoleHandler.setLevel(Level.INFO);
	        Logger.getAnonymousLogger().addHandler(consoleHandler);
	        return LOGGER;
	        
	 }
	} 
