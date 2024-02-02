#Author: your.email@your.domain.com
Feature: Verify LoadId is being dispalyed in the Load-Board Page
  

  @RegressionTest @SmokeTest 
  Scenario Outline: Verify load number in load details page
    Given Fetch the testdata required "<fileName>" "<sheetName>" "<scenario>"
    And Launch Mod Application
    And Verify Load Id in Order Details Page
    And Close the Application

    Examples: 
      | fileName         | sheetName | scenario  |
      | LoginCredentials | Login     | LoginCred |
      
#defintion for Examples: Multiple test datas will be sent via examples using scenario outline
