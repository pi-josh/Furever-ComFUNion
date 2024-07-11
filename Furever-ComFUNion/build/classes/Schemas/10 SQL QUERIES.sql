-- Simple Queries
-- 1. Retrieve Cats and Hamsters with 'NA' Status Ordered by Name and Age
SELECT *
FROM forevercomfunion.`pet.v2`
WHERE PetType IN ('Cat', 'Hamster') AND PetStatus = "NA"
ORDER BY PetName, PetAge DESC;

-- 2. List Active Veterinarians with Contact Information
SELECT VetFullName, VetEmailAdd, VetCellNum 
FROM forevercomfunion.`vet.v2`
WHERE VetAcctStatus = "A";


-- 3. Retrieve Clients Aged 25 and Above or with 'D' Status Ordered by Age and ID
SELECT *
FROM forevercomfunion.`client.v2`
WHERE ClientAge >= 25 OR ClientAcctStatus = "D"
ORDER BY ClientAge DESC, ClientID;


-- 4. Retrieve Applications of Type 'A' with Appointment Dates On/After July 1, 2024
SELECT *
FROM forevercomfunion.`application.v2`
WHERE ApplicationType = "A" AND AppointDate >= "2024-07-01"
ORDER BY AppointDate;

-- Moderate Queries

-- 5. Count of Pets Aged 10 months and above by Type with More Than One Record
SELECT PetType, COUNT(*) TotalPetCount
FROM forevercomfunion.`pet.v2`
WHERE PetAge LIKE "1_ months"
GROUP BY PetType
HAVING TotalPetCount > 1;


-- 6. Count of Application Records Grouped by Type and Status Since 2024
SELECT ApplicationType, AppointStatus, COUNT(*) TotalRecord
FROM forevercomfunion.`application.v2`
WHERE AppointDate >= "2024-01-01"
GROUP BY ApplicationType, AppointStatus
HAVING TotalRecord = 5;


-- 7. Average Client Age Grouped by Account Status
SELECT ClientAcctStatus, AVG(ClientAge)
FROM forevercomfunion.`client.v2`
GROUP BY ClientAcctStatus;

-- Difficult Queries
-- 8. Count of Application Records Grouped by Application Type and Pet Type
SELECT ApplicationType, PetType, COUNT(*) TotalRecord
FROM forevercomfunion.`application.v2` a, forevercomfunion.`pet.v2` p
WHERE a.petID = p.petID
GROUP BY ApplicationType, PetType
ORDER BY ApplicationType, PetType;

-- 9. Average Age of Pets Grouped by Application Type, Client Name, and Pet Type
SELECT ApplicationType, ClientFullName, PetType, AVG(PetAge) AveragePetAge
FROM forevercomfunion.`application.v2` a, forevercomfunion.`pet.v2` p, forevercomfunion.`client.v2` c
WHERE a.petID = p.petID AND a.clientID = c.clientID
GROUP BY ApplicationType, ClientFullName, PetType
HAVING AveragePetAge >= 5
ORDER BY ClientFullName, AveragePetAge;

-- 10. Total Age of Pets Grouped by Origin and Type with Minimum Age of 10
SELECT PetOrigin, PetType, SUM(PetAge) TotalPetAge
FROM forevercomfunion.`application.v2` a, forevercomfunion.`pet.v2` p
WHERE a.petID = p.petID
GROUP BY PetOrigin, PetType
HAVING TotalPetAge >= 10
ORDER BY PetOrigin, PetType;