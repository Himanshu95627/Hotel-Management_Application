package com.Himanshu.User.service.Repositories;

import com.Himanshu.User.service.Models.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserClass,String> {
}
