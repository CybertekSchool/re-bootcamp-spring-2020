--- GET THE COUNTRY NAME AND REGION NAME FOR ALL COUNTIRE 
SELECT
    c.country_name,
    r.region_name
FROM
    regions     r
    INNER JOIN countries   c ON r.region_id = c.region_id ; 
    
    
    
    
--- GET THE COUNTRY NAME AND REGION NAME IN Europe
SELECT
    c.country_name,
    r.region_name
FROM
    regions     r
    INNER JOIN countries   c ON r.region_id = c.region_id
WHERE r.region_name = 'Europe' ; 


--- USING SUB QUERY THIS IS WHAT WE CAN DO 
--1 , FIND OUT THE ID OF EUROPE 
SELECT REGION_ID FROM REGIONS WHERE REGION_NAME = 'Europe' ; 
--2 , USE THAT TO LIST ALL C VOUNTRY NAME 
SELECT COUNTRY_NAME FROM COUNTRIES WHERE REGION_ID = 1 ; 

--- COMBINE 
SELECT COUNTRY_NAME , 'Europe'  FROM COUNTRIES 
WHERE REGION_ID = (SELECT REGION_ID FROM REGIONS WHERE REGION_NAME = 'Europe'); 
 


--- GET THE COUNTRY NAME AND REGION NAME IN Europe and Asia
SELECT
    c.country_name,
    r.region_name
FROM
    regions     r
    INNER JOIN countries   c ON r.region_id = c.region_id
WHERE r.region_name in ('Europe','Asia')  ; 


