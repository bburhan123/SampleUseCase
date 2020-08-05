@DbsSampleUseCase @Web @UI
Feature: DBS Sample Use Case

  @Scenario_001
  Scenario: id_001 - DBS sample use case scenario
    Given I am on DBS home page
    When I navigate to Singapore DBS stronger together fund page
    And I read and write the table in excel sheet
      | <File>          |
      | SampleExcelData |
    When I navigate to below link
      | <LinkName>         |
      | About              |
      | WhoWeAre           |
      | OurAwardsAccolades |
    Then I validate the total number of awards on awards and accolades page
      | <NumberOfAwards> |
      | #22              |
    And I validate the award name and caption of the award mentioned in the below table
      | <AwardName>     | <CaptionOfTheAward>                                      |
      | #A World First  | #Euromoney                                               |
      | #The Banker     | #Bank of the Year 2018                                   |
      | #Global Finance | #Best Bank in the World 2018                             |
      | #Euromoney      | #Awards For Excellence                                   |
      | #Global Finance | #World's Best Banks                                      |
      | #Global Finance | #World's Best Investment Banks and Derivatives Providers |


  #Additional negative Scenarios
  # Please uncomment the below code if you want to test with wrong test data
#  @Scenario_002
#  Scenario: id_002 - Sample negative scenario to validate number of awards
#    Given I am on DBS home page
#    When I navigate to Singapore DBS stronger together fund page
#    When I navigate to below link
#      | <LinkName>         |
#      | About              |
#      | WhoWeAre           |
#      | OurAwardsAccolades |
#    Then I validate the total number of awards on awards and accolades page
#      | <NumberOfAwards> |
#      | #10              |
#
#  @Scenario_003
#  Scenario: id_003 - Sample negative scenario to validate number of awards
#    Given I am on DBS home page
#    When I navigate to Singapore DBS stronger together fund page
#    When I navigate to below link
#      | <LinkName>         |
#      | About              |
#      | WhoWeAre           |
#      | OurAwardsAccolades |
#    And I validate the award name and caption of the award mentioned in the below table
#      | <AwardName> | <CaptionOfTheAward>    |
#      | #The Banker | #Bank of the Year 2040 |