/*

Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

for more information: https://leetcode.com/problems/second-highest-salary/description/
*/

#MySQL
select ifnull(
    (
        select distinct Salary from Employee
        order by Salary desc limit 1 offset 1
    ), null
) SecondHighestSalary;

# IFNULL(expr1,expr2). If expr1 is not null, then return the result of expr1, otherwise return the result of expr2.
