import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class SelectBook {

	   private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	   private static final String DB_UNAME = "root";
	   private static final String DB_PWD = "root";
	   private static final String SELECT_SQL = "SELECT * FROM BOOKS";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		    /*Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery(SELECT_SQL);
		    while(rs.next()) {
		    	System.out.println(rs.getInt("book_id")+"-----"+rs.getString("book_name")+"----------"+rs.getString("book_price"));
		    }
		    con.close();*/
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		System.out.println(rs.getFetchSize());
		rs.absolute(1);
		rs.updateInt(4, 2000);
		rs.updateRow();
		ResultSetMetaData meta=rs.getMetaData();
		System.out.println(meta.getColumnCount());
		 for(int i=1;i<=meta.getColumnCount();i++){

             String columnName = meta.getColumnName(i);
                           System.out.println(columnName);


            }
		 
		 


		/*System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
		rs.previous();
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
		rs.next();
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));*/
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
			Thread.sleep(20000);
		}
		con.close();
	}

}
