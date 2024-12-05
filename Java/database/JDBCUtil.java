package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
        Connection c = null;

        try {
            // Thông tin kết nối MySQL
            String url = "jdbc:mysql://localhost:3306/storecirclek";
            String username = "root";
            String password = "123456";
            
            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void printInfo(Connection c) {
    	try {
			if(c != null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
