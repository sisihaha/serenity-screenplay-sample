package sample.serenitybdd.cucumber.step;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class hook {
	@Before
	public void set_the_stage() {
		OnStage.setTheStage(new OnlineCast());
	}

}
