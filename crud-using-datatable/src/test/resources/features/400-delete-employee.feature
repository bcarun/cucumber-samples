Feature: Delete Employee

  Background:

    Given an employee with the following attributes
      | id  | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | 400 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |

    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 401 | Mobile | +1      | 2141112222  |           |
      | 402 | Office | +1      | 8362223000  | 333       |

    When employee already exists


  Scenario: DELETE BY ID

    When user wants to delete employee by id 400
    Then the delete 'IS SUCCESSFUL'

