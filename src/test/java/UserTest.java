import entities.User;
import org.junit.jupiter.api.Test;
import persistence.DBConnector;
import persistence.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        Connection con = null;
        try {
            con = DBConnector.connection();
            String dropTable = "DROP TABLE usertable";
            con.prepareStatement(dropTable).executeUpdate();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @Test
    public void listAllUserNamesTest(){
        UserMapper userMapper = new UserMapper();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Hans");
        ArrayList<String> actual = userMapper.getAllUserNames();
        assertEquals(expected, actual);

    }

    @Test
    public void getSpecificUserInfoTest(){
        UserMapper userMapper = new UserMapper();
        User user = userMapper.getUserByID(1);
        assertEquals("Hans", user.getfName());
        assertEquals("Hansen", user.getlName());
        assertEquals("Hemmelig123", user.getPassword());
        assertEquals("40404040", user.getPhone());
        assertEquals("Rolighedsvej 3", user.getAddress());

    }
}
