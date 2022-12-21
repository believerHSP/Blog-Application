package com.blog.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	@Size(min = 3, message = "title should min of 3 Characters")
	private String title;
	
	@Size(min = 10, message = "title should min of 10 Characters")
	private String description;
	
    @NotBlank(message="Name should not be null")
	private String name;
    
    @NotBlank(message="email should not be null")
	private String email;
    
    @OneToMany
    private List<Comment> comment;
	
}