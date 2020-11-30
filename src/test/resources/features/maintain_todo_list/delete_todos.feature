@automated
Feature: Deleting todos

  Scenario: Delete an active item
    Given 'Jane' has a todo list containing the following items
      | Buy some milk |
      | Walk the dog  |
    When 'Jane' deletes the task called 'Walk the dog'
    Then there should be the following items in todo list for 'James'
      | Buy some milk |
