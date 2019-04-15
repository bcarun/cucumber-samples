Feature: Update Employee

  Background:

    Given an employee with the following attributes
      | id  | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | 300 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |

    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 301 | Mobile | +1      | 2141112222  |           |
      | 302 | Office | +1      | 8362223000  | 333       |

    When employee already exists


  Scenario Outline: <testCase> <expectedResult>

    Given user wants to update an employee with the following attributes
      | id   | firstName   | lastName   | dateOfBirth   | startDate   | employmentType   | email   |
      | <id> | <firstName> | <lastName> | <dateOfBirth> | <startDate> | <employmentType> | <email> |

    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 301 | Mobile | +1      | 2141112222  |           |
      | 302 | Office | +1      | 8362223000  | 333       |

    When user saves the employee '<testCase>'
    Then the save '<expectedResult>'

    Examples:
      | testCase                 | expectedResult | id  | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | WITHOUT ID               | FAILS          |     | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT FIRST NAME       | FAILS          | 300 |           | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT LAST NAME        | FAILS          | 300 | Rachel    |          | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT DATE OF BIRTH    | FAILS          | 300 | Rachel    | Green    |             | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT START DATE       | FAILS          | 300 | Rachel    | Green    | 1990-01-01  |            | Permanent      | rachel.green@fs.com |
      | WITHOUT EMPLOYMENT TYPE  | FAILS          | 300 | Rachel    | Green    | 1990-01-01  | 2018-01-01 |                | rachel.green@fs.com |
      | WITHOUT EMAIL            | FAILS          | 300 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      |                     |
      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | 300 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |



