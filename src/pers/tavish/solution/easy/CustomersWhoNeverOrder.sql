/*

Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

for more information: https://leetcode.com/problems/customers-who-never-order/description/
*/

#MySQL 
select c.Name Customers from Customers c
where not exists (select o.CustomerId from Orders o where o.CustomerId = c.Id);

#MySQL
select c.Name Customers from Customers c
where id not in (select o.CustomerId from Orders o);

#MySQL
select c.Name Customers from Customers c
left join Orders o on c.Id = o.CustomerId
where o.CustomerId is null;

