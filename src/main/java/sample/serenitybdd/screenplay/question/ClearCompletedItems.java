package sample.serenitybdd.screenplay.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import sample.serenitybdd.screenplay.ui.TodoList;

@Subject("the 'Clear Completed' option")
public class ClearCompletedItems implements Question<ElementAvailability> {
    @Override
    public ElementAvailability answeredBy(Actor actor) {
        return ElementAvailability.from(
                TodoList.CLEAR_COMPLETED.resolveFor(actor).isCurrentlyVisible()
        );
    }
    public static ClearCompletedItems option() {
        return new ClearCompletedItems();
    }
}