# Write your MySQL query statement below
delete P1
from Person as P1 join Person as P2
on P1.email=P2.email and P1.id>p2.id;