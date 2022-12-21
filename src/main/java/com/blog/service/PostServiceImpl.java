package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.blog.exception.PostException;
import com.blog.model.Post;
import com.blog.repository.PostDao;

public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postrepo;

	@Override
	public Post deletePostId(Integer postId) throws PostException {
		Optional<Post> p=  postrepo.findById(postId);
	  if(p.isPresent()) 
	  {
		 Post po= p.get();
		 postrepo.delete(po);
		 return po;
	  }
	  else {
		  throw new PostException("this postID doesnt exist");
	  }
	}

	@Override
	public Post updatePost(Post post) throws PostException {
		Optional<Post> p=postrepo.findById(post.getPostId());
		
		if(p.isPresent())
		{
			Post updatePost=postrepo.save(post);
			return updatePost;
		}
		else {
			throw new PostException("Invalid Post Id");
		}
	}

	@Override
	public Post viewPostById(Integer postId) throws PostException {
        Optional<Post> p=postrepo.findById(postId);
		
		if(p.isPresent())
		{
			return p.get();
		}
		else {
			throw new PostException("Invalid Post Id");
		}
		
	}

	@Override
	public List<Post> getAllPosts() throws PostException {
		
		List<Post> post=postrepo.findAll();
		
		if(post.size()==0)
			throw new PostException("No post is there");
		else {
			return post;
		}
	}
	@Override
	public Post addPosts(Post post) throws PostException {
	Post p=postrepo.save(post);
		
		return p;
	}

}
