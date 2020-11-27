package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import sample.serenitybdd.screenplay.ui.TodoListItem;

public class DeleteAnItem {
    public static Performable called(String itemName) {
        return Task.where("{0} deletes the item " + itemName,
        		Click.on(TodoListItem.DELETE_ITEM.of(itemName))
        );
    }
}