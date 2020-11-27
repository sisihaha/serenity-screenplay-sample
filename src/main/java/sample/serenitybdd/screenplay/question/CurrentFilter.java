package sample.serenitybdd.screenplay.question;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import sample.serenitybdd.screenplay.model.TodoStatusFilter;
import sample.serenitybdd.screenplay.ui.TodoList;

public class CurrentFilter {

    public static Question<TodoStatusFilter> selected() {
        return Text.of(TodoList.SELECTED_FILTER)
                .describedAs("the current filter")
                .asEnum(TodoStatusFilter.class);
    }
}