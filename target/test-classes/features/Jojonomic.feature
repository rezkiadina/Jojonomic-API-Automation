@JojonomicAPI

  Feature: Get data on Weatherbit

    Scenario Outline: Get current API data
      Given Get current API with valid "<lat>" as lat and "<lon>" as lon using Key "b45ca70eb57746b1be8dcb853cd8a20e"
      When Send get current API request
      Then Status code should response 200 OK
      Then Body response should contain state_code "NY"
      And Validate Get current API with valid JSon
      Examples:
        | lat       | lon        |
        | 40.730610 | -73.935242 |

    Scenario: Get forecast API data
        Given Get forecast API with "27601" as postalcode using Key "b45ca70eb57746b1be8dcb853cd8a20e"
        When Send get forecast API request
        Then Status code should response 200 OK
        Then Body response should contain timestamp_utc "2023-03-11T13:00:00" and weather "code : 800"
        And validate Get forecast API with valid Json

