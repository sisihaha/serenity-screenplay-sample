package sample.serenitybdd.cucumber.step;

import static java.util.Collections.EMPTY_LIST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sample.serenitybdd.screenplay.model.TodoStatusFilter;
import sample.serenitybdd.screenplay.question.TodoItems;
import sample.serenitybdd.screenplay.task.CompleteItem;
import sample.serenitybdd.screenplay.task.DeleteAnItem;
import sample.serenitybdd.screenplay.task.FilterItems;

public class MaintainTodoStepDefinition {
	@When("{string} completes the task called {string}")
	public void completes_the_task_called(String actorName, String thingToDo) {
		theActorInTheSpotlight().attemptsTo(
				CompleteItem.called(thingToDo));
	}

	@When("^'(.*)' filters todo list to show only '(.*)' tasks$")
	public void filters_todo_list_to_show_only_completed_tasks(String actorName, TodoStatusFilter status) {
		theActorInTheSpotlight().attemptsTo(
				FilterItems.toShow(status));
	}

	@Then("todo list should be empty for {string}")
	public void todo_list_should_be_empty_for(String actorName) {
		theActorInTheSpotlight().should(
				seeThat(TodoItems.displayed(), equalTo(EMPTY_LIST)));
	}
	
	@When("{string} deletes the task called {string}")
	public void deletes_the_task_called(String actorName, String thingToDo) {
		theActorInTheSpotlight().attemptsTo(
				DeleteAnItem.called(thingToDo));
	}
}
