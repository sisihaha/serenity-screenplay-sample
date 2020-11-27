package sample.serenitybdd.screenplay.question;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;
import sample.serenitybdd.screenplay.ui.TodoList;

public class Placeholder {
    public static Question<String> text() {
        return Attribute.of(TodoList.WHAT_NEEDS_TO_BE_DONE)
                        .named("placeholder")
                        .describedAs("the placeholder text")
                        .asAString();
    }
}
