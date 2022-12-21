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
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.CommentException;
import com.blog.model.Comment;
import com.blog.service.CommentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
	public class CommentController {

		@Autowired
		private CommentService cService;
		
		@PostMapping("/comment")
		public ResponseEntity<Comment> addPost(@RequestBody Comment com)throws CommentException {
			Comment saveC=cService.addComment(com);
			
			return new ResponseEntity<Comment>(saveC,HttpStatus.CREATED);
		}
		
		
		
		@PutMapping("/comment")
		public ResponseEntity<Comment> updateCom(@RequestBody Comment com) throws CommentException{
			Comment updateC=cService.updateComment(com);
			
			return new ResponseEntity<Comment>(updateC,HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/comment/{id}")
		public ResponseEntity<Comment> deleteCommentById(@PathVariable("id")Integer cId)throws CommentException{	
			Comment deleteC=cService.deleteCommentId(cId);
			
			return new ResponseEntity<Comment>(deleteC,HttpStatus.OK);
		}
		
		
		@GetMapping("/comments")
		public ResponseEntity<List<Comment>> getAllComment()throws CommentException{
			List<Comment> allC=cService.getAllComment();
			
			return new ResponseEntity<List<Comment>>(allC,HttpStatus.OK);
		}
		
		
		@GetMapping("/comments/{cid}")
		public ResponseEntity<Comment> getCommentById(@PathVariable("cid")Integer CId)throws CommentException{
			Comment comment=cService.viewCommentById(CId);

			return new ResponseEntity<Comment>(comment,HttpStatus.OK);
		}
	
	}
