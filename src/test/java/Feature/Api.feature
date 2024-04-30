
Feature: Api

  @api
  Scenario: User can get in API
    Given Prepare URL valid for "GET_LIST_USERS"
    And Hit API get list data
    Then Validation status code is equals 200
    Then Validation response body get list user
    Then Validation response json whit JSONSchema "get_list_users.json"

