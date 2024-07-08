CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllExistingApplications`()
BEGIN
SELECT AppointDate, AppointTime, VetID
FROM forevercomfunion.`application.v2`
WHERE AppointStatus != "C";
END