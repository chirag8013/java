Feature: Data Ingestion

Background: Validate Admin Utils
When User enter the valid credentials that maps to Admin role in QATS
And is able to view the Admin Landing page
And I am able to login to QATS as an Admin

Scenario: Ingest data for Pyramid 
Given I have Logged into QATS Application as an Admin 
Then Upon Occasion I Need to be able to ingest data from Pyramid for a given date
And view the ingested data on Dashboard to support  creation of new QA reviews

Scenario: Ingest data for Accurate
Given I have Logged into QATS Application as an Admin 
Then Upon Occasion I Need to be able to ingest data from Accurate for a given date
And view the ingested data on Dashboard to support  creation of new QA reviews

Scenario: Ingest data for ORP
Given I have Logged into QATS Application as an Admin 
Then Upon Occasion I Need to be able to ingest data from ORP for a given date
And view the ingested data on Dashboard to support  creation of new QA reviews
