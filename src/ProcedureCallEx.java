import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

public class ProcedureCallEx {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
  private static final String DB_UNAME = "root";
  private static final String DB_PWD = "root";
  private static final String PROCEDURE = "call getbooksdata()";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        Connection con  = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		CallableStatement cstmt = (CallableStatement) con.prepareCall(PROCEDURE);
		ResultSet rs = cstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));

		}
		con.close();
	}

}
