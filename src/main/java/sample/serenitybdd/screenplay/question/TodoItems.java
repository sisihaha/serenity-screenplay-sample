package sample.serenitybdd.screenplay.question;

import java.util.List;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import sample.serenitybdd.screenplay.ui.TodoList;

/**
 * A factory class used to provide different questions about the items displayed in the todo list
 */
public class TodoItems {
    public static Question<List<String>> displayed() {
        return Text.of(TodoList.ITEMS)
                .describedAs("the items displayed")
                .asAList();
    }

    public static Question<Integer> leftCount() {
        return Text.of(TodoList.ITEMS_LEFT)
                   .describedAs("the number of items left")
                   .asInteger();
    }
}
