package navigation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Angular2Wait {
    public static ExpectedCondition<Boolean> waitForAngularIOToFinishProcessingRequests() {

        return new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver driver) {
                String result = ((JavascriptExecutor) driver).executeScript(
                        "try {\n" +
                                "var angular = window.getAllAngularTestabilities();\n" + // Sprawdzamy czy Angular jest dostępny, jeśli Angular nie był by gotowy, zostanie rzucony wyjątek i kod zwróci fałsz
                                "var isStableIndex = window.getAllAngularTestabilities().findIndex(x=>x.isStable());" + // Ponieważ obiekt Teststabilies jest tablicą, szukamy w nim indeksu metody isStable()
                                "return angular[isStableIndex].isStable()" + // Pobieramy wartość z metody isStable()
                                "} catch (err){\n" +
                                "return false\n" + // Jeśli aplikacja nie jest gotowa, zostanie rzucony wyjątek, co jest równoznaczne z fałszem i brakiem gotowości / stabilności
                                "}"
                ).toString();
                return Boolean.valueOf(result);
            }
        };
    }
}
