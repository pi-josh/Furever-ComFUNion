-- Simple will be basic query which may use  WHERE (with AND, OR operators), ORDER BY (single table)
-- 1.
SELECT *
FROM forevercomfunion.`pet.v2`
WHERE PetType IN ('Cat', 'Hamster') AND PetStatus = "NA"
ORDER BY PetName, PetAge DESC;

-- 2.
SELECT *
FROM forevercomfunion.`vet.v2`
WHERE VetFullName LIKE "R%" AND VetAcctStatus = "A"
ORDER BY VetFullName DESC;

-- 3.
SELECT *
FROM forevercomfunion.`client.v2`
WHERE ClientAge >= 25 OR ClientAcctStatus = "D"
ORDER BY ClientAge DESC, ClientID;

-- 4.
SELECT *
FROM forevercomfunion.`application.v2`
WHERE ApplicationType = "A" AND AppointDate >= "2024-07-01"
ORDER BY AppointDate;

-- Moderate may be a combination of simple and GROUP BY /HAVING, column functions  (single table)
-- 5.
SELECT PetType, COUNT(*) TotalPetCount
FROM forevercomfunion.`pet.v2`
WHERE PetAge LIKE "1_ months"
GROUP BY PetType
HAVING TotalPetCount > 1;

-- 6.
SELECT ApplicationType, AppointStatus, COUNT(*) TotalRecord
FROM forevercomfunion.`application.v2`
WHERE AppointDate >= "2024-01-01"
GROUP BY ApplicationType, AppointStatus
HAVING TotalRecord = 5;

-- 7.
SELECT ClientAcctStatus, AVG(ClientAge)
FROM forevercomfunion.`client.v2`
GROUP BY ClientAcctStatus;

-- Difficult may be a combination of moderate with more than 1 table being used.
-- 8.
SELECT ApplicationType, PetType, COUNT(*) TotalRecord
FROM forevercomfunion.`application.v2` a, forevercomfunion.`pet.v2` p
WHERE a.petID = p.petID
GROUP BY ApplicationType, PetType
ORDER BY ApplicationType, PetType;

-- 9.
SELECT ApplicationType, ClientFullName, PetType, AVG(PetAge) AveragePetAge
FROM forevercomfunion.`application.v2` a, forevercomfunion.`pet.v2` p, forevercomfunion.`client.v2` c
WHERE a.petID = p.petID AND a.clientID = c.clientID
GROUP BY ApplicationType, ClientFullName, PetType
HAVING AveragePetAge >= 5
ORDER BY ClientFullName, AveragePetAge;


-- 10.
SELECT PetOrigin, PetType, SUM(PetAge) TotalPetAge
FROM forevercomfunion.`application.v2` a, forevercomfunion.`pet.v2` p
WHERE a.petID = p.petID
GROUP BY PetOrigin, PetType
HAVING TotalPetAge >= 10
ORDER BY PetOrigin, PetType;