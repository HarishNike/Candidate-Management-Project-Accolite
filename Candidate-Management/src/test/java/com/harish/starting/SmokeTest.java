package com.harish.starting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.harish.starting.controller.Candidate_Manage_Controller;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private Candidate_Manage_Controller controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	static String s="[{\"id\":5,\"email\":\"r@gmail.com\",\"name\":\"rithesh\",\"joindate\":\"2021-04-17\",\"location\":\"Hyderabad\",\"feedback\":\"nice\",\"institution\":\"mit\",\"cpp\":\"yes\",\"java\":\"yes\",\"python\":\"no\",\"angular\":\"no\",\"react\":\"no\",\"javascript\":\"no\",\"android\":\"no\",\"contact\":\"8122169295\",\"jobDescription\":\"intern\"}";
			
}