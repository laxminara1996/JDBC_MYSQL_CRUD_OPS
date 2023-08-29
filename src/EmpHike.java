import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpHike {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";
 	private static final String UPDATE_SQL_SALARY = "update employee set emp_salary = emp_salary+(emp_salary*?)/100";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
         System.out.println("enter HIKE");
         int hike = sc.nextInt();
         Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
 		PreparedStatement psmt = con.prepareStatement(UPDATE_SQL_SALARY);
 		psmt.setInt(1,hike);
 		psmt.executeUpdate();
 		System.out.println("update completed");
 		con.close();
	}

}
