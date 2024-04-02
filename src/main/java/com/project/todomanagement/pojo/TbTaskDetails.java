package com.project.todomanagement.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_task_details")
@SuppressWarnings("all")
public class TbTaskDetails {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    @NotEmpty(message = "UserId Should not be Empty")
	    private String userId;

	    @NotEmpty(message = "Task Description Should not be Empty")
	    private String taskDescription;

	    @NotEmpty(message = "Task Description Should not be Empty")
	    private Date targetDate;
	    
	    @NotEmpty(message = "Task Status Should not be Empty")
	    private String taskStatus;

	    private Boolean isActive;
	    private String createdBy;
	    private Date createdOn;
	    private String updatedBy;
	    private Date updatedOn;

}
