package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.survey.bean.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	
	@Query(value = "SELECT * FROM tbl_Users WHERE User_Type = 'User'", nativeQuery = true)
	List<Users> getAllCandidates();

  public Users getByUserName(String userName);
  public Users getByPassword(String password);

	
	
	
}
