package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SPManager {
    private static final String URL = "jdbc:mysql://localhost:3306/furever_comfunion";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "_03riseandshine07_";
    
    /* Method to fetch all pets
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "{CALL GetAllPets()}";
            try (CallableStatement stmt = connection.prepareCall(query)) {
                ResultSet rs = stmt.executeQuery();
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
    */

    // Method to fetch filtered and sorted pets
    public ArrayList<Pet> getFilteredSortedPets(List<String> petTypes, List<String> petOrigins, List<String> petStatuses,
                                                List<String> petSizes, List<String> petGenders, List<String> sortCriteria) {
        ArrayList<Pet> pets = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
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

            System.out.println("Constructed Query: " + query.toString());
            try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
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

                ResultSet rs = stmt.executeQuery();
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
}
