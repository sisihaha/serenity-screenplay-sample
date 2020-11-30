package sample.serenitybdd.screenplay.model;

import lombok.Data;

@Data
public class CommentInformation {
	private int postId;
	private int id;
	private String name;
	private String email;
	private String body;
}
