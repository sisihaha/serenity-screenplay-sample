package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import sample.serenitybdd.screenplay.ui.TodoList;

public class Clear {
    public static Performable completedItems() {
        return Task.where("{0} clears all the completed items",
                Click.on(TodoList.CLEAR_COMPLETED)
        );
    }
}