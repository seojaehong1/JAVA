package dept;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeptDao {

private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private DeptDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Dept> selectAll(){
		return jdbcTemplate.query("select * from dept",
				(rs, num) -> {
					Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				return dept;
				});
	}
	
	public List<Dept> selectByDeptno(int deptno) {
		return jdbcTemplate.query("select * from dept where deptno = ?", 
				(rs, num) -> {
					Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				return dept;
				},deptno);
	}
	
	public void insert(Dept dept) {
		jdbcTemplate.update("INSERT INTO dept (deptno, dname, loc) VALUES (?,?,?)",
				dept.getDeptno(), dept.getDname(), dept.getLoc());
	}
	
	public void update(Dept dept) {
		jdbcTemplate.update("UPDATE dept SET dname = ?, loc = ? where deptno = ?",
				dept.getDname(), dept.getLoc(),dept.getDeptno());
	}
	public void delete(int deptno) {
		jdbcTemplate.update("DELETE FROM dept where deptno = ?",
				deptno);
	}
	
	
}
