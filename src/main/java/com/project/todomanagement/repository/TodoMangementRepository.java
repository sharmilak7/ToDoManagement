package com.project.todomanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todomanagement.pojo.TbTaskDetails;

public interface TodoMangementRepository extends JpaRepository<TbTaskDetails, Long> {
	List<TbTaskDetails> findByUserId(String user);
}
