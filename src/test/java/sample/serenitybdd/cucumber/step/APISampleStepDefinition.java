package sample.serenitybdd.cucumber.step;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import sample.serenitybdd.screenplay.model.CommentInformation;
import sample.serenitybdd.screenplay.task.SampleAPI;

public class APISampleStepDefinition {
	@Given("I am API consumer")
	public void i_am_api_consumer() {
		String baseURL = "https://jsonplaceholder.typicode.com";
		theActorCalled("consumer").whoCan(
				CallAnApi.at(baseURL));
	}	

	@When("I request to get 1st todo item")
	public void i_request_to_get_1st_todo_item() {
		theActorInTheSpotlight().attemptsTo(
				SampleAPI.getTodo("1"));
	}

	@Then("I should see response JSON data conforms to JSON schema")
	public void i_should_see_response_json_data_conforms_to_json_schema(String jsonSchema) {
		theActorInTheSpotlight().should(
				seeThatResponse("JSON data conforms to JSON schema",
						response -> response.body(matchesJsonSchema(jsonSchema))));
	}
	
	@When("I request to get 1st comment posted")
	public void i_request_to_get_1st_comment_posted() {
		theActorInTheSpotlight().attemptsTo(
				SampleAPI.getComment("1"));
	}
	
	@Then("I should see the following comment information")
	public void i_should_see_the_following_comment_information(CommentInformation comment) {
		theActorInTheSpotlight().should(seeThatResponse("JSON data is same as the one expected", response -> {
			Assert.assertEquals(comment, response.extract().as(CommentInformation.class));
		}));
	}
	
	@When("I request to post the following comment")
	public void i_request_to_post_the_following_comment(String jsonBody) {
		theActorInTheSpotlight().attemptsTo(
				SampleAPI.postComment(jsonBody));
	}

	@Then("I should see the following information in the response")
	public void i_should_see_the_following_information_in_the_response(CommentInformation comment) {
		theActorInTheSpotlight().should(
				seeThatResponse("JSON data is same as the one expected", 
						response -> response.assertThat()
						.body("name", equalTo(comment.getName()))
						.body("email", equalTo(comment.getEmail()))
						.body("body", equalTo(comment.getBody()))));
	}

	@Then("I should see id greater than {int} in the response")
	public void i_should_see_id_greater_than_in_the_response(int number) {
		theActorInTheSpotlight().should(
				seeThatResponse("id is greater than {0}", 
						response -> response.assertThat().body("id", greaterThan(number))));
	}

}
