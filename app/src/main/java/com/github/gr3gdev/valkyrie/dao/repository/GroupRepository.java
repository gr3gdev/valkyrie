package com.github.gr3gdev.valkyrie.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.gr3gdev.valkyrie.dao.bean.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
