Feature: Epam test site features

  Scenario: Login on EPAM test site
    Given Open EPAM test site
    When Login as user "user_1"
    Then Name of "user_1" displayed