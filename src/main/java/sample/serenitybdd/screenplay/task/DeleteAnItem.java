package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import sample.serenitybdd.screenplay.ui.TodoListItem;

public class DeleteAnItem {
	public static Performable called(String itemName) {
		return Task.where("{0} deletes the item " + itemName, 
				MoveMouse.to(TodoListItem.ITEM_LABEL.of(itemName)),
				Click.on(TodoListItem.DELETE_ITEM.of(itemName)));
	}
}