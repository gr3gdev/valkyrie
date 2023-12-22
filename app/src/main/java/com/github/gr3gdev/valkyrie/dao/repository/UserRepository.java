package com.github.gr3gdev.valkyrie.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.gr3gdev.valkyrie.dao.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
