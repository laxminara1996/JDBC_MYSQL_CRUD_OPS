import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BathcOpsEx {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	  private static final String DB_UNAME = "root";
	  private static final String DB_PWD = "root";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		Statement stmt = con.createStatement();
		stmt.addBatch("insert into books values(5,'Ai',2300)");
		stmt.addBatch("insert into books values(6,'Ml',2300)");
		stmt.addBatch("insert into books values(7,'Ds',2300)");
        int[] count = stmt.executeBatch();
        System.out.println("rows affected:"+count.length);
        con.close();
		
	}

}
