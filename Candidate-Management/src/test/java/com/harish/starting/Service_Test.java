package com.harish.starting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.harish.starting.CandImpl.CanRepo;
import com.harish.starting.controller.Candidate_Manage_Controller;
import com.harish.starting.model.Candidate;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class Service_Test {
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
	
public void intial()
{
	this.dataSource = new DriverManagerDataSource();
    this.dataSource.setUrl("jdbc:mysql://localhost:3306/db");
    this.dataSource.setUsername("root");
    this.dataSource.setPassword("password");
	this.cr=new CanRepo(dataSource);
}

@Test
public void getcandidates()
{	intial();
//CanRepo pp=org.mockito.Mockito.mock(CanRepo.class);
//CanRepo p1p=org.mockito.Mockito.mock(CanRepo.class);
List<Candidate> allcand=new ArrayList<Candidate>();
	when(c.getAllCandidates()).thenReturn(Stream.of(
new Candidate(0, "harishnike2605@gmail.com", "Harish",new Date(),"Chennai", "nice", "MIT", "8122169295", "no", "yes", "yes", "no", "no", "no","no","intern"),
new Candidate(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
			)
			.collect(Collectors.toList()));
//	when(c.getAllCandidates()).thenReturn(allcand);
//	System.out.println("sdfsd"+allcand.size());
	assertEquals(2,c.getAllCandidates().size());
}

}
