package Models;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class SPManager {
    private static final String URL = "jdbc:mysql://localhost:3306/forevercomfunion";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "_03riseandshine07_";

    public SPManager() {
        // Connection is created per method call, not in the constructor
    }
    // Method to check if a cell number already exists in the client or vet table
    public boolean isCellNumExistQuery(String cellNum) {
        String clientQuery = "SELECT COUNT(*) FROM `client.v2` WHERE CellNum = ?";
        String vetQuery = "SELECT COUNT(*) FROM `vet.v2` WHERE VetCellNum = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement clientPs = connection.prepareStatement(clientQuery);
             PreparedStatement vetPs = connection.prepareStatement(vetQuery)) {

            // Check client table
            clientPs.setString(1, cellNum);
            try (ResultSet clientRs = clientPs.executeQuery()) {
                if (clientRs.next() && clientRs.getInt(1) > 0) {
                    return true;
                }
            }

            // Check vet table
            vetPs.setString(1, cellNum);
            try (ResultSet vetRs = vetPs.executeQuery()) {
                if (vetRs.next() && vetRs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
     
    // Method to check if an email address already exists in the client or vet table
    public boolean isEmailExistQuery(String email) {
        String clientQuery = "SELECT COUNT(*) FROM `client.v2` WHERE ClientEmailAdd = ?";
        String vetQuery = "SELECT COUNT(*) FROM `vet.v2` WHERE VetEmailAdd = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement clientPs = connection.prepareStatement(clientQuery);
             PreparedStatement vetPs = connection.prepareStatement(vetQuery)) {

            // Check client table
            clientPs.setString(1, email);
            try (ResultSet clientRs = clientPs.executeQuery()) {
                if (clientRs.next() && clientRs.getInt(1) > 0) {
                    return true;
                }
            }

            // Check vet table
            vetPs.setString(1, email);
            try (ResultSet vetRs = vetPs.executeQuery()) {
                if (vetRs.next() && vetRs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    // Method to check if a username already exists in the client or vet table
    public boolean isUsernameExistQuery(String username) {
        String clientQuery = "SELECT COUNT(*) FROM `client.v2` WHERE ClientUsername = ?";
        String vetQuery = "SELECT COUNT(*) FROM `vet.v2` WHERE VetUsername = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement clientPs = connection.prepareStatement(clientQuery);
             PreparedStatement vetPs = connection.prepareStatement(vetQuery)) {

            // Check client table
            clientPs.setString(1, username);
            try (ResultSet clientRs = clientPs.executeQuery()) {
                if (clientRs.next() && clientRs.getInt(1) > 0) {
                    return true;
                }
            }

            // Check vet table
            vetPs.setString(1, username);
            try (ResultSet vetRs = vetPs.executeQuery()) {
                if (vetRs.next() && vetRs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    public static int birthdateToAge(String birthdate) {
        LocalDate birthDate = LocalDate.parse(birthdate);
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null && currentDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
                return 0; 
        }
    }
    
    // Methods to register a new account
    public boolean registerClient(String clientUsername, String clientPassword, String clientFullName, int clientAge, String clientAddress, String cellNum, String clientEmailAdd, String clientOccupation, String companyName, String workType, String clientAcctStatus) {
        String query = "INSERT INTO `client.v2` (ClientUsername, ClientPassword, ClientFullName, ClientAge, ClientAddress, CellNum, ClientEmailAdd, ClientOccupation, CompanyName, WorkType, ClientAcctStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, clientUsername);
            ps.setString(2, clientPassword);
            ps.setString(3, clientFullName);
            ps.setInt(4, clientAge);
            ps.setString(5, clientAddress);
            ps.setString(6, cellNum);
            ps.setString(7, clientEmailAdd);
            ps.setString(8, clientOccupation);
            ps.setString(9, companyName);
            ps.setString(10, workType);
            ps.setString(11, clientAcctStatus);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registerVet(String vetUsername, String vetPassword, String vetFullName, int vetAge, String vetCellNum, String vetEmailAdd, String vetAcctStatus) {
        String query = "INSERT INTO `vet.v2` (VetUsername, VetPassword, VetFullName, VetAge, VetCellNum, VetEmailAdd, VetAcctStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, vetUsername);
            ps.setString(2, vetPassword);
            ps.setString(3, vetFullName);
            ps.setInt(4, vetAge);
            ps.setString(5, vetCellNum);
            ps.setString(6, vetEmailAdd);
            ps.setString(7, vetAcctStatus);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get adoption application history for a vet
    public ArrayList<Application> getAdoptionApplicationHistoryForVet(String vetID) {
        return getApplicationHistoryForVetByType(vetID, "A");
    } // Not to be used

    // Method to get rehome application history for a vet
    public ArrayList<Application> getRehomeApplicationHistoryForVet(String vetID) {
        return getApplicationHistoryForVetByType(vetID, "R");
    } // Not to be used

    // Method to get pending adoption applications for a vet
    public ArrayList<Application> getPendingAdoptionApplicationsForVet(String vetID) {
        return getApplicationHistoryForVetByTypeAndStatus(vetID, "A", "P");
    }

    // Method to get successful adoption applications for a vet
    public ArrayList<Application> getSuccessfulAdoptionApplicationsForVet(String vetID) {
        return getApplicationHistoryForVetByTypeAndStatus(vetID, "A", "S");
    }

    // Method to get cancelled adoption applications for a vet
    public ArrayList<Application> getCancelledAdoptionApplicationsForVet(String vetID) {
        return getApplicationHistoryForVetByTypeAndStatus(vetID, "A", "C");
    }

    // Method to get pending rehome applications for a vet
    public ArrayList<Application> getPendingRehomeApplicationsForVet(String vetID) {
        return getApplicationHistoryForVetByTypeAndStatus(vetID, "R", "P");
    }

    // Method to get successful rehome applications for a vet
    public ArrayList<Application> getSuccessfulRehomeApplicationsForVet(String vetID) {
        return getApplicationHistoryForVetByTypeAndStatus(vetID, "R", "S");
    }

    // Method to get cancelled rehome applications for a vet
    public ArrayList<Application> getCancelledRehomeApplicationsForVet(String vetID) {
        return getApplicationHistoryForVetByTypeAndStatus(vetID, "R", "C");
    }

    // Helper method to get application history for a vet by type // Not to be used
    private ArrayList<Application> getApplicationHistoryForVetByType(String vetID, String applicationType) {
        ArrayList<Application> applications = new ArrayList<>();
        String query = "SELECT a.ApplicationID, a.ApplicationType, a.AppointDate, a.AppointStatus, " +
                       "a.ClientID, c.ClientFullName, p.PetName, p.PetType " +
                       "FROM forevercomfunion.`application.v2` a, forevercomfunion.`client.v2` c, forevercomfunion.`pet.v2` p " +
                       "WHERE a.ClientID = c.ClientID AND a.PetID = p.PetID AND a.VetID = ? AND a.ApplicationType = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, vetID);
            ps.setString(2, applicationType);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Application app = new Application();
                    app.setApplicationID(rs.getInt("ApplicationID"));
                    app.setApplicationType(rs.getString("ApplicationType"));
                    app.setAppointDate(rs.getString("AppointDate"));
                    app.setAppointStatus(rs.getString("AppointStatus"));
                    app.setClientID(rs.getInt("ClientID"));
                    app.setVetName(rs.getString("ClientFullName"));
                    app.setPetName(rs.getString("PetName"));
                    app.setPetType(rs.getString("PetType"));
                    applications.add(app);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    } // Not to be used // Not to be used // Not to be used // Not to be used // Not to be used

    // Helper method to get application history for a vet by type and status
    private ArrayList<Application> getApplicationHistoryForVetByTypeAndStatus(String vetID, String applicationType, String appointStatus) {
        ArrayList<Application> applications = new ArrayList<>();
        String query = "SELECT a.ApplicationID, a.ApplicationType, a.AppointDate, a.AppointStatus, " +
                       "a.ClientID, c.ClientFullName, p.PetName, p.PetType " +
                       "FROM forevercomfunion.`application.v2` a, forevercomfunion.`client.v2` c, forevercomfunion.`pet.v2` p " +
                       "WHERE a.ClientID = c.ClientID AND a.PetID = p.PetID AND a.VetID = ? AND a.ApplicationType = ? AND a.AppointStatus = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, vetID);
            ps.setString(2, applicationType);
            ps.setString(3, appointStatus);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Application app = new Application();
                    app.setApplicationID(rs.getInt("ApplicationID"));
                    app.setApplicationType(rs.getString("ApplicationType"));
                    app.setAppointDate(rs.getString("AppointDate"));
                    app.setAppointStatus(rs.getString("AppointStatus"));
                    app.setClientID(rs.getInt("ClientID"));
                    app.setVetName(rs.getString("ClientFullName"));
                    app.setPetName(rs.getString("PetName"));
                    app.setPetType(rs.getString("PetType"));
                    applications.add(app);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    // Method to get application history for a client
    public ArrayList<Application> getApplicationHistoryForClient(int clientID) {
        ArrayList<Application> applications = new ArrayList<>();
        String query = "SELECT a.ApplicationID, a.ApplicationType, a.AppointDate, a.AppointStatus, " +
                       "v.VetFullName, p.PetName, p.PetType " +
                       "FROM forevercomfunion.`application.v2` a, forevercomfunion.`vet.v2` v, forevercomfunion.`pet.v2` p " +
                       "WHERE a.VetID = v.VetID AND a.PetID = p.PetID AND a.ClientID = ?";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, clientID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Application app = new Application();
                    app.setApplicationID(rs.getInt("ApplicationID"));
                    app.setApplicationType(rs.getString("ApplicationType"));
                    app.setAppointDate(rs.getString("AppointDate"));
                    app.setAppointStatus(rs.getString("AppointStatus"));
                    app.setVetName(rs.getString("VetFullName"));
                    app.setPetName(rs.getString("PetName"));
                    app.setPetType(rs.getString("PetType"));
                    applications.add(app);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    // Method to fetch all veterinarians // For vet list tab
    public ArrayList<Veterinarian> getAllVets() {
        ArrayList<Veterinarian> vets = new ArrayList<>();
        String query = "{CALL GetAllVets()}"; // Adjust if your stored procedure name is different

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Veterinarian vet = new Veterinarian();
                vet.setVetFullName(rs.getString("VetFullName"));
                vet.setVetEmailAdd(rs.getString("VetEmailAdd"));
                vet.setVetCellNum(rs.getString("VetCellNum"));
                vets.add(vet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vets;
    }
    
    // Method to fetch all veterinarians // for adopt/rehome form
    public ArrayList<Veterinarian> getAllVetsIDName() {
        ArrayList<Veterinarian> vets = new ArrayList<>();
        String query = "{CALL GetAllVetsIDName()}"; // Adjust if your stored procedure name is different

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Veterinarian vet = new Veterinarian();
                vet.setVetID(rs.getString("VetID"));
                vet.setVetFullName(rs.getString("VetFullName"));
                vets.add(vet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vets;
    }

    // Method to fetch all pets
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        String query = "{CALL GetAllPets()}";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pet pet = new Pet(
                    rs.getString("PetID"),
                    rs.getString("PetType"),
                    rs.getString("PetOrigin"),
                    rs.getString("PetStatus"),
                    rs.getString("PetSize"),
                    rs.getString("PetAge"),
                    rs.getString("PetName"),
                    rs.getString("PetSex")
                );
                pet.setPicURLBasedOnType(pet.getPetType());
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // Method to fetch filtered and sorted pets
    public ArrayList<Pet> getFilteredSortedPets(List<String> petTypes, List<String> petOrigins, List<String> petStatuses,
                                                List<String> petSizes, List<String> petGenders, List<String> sortCriteria) {
        ArrayList<Pet> pets = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM `pet.v2` WHERE 1=1");

        // Add filters
        if (petTypes != null && !petTypes.isEmpty() && petTypes.get(0) != null) {
            query.append(" AND PetType IN (")
                .append(String.join(", ", petTypes.stream().map(p -> "?").toArray(String[]::new)))
                .append(")");
        }
        if (petOrigins != null && !petOrigins.isEmpty() && petOrigins.get(0) != null) {
            query.append(" AND PetOrigin IN (")
                .append(String.join(", ", petOrigins.stream().map(p -> "?").toArray(String[]::new)))
                .append(")");
        }
        if (petStatuses != null && !petStatuses.isEmpty() && petStatuses.get(0) != null) {
            query.append(" AND PetStatus IN (")
                .append(String.join(", ", petStatuses.stream().map(p -> "?").toArray(String[]::new)))
                .append(")");
        }
        if (petSizes != null && !petSizes.isEmpty() && petSizes.get(0) != null) {
            query.append(" AND PetSize IN (")
                .append(String.join(", ", petSizes.stream().map(p -> "?").toArray(String[]::new)))
                .append(")");
        }
        if (petGenders != null && !petGenders.isEmpty() && petGenders.get(0) != null) {
            query.append(" AND PetSex IN (")
                .append(String.join(", ", petGenders.stream().map(p -> "?").toArray(String[]::new)))
                .append(")");
        }

        // Add sorting
        if (sortCriteria != null && !sortCriteria.isEmpty()) {
            query.append(" ORDER BY ")
                .append(String.join(", ", sortCriteria));
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;

            // Set filter values
            if (petTypes != null && !petTypes.isEmpty() && petTypes.get(0) != null) {
                for (String type : petTypes) {
                    stmt.setString(paramIndex++, type);
                }
            }
            if (petOrigins != null && !petOrigins.isEmpty() && petOrigins.get(0) != null) {
                for (String origin : petOrigins) {
                    stmt.setString(paramIndex++, origin);
                }
            }
            if (petStatuses != null && !petStatuses.isEmpty() && petStatuses.get(0) != null) {
                for (String status : petStatuses) {
                    stmt.setString(paramIndex++, status);
                }
            }
            if (petSizes != null && !petSizes.isEmpty() && petSizes.get(0) != null) {
                for (String size : petSizes) {
                    stmt.setString(paramIndex++, size);
                }
            }
            if (petGenders != null && !petGenders.isEmpty() && petGenders.get(0) != null) {
                for (String gender : petGenders) {
                    stmt.setString(paramIndex++, gender);
                }
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pet pet = new Pet(
                        rs.getString("PetID"),
                        rs.getString("PetType"),
                        rs.getString("PetOrigin"),
                        rs.getString("PetStatus"),
                        rs.getString("PetSize"),
                        rs.getString("PetAge"),
                        rs.getString("PetName"),
                        rs.getString("PetSex")
                    );
                    pet.setPicURLBasedOnType(pet.getPetType());
                    pets.add(pet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    
    // Method to fetch date and time of existing applications
    public ArrayList<Application> getAllExistingApplications() {
        ArrayList<Application> apps = new ArrayList<>();
        String query = "{CALL GetAllExistingApplications()}"; // Adjust if your stored procedure name is different

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Application app = new Application();
                app.setAppointDate(rs.getString("AppointDate"));
                app.setAppointTime(rs.getString("AppointTime"));
                app.setVetID(rs.getString("VetID"));
                apps.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apps;
    }
    
    // Method to fetch a particular client account that matches the credentials
    public Client getClientByCredentials(String username, String password) {
        Client client = null;
        String query = "SELECT * FROM `client.v2` WHERE ClientAcctStatus = 'A' AND ClientUsername = ? AND ClientPassword = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    client = new Client(
                        rs.getInt("ClientID"),
                        rs.getString("ClientUsername"),
                        rs.getString("ClientPassword"),
                        rs.getString("ClientFullName"),
                        rs.getInt("ClientAge"),
                        rs.getString("ClientAddress"),
                        rs.getString("CellNum"),
                        rs.getString("ClientEmailAdd"),
                        rs.getString("ClientOccupation"),
                        rs.getString("CompanyName"),
                        rs.getString("WorkType"),
                        rs.getString("ClientAcctStatus")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
    
    // Method to fetch a particular veterinarian account that matches the credentials
    public Veterinarian getVetByCredentials(String username, String password) {
        Veterinarian vet = null;
        String query = "SELECT * FROM `vet.v2` WHERE VetAcctStatus = 'A' AND VetUsername = ? AND VetPassword = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vet = new Veterinarian(
                        rs.getString("VetID"),
                        rs.getString("VetUsername"),
                        rs.getString("VetPassword"),
                        rs.getString("VetFullName"),
                        rs.getInt("VetAge"),
                        rs.getString("VetCellNum"),
                        rs.getString("VetEmailAdd"),
                        rs.getString("VetAcctStatus")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vet;
    }
    
    // Method to insert an application record
    public boolean insertApplicationRecord(String applicationType, String appointDate, String appointTime, String appointPlace, String appointStatus, int clientID, int petID, int vetID) {
        String insertQuery = "INSERT INTO forevercomfunion.`application.v2` (applicationType, appointDate, appointTime, appointPlace, appointStatus, clientID, petID, vetID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {

            ps.setString(1, applicationType);
            ps.setString(2, appointDate);
            ps.setString(3, appointTime);
            ps.setString(4, appointPlace);
            ps.setString(5, appointStatus);
            ps.setInt(6, clientID);
            ps.setInt(7, petID);
            ps.setInt(8, vetID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to update the status of pet record
    public boolean updatePetStatus(int petID, String petStatus) {
        String updateQuery = "UPDATE forevercomfunion.`pet.v2`"
                           + "SET PetStatus = ?"
                           + "WHERE PetID = ?;";
       try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, petStatus);
            ps.setInt(2, petID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to get a particular application by id
    public Application getApplicationRecord(int applicationID) {
        Application application = null;
        String query = "SELECT * FROM forevercomfunion.`application.v2` WHERE ApplicationID = ?;";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, applicationID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    application = new Application(
                        rs.getInt("ApplicationID"),
                        rs.getString("ApplicationType"),
                        rs.getString("AppointDate"),
                        rs.getString("AppointTime"),
                        rs.getString("AppointStatus"),
                        rs.getInt("ClientID"),
                        rs.getString("PetID"),
                        rs.getString("VetID")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }
    
    // Method to get a particular pet by id
    public Pet getPetRecordByID(String petID) {
        Pet pet = null;
        String query = "SELECT * FROM forevercomfunion.`pet.v2` WHERE petID = ?;";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, petID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pet = new Pet(
                        rs.getString("PetID"),
                        rs.getString("PetType"),
                        rs.getString("PetOrigin"),
                        rs.getString("PetStatus"),
                        rs.getString("PetSize"),
                        rs.getString("PetAge"),
                        rs.getString("PetName"),
                        rs.getString("PetSex")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }
    
    // Method to get a particular application by id
    public Veterinarian getVetRecordByID(String vetID) {
        Veterinarian vet = null;
        String query = "SELECT * FROM forevercomfunion.`vet.v2` WHERE vetID = ?;";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, vetID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vet = new Veterinarian(
                        rs.getString("VetID"),
                        rs.getString("VetUsername"),
                        rs.getString("VetPassword"),
                        rs.getString("VetFullName"),
                        rs.getInt("VetAge"),
                        rs.getString("VetCellNum"),
                        rs.getString("VetEmailAdd"),
                        rs.getString("VetAcctStatus")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vet;
    }
    
    // Method to fetch count of all pet records
    public int getAllPetsCount() {
        int petCount = 0;
        String query = "{CALL GetAllPetsCount()}"; // Adjust if your stored procedure name is different

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             CallableStatement stmt = connection.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                petCount = rs.getInt("Count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petCount;
    }
    
    // Method to update application record
    public boolean updateApplicationRecord(int applicationID, String applicationType, String appointDate, String appointTime, String appointPlace, String appointStatus, int clientID, int selectedPetID, int selectedVetID) {
        String updateQuery = "UPDATE forevercomfunion.`application.v2` SET applicationType = ?, appointDate = ?, appointTime = ?, appointPlace = ?, appointStatus = ?, clientID = ?, petID = ?, vetID = ? WHERE applicationID = ?;";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, applicationType);
            ps.setString(2, appointDate);
            ps.setString(3, appointTime);
            ps.setString(4, appointPlace);
            ps.setString(5, appointStatus);
            ps.setInt(6, clientID);
            ps.setInt(7, selectedPetID);
            ps.setInt(8, selectedVetID);
            ps.setInt(9, applicationID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to delete an application record
    public boolean deleteApplicationRecordByID(int applicationID) {
        String deleteQuery = "DELETE FROM forevercomfunion.`application.v2` WHERE applicationID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setInt(1, applicationID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to insert a pet record and return the generated primary key
    public int insertPetRecord(String petType, String petOrigin, String petStatus, String petSize,
                               String petAge, String petName, String petSex) {
        String insertQuery = "INSERT INTO forevercomfunion.`pet.v2` (petType, petOrigin, petStatus, petSize, petAge, petName, petSex) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int generatedKey = 0;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, petType);
            ps.setString(2, petOrigin);
            ps.setString(3, petStatus);
            ps.setString(4, petSize);
            ps.setString(5, petAge);
            ps.setString(6, petName);
            ps.setString(7, petSex);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedKey = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedKey;
    }
    
    // Method to update a pet record by ID and return the petID if successful, otherwise return 0
    public int updatePetRecordByID(int petID, String petType, String petOrigin, String petStatus, String petSize,
                                   String petAge, String petName, String petSex) {
        String updateQuery = "UPDATE forevercomfunion.`pet.v2` SET petType = ?, petOrigin = ?, petStatus = ?, petSize = ?, petAge = ?, petName = ?, petSex = ? WHERE petID = ?";
        int result = 0;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, petType);
            ps.setString(2, petOrigin);
            ps.setString(3, petStatus);
            ps.setString(4, petSize);
            ps.setString(5, petAge);
            ps.setString(6, petName);
            ps.setString(7, petSex);
            ps.setInt(8, petID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                result = petID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method to delete a pet record by ID
    public int deletePetRecordByID(int petID) {
        String deleteQuery = "DELETE FROM forevercomfunion.`pet.v2` WHERE petID = ?";
        int result = 0;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(deleteQuery)) {

            ps.setInt(1, petID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                result = petID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method to accept an application record
    // Changing the appointStatus to "S"
    public boolean acceptApplicationRecord(int appID) {
        return updateApplicationStatus(appID, "S");
    }

    // Method to decline an application record
    // Changing the appointStatus to "C"
    public boolean declineApplicationRecord(int appID) {
        return updateApplicationStatus(appID, "C");
    }

    // Common method to update the application status
    private boolean updateApplicationStatus(int appID, String appointStatus) {
        String updateQuery = "UPDATE forevercomfunion.`application.v2` SET appointStatus = ? WHERE applicationID = ?";
        boolean result = false;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, appointStatus);
            ps.setInt(2, appID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method to update client record by id
    public boolean updateClientRecordByID(int clientID, String username, String password, String fullName, int age, String currentAddress, String contactNumber, String emailAddress, String occupation, String companyName, String workType, String acctStatus) {
        String updateQuery = "UPDATE `client.v2` SET ClientUsername = ?, ClientPassword = ?, ClientFullName = ?, ClientAge = ?, ClientAddress = ?, CellNum = ?, ClientEmailAdd = ?, ClientOccupation = ?, CompanyName = ?, WorkType = ?, ClientAcctStatus = ? WHERE ClientID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setInt(4, age);
            ps.setString(5, currentAddress);
            ps.setString(6, contactNumber);
            ps.setString(7, emailAddress);
            ps.setString(8, occupation);
            ps.setString(9, companyName);
            ps.setString(10, workType);
            ps.setString(11, acctStatus);
            ps.setInt(12, clientID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to update vet record by id
    public boolean updateVetRecordByID(int vetID, String username, String password, String fullName, int age, String contactNumber, String emailAddress, String acctStatus) {
        String updateQuery = "UPDATE `vet.v2` SET VetUsername = ?, VetPassword = ?, VetFullName = ?, VetAge = ?, VetCellNum = ?, VetEmailAdd = ?, VetAcctStatus = ? WHERE VetID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setInt(4, age);
            ps.setString(5, contactNumber);
            ps.setString(6, emailAddress);
            ps.setString(7, acctStatus);
            ps.setInt(8, vetID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Method to delete a client record by changing the account status to "D"
    public boolean deleteClientRecordByID(int clientID) {
        String updateQuery = "UPDATE forevercomfunion.`client.v2` SET ClientAcctStatus = 'D' WHERE ClientID = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setInt(1, clientID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Method to delete a veterinarian record by changing the account status to "D"
    public boolean deleteVetRecordByID(int vetID) {
        String updateQuery = "UPDATE forevercomfunion.`vet.v2` SET VetAcctStatus = 'D' WHERE VetID = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setInt(1, vetID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to update pending applications assigned to a vet when they are deactivated
    // If applicationType == "A", the corresponding petID's petStatus would be set to "NA" and appointStatus would be set to "C" for Cancelled
    // If applicationType == "R", the application would be deleted and the corresponding petID's record would be deleted also
    public void updateApplicationRecordByVetID(int vetID) {
        ArrayList<Application> adoptApplications = null;
        ArrayList<Application> rehomeApplications = null;
        
        adoptApplications = getPendingAdoptionApplicationsForVet(String.valueOf(vetID));
        rehomeApplications = getPendingRehomeApplicationsForVet(String.valueOf(vetID));
        
        if(adoptApplications != null) {
            for(Application adopt : adoptApplications) {
                declineApplicationRecord(vetID);
                updatePetStatus(Integer.valueOf(adopt.getPetID()), "NA");
            }
        }
        if(rehomeApplications != null) {
            for(Application rehome : rehomeApplications) {
                int curPetID = Integer.valueOf(rehome.getPetID());
                deleteApplicationRecordByID(rehome.getApplicationID());
                deletePetRecordByID(curPetID);
            }
        }
    }
    
    // Method to update pending applications assigned to a client when they deactivated
    // If applicationType == "A", the corresponding petID's petStatus would be set to "NA" and appointStatus would be set to "C" for Cancelled
    // If applicationType == "R", the application would be deleted and the corresponding petID's record would be deleted also
    public void updateApplicationRecordByClientID(int clientID) {
        ArrayList<Application> applications = null;
        
        getApplicationHistoryForClient(clientID);
        if(applications != null) {
            for(Application app : applications) {
                String appType = app.getApplicationType();
                if(appType.equals("A")) {
                    declineApplicationRecord(Integer.valueOf(app.getVetID()));
                    updatePetStatus(Integer.valueOf(app.getPetID()), "NA");
                } else if(appType.equals("R")) {
                    int curPetID = Integer.valueOf(app.getPetID());
                    deleteApplicationRecordByID(app.getApplicationID());
                    deletePetRecordByID(curPetID);
                }
            }
        }
    }
    
    public void buildAndExecuteSummaryQuery(List<String> displayAttributes, List<String> columnFunctions, List<String> havingConditions) {
        String query = buildQuery(displayAttributes, columnFunctions, havingConditions);

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Process the result set here as needed
                for (String attribute : displayAttributes) {
                    System.out.print(attribute + ": " + resultSet.getString(attribute) + " ");
                }
                for (String function : columnFunctions) {
                    String[] parts = function.split(" ");
                    if (parts.length > 1) {
                        System.out.print(parts[1] + ": " + resultSet.getString(parts[1]) + " ");
                    }
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // THIS IS THE 1 TO BE CALLED !!!
    }

    private String buildQuery(List<String> displayAttributes, List<String> columnFunctions, List<String> havingConditions) {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT ");
        if (!displayAttributes.isEmpty()) {
            queryBuilder.append(String.join(", ", displayAttributes));
        }
        if (!columnFunctions.isEmpty()) {
            if (!displayAttributes.isEmpty()) {
                queryBuilder.append(", ");
            }
            queryBuilder.append(String.join(", ", columnFunctions));
        }

        queryBuilder.append(" FROM forevercomfunion.`application.v2` a, forevercomfunion.`client.v2` c, forevercomfunion.`pet.v2` p, forevercomfunion.`vet.v2` v ");
        queryBuilder.append("WHERE a.ClientID = c.ClientID AND a.PetID = p.PetID AND a.VetID = v.VetID ");

        if (!displayAttributes.isEmpty()) {
            queryBuilder.append("GROUP BY ").append(String.join(", ", displayAttributes)).append(" ");
        }

        if (!havingConditions.isEmpty()) {
            queryBuilder.append("HAVING ").append(String.join(" AND ", havingConditions)).append(" ");
        }
        System.out.println(queryBuilder.toString());

        return queryBuilder.toString();
    }
}
