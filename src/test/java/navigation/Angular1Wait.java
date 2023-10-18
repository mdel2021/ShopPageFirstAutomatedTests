package navigation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Angular1Wait {
    public static ExpectedCondition<Boolean> waitForAngularToFinishProcessingRequests() {

        return new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                String result = executor.executeScript("" +
                        "if (window.angular === undefined) " +
                        "{return false} " +
                        "else{" +
                        "var injector = window.angular.element('body').injector();" +
                        "return injector.get('$http').pendingRequests.length === 0" +
                        "}").toString();
                return Boolean.valueOf(result);
            }
        };
    }
}
