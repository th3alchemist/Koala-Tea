//package com.KoalaTea;
//
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.KoalaTea.model.User;
//import com.KoalaTea.service.UserService;
//import com.KoalaTea.web.UserController;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class UserControllerTest {
//	
//	@LocalServerPort
//	private int port;
//	@Autowired
//	private MockMvc mockMvc;
//	@Mock
//	private UserService userService;
//	@InjectMocks
//	private UserController userController;
//	
//	@Before
//	public void setUp() {
//		// initialize mockito mocks
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//	}
//	
//	@Test
//	public void testMock() {
//		assertNotNull(userService);
//		assertNotNull(userController);
//	}
//	
//	@Test
//	public void testInsertRecipe() {
//		
//		String json =  "{\"id\" : \"1\","
//				+ "\"email\" : \"test@email.com\","
//				+ "\"password\" : \"password\","
//				+ "\"fname\" : \"Bob\","
//				+ "\"lname\" : \"Saget\","
//				+ "\"address\" : \"1001 S St\","
//				+ "\"dateOfBirth\" : \"1956-05-17\"}";
//		
//		User u = new User(1, "test@email.com", "password", "Bob", "Saget", 
//				"1001 S St", java.sql.Date.valueOf("1956-05-17"));
//		try {
//			mockMvc.perform(post("/user/insert")
//					.contentType(MediaType.APPLICATION_JSON)
//					.content(json))
//					.andExpect(jsonPath("$.id", Matchers.is(1)))
//					.andExpect(jsonPath("$.email", Matchers.is("test@email.com")))
//					.andExpect(jsonPath("$.password", Matchers.is("password")))
//					.andExpect(jsonPath("$.fname", Matchers.is("Bob")))
//					.andExpect(jsonPath("$.lname", Matchers.is("Saget")))
//					.andExpect(jsonPath("$.address", Matchers.is("1001 S St")))
//					.andExpect(jsonPath("$.dateOfBirth", Matchers.is("1956-05-17")))
//					.andDo(print()).andReturn();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		verify(userService).insertUser(u);
//		
//	}
//
//}
