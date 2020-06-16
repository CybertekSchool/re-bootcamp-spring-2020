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
    regions r
    INNER JOIN countries   c ON r.region_id = c.region_id
WHERE r.region_name = 'Europe' ; 


--- USING SUB QUERY THIS IS WHAT WE CAN DO 
--1 , FIND OUT THE ID OF EUROPE 
SELECT REGION_ID FROM REGIONS WHERE REGION_NAME = 'Europe' ; 
--2 , USE THAT TO LIST ALL C VOUNTRY NAME 
SELECT COUNTRY_NAME FROM COUNTRIES WHERE REGION_ID = 1 ; 

--- COMBINE  -- alternative way of getting same result
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






SELECT
    c.country_name,
    r.region_name
FROM
    regions r
    INNER JOIN countries   c ON r.region_id = c.region_id
WHERE r.region_name = 'Europe' ; 


--- get all the city names with country 
SELECT c.country_name , l.city
FROM COUNTRIES c 
join locations l on l.country_id = c.country_id ; 


-- we want to get all the cities in EU 
-- we joied countries , locations , regions
SELECT c.country_name , l.city , r.region_name
FROM COUNTRIES c 
join locations l on l.country_id = c.country_id
join regions r on r.region_id = c.region_id 
WHERE r.region_name = 'Europe'
; 

--- get all employee name from Europe 
-- Employee -- Departments -- Location -- Country -- Region 

SELECT e.first_name , r.region_name
from employees e 
join departments d on e.department_id = d.department_id
join locations l on l.location_id = d.location_id
join countries c on l.country_id = c.country_id
join regions r on r.region_id = c.region_id 
--WHERE r.region_name = 'Europe'
ORDER BY r.region_name
; 

--- FIND OUT HOW MANY EMPLOYEE IN EACH REGION 
SELECT r.region_name , COUNT(e.first_name) AS EMP_CNT 
    from employees e 
    join departments d on e.department_id = d.department_id
    join locations l on l.location_id = d.location_id
    join countries c on l.country_id = c.country_id
    join regions r on r.region_id = c.region_id 
group by r.region_name ; 


--- FIND OUT EMPLOYEE WITH SALE MANAGER TITLE IN EACH EUROPE 
SELECT e.first_name , r.region_name , j.job_title
from employees e 
    join jobs j on j.job_id = e.job_id
    join departments d on e.department_id = d.department_id
    join locations l on l.location_id = d.location_id
    join countries c on l.country_id = c.country_id
    join regions r on r.region_id = c.region_id 

where j.job_title = 'Sales Representative' 
    and r.region_name = 'Europe' ; 
    
    
-- find out how many kind of job_title in each region 

SELECT r.region_name   , COUNT(Distinct j.job_title) as job_title_cnt  -- count(j.job_title)
from employees e 
    join jobs j on j.job_id = e.job_id
    join departments d on e.department_id = d.department_id
    join locations l on l.location_id = d.location_id
    join countries c on l.country_id = c.country_id
    join regions r on r.region_id = c.region_id 

group by r.region_name 

; 


-- How many manager do we have in employees table 

--SELECT COUNT(MANAGER_ID) FROM EMPLOYEES ; 
SELECT COUNT(DISTINCT MANAGER_ID) FROM EMPLOYEES ; 



---  left ourter join 
-- return all employee name even if they dont have department 
SELECT e.first_name , department_name
FROM EMPLOYEES e 
left outer join departments d on e.department_id = d.department_id ; 


--- return all emoloyee name with departments , 
-- including the department without any employees ; 
SELECT e.first_name , department_name
FROM EMPLOYEES e 
right outer join departments d on e.department_id = d.department_id ; 

--- return all department name without any employees ; 
SELECT e.first_name , department_name
FROM EMPLOYEES e 
right outer join departments d on e.department_id = d.department_id 
WHERE e.first_name IS NULL 
; 

SELECT e.first_name , department_name
FROM EMPLOYEES e 
FULL outer join departments d on e.department_id = d.department_id ; 




-------   LIST ALL MANAGER_IDs 
--SELECT COUNT(MANAGER_ID) FROM EMPLOYEES ; 
SELECT DISTINCT MANAGER_ID FROM EMPLOYEES ; 

SELECT FIRST_NAME FROM EMPLOYEES 
WHERE EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID FROM EMPLOYEES) ; 


---- SELF JOIN TO GET EMPLOYEES EACH MANAGER MANAGE 
-- MANAGER ID IS EMPLOYEE_ID OF MANAGER GUY 
SELECT m.first_name AS manager, e.first_name as employee
from employees m 
join employees e on m.employee_id = e.manager_id 

ORDER BY 1 
; 

--- FIND OUT HOW MANY PEOPLE EACH MANAGER MANAGE 
SELECT m.first_name AS manager, count(e.first_name) as employee_CNT
from employees m 
join employees e on m.employee_id = e.manager_id 
GROUP BY m.first_name ;



--- find out the max employee count under one manager 

SELECT MAX(e.employee_CNT) MAX_EMP_UNDER_ONE_MANAGER
FROM (
    SELECT m.first_name AS manager, count(e.first_name) as employee_CNT
    from employees m 
    join employees e on m.employee_id = e.manager_id 
    GROUP BY m.first_name 
    ORDER BY 2 DESC
 ) e 
 
    ;


--- FIND OUT MANAGER NAME WITH MOST EMPLOYEES 


