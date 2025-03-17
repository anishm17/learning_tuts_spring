package com.movie.admin;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MovieAdminServiceApplicationTests {

	//@Autowired
	//private MockMvc  mockMvc;
	
	
	@Test
	void testCreateRetreiveMockMvc()  throws Exception{
		//this.mockMvc.perform(post("/movie/add")).andExpect(status().is2xxSuccessful());
		
		//this.mockMvc.perform(get("/movie/get/1")).andDo(print()).andExpect(status().isOk())
		 //.andExpect((ResultMatcher) content().string(containsString("1")));
	}

}
