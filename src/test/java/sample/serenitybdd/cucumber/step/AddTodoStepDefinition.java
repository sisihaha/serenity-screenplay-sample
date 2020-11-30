package sample.serenitybdd.cucumber.step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sample.serenitybdd.screenplay.question.TodoItems;
import sample.serenitybdd.screenplay.task.AddATodoItem;
import sample.serenitybdd.screenplay.task.Start;

public class AddTodoStepDefinition {
	@Given("{string} has an empty todo list")
	public void has_an_empty_todo_list(String actorName) {
		theActorCalled(actorName).wasAbleTo(
				Start.withAnEmptyTodoList());
	}

	@When("{string} adds {string} to todo list")
	public void adds_to_todo_list(String actorName, String thingToDo) {
		theActorInTheSpotlight().attemptsTo(
				AddATodoItem.called(thingToDo));
	}
	@Then("there should be the following items in todo list for {string}")
	public void there_should_be_the_following_items_in_todo_list_for(String actorName, List<String> todoList) {
		theActorInTheSpotlight().should(
				seeThat(TodoItems.displayed(), equalTo(todoList)));
	}

	@Given("{string} has a todo list containing the following items")
	public void has_a_todo_list_containing_the_following_items(String actorName, List<String> todoList) {
		theActorCalled(actorName).wasAbleTo(
				Start.withATodoListContaining(todoList));
	}
}
