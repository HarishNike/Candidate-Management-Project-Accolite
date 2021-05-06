package com.harish.starting.CandImpl;

import java.util.ArrayList;
import java.io.*;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.harish.starting.Interfaces.CandInterface;
import com.harish.starting.controller.Candidate_Manage_Controller;
import com.harish.starting.model.Candidate;
import com.harish.starting.model.Location;
import com.harish.starting.model.Logs;
import com.harish.starting.model.Skill;

@Repository
@Service
@Component
public class CanRepo  {
	@Autowired
	private JdbcTemplate jdbc;
	Logger logger=LoggerFactory.getLogger(CanRepo.class);
public  CanRepo(DataSource dataSource)
{//only used when testing
	this.jdbc=new JdbcTemplate(dataSource);
}
	public List<Candidate> getAllCandidates()
	{		try {
		logger.info("FETCHING CANDIDATES");
			return jdbc.query(
			            "select * from candidate order by Year(joindate) desc",
			            (rs, rowNum) ->
			                    new Candidate(
			                    	rs.getInt("id"),
			                    	 rs.getString("email"),
			                           rs.getString("name"),
			                           rs.getDate("joindate"),
			                           rs.getString("location"),
			                           rs.getString("feedback"),
			                           rs.getString("institution"),
			                           rs.getString("contact"),
			                           rs.getString("cpp"),
			                           rs.getString("java"),
			                    	   rs.getString("python"),
			                    	   rs.getString("angular"),
			                    	   rs.getString("react"),
			                    	   rs.getString("javascript"),
			                    	   rs.getString("android"),
			                    	   rs.getString("jobDescription")
			                    	
			                    )
			    );
	}
	catch(Exception e) {logger.error(e.toString());return (new ArrayList<Candidate>());}
			
	}
	
	public String save(Candidate c)
	{	 
		String sqlQuery = "insert into candidate(email,name,joindate,location,feedback,institution,contact,cpp,java,python,angular,react,javascript,android,jobDescription) " +
             "values (?, ?, ?,?, ?, ?,?,?, ?,?,?, ?,?,?,?)";
try {
		jdbc.update(sqlQuery,c.getEmail(),c.getName(),c.getJoindate(),c.getLocation(),c.getFeedback(),c.getInstitution(),c.getContact(),c.getCpp(),c.getJava(),c.getPython(),c.getAngular(),c.getReact(),c.getJavascript(),c.getAndroid(),c.getJobDescription());

logger.info("CANDIDATE-"+"\t Name:"+c.getName()+"  Added Successfully");
return "created successfully";
}
catch(Exception e) {logger.error(e.toString());return "failed";}
}
	



	public List<Location> getlocationcount()
	{
		return jdbc.query(
	            "select location,count(*) as count from candidate group by location",
	            (rs, rowNum) ->new Location(rs.getString("location"), rs.getInt("count"))   	                      
	                    
	    );

	}

	public List<Candidate> getcandbyloc(String c)
	{	 String sql="select * from candidate where location like '%"+c+"%'";
	return jdbc.query(sql,
			 //           "select * from candidate where location like '%'?'%'",new Object[]{c},
			            (rs, rowNum) ->new Candidate(
		                    	rs.getInt("id"),
		                    	 rs.getString("email"),
		                           rs.getString("name"),
		                           rs.getDate("joindate"),
		                           rs.getString("location"),
		                           rs.getString("feedback"),
		                           rs.getString("institution"),
		                           rs.getString("contact"),
		                           rs.getString("cpp"),
		                           rs.getString("java"),
		                    	   rs.getString("python"),
		                    	   rs.getString("angular"),
		                    	   rs.getString("react"),
		                    	   rs.getString("javascript"),
		                    	   rs.getString("android"),
		                    	   rs.getString("jobDescription")
		                                          
			                    )
			    );
		
	}

	public List<Candidate> getcandbyemail(String c)
	{	 String sql="select * from candidate where email like '%"+c+"%' OR location like '%"+c+"%' OR jobDescription like '%"+c+"%' ";
	return jdbc.query(sql,
			 //           "select * from candidate where email like '%'?'%'",new Object[]{c},
			            (rs, rowNum) ->new Candidate(
		                    	rs.getInt("id"),
		                    	 rs.getString("email"),
		                           rs.getString("name"),
		                           rs.getDate("joindate"),
		                           rs.getString("location"),
		                           rs.getString("feedback"),
		                           rs.getString("institution"),
		                           rs.getString("contact"),
		                           rs.getString("cpp"),
		                           rs.getString("java"),
		                    	   rs.getString("python"),
		                    	   rs.getString("angular"),
		                    	   rs.getString("react"),
		                    	   rs.getString("javascript"),
		                    	   rs.getString("android"),
		                    	   rs.getString("jobDescription")
		                                          
			                    )
			    );
		
	}

	public List<Location> getskill()
	{	List<Location> L=new ArrayList<Location>();Location l=new Location("",0);
		int a[]=new int [7];
		 RowCountCallbackHandler countCallback1 = new RowCountCallbackHandler();  RowCountCallbackHandler countCallback2 = new RowCountCallbackHandler();// not reusable
		 RowCountCallbackHandler countCallback3 = new RowCountCallbackHandler();RowCountCallbackHandler countCallback4 = new RowCountCallbackHandler();
		 RowCountCallbackHandler countCallback5 = new RowCountCallbackHandler();RowCountCallbackHandler countCallback6 = new RowCountCallbackHandler();
		 RowCountCallbackHandler countCallback7 = new RowCountCallbackHandler();
		 jdbc.query("select * from candidate where cpp=\'yes\'", countCallback1);
		 int f = countCallback1.getRowCount();L.add(new Location("cpp",f));
		 jdbc.query("select * from candidate where java=\'yes\'", countCallback2);
		 f = countCallback2.getRowCount();L.add(new Location("java",f));
		 jdbc.query("select * from candidate where python=\'yes\'", countCallback3);
		 f = countCallback3.getRowCount();L.add(new Location("python",f));
		 jdbc.query("select * from candidate where angular=\'yes\'", countCallback4);
		 f = countCallback4.getRowCount();L.add(new Location("angular",f));
		 jdbc.query("select * from candidate where react=\'yes\'", countCallback5);
		 f= countCallback5.getRowCount();L.add(new Location("react",f));
		 jdbc.query("select * from candidate where javascript=\'yes\'", countCallback6);
		 f= countCallback6.getRowCount();L.add(new Location("javascript",f));
		 jdbc.query("select * from candidate where android=\'yes\'", countCallback7);
		 f = countCallback7.getRowCount();L.add(new Location("android",f));
	System.out.println(L.toString());
		 return L;
	}
	
	public List<Candidate> getcandbyjob(String c)
	{
		String sql="select * from candidate where jobDescription like '%"+c+"%'";
		return jdbc.query(sql,
				 //           "select * from candidate where jobDescription like '%'?'%'",new Object[]{c},
				            (rs, rowNum) ->new Candidate(
			                    	rs.getInt("id"),
			                    	 rs.getString("email"),
			                           rs.getString("name"),
			                           rs.getDate("joindate"),
			                           rs.getString("location"),
			                           rs.getString("feedback"),
			                           rs.getString("institution"),
			                           rs.getString("contact"),
			                           rs.getString("cpp"),
			                           rs.getString("java"),
			                    	   rs.getString("python"),
			                    	   rs.getString("angular"),
			                    	   rs.getString("react"),
			                    	   rs.getString("javascript"),
			                    	   rs.getString("android"),
			                    	   rs.getString("jobDescription")
			                                          
				                    )
				    );
			


	}
	public List<Location> getJobcount()
	{
		List<Location> L=new ArrayList<Location>();
		 RowCountCallbackHandler countCallback1 = new RowCountCallbackHandler();  RowCountCallbackHandler countCallback2 = new RowCountCallbackHandler();// not reusable
		 RowCountCallbackHandler countCallback3 = new RowCountCallbackHandler();RowCountCallbackHandler countCallback4 = new RowCountCallbackHandler();
		jdbc.query("select * from candidate where jobDescription=\'Intern\'",countCallback1);
		int f=countCallback1.getRowCount();L.add(new Location("Intern",f));
		jdbc.query("select * from candidate where jobDescription=\'HR\'",countCallback2);
		f=countCallback2.getRowCount();L.add(new Location("HR",f));
		jdbc.query("select * from candidate where jobDescription=\'Manager\'",countCallback3);
		 f=countCallback3.getRowCount();L.add(new Location("Manager",f));
		jdbc.query("select * from candidate where jobDescription=\'Employee\'",countCallback4);
		 f=countCallback4.getRowCount();L.add(new Location("Employee",f));
	              
		return L;
		
	}
	
	public Candidate getbyId(int id)
	{
//		return jdbc.queryForObject("select *from candidate where id=?", new Candidate(), i

		String s="select *from candidate where id=?";
	Candidate f=(Candidate)jdbc.queryForObject(s, new Object[]{id}, 
				(rs, rowNum) ->
        new Candidate(
        		rs.getInt("id"),
           	 rs.getString("email"),
                  rs.getString("name"),
                  rs.getDate("joindate"),
                  rs.getString("location"),
                  rs.getString("feedback"),
                  rs.getString("institution"),
                  rs.getString("contact"),
                  rs.getString("cpp"),
                  rs.getString("java"),
           	   rs.getString("python"),
           	   rs.getString("angular"),
           	   rs.getString("react"),
           	   rs.getString("javascript"),
           	   rs.getString("android"),
           	   rs.getString("jobDescription")
               
        ));
	return f;
	}
	public String  delete(int id)
	{
		String s="delete from candidate where id=?";
		try{jdbc.update(s,id);
		return "success";}
		catch(Exception e) {
			logger.error(e.toString());
			return "failed";
		}
	}
	public String  update(Candidate c)
	{	logger.info("Trying to update Candidate-ID:"+c.getId()+"\tCandidate Name:"+c.getName());
		String s="update candidate set contact=? ,  location=?, feedback=? , cpp=? , java=? , android=? , angular=? ,python=? , react=? , javascript=?  where id=? ";
		try{jdbc.update(s,c.getContact(),c.getLocation(),c.getFeedback(),c.getCpp(),c.getJava(),c.getAndroid(),c.getAngular(),c.getPython(),c.getReact(),c.getJavascript(),c.getId());
		return "updated";}
		catch(Exception e) {logger.error(e.toString()); return "failed";}
	}
	public String addlogs(Logs l)
	{
String sqlQuery = "insert into Logs(name,operation,date) values(?, ?, ?)";
jdbc.update(sqlQuery,l.getName(),l.getOperation(),l.getDate());

			return "ok";
	}
	public List<Logs> getlogs()
	{
		return jdbc.query(
	            "select * from Logs",
	            (rs, rowNum) ->
	                    new Logs(
	                    	rs.getString("name"),
	                    	 rs.getString("operation"),
	                           rs.getDate("date")
	                    )
	    );

	}
	
}
