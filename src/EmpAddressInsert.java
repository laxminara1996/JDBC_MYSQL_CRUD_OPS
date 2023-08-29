import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpAddressInsert {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	  private static final String DB_UNAME = "root";
	  private static final String DB_PWD = "root";
	  private static final String EMP_INSERT = "INSERT INTO EMP VALUES(?,?,?)";
		private static final String EMP_ADDR_INSERT = "INSERT INTO ADDRESS VALUES(?,?,?,?)";

		public static void main(String[] args) throws Exception {

			Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

			// By Default conn - autoCommit mode is true

			con.setAutoCommit(false);

			try {
				/*PreparedStatement pstmt = con.prepareStatement(EMP_INSERT);
				pstmt.setInt(1, 101);
				pstmt.setString(2, "John");
				pstmt.setDouble(3, 1000.00);

				pstmt.executeUpdate();*/

				PreparedStatement pstmt2 = con.prepareStatement(EMP_ADDR_INSERT);
				pstmt2.setString(1, "Hyd");
				pstmt2.setString(2, "TG");
				pstmt2.setString(3, "India");
				pstmt2.setInt(4, 101);
				pstmt2.executeUpdate();

				con.commit();

				System.out.println("Records Inserted...");

			} catch (Exception e) {
				System.out.println("Transcation Rolled Back....");
				con.rollback();
			}
			con.close();
		}

}
