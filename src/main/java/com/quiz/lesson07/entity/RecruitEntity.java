package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "recruit")
@Entity
public class RecruitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	private String position;
	private String responsibilities;
	private String qualification;
	private String type;
	private String region;
	private int salary;
	private LocalDate deadline;
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
