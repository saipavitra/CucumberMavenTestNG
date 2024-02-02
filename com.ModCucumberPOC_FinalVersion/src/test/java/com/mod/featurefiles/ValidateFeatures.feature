#Author: your.email@your.domain.com
#@RegressionTest - global declaration of tag name for the feature file
Feature: Verify LoadId is being dispalyed in the Load-Board Page
  

  @RegressionTest @SmokeTest
  Scenario Outline: Verify load number in load details page
    Given Fetch the testdata required "<fileName>" "<sheetName>" "<scenario>"
    | LoginCredentials | Login     | LoginLUKET | # testdata without excel's header
    And Launch Mod Application
    And Verify Load Id in Order Details Page
    And Close the Application

    Examples: 
      | fileName         | sheetName | scenario   |
      | LoginCredentials | Login     | LoginLUKET |
      
      @RegressionTest @ReTest
  Scenario Outline: Verify load number in load details page
    Given Fetch the testdata required "<fileName>" "<sheetName>" "<scenario>"
    And Launch Mod Application
    And Verify Load Id in Order Details Page
    And Close the Application

    Examples: 
      | fileName         | sheetName | scenario   |
      | LoginCredentials | Login     | LoginLUKET |
      