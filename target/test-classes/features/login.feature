Feature: Verify user unable to login

Scenario: user able to login with invalid credentials 
Given user is on the homepage
When user put the curson on signin button
Then user click on the signin button
And user enters invalid username
And user enters invalid password
And user click on signin button again
Then error should displayed
