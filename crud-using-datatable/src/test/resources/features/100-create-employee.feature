Feature: Create Employee

  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL

    Given user wants to create an employee with the following attributes
      | id  | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | 100 | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |

    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 102 | Mobile | +1      | 2141112222  |           |
      | 103 | Office | +1      | 8362223000  | 333       |

    When user saves the new employee 'WITH ALL REQUIRED FIELDS'
    Then the save 'IS SUCCESSFUL'


  Scenario Outline: <testCase> <expectedResult>

    Given user wants to create an employee with the following attributes
      | id  | firstName   | lastName   | dateOfBirth   | startDate   | employmentType   | email   |
      | 110 | <firstName> | <lastName> | <dateOfBirth> | <startDate> | <employmentType> | <email> |

    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 111 | Mobile | +1      | 2141112222  |           |
      | 112 | Office | +1      | 8362223000  | 333       |

    When user saves the new employee '<testCase>'
    Then the save '<expectedResult>'

    Examples:
      | testCase                 | expectedResult | firstName | lastName | dateOfBirth | startDate  | employmentType | email               |
      | WITHOUT FIRST NAME       | FAILS          |           | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT LAST NAME        | FAILS          | Rachel    |          | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT DATE OF BIRTH    | FAILS          | Rachel    | Green    |             | 2018-01-01 | Permanent      | rachel.green@fs.com |
      | WITHOUT START DATE       | FAILS          | Rachel    | Green    | 1990-01-01  |            | Permanent      | rachel.green@fs.com |
      | WITHOUT EMPLOYMENT TYPE  | FAILS          | Rachel    | Green    | 1990-01-01  | 2018-01-01 |                | rachel.green@fs.com |
      | WITHOUT EMAIL            | FAILS          | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      |                     |
      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com |
