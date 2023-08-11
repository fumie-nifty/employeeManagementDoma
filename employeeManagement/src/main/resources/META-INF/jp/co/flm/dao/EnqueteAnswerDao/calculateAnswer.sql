SELECT  
	COUNT(Distinct esq_Id)
AS 
	totalAnswer
FROM 
	EnqueteAnswer
WHERE 
	Enquete_Id=/*enqueteId*/1