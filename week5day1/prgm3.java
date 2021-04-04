package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class prgm3 {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from pupil");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		
		System.out.println("No. of Cols =" +rsmd.getColumnCount());
		int colCount = rsmd.getColumnCount();
		for(int i=1;i<=colCount;i++)
		{
		String c=rsmd.getColumnName(i);
		
		String c1=rsmd.getColumnTypeName(i);
		String c2=rsmd.getColumnLabel(i);
		System.out.println("columne name " +c +" typename "+c1+" label " +c2);
	}

}
	}
