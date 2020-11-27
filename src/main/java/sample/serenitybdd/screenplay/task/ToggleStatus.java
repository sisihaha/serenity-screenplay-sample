package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Evaluate;
import sample.serenitybdd.screenplay.ui.TodoList;

public class ToggleStatus {
    public static Performable ofAllItems() {
        return Task.where("{0} toggles the status of all items",
                Evaluate.javascript("arguments[0].click();", TodoList.TOGGLE_ALL_BUTTON)
        );
    }
}