package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerExampleTest {
    private Logger logger = LogManager.getLogger(LoggerExampleTest.class);

    @Test
    public void logLevelTest() {
        logger.trace("Trace Message : ...");
        logger.debug("Debug Message : ...");
        logger.info("Info Message : ...");
        logger.warn("Warn Message : ...");
        logger.error("Error Message : ...");
        logger.fatal("Fatal Message : ...");
    }
}
