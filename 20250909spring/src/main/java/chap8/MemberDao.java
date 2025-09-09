package chap8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate; //여기는 autowired가 필요가없넹?
	
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail2(String email) { //기본생성자 생성해야하고 queryForObject는 결과값이 없거나 2개이상이면 오류를 일으킨다. 뭐 잡을려면 trycatch말곤 없는듯?
		return jdbcTemplate.queryForObject("select * from member where email = ?",
				new BeanPropertyRowMapper<>(Member.class)
				,email);
	}
	
	
	public Member selectByEmail1(String email) {
		List<Member> results = jdbcTemplate.query("select * from member where email = ?",
				(rs, num) -> {  //람다식이 훨신 짧네~
					Member mem = new Member(rs.getLong("id"),rs.getString("email"),rs.getString("password"), rs.getString("name"), null);
						
					return mem;
				},
//				new RowMapper<Member>() {
//
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member mem = new Member(rs.getString("email"),rs.getString("password"), rs.getString("name"), null);
//						
//						return mem;
//					}
//			
//		}, 
				email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(Member member) {
		if(member != null)
		jdbcTemplate.update(
				"INSERT INTO member (email, name, password) VALUES (?,?,?)",
				member.getEmail(), member.getName(), member.getPassword()
				);
	}
}
