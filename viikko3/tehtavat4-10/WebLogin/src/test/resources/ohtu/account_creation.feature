Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created 

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When too short username "li" and valid password "salainen1" and matching password confirmation are entered
        Then user is not created and error "username should have at least 3 characters" is reported

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  valid username "liisa" and too short password "salain3" and matching password confirmation are entered
        Then user is not created and error "password should have at least 8 characters" is reported

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  valid username "liisa" and password "salainen1" and non-matching password confirmation "salainen2" are entered
        Then user is not created and error "password and password confirmation do not match" is reported  

    Scenario: user can login with successfully generated account
        Given user with username "lea" with password "salainen1" is successfully created
        And   login is selected
        When  correct username "lea" and password "salainen1" are given
        Then  user is logged in