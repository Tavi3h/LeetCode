/*

Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+

for more information: https://leetcode.com/problems/consecutive-numbers/description/
*/

#MySQL
select distinct log1.Num ConsecutiveNums from Logs log1
inner join Logs log2 on log1.Id = log2.Id - 1
inner join Logs log3 on log1.Id = log3.Id - 2
where log1.Num = log2.Num and log1.num = log3.num;
