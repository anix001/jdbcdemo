import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/javalearn";
        String username ="root";
        String password = "root";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT  * FROM student_tbl");

            while (resultSet.next())
                System.out.println(resultSet.getLong(1) + " "+ resultSet.getInt(2) +" " + resultSet.getString(3) + " " + resultSet.getString(4));

            conn.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
