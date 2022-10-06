package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentDAO {

private JdbcTemplate temp;

public void setTemp(JdbcTemplate temp) {
	this.temp = temp;
}

/*driver,connection-url,un,pwd=>spring.xml
 * prepare statements ,execute of query, close
 * */
//insert,update,delete-JDBC-executeUpdate-----JdbcTemplate-update()
public int insert(Student s) {
	String sql="insert into student values("+s.getId()+",'"+s.getName()+"','"+s.getEmail()+"')";
	System.out.println(sql);
	return temp.update(sql);

}

public int delete(Student s) {
	String sql="delete from student where sid="+s.getId();
	System.out.println(sql);
	return temp.update(sql);

}

public int update(Student s) {
	String sql="update student set name='"+s.getName()+"', email='"+s.getEmail()+"' where sid="+s.getId();
	System.out.println(sql);
	return temp.update(sql);

}


public List<Student> getallstudents(){
	String sql="select * from student";
	return temp.query(sql,new ResultSetExtractor<List<Student>>() {

		public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			ArrayList<Student> al=new ArrayList<Student>();
			while(rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				al.add(s);
			}
			
			return al;
			
		}
		
		
		
		
	} );
	
}



}

