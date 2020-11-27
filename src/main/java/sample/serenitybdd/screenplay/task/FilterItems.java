package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import sample.serenitybdd.screenplay.model.TodoStatusFilter;
import sample.serenitybdd.screenplay.ui.TodoList;

public class FilterItems {
    public static Performable toShow(TodoStatusFilter filter) {
        return Task.where("{0} filters items by " + filter,
                Click.on(TodoList.FILTER.of(filter.name()))
        );
    }
}