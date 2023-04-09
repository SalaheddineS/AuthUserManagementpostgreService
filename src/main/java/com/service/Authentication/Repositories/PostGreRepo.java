package com.service.Authentication.Repositories;

import com.service.Authentication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostGreRepo extends JpaRepository<User, Integer>{

}
