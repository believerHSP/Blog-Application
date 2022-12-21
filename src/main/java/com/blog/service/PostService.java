package com.blog.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blog.exception.PostException;
import com.blog.model.Post;


@Service
public interface PostService {
	
	
	public Post addPosts(Post post) throws PostException;
	
	public Post deletePostId(Integer postId) throws PostException;

	public Post updatePost(Post post)throws PostException;

	public Post viewPostById(Integer postId)throws PostException;
	
	public List<Post> getAllPosts() throws PostException;
	
}
