package com.blog.service;

import java.util.List;

import com.blog.exception.CommentException;
import com.blog.model.Comment;

public interface CommentService {
		
	public Comment addComment(Comment comment)throws CommentException;
	
	public Comment updateComment(Comment comment)throws CommentException;
	
	public Comment deleteCommentId(Integer cId) throws CommentException;
	
	public List<Comment> getAllComment() throws CommentException;
	
	public Comment viewCommentById(Integer cId)throws CommentException;
}
