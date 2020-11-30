package sample.serenitybdd.cucumber.step;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

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
		theActorInTheSpotlight().should(seeThatResponse("JSON data conforms to JSON schema", response -> {
			Assert.assertEquals(comment, response.extract().as(CommentInformation.class));
		}));
	}
}
