package catering;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import catering.controller.DishRestController;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class, DishRestController.class})
@AutoConfigureMockMvc
public class DishControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dish"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		
		MvcResult result1 = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dish/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		
//		MvcResult result3 = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/dish/")
//				.param("dish_number","9")
//                .param("dish_name","aaa")
//                .param("discount","7")
//                .param("price","20"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andDo(MockMvcResultHandlers.print())
//				.andReturn();
//		
//		MvcResult result4 = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/dish"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andDo(MockMvcResultHandlers.print())
//				.andReturn();
//		
//		MvcResult result5 = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/dish/1"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andDo(MockMvcResultHandlers.print())
//				.andReturn();
//		
//		MvcResult result6 = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/dish")
//				.param("dish_number","9")
//                .param("dish_name","aaa")
//                .param("discount","7")
//                .param("price","20"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andDo(MockMvcResultHandlers.print())
//				.andReturn();
	}


}
