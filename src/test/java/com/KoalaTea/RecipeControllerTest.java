//package com.KoalaTea;
//
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
//import com.KoalaTea.model.CookBook;
//import com.KoalaTea.model.Recipe;
//import com.KoalaTea.model.User;
//import com.KoalaTea.service.RecipeService;
//import com.KoalaTea.web.RecipeController;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class RecipeControllerTest {
//	
//	@LocalServerPort
//	private int port;
//	@Autowired
//	private MockMvc mockMvc;
//	@Mock
//	private RecipeService recipeService;
//	@InjectMocks
//	private RecipeController recipeController;
//	
//	@Before
//	public void setUp() {
//		// initialize mockito mocks
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
//	}
//	
//	@Test
//	public void testMock() {
//		assertNotNull(recipeService);
//		assertNotNull(recipeController);
//	}
//	
//	@Test
//	public void testInsertRecipe() throws Exception {
//		// mock some data
//		String json = "{\"id\" : \"1\","
//						+ "\"title\" : \"cake\","
//						+ "\"instructions\" : \"bake me a cake as fast as you can\","
//						+ "\"shared\" : \"true\","
//						+ "\"user\" : {"
//							+ "\"id\" : \"1\","
//							+ "\"email\" : \"test@email.com\","
//							+ "\"password\" : \"password\","
//							+ "\"fname\" : \"Bob\","
//							+ "\"lname\" : \"Saget\","
//							+ "\"address\" : \"1001 S St\","
//							+ "\"dateOfBirth\" : \"1956-05-17\""
//							+ "},"
//						+ "\"cookBook\" : {"
//							+ "\"id\" : \"1\","
//							+ "\"title\" : \"Cookbook title\","
//							+ "\"description\" : \"Cookbook description\","
//							+ "\"shared\" : \"true\""
//							+ "}"
//					+ "}";
//		User u = new User(1, "test@email.com", "password", "Bob", "Saget", "1001 S St", java.sql.Date.valueOf("1956-05-17"));
//		Recipe r = new Recipe(1,"cake", "bake me a cake as fast as you can", true, 
//					u, 
//					new CookBook(1, "Cookbook title", "Cookbook description", true, u));
//		
//		mockMvc.perform(post("/recipe/insert")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(json))
//				.andExpect(jsonPath("$.id", Matchers.is(1)))
//				.andExpect(jsonPath("$.title", Matchers.is("cake")))
//				.andExpect(jsonPath("$.instructions", Matchers.is("bake me a cake as fast as you can")))
//				.andExpect(jsonPath("$.shared", Matchers.is("true")))
//				.andExpect(jsonPath("$.user.id", Matchers.is("1")))
//				.andExpect(jsonPath("$.user.email", Matchers.is("test@email.com")))
//				.andExpect(jsonPath("$.user.password", Matchers.is("password")))
//				.andExpect(jsonPath("$.user.fname", Matchers.is("Bob")))
//				.andExpect(jsonPath("$.user.lname", Matchers.is("Saget")))
//				.andExpect(jsonPath("$.user.address", Matchers.is("1001 S St")))
//				.andExpect(jsonPath("$.user.dateOfBirth", Matchers.is("1956-05-17")))
//				.andExpect(jsonPath("$.cookBook.id", Matchers.is("1")))
//				.andExpect(jsonPath("$.cookBook.title", Matchers.is("Cookbook title")))
//				.andExpect(jsonPath("$.cookBook.description", Matchers.is("Cookbook description")))
//				.andExpect(jsonPath("$.cookBook.shared", Matchers.is("true")))
//				.andDo(print()).andReturn();
//		
//		verify(recipeService).insertRecipe(r);
//	}
//	
//	
//	
//
//}
