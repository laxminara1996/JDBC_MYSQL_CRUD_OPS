import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class InsertBook {

	  private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	  private static final String DB_UNAME = "root";
	  private static final String DB_PWD = "root";
	  private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(04,'WEB',1200)";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
        //step:1 load driver
		Class.forName("com.mysql.jdbc.Driver");
		//step2: get Connection
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		System.out.println(con);
		//step3: create statement
		 Statement stmt =  con.createStatement();
		//step4: execute query
		int row = stmt.executeUpdate(INSERT_SQL);
		//step5 : process result
		System.out.println(row);
		//step6: close connection
		con.close();
	}

}
