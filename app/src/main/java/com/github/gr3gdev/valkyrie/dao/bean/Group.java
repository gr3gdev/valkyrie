package com.github.gr3gdev.valkyrie.dao.bean;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`groups`")
@Data
public class Group {
    @Id
    private Long id;
    private String groupname;
    @OneToMany(mappedBy = "groupId")
    private Set<GroupAuthority> authorities;
    @ManyToAny(fetch = FetchType.LAZY)
    private Set<User> members;
}
