package managers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import data.Entry;
import data.Stat;

public class EntryManager extends Manager {
	public static final String ATTRIBUTE_NAME = "entryManager";
	
	public EntryManager(DataSource dataSource) {
		super(dataSource);
	}
	
	public boolean addEntry(Entry entry) {
		try {
			Connection con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO Entry(");
			sb.append("user_name, submission_date, movie_name, entry_type)");
			sb.append("VALUES(?, ?, ?, ?)");
			PreparedStatement st = con.prepareStatement(sb.toString());
			st.setString(1, entry.getUsername());
			
			st.setTimestamp(2, entry.getSubmissionDate());
			st.setString(3, entry.getMovieName());
			st.setString(4, entry.getEntryType());
			st.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Stat> getEntries(int limit) {
		List<Stat> result = new ArrayList<Stat>();
		try {
			Connection con = dataSource.getConnection();
			String query = "select a.*, b.seansebis_Raodenoba, c.sxva_Raodenoba from( "
					+ " (select movie_name, count(1) as javshnebis_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'ჯავშანი'"
					+ " group by movie_name) "
					+ " union "
					+ " (select Distinct movie_name,0 as javshnebis_Raodenoba"
					+ " from Entry"
					+ " where !( movie_name in "
					+ " (select distinct movie_name as javshnebis_Raodenoba	 "
					+ " from Entry"
					+ " where entry_type = 'ჯავშანი'"
					+ " group by movie_name)  )	"
					+ " group by movie_name )  ) a"
					+ " inner join  "
					+ " ((select movie_name,count(1) as seansebis_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'სეანსები'"
					+ " group by movie_name) "
					+ " union "
					+ " (select Distinct movie_name,0 as seansebis_Raodenoba	"
					+ " from Entry"
					+ " where !( movie_name in "
					+ " (select distinct movie_name as seansebis_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'სეანსები'"
					+ " group by movie_name)  )"
					+ " group by movie_name) ) b"
					+ " on a.movie_name = b.movie_name"
					+ " inner join  "
					+ " ((select movie_name,count(1) as sxva_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'სხვა'"
					+ " group by movie_name) "
					+ " union "
					+ " (select Distinct movie_name,0 as sxva_Raodenoba	"
					+ " from Entry"
					+ " where !( movie_name in "
					+ " (select distinct movie_name as sxva_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'სხვა'"
					+ " group by movie_name)  )"
					+ " group by movie_name) ) c"
					+ " on a.movie_name = c.movie_name"
					+ " limit " + limit;
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String movieName = rs.getString(1);
				Integer javshnebi = rs.getInt(2);
				Integer seansebi = rs.getInt(3);
				Integer bla = 0;
				Stat stat = new Stat(movieName, javshnebi, seansebi, bla);
				result.add(stat);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Stat> searchEntries(Timestamp startDate, Timestamp endDate) {
		List<Stat> result = new ArrayList<Stat>();
		try {
			Connection con = dataSource.getConnection();
			String query = "select a.*, b.seansebis_Raodenoba from( "
					+ " (select movie_name, count(1) as javshnebis_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'javshani'"
					+ " and submission_date < '" + endDate + "'"
					+ " and submission_date > '" + startDate + "'"
					+ " group by movie_name) "
					+ " union "
					+ " (select Distinct movie_name,0 as javshnebis_Raodenoba"
					+ " from Entry"
					+ " where !( movie_name in "
					+ " (select distinct movie_name as javshnebis_Raodenoba	 "
					+ " from Entry"
					+ " where entry_type = 'javshani'"
					+ " group by movie_name)  )	"
					+ " group by movie_name )  ) a"
					+ " inner join  "
					+ " ((select movie_name,count(1) as seansebis_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'seansebi'"
					+ " and submission_date < '" + endDate + "'"
					+ " and submission_date > '" + startDate + "'"
					+ " group by movie_name) "
					+ " union "
					+ " (select Distinct movie_name,0 as seansebis_Raodenoba	"
					+ " from Entry"
					+ " where !( movie_name in "
					+ " (select distinct movie_name as seansebis_Raodenoba"
					+ " from Entry"
					+ " where entry_type = 'seansebi'"
					+ " group by movie_name)  )"
					+ " group by movie_name) ) b"
					+ " on a.movie_name = b.movie_name";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String movieName = rs.getString(1);
				Integer javshnebi = rs.getInt(2);
				Integer seansebi = rs.getInt(3);
				Integer sxva = rs.getInt(4);
				Stat stat = new Stat(movieName, javshnebi, seansebi, sxva);
				result.add(stat);
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
