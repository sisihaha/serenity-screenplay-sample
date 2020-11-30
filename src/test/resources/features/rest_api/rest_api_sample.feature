@automated
Feature: Sample for RESTful API
  Fake Online REST API for testing: https://jsonplaceholder.typicode.com/

  Scenario: Get todo item
    Given I am API consumer
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
