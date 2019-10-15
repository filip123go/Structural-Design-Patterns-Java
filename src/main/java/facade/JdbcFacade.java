package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcFacade {
	private static final Logger LOGGER = Logger.getLogger(JdbcFacade.class.getName());
	private DbSingleton instance;
	private Statement sta = null;
	private Connection conn = null;


	public JdbcFacade() {
		instance = DbSingleton.getInstance();
	}

	public int createTable() {
		int count = 0;
		try {
			openConnection();
			count = sta.executeUpdate("CREATE TABLE Address (ID INTEGER, StreetName VARCHAR(20), City VARCHAR(20))");
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "---Cannot CREATE TABLE. Please check the sql syntax and the connection to the db ---", e);
		} finally {
			closeConnection();
		}
		return count;
	}

	public int insertIntoTable() {
		int count = 0;
		try {
			openConnection();
			count = sta.executeUpdate("INSERT INTO Address (ID , StreetName , City) values (1,'1234 Some Street', 'Layton')");
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "---Cannot INSERT SQL statement. Please check the sql syntax and the connection to the db ---", e);
		} finally {
			closeConnection();
		}
		return count;
	}

	public List<Address> getAddresses() throws SQLException {
		List<Address> addresses = new ArrayList<>();
		ResultSet rs = null;

		try {
			openConnection();
			rs = sta.executeQuery("SELECT * FROM Address");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				Address address = new Address();
				address.setId(rs.getString(1));
				address.setStreetName(rs.getString(2));
				address.setCity(rs.getString(3));

				addresses.add(address);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "---Cannot Select from Address table. Please check the sql syntax and the connection to the db ---", e);
		} finally {
			assert rs != null;
			rs.close();
			closeConnection();
		}
		return addresses;
	}


	private Statement openConnection() {
		conn = instance.getConnection();
		try {
			sta = conn.createStatement();
			LOGGER.log(Level.INFO, "---Connection established ---");
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "---There was a problem creating the connection ---", e);
		}
		return sta;
	}

	private void closeConnection() {
		assert sta != null;
		try {
			sta.close();
			conn.close();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "---There was a problem closing the connection ---", e);
		}
		LOGGER.log(Level.INFO, "---Connection closed ---");
	}
}

class Address {
	private String id;
	private String streetName;
	private String city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}