package baseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class BaseSteps {

    protected Logger logger = LogManager.getLogger(BaseSteps.class);
    protected WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }
}
