package com.github.gr3gdev.valkyrie.dao.bean;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`users`")
@Data
public class User {
    @Id
    private String username;
    private String password;
    @OneToMany(mappedBy = "username")
    private Set<Authority> authorities;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean disabled;
}
