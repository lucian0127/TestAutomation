Feature: MyAccount Popup Feature

  Background:
    Given User has already logged in to application
    | username  | password  |
    | lucian0127 | Warlockmaster1! |

  Scenario: MyAccount popup title
    Given User navigates the MyAccount popup
    When User gets the title of the MyAccount popup
    Then Page title should be "Signed in as lucian0127"

  Scenario: MyAccount menu items count
    Given User is navigating the MyAccount popup
    Then User gets MyAccount menu items
      | Your profile |
      | Your repositories |
      | Your codespaces |
      | Your projects |
      | Your stars |
      | Your gists |
      | Upgrade |
      | Help |
      | Settings |
    And The MyAccount menu items count should be 9