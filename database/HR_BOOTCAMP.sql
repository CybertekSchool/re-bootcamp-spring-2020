SELECT * FROM EMPLOYEES ; 

SELECT UPPER(FIRST_NAME), LOWER(LAST_NAME) FROM EMPLOYEES ; 

-- GET PART OF THE CHARACTER INSIDE WORD
-- THERE IS NO 0 INDEX CONCEPT IN SQL , INDEX ALWAYS START WITH ONE , ENDING INDEX INLCLUDED
SELECT SUBSTR( FIRST_NAME , 1 , 2 ) FROM EMPLOYEES ; 

-- GET THE INITIAL OF A STRING
SELECT SUBSTR( FIRST_NAME , 1 , 1 ) FROM EMPLOYEES ; 
-- GET INITIAL IN LOWERCASE

SELECT SUBSTR(  LOWER(FIRST_NAME) , 1 , 1 ) FROM EMPLOYEES ; 

SELECT LOWER (SUBSTR(FIRST_NAME,1,1) ) FROM EMPLOYEES ; 

-- HOW TO GET INITIAL AS THIRD COLUMN IF A TABLE HAVE FIRST_NAME AND LAST_NAME COLUMN 
-- FIRST_NAME , LAST_NAME , FULL_NAME ,  INITIALS

SELECT first_name, last_name, first_name|| ' ' ||last_name AS FULL_NAME
from employees ; 

SELECT SUBSTR( FIRST_NAME , 1 , 1 )|| SUBSTR( LAST_NAME , 1 , 1 ) AS INITIALS
from employees ; 


SELECT first_name, last_name, 
            first_name|| ' ' ||last_name AS FULL_NAME,
            SUBSTR( FIRST_NAME , 1 , 1 )|| SUBSTR( LAST_NAME , 1 , 1 ) AS INITIALS
            from employees ; 



--- COUNT , MAX, MIN , SUM , AVG .....

SELECT COUNT(*) CNT
FROM EMPLOYEES ; 

-- COUNT HOW MANY FIRST NAME START WITH A 

SELECT COUNT(*) CNT
FROM EMPLOYEES 
WHERE first_name like 'A%'
; 

-- COUNT HOW MANY FIRST NAME CONTAINS WITH A 

SELECT COUNT(*) AS CNT
FROM EMPLOYEES 
WHERE first_name like '%a%'
; 

-- get the count of employees salary between 10000, 20000
SELECT COUNT(*) AS CNT
FROM EMPLOYEES 
WHERE salary BETWEEN 10000 AND 20000 ;


-- - COUNT , MAX, MIN , SUM , AVG .....

SELECT COUNT(*) AS EMP_CNT ,  MAX(SALARY) AS MAX_SAL , MIN(SALARY) AS MIN_SALARY , 
        SUM(SALARY) AS SUM_OF_ALL , AVG(SALARY) AS average
FROM EMPLOYEES ; 


--- GROUP BY 
--4, get the count of all employees
--	1,in each dep
SELECT department_id,   COUNT(*) AS DEP_EMP_CNT
FROM EMPLOYEES  
GROUP BY department_id ; 

--2,in each job title
SELECT job_id, COUNT(*) AS JOB_ID_EMP_CNT
FROM EMPLOYEES  
GROUP BY job_id ;

--3,in each commision_pct   
SELECT commission_pct , COUNT(*) AS COM_PCT_CNT 
FROM EMPLOYEES  
GROUP BY commission_pct
;


--- find out how many location each country have for departments 
SELECT country_id  , COUNT(*) AS CNT  --, COUNT(state_province) AS CNT2
FROM LOCATIONS 
GROUP BY country_id
--HAVING COUNT(*) > 2
; 


--- find out how many location each country have for departments 
-- IN US , IT , DE
SELECT country_id  , COUNT(*) AS CNT  --, COUNT(state_province) AS CNT2
FROM LOCATIONS 
WHERE country_id IN ('US','IT','DE')
GROUP BY country_id
--HAVING COUNT(*) > 2
; 


-- find out how many location each country have for departments 
-- AND ONLY DISPLAY the result if the count is more than 2 
SELECT country_id  , COUNT(*) AS CNT  --, COUNT(state_province) AS CNT2
FROM LOCATIONS 
GROUP BY country_id
HAVING COUNT(*) > 2
; 


--3,in each commision_pct   
SELECT commission_pct , COUNT(*) AS COM_PCT_CNT 
FROM EMPLOYEES  
GROUP BY commission_pct
HAVING COUNT(*) < 5 ;

-----  get the sum of all the salary
--	1,in each dep

    SELECT department_id , SUM(SALARY)
    FROM EMPLOYEES  
    --WHERE department_id IS NOT NULL   -- IT WORKS!
    GROUP BY department_id
    HAVING  department_id IS NOT NULL  -- THIS WILL WORK AS WELL 
    ;
    
    -- 1.1 in each dep and only show the ones with more than 100K as sum of salary 
    SELECT department_id , SUM(SALARY) as ALL_SALARY
    FROM EMPLOYEES 
    -- WHERE SUM(SALARY) > 100000  -- THIS DOES NOT WORK!!
    GROUP BY department_id  
    HAVING SUM(SALARY) > 100000 ; 
    
--	2,in each JOB_ID
    SELECT JOB_ID , SUM(SALARY) as ALL_SALARY, MAX(SALARY) AS MAX_SAL , 
                    MIN(SALARY) AS MIN_SAL
    FROM EMPLOYEES 
    GROUP BY JOB_ID 
    ; 
    --2.1 --- RESTRICT THE RESULT TO DISPLAY ONLY WITH JOB_ID WITH MIN SALARY OF 15000
    SELECT JOB_ID , SUM(SALARY) as ALL_SALARY, MAX(SALARY) AS MAX_SAL , 
                    MIN(SALARY) AS MIN_SAL
    FROM EMPLOYEES 
    GROUP BY JOB_ID 
    HAVING MIN(SALARY) > 15000
    ; 
    
    
    --- subquery with aggreate functions 
    -- find the richest guy name in the employee list 
    -- 1 , find the max salary 
    -- 2 , find the name of the employee with that salary 
    select max(salary) max_sal from employees ; 
    
    select first_name from employees 
    where salary =  24000 ; 
    
    -- it can be combined as below 
    select first_name ,salary from employees 
    where salary =  ( select max(salary) max_sal from employees ) ; 
    
    
    
    -- find the richest guy name in each department
    -- 1 , find the max salaries of each departments
    SELECT MAX(SALARY)
    FROM employees
    GROUP BY department_id ;
    
    -- 2 , find the names of the employees with those salaries
    
    SELECT FIRST_NAME , SALARY , department_id
    FROM EMPLOYEES 
    WHERE SALARY IN (4400,
                    6500,
                    7000,
                    8200,
                    9000,
                    10000,
                    11000,
                    12008,
                    12008,
                    13000,
                    14000,
                    24000) 
    ; 
    
    
    SELECT FIRST_NAME , SALARY , department_id
    FROM EMPLOYEES 
    WHERE SALARY IN ( SELECT MAX(SALARY)
                    FROM employees
                    GROUP BY department_id )  ; 
    
    
    --- QUESTION : HOW TO FIND ALL THE NAMES OF EMPLOYEES MAKE MORE THAN AVERAGE SALARY 
    SELECT FIRST_NAME , SALARY 
    FROM EMPLOYEES 
    WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES ) ; 
    
    
    --- QUESTION : HOW TO FIND COUNT OF ALL THE  EMPLOYEES MAKE MORE THAN AVERAGE SALARY 
    SELECT Count(*) FROM employees
    WHERE salary > (select avg(salary) from employees) ;
    
    
    --- QUESTION : HOW TO FIND COUNT OF ALL THE EMPLOYEES IN EACH DEP
        -- WHO MAKE MORE THAN AVERAGE SALARY 
        -- ONLY DISPLAY THE DEPARTMENTS IF THE COUNT IS MORE THAN 5
    SELECT department_id, Count(*) ABOVE_AVG_CNT FROM employees
    WHERE salary > (select avg(salary) from employees) 
    GROUP BY department_id
    HAVING Count(*) > 5 
    ;
    
    
    -- find the names of the employees with salary of 4800, 12008, 8200 , 11000 
    SELECT FIRST_NAME , SALARY 
    FROM EMPLOYEES 
    WHERE SALARY IN (4800, 12008, 8200 , 11000 ) ; 
    