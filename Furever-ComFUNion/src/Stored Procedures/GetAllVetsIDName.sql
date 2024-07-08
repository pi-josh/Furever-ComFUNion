CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllVetsIDName`()
BEGIN
SELECT VetID, VetFullName
FROM forevercomfunion.`vet.v2`
WHERE VetAcctStatus = "A";
END