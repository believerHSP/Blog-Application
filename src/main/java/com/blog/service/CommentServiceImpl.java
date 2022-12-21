package com.blog.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.blog.exception.CommentException;
import com.blog.model.Comment;
import com.blog.repository.CommentDao;


public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao crepo;
	@Override
	public Comment addComment(Comment comment) throws CommentException {
		Comment c=crepo.save(comment);
		return c;
	}

	@Override
	public Comment updateComment(Comment comment) throws CommentException {
		Optional<Comment> c=crepo.findById(comment.getCId());
		
		if(c.isPresent())
		{
			Comment updateComment=crepo.save(comment);
			return updateComment;
		}
		else {
			throw new CommentException("Invalid Comment Id");
		}
	}

	@Override
	public Comment deleteCommentId(Integer cId) throws CommentException {
		Optional<Comment> c=crepo.findById(cId);
		
		if(c.isPresent())
		{
			Comment ExistingCom=c.get();
			crepo.delete(ExistingCom);
			
			return ExistingCom;
		}
		else {
			throw new CommentException("Invalid Comment Id");
		}
	}

	@Override
	public List<Comment> getAllComment() throws CommentException {
		List<Comment> com=crepo.findAll();
		
		if(com.size()==0)
			throw new CommentException("No Comment is there");
		else
			return com;
	}
	
		

	@Override
	public Comment viewCommentById(Integer cId) throws CommentException {
		Optional<Comment> c=crepo.findById(cId);
		
		if(c.isPresent())
		{
			return c.get();
		}
		else
			throw new CommentException("Invalid Comment Id");
	}
	}
	

