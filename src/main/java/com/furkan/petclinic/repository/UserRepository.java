package com.furkan.petclinic.repository;

import com.furkan.petclinic.repository.entity.Owner;
import com.furkan.petclinic.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUserId(long id);

}
