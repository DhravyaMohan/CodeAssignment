package com.example.cts.formSubmission.repository;

import com.example.cts.formSubmission.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
