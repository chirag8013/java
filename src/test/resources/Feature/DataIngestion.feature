Feature: Data Ingestion

Background: Validate Admin Utils
When Log into QATS Application as an Admin

@Pyramid
Scenario: Ingest data for Pyramid 
When I should to be able to ingest data from Pyramid for a given date
And view the ingested data on Dashboard to support  creation of new QA reviews

@Accurate
Scenario: Ingest data for Accurate
When I should to be able to ingest data from Accurate for a given date
And view the ingested data on Dashboard to support  creation of new QA reviews

@ORP
Scenario: Ingest data for ORP
When I should to be able to ingest data from ORP for a given date
And view the ingested data on Dashboard to support  creation of new QA reviews

