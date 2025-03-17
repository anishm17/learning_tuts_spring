package com.movie.visitor;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class MovieVisitorServiceApplicationTests {

	//@Autowired
	//private MockMvc  mockMvc;
	
	
	@Test
	void testVisitorUpdateFeedbackMockMvc()  throws Exception{
		//this.mockMvc.perform(put("/visitor/feedback/1")).andExpect(status().isAccepted());
	}

}