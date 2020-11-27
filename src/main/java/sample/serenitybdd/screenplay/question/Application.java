package sample.serenitybdd.screenplay.question;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import sample.serenitybdd.screenplay.model.ApplicationInformation;
import sample.serenitybdd.screenplay.ui.TodoListApp;

public class Application implements Question<ApplicationInformation> {

    @Override
    public ApplicationInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        String heading = the(Text.of(TodoListApp.MAIN_HEADING).viewedBy(actor));
        String aboutInformation = the(Text.of(TodoListApp.FOOTER).viewedBy(actor));

        return new ApplicationInformation(title, heading, aboutInformation);
    }

    public static Application information() {
        return new Application();
    }
}