@automated
Feature: Completing todos

  Scenario: Mark a task as completed
    Given 'Jane' has a todo list containing the following items
      | Buy some milk |
      | Walk the dog  |
    When 'Jane' completes the task called 'Walk the dog'
    And 'Jane' filters todo list to show only 'Completed' tasks
    Then there should be the following items in todo list for 'James'
      | Walk the dog |

  Scenario: List of completed items should be empty if nothing has been completed
    Given 'James' has a todo list containing the following items
      | Buy some milk |
      | Walk the dog  |
    When 'James' filters todo list to show only 'Completed' tasks
    Then todo list should be empty for 'James'
