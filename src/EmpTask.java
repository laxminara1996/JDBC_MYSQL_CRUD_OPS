import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpTask {
	
private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
private static final String DB_UNAME = "root";
private static final String DB_PWD = "root";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
         Scanner sc = new Scanner(System.in);
         System.out.println("enter dept");
         String dept = sc.next();
         System.out.println("enter location");
         String location = sc.next(); 
         System.out.println("enter gender");
         String gender = sc.next();
 		Class.forName("com.mysql.jdbc.Driver");
 		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		StringBuilder sql = new StringBuilder("select * from employee where 1=1 ");
 		if(dept!=null && !dept.equals("null")){
 			sql.append("and emp_dept =?");	
 		}
 		if(location!=null &&!location.equals("null")){
 			sql.append("and work_location= ?");	
 		}
 		if(gender!=null && !gender.equals("null")){
 			sql.append("and emp_gender =?");	
 		}
		PreparedStatement psmt = con.prepareStatement(sql.toString());
		int index = 1;
		if((dept!=null) &&(!dept.equals("null"))){
			psmt.setString(index, dept);
			index++;
		}
		if((location!=null) &&(!location.equals("null"))){
			psmt.setString(index, location);
			index++;
		}
		if((gender!=null) && (!gender.equals("null"))){
			psmt.setString(index, gender);
		}
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3)+"---"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));
			
		}
		con.close();
	}
}
