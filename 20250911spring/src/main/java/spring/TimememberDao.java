package spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;




@Component
public class TimememberDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TimememberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public List<Timemember> selectAll(){
		return jdbcTemplate.query("select * from timemember",
				(rs, num) -> {
					Timemember timemember = new Timemember(rs.getInt("ID"), rs.getString("PASSWORD"), rs.getLong("starttime"),rs.getLong("endtime"),rs.getLong("totaltime"),rs.getInt("rank1"));
				return timemember;
				});
	}
	

	public void insert(Timemember timemember) {
		jdbcTemplate.update("INSERT INTO timemember (ID, PASSWORD,starttime, endtime, total, rank) VALUES (?,?,?,?,?,?,?)",
				timemember.getId(), timemember.getPassword(), null, null, null, null);
		
	}
	
	public void update(Timemember timemember) {
		jdbcTemplate.update("""
		        UPDATE timemember
		        SET starttime = ?, endtime = ?, total = ?
		        WHERE id = ?
		    """, timemember.getStarttime(), timemember.getEndtime(), timemember.getTotaltime(), timemember.getId());
		
		jdbcTemplate.update("""
		        UPDATE timemember tt
		        JOIN (
		            SELECT id,
		                   DENSE_RANK() OVER (ORDER BY total ASC) AS new_rank
		            FROM timemember
		            WHERE total IS NOT NULL
		        ) r ON r.id = tt.id
		        SET tt.rank = r.new_rank
		    """);
	}
	
	public Timemember timecheckstart(Timemember timemember) {
		long start = System.nanoTime();
		timemember.setStarttime(start);
		
		return timemember;
	}
	public Timemember timecheckend(Timemember timemember) {
		long end = System.nanoTime();
		timemember.setStarttime(end);
		return timemember;
	}
	
	public Timemember timechecktotal(Timemember timemember) {
		long total = timemember.getEndtime() - timemember.getStarttime();
		timemember.setTotaltime(total);
		return timemember;
	}
	
	
	
	
	
}
