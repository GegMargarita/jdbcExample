import java.sql.*;
import java.util.Scanner;

public class JDBCExample {


    public static void main(String[] args) {
        final String login = "root";
        final String pass = "aaaa";
        final String url = "jdbc:mysql://localhost:3306/LOGIN_REGISTOR";

        // name , surname , email , password
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name ");
        String name = scanner.next();

        System.out.println("Enter email ");
        String email = scanner.next();

        System.out.println("Enter password ");
        String password = scanner.next();

        //insert into LOGIN_REGISTOR values('Maga' , "Geghamyan" , "gegmargarita@gmail.com", "aaaa");
        String sql = "insert into LOGIN_REGISTOR values('" + name + "','" + email + "','" + password + "')";
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            conn = DriverManager.getConnection(url, login, pass);
            Statement st = conn.createStatement();
            if (st.executeUpdate(sql) == 1) {
                System.out.println("Successfull" + sql);
            } else {
                System.out.println("insertion failed");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


}
