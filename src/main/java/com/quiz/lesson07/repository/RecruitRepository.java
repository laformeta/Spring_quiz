package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{

	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);
	
	@Query(value = "select * from `recruit` " + "where `deadline` > :deadline "
			+ "and `salary` >= :salary " + "and `type` = :type " + "order by `salary` DESC", nativeQuery = true)
	public List<RecruitEntity> findDeadlineSalaryType(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type);
}
