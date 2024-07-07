CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllExistingApplications`()
BEGIN
SELECT AppointDate, AppointTime
FROM forevercomfunion.`application.v2`;
END