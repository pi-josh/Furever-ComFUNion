package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SPManager {
    private static final String URL = "jdbc:mysql://localhost:3306/forevercomfunion";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "_03riseandshine07_";

    public SPManager() {
        // Connection is created per method call, not in the constructor
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
    public boolean insertApplicationRecord(String applicationType, String appointDate, String appointTime, String appointPlace, String appointStatus, int clientID, String petID, String vetID) {
        String insertQuery = "INSERT INTO forevercomfunion.`application.v2` (applicationType, appointDate, appointTime, appointPlace, appointStatus, clientID, petID, vetID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {

            ps.setString(1, applicationType);
            ps.setString(2, appointDate);
            ps.setString(3, appointTime);
            ps.setString(4, appointPlace);
            ps.setString(5, appointStatus);
            ps.setInt(6, clientID);
            ps.setString(7, petID);
            ps.setString(8, vetID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to update the status of pet record
    public boolean updatePetStatus(String petID, String petStatus) {
        String updateQuery = "UPDATE forevercomfunion.`pet.v2`"
                           + "SET PetStatus = ?"
                           + "WHERE PetID = ?;";
       try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, petStatus);
            ps.setString(2, petID);

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
}
