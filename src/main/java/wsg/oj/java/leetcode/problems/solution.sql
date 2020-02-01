SELECT P.FirstName, P.LastName, A.City, A.State
FROM PERSON P
       LEFT JOIN ADDRESS A ON P.PersonId = A.PersonId;

SELECT A.NAME
FROM Employee A,
     Employee B
WHERE A.Salary > B.Salary
  AND A.ManagerId = B.Id;

SELECT C.Name AS Customers
FROM Customers C
WHERE NOT EXISTS(SELECT O.Id FROM Orders O WHERE C.Id = O.CustomerId);