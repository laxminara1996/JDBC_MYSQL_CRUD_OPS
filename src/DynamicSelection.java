import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DynamicSelection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          Scanner sc = new Scanner(System.in);
          System.out.println("enter price");
          int price = sc.nextInt();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		StringBuilder sql = new StringBuilder("select * from books");
		if (price>0){
			sql.append(" where book_price <= ?");
		}
		PreparedStatement ps = con.prepareStatement(sql.toString());
		if (price>0) {
			ps.setInt(1,price);
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"---------"+rs.getString(2)+"---------"+rs.getInt(3));
		}
		con.close();
	}
	

}
