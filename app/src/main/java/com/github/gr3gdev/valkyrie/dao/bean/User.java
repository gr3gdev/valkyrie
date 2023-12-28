package com.github.gr3gdev.valkyrie.dao.bean;

import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    private String firstname;
    private String lastname;
    private String email;
    @OneToMany(mappedBy = "username")
    private Set<Authority> authorities;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean disabled;
    private boolean temporaryPassword;
    @CreatedDate
    private ZonedDateTime created;
    @LastModifiedDate
    private ZonedDateTime modified;
}
