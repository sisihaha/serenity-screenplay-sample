package sample.serenitybdd.screenplay.task;

import static org.openqa.selenium.Keys.RETURN;
import static sample.serenitybdd.screenplay.ui.TodoList.WHAT_NEEDS_TO_BE_DONE;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class AddATodoItem {

    public static Task called(String thingToDo) {
        return Task.where("{0} adds a todo item called: #thingToDo",
                Enter.theValue(thingToDo)
                        .into(WHAT_NEEDS_TO_BE_DONE)
                        .thenHit(RETURN)
                ).with("thingToDo").of(thingToDo);
    }
}