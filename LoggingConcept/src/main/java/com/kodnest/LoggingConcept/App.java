package com.kodnest.LoggingConcept;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App {
	
	public static final Logger logger = LogManager.getLogger(App.class);
	
    public static void main(String[] args) {
        process();
    }
    
    public static void process()
    {
    	logger.trace("Trace method");
    	logger.debug("Debug method");
    	logger.info("Info method");
    	logger.warn("Warn method");
    	logger.error("error Method");
    	logger.fatal("fatal Method");
    }
}
