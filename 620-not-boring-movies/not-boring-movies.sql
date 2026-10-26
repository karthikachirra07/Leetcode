# Write your MySQL query statement below
select * From Cinema
Where(id%2!=0 )and description!='boring'
order by rating desc;