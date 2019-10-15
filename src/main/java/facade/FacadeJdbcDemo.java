package facade;

import java.sql.SQLException;

public class FacadeJdbcDemo {
	public static void main(String[] args) throws SQLException {
		JdbcFacade jdbcFacade = new JdbcFacade();

		jdbcFacade.createTable();

//		System.out.println("Table created");

		jdbcFacade.insertIntoTable();

//		System.out.println("Record Inserted");

		jdbcFacade.getAddresses();

	}
}
