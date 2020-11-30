@automated
Feature: Sample for RESTful API
  Fake Online REST API for testing: https://jsonplaceholder.typicode.com/

  Background: 
    Given I am API consumer

  Scenario: Get todo item
    When I request to get 1st todo item
    Then I should see response JSON data conforms to JSON schema
      """
      {
      	"properties": {
      		"userId": {
      			"type": "integer"
      		},
      		"id": {
      			"type": "integer"
      		},
      		"title": {
      			"type": "string"
      		},
      		"completed": {
      			"type": "boolean"
      		}
      	}
      }
      """

  Scenario: Get comment
    When I request to get 1st comment posted
    Then I should see the following comment information
      | PostId | Id | Name                         | Email              | Body                                                                                                                                                    |
      |      1 |  1 | id labore ex et quam laborum | Eliseo@gardner.biz | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |

  Scenario: Post comment
    When I request to post the following comment
      """
      {
      "name": "James",
      "email": "james@dummy.email.com",
      "body": "say hello"
      }
      """
    Then I should see the following information in the response
      | Name  | Email                 | Body      |
      | James | james@dummy.email.com | say hello |
    And I should see id greater than 0 in the response
