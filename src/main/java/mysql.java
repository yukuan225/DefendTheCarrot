import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {
    private Connection con;
    private Statement state;
    public static String username;
    public static String password;
    public static String id;

    /*
     连接数据库
     */
    public mysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("", "", "");
        state = con.createStatement();
    }
    public Connection getCon() {
        return con;
    }




}


