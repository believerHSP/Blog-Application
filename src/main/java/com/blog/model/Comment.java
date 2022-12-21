package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Entity
@Data
public class Comment {
	
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
	private int cId;

@NotBlank(message="comment should not be empty")
private String comment;
	
}
