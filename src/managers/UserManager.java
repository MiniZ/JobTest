package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import data.Entry;
import data.User;

public class UserManager extends Manager {
	public static final String ATTRIBUTE_NAME = "userManager";
	
	public UserManager(DataSource dataSource) {
		super(dataSource);
	} 
	
	public boolean usernameExists(String username) {
		try {
			Connection con = dataSource.getConnection();
			String query = "SELECT * FROM User WHERE user_name= '" + username + "'";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			boolean contains = result.next();
			con.close();
			return contains;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createUser(User user) {
		try {
			Connection con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO User(");
			sb.append("user_name, hashed_password, first_name, last_name)");
			sb.append("VALUES(?, ?, ?, ?)");
			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, user.getUsername());
			st.setString(2, user.getHashedPassword());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLastName());
			st.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isAdmin(String username) {
		try {
			Connection con = dataSource.getConnection();
			String query = "SELECT * FROM Admins WHERE user_name ='" + username + "'";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			boolean isAdmin = result.next();
			con.close();
			return isAdmin;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Entry> getEntries(String username, int limit) {
		List<Entry> entries = new ArrayList<Entry>();
		try {
			Connection con = dataSource.getConnection();
			String query = "SELECT * FROM Entry WHERE user_name ='" + username +"' "
					+ " ORDER BY submission_date desc " + "LIMIT " + limit;
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Integer ID = rs.getInt(1);
				Timestamp submissionDate = rs.getTimestamp(3);
				String movieName = rs.getString(4);
				String entryType = rs.getString(5);
				Entry entry = new Entry(ID, username, submissionDate,movieName, entryType);
				entries.add(entry);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return entries;
	}
	
	public User getAccount(String username) {
		User acc = null;
		try {
			Connection con = dataSource.getConnection();
			String query = generateSimpleSelectQuery("User",
					new ArrayList<String>(), "user_name", username);
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				acc = new User(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}

	public boolean authenticateUser(String username, String hashedPassword) {
		User target = getAccount(username);
		if (target != null)
			return hashedPassword.equals(target.getHashedPassword());
		return false;
	}
}








