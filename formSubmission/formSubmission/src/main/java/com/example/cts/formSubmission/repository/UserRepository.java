package com.example.cts.formsubmission.repository;

import com.example.cts.formsubmission.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
