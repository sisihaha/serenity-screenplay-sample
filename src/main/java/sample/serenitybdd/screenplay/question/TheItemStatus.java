package sample.serenitybdd.screenplay.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;
import sample.serenitybdd.screenplay.model.TodoStatus;
import sample.serenitybdd.screenplay.ui.TodoListItem;

@Subject("The item status for '#itemName'")
public class TheItemStatus implements Question<TodoStatus> {

    private final String itemName;

    @Override
    public TodoStatus answeredBy(Actor actor) {
        Target completeItemButton = TodoListItem.COMPLETE_ITEM.of(itemName);

        Boolean itemChecked = completeItemButton.resolveFor(actor).isSelected();

        return TodoStatus.from(itemChecked);
    }

    public static TheItemStatus forTheItemCalled(String itemName) {
        return new TheItemStatus(itemName);
    }
    public TheItemStatus(String itemName) {
        this.itemName = itemName;
    }
}