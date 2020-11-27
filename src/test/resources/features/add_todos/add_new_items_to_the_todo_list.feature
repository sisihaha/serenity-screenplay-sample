@automated
Feature: Add new todos

  Scenario: Adding an item to an empty todo list
    Given 'James' has an empty todo list
    When 'James' adds 'Buy some milk' to todo list
    Then there should be the following items in todo list for 'James'
      | Buy some milk |

  Scenario: Adding an item to a todo list with other items in the list
    Given 'Jane' has a todo list containing the following items
      | Buy some milk |
      | Walk the dog  |
    When 'Jane' adds 'Buy some cereal' to todo list
    Then there should be the following items in todo list for 'Jane'
      | Buy some milk   |
      | Walk the dog    |
      | Buy some cereal |