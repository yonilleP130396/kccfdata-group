package jsp.servlet.crud.groupgratefulnessmanagementsystem.dao;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp.servlet.mysql.crud.managementsystem01.model.Members;


public class StudentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_management_system";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_USERS_SQL = "INSERT INTO gratefullness_group_members" + "  (st_name, st_address,st_course,st_gender,st_posistion,st_remarks, st_photos) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?);";

    
			
    		
    private static final String SELECT_USER_BY_ID = "select * from gratefullness_group_members where id =?";
    private static final String SELECT_ALL_USERS = "select * from gratefullness_group_members";
    private static final String DELETE_USERS_SQL = "delete from gratefullness_group_members where id = ?;";
    private static final String UPDATE_USERS_SQL = "update gratefullness_group_members set st_name=?, st_address=?,st_course=?,st_gender=?,st_posistion=?,st_remarks=?, st_photos=? where id = ?;";
    
    
    private static final String SELECT_ACCOUNTUSERS_SQL = "select * from accountloginusers where username = ? and password = ? ";

    public StudentDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    
    

    public void insertStudent(Members member) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getAddress());
            preparedStatement.setString(3, member.getCourse());
            preparedStatement.setString(4, member.getGender());
            preparedStatement.setString(5, member.getPosition());
            preparedStatement.setString(6, member.getRemarks());
            preparedStatement.setString(7, member.getPicturelocation());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Members selectStudent(int id) {
        Members member = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("st_name");
                String address = rs.getString("st_address");
                String course = rs.getString("st_course");
                String gender = rs.getString("st_gender");
                String posistion = rs.getString("st_posistion");
                String remarks = rs.getString("st_remarks");
                String photo = rs.getString("st_photos");
                member = new Members(id, name, address, course, gender, posistion, remarks, photo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return member;
    }

    public List < Members > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Members > members = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("st_name");
                String address = rs.getString("st_address");
                String course = rs.getString("st_course");
                
                String gender = rs.getString("st_gender");
                String posistion = rs.getString("st_posistion");
                String remarks = rs.getString("st_remarks");
                String photo = rs.getString("st_photos");
                members.add(new Members(id, name, address, course, gender, posistion, remarks, photo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return members;
    }

    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
 
    public boolean updateStudent(Members member) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getAddress());
            statement.setString(3, member.getCourse());
            statement.setString(4, member.getGender());
            statement.setString(5, member.getPosition());
            statement.setString(6, member.getRemarks());
            statement.setString(7, member.getPicturelocation());

            statement.setInt(8, member.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    //dao for login THAT VALIDATES USER
    public  boolean validateUser(String username, String password) {
        try (Connection connection =getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNTUSERS_SQL)) {
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
      }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    
}