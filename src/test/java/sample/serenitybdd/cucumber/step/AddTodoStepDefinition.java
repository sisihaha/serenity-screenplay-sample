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
		theActorInTheSpotlight().should(seeThat(TodoItems.displayed(), equalTo(todoList)));
	}

	@Given("{string} has a todo list containing the following items")
	public void has_a_todo_list_containing_the_following_items(String actorName, List<String> todoList) {
		theActorCalled(actorName).wasAbleTo(
				Start.withATodoListContaining(todoList));
	}
//
//
//	Some other steps were also undefined:
//
//	@When("{string} adds {string} to todo list")
//	public void adds_to_todo_list(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("there should be the following items in todo list")
//	public void there_should_be_the_following_items_in_todo_list(io.cucumber.datatable.DataTable dataTable) {
//	    // Write code here that turns the phrase above into concrete actions
//	    // For automatic transformation, change DataTable to one of
//	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//	    //
//	    // For other transformations you can register a DataTableType.
//	    throw new io.cucumber.java.PendingException();
//	}
//
//
//	[ERROR] Adding items to several peoples todo lists(Add new todos)  Time elapsed: 0.055 s  <<< ERROR!
//	io.cucumber.junit.UndefinedStepException: 
//	The step "'James' has a todo list containing the following items" is undefined. You can implement it using the snippet(s) below:
//
//	@Given("{string} has a todo list containing the following items")
//	public void has_a_todo_list_containing_the_following_items(String string, io.cucumber.datatable.DataTable dataTable) {
//	    // Write code here that turns the phrase above into concrete actions
//	    // For automatic transformation, change DataTable to one of
//	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//	    //
//	    // For other transformations you can register a DataTableType.
//	    throw new io.cucumber.java.PendingException();
//	}
//
//
//	Some other steps were also undefined:
//
//	@When("{string} adds {string} to todo list")
//	public void adds_to_todo_list(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("there should be the following items in todo list for {string}")
//	public void there_should_be_the_following_items_in_todo_list_for(String string, io.cucumber.datatable.DataTable dataTable) {
//	    // Write code here that turns the phrase above into concrete actions
//	    // For automatic transformation, change DataTable to one of
//	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//	    //
//	    // For other transformations you can register a DataTableType.
//	    throw new io.cucumber.java.PendingException();
//	}

}
