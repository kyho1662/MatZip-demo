package com.project.matzip.repository;

import com.project.matzip.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}