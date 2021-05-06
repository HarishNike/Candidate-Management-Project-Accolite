package com.harish.starting;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harish.starting.CandidateManagementApplication;
import com.harish.starting.CandImpl.CanRepo;
import com.harish.starting.controller.Candidate_Manage_Controller;
import com.harish.starting.model.Candidate;
import com.harish.starting.model.Location;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class CandidateManagementApplicationTests{
	@Autowired
    private MockMvc mockMvc;
	@Autowired
	JdbcTemplate jdbc;
	@MockBean
	CanRepo c;
	@InjectMocks
	Candidate_Manage_Controller controller;
	DriverManagerDataSource dataSource;
	CanRepo cr;
	Candidate_Manage_Controller controller1;
	public void intial()
	{
		this.dataSource = new DriverManagerDataSource();
	    this.dataSource.setUrl("jdbc:mysql://localhost:3306/db");
	    this.dataSource.setUsername("root");
	    this.dataSource.setPassword("password");
		this.cr=new CanRepo(dataSource);
		controller1=new Candidate_Manage_Controller(this.cr);
	}

	@Test
	public void Createcand_Controller_test() throws JsonProcessingException, Exception
	{
		Candidate c=new Candidate(1,"hari@gmail.com","harish",new Date(26,05,2000),"chennai","nice","mit","8122169295","no","no","no","no","yes","no","no","intern");
		mockMvc.perform(MockMvcRequestBuilders.post("/addcandidate").content(new ObjectMapper().writeValueAsString(c))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void Deletecand_Controller_test() throws JsonProcessingException, Exception
	{		when(c.delete(12)).thenReturn("success");
		mockMvc.perform(MockMvcRequestBuilders.delete("/deletecandidate/12"))
				.andExpect(status().isOk());
	}
	String json_type_input=" {\n"
			+ "        \"id\": 5,\n"
			+ "        \"email\": \"r@gmail.com\",\n"
			+ "        \"name\": \"rithesh\",\n"
			+ "        \"joindate\": \"2021-04-17\",\n"
			+ "        \"location\": \"Hyderabad\",\n"
			+ "        \"feedback\": \"nice\",\n"
			+ "        \"institution\": \"mit\",\n"
			+ "        \"cpp\": \"yes\",\n"
			+ "        \"java\": \"yes\",\n"
			+ "        \"python\": \"no\",\n"
			+ "        \"angular\": \"no\",\n"
			+ "        \"react\": \"no\",\n"
			+ "        \"javascript\": \"no\",\n"
			+ "        \"android\": \"no\",\n"
			+ "        \"contact\": \"8122169295\",\n"
			+ "        \"jobDescription\": \"intern\"\n"
			+ "    }";

	String json_type_input1=" [ {\n"
			+ "        \"id\": 5,\n"
			+ "        \"email\": \"r@gmail.com\",\n"
			+ "        \"name\": \"rithesh\",\n"
			+ "        \"joindate\": \"2021-04-17\",\n"
			+ "        \"location\": \"Hyderabad\",\n"
			+ "        \"feedback\": \"nice\",\n"
			+ "        \"institution\": \"mit\",\n"
			+ "        \"cpp\": \"yes\",\n"
			+ "        \"java\": \"yes\",\n"
			+ "        \"python\": \"no\",\n"
			+ "        \"angular\": \"no\",\n"
			+ "        \"react\": \"no\",\n"
			+ "        \"javascript\": \"no\",\n"
			+ "        \"android\": \"no\",\n"
			+ "        \"contact\": \"8122169295\",\n"
			+ "        \"jobDescription\": \"intern\"\n"
			+ "    } ]";
	
	@Test
	public void Updatecand_Controller_test() throws JsonProcessingException, Exception
	{	Candidate candidate=new Candidate(0, "r@gmail.com", "Harish",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern");	
		when(c.update(candidate)).thenReturn("success");
		mockMvc.perform(MockMvcRequestBuilders.put("/updatecandidate/12").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json_type_input))
		
				.andExpect(status().isOk());
	}
	@Test
	public void getallcandidates_Controller_test() throws Exception,JsonProcessingException
	{	List<Candidate> candidate=new ArrayList<>();
		when(c.getAllCandidates()).thenReturn(candidate);
		mockMvc.perform(MockMvcRequestBuilders.get("/getallcandidates").content(json_type_input1))
		.andExpect(status().isOk());
	}

	@Test
	public void getCandJob_Controller_test() throws JsonProcessingException, Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/getcandidatebyjob/chennai").content(json_type_input1))
		
				.andExpect(status().isOk());
	}

	
	@Test
	public void getCandidateList_Controller_test() throws Exception {
	   String uri = "/getallcandidates";
	   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	}
	

@Test
public void getcandidates_Service()
{	//intial();
List<Candidate> allcand=new ArrayList<Candidate>();
	when(c.getAllCandidates()).thenReturn(Stream.of(
new Candidate(0, "harishnike2605@gmail.com", "Harish",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern"),
new Candidate(1, "nike2605@gmail.com", "nike",new Date(),"Chennai", "nice", "MIT", "8122169295", "yes", "yes", "yes", "no", "no", "no","no","intern")
			)
			.collect(Collectors.toList()));
	assertEquals(2,c.getAllCandidates().size());
}
@Test
public void getcandidate_by_email_Service()
{	//intial();
	String s="r@gmail.com";
	List<Candidate> allcand=new ArrayList<Candidate>();
	when(c.getcandbyemail(s)).thenReturn(Stream.of(
new Candidate(0, "r@gmail.com", "Harish",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern")
)
			.collect(Collectors.toList()));
	assertEquals(1,c.getcandbyemail(s).size());
}
@Test
public void addcandidate()
{	intial();
	Candidate candidate =new Candidate(0, "harishnike2605@gmail.com", "Harish",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern");
//	when(c.save(candidate)).thenReturn("created successfully");
//	assertEquals("created successfully", controller1.saving_cand(candidate));

}

@Test
public void getcandidate_by_test()
{
	String job="intern";
	when(c.getcandbyjob(job)).thenReturn(Stream.of(
new Candidate(0, "r@gmail.com", "Harish",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern"),
new Candidate(1, "guru@gmail.com", "guru",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern")
			)
			.collect(Collectors.toList()));

assertEquals(2,c.getcandbyjob(job).size());
}
@Test
public void getJobcount_service()
{
when(c.getJobcount()).thenReturn(Stream.of(new Location("intern",2)).collect(Collectors.toList()));
assertEquals(1,c.getJobcount().size());
}


TestRestTemplate restTemplate = new TestRestTemplate();

HttpHeaders headers = new HttpHeaders();

@Test
public void testGetCandidateData () throws JSONException {
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response = restTemplate.exchange(
            createURLWithPort("/getallcandidates"),
            HttpMethod.GET, entity, String.class);
    
    	
//   String expected = "[{\"id\":1,\"name\":\"First Location\",\"principle\":\"Mr. Ranvir\",\"address\":\"California\"}]";
//    JSONAssert.assertEquals(SmokeTest.s,response.getBody(), false);
}
private String createURLWithPort(String uri) {
    return "http://localhost:8082"  + uri;
}

@Test
public void addCandidate_integrationtest()
{
//	Candidate candidate = new Candidate(15, "mohan@gmail.com", "Mohanraj",new Date(),"Delhi", "nice", "SSN", "9723169295", "no", "yes", "yes", "no", "yes", "no","no","intern");
//ResponseEntity<String> response=this.restTemplate.postForEntity(createURLWithPort("/addcandidate"), candidate, String.class);
//assertEquals(201,response.getStatusCode());
//    ResponseEntity<String> responseEntity = this.restTemplate
//        .postForEntity("http://localhost:8082"  + "/addcandidate", candidate, String.class);
//  System.out.println(responseEntity.getBody());
//    assertEquals(201, responseEntity.getStatusCodeValue());
}
}



