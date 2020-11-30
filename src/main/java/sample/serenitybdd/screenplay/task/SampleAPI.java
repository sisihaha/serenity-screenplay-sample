package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class SampleAPI {
	
    public static Task getTodo(String id) {
    	String endpoint = "/todos/" + id;
        return Task.where("Get todo with id {0}",
                Get.resource(endpoint));
    }
    
    public static Task getComment(String id) {
    	String endpoint = "/comments/" + id;
        return Task.where("Get comment with id {0}",
                Get.resource(endpoint));
    }
}
