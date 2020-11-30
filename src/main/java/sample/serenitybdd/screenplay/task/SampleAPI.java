package sample.serenitybdd.screenplay.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

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
    
    public static Task postComment(String jsonBody) {
    	String endpoint = "/posts";
        return Task.where("Post comment with JSON body {0}",
                Post.to(endpoint).with(request -> request.header("Content-Type", "application/json")
                		.body(jsonBody)));
    }
}
