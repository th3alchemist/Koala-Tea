package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KoalaTea.model.Joke;
import com.KoalaTea.model.Movie;
import com.revature.service.MovieService;


/*
 * Because your Java backend will almost certainly be hosted somewhere where the origin
 * (e.g. the protocol, host, and port) are different from that of your Angular frontend,
 * you will need to address the issues with the CORS (Cross-Origin Resource Sharing)
 * policy. In order to do so, Spring already has a @CrossOrigin annotation that you
 * can use to specify which origins can access your API. By default, it allows all
 * origins. We can specify a more specific origin by using the "value" attribute.
 */
@CrossOrigin
//This is a Spring stereotype that denotes that this class is serving as a controller
//@Controller
/*
 * Thus far, we have been using a generic Controller. A generic Controller, however,
 * does not automatically write to the response body. We instead want to use a
 * RestController. A RestController will always write to the response body rather than
 * attempting to return a view. Note that the @RestController annotation is just a
 * convenience annotation that is a combination of @Controller and @ResponseBody.
 */
@RestController
//This maps this entire controller to "/movie"
@RequestMapping(value="/movie")

public class MovieController {

	private MovieService movieService;
	
	/*
	 * Let's inject a MovieService into this controller. This is, after all, still
	 * Spring. Let it handle dependency injection for you.
	 */
	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
	
	/*
	 * Let's first play around with our InternalResourceViewResolver by returning
	 * a view. Realistically speaking, you won't use MVC like this if you know a 
	 * frontend framework.
	 */
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome() {
		return "index";
	}
	
	/*
	 * Let's define a handler that will handle each NonExistentMovieException that
	 * is thrown here in this controller.
	 */
//	@ExceptionHandler(NonExistentMovieException.class)
//	public String error() {
//		return "This would have returned a 404 page if I was using a generic controller.";
//	}
	
	/*
	 * This GetMapping annotation is a more specific of RequestMapping which has the
	 * HTTP method built in. We can also use the "produces" attribute to specify what
	 * this endpoint sends back to the client. In this case, it is JSON.
	 */
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	//Because we are using a generic controller, we must use the @ResponseBody
	//annotation to denote that we want to write to the Response body. Otherwise,
	//the view resolver will attempt to resolve what is returned as a view.
	@ResponseBody
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	/*
	 * The PostMapping annotation denotes that this method accepts post requests.
	 * Notice that we have used the @RequestBody annotation here to grab a Movie
	 * object directly from the request body. Spring uses Jackson Databind under
	 * the hood to marshall the JSON in the request body into a Movie object.
	 */
	@PostMapping(value="/insert")
	public void insertMovie(@RequestBody Movie m) {
		movieService.insertMovie(m);
	}
	
	/*
	 * When we want to retrieve a value and send it back to the client, 
	 * there are two useful ways of doing so:
	 * Using the @PathVariable annotation
	 * Using the @RequestParam annotation
	 * 
	 * Let's first play around with the PathVariable annotation. In order to use it,
	 * we must place our path variable inside of {} brackets.
	 */
	@GetMapping(value="/{id}")
	public Movie getMovieById(@PathVariable int id) {
		return movieService.getMovieById(id);
	}
	
	/*
	 * Now we'll play around with the @RequestParam annotation. The RequestParam
	 * allows us to access parameters from our query string.
	 */
	
	@GetMapping(value="/byId")
	public Movie getMovieByIdAgain(@RequestParam int id) {
		return movieService.getMovieById(id);
	}
	
	/*
	 * In Spring Web, we have access to a special object called a "ResponseEntity".
	 * It allows us to send back a representation of our data and response code.
	 */
	
//	@GetMapping(value="/byMovieId")
//	public ResponseEntity<Movie> getMovieWithResponseEntity(@RequestParam int id) {
//		//Let's add some error checking.
//		if(id > 0)
//		return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
//		
//		else throw new NonExistentMovieException();
//	}
	
	@GetMapping(value="/joke")
	public Joke getRandomJoke() {
		return Rest.getChuckJoke();
	}
}
