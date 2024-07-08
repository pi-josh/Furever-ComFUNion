CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllPetsCount`()
BEGIN
SELECT COUNT(*)
FROM forevercomfunion.`pet.v2`;
END