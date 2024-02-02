#Author: your.email@your.domain.com
Feature: Verify Driver Contact is Editable in mod

  @SmokeTest @RegressionTest @123_Carrier 
  Scenario Outline: Update Driver Contact details in carrier profile section in mod application
    Given Fetch the testdata required "<fileName>" "<sheetName>" "<scenario>"
    And Launch Mod Application
    And Navigate to Legacy Application
    And Navigate to Carrier Profile Page
    And Edit the Contact of Driver in Carrier profile page of Mod Application
    And Close the Application

    Examples: 
      | fileName       | sheetName                | scenario                 |
      | CarrierProfile | DriverContactEditability | DriverContactEditability |
      | CarrierProfile | DriverContactEditability | LoginTest |
