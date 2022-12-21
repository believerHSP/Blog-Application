package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.PostException;
import com.blog.model.Post;
import com.blog.service.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Blog")
public class PostController {
	
	@Autowired
	private PostService pService;
	
	
	@GetMapping("/posts/{postid}")
	public ResponseEntity<Post> getPostById(@PathVariable("postid")Integer postId)throws PostException{
		
		Post postbyid=pService.viewPostById(postId);
		
		return new ResponseEntity<Post>(postbyid,HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Post> addPost(@RequestBody Post post)throws PostException {
		
		Post saveP=pService.addPosts(post);
		
		return new ResponseEntity<Post>(saveP,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/post/{id}")
	public ResponseEntity<Post> deletePostById(@PathVariable("id")Integer postId)throws PostException{
		
		Post delP=pService.deletePostId(postId);
		
		return new ResponseEntity<Post>(delP,HttpStatus.OK);
	}
	
	
	@PutMapping("/post")
	public ResponseEntity<Post> updatePost(@RequestBody Post post) throws PostException{
		
		Post uPosts=pService.updatePost(post);
		
		return new ResponseEntity<Post>(uPosts,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPost()throws PostException{
		
		List<Post> allpost=pService.getAllPosts();
		
		return new ResponseEntity<List<Post>>(allpost,HttpStatus.OK);
	}
	
	
}
