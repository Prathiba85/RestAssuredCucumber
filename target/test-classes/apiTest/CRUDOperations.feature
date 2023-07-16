Feature: This feature will be used to test the CRUD operations on employee springboot application using RestAssurred.

  @tag1
  Scenario: This scenario will test the Get operation on Emplyee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform get operation
    Then I should get response as 200

  Scenario: This scenario will create the on Emplyee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees" and like to perform post
    When I perform post operation
    Then I should get response for post as 201

  Scenario: This scenario will create the on Emplyee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform post operation with below data
      | firstName | Prathiba    |
      | lastName  | Sankar      |
      | salary    |3000 |
      | email     | abc@xyz.com |
    Then I should get response for post as 201
    And Firstname should be "Prathiba" in response
 
 Scenario: This scenario will delete the on Emplyee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform delete operation 
    Then I should get response for post as 200
   