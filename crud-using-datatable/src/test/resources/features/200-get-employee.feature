Feature: Get Employee

  Background:

    Given an employee with the following attributes
      | id  | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | 200 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |

    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 201 | Mobile | +1      | 2141112222  |           |
      | 202 | Office | +1      | 8362223000  | 333       |

    When employee already exists


  Scenario: GET BY ID

    When user wants to get employee by id 200
    Then the get 'IS SUCCESSFUL'
    And following employee is returned
      | id  | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | 200 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |

    And following employee phone numbers are returned
      | id  | type   | isdCode | phoneNumber | extension |
      | 201 | Mobile | +1      | 2141112222  |           |
      | 202 | Office | +1      | 8362223000  | 333       |


