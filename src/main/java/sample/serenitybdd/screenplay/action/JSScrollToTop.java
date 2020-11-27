package sample.serenitybdd.screenplay.action;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

/**
 * An example of a custom WebDriver Action.
 */
public class JSScrollToTop implements Interaction {

	@Override
    @Step("JS scroll to top")
    public <T extends Actor> void performAs(T theActor) {
        BrowseTheWeb.as(theActor).evaluateJavascript("window.scrollTo(0, 0)");
    }

    public static Interaction on() {
        return instrumented(JSScrollToTop.class);
    }
}
