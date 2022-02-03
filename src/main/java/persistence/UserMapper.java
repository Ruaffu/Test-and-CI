package persistence;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {
    public ArrayList<String> getAllUserNames() {
            ArrayList<String> userNames = new ArrayList<>();

            try (Connection connection = DBConnector.connection()) {
                String sql = "SELECT fname FROM usertable ";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String fname = rs.getString("fname");
                        userNames.add(fname);

                    }
                    return userNames;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
}
