package dao;

import java.sql.*;

public class SingletonConnetion {
	
	private static Connection connection;
		static {


		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Magasin_DB",
					"postgres","mouad"); }
		catch (Exception e) { 
			// TODO Auto-generated catch
			 e.printStackTrace(); }

	}


		public static Connection  getConnection() {
			return connection;
		}





	}
