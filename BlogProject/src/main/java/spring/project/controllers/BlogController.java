package spring.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.project.entities.Blog;
import spring.project.repositories.BlogRepository;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")									
public class BlogController {
	
	private @Autowired BlogRepository blogRepo;

	@GetMapping("/blogs")
	public List<Blog> getAllBlogs() {
		return blogRepo.findAll();
	}

	@PostMapping("/blogs")
	public Blog saveBlog(@RequestBody Blog blog) {
		

		
		return blogRepo.save(blog);
	}

	@GetMapping("/blogs/{id}")
	public Blog getSingleBlog(@PathVariable Long id) {
		return blogRepo.findById(id).get();
	}

	@PutMapping("/blogs")
	public Blog updateBlog(@RequestBody Blog blog) {
		return blogRepo.save(blog);
	}

	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<HttpStatus> deleteBlogById(@PathVariable Long id) {
		blogRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
