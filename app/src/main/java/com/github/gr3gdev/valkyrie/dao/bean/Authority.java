package com.github.gr3gdev.valkyrie.dao.bean;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "`authorities`")
@IdClass(Authority.AuthorityId.class)
@Data
public class Authority {
    @Id
    private String authority;
    @Id
    private String username;

    @Data
    @EqualsAndHashCode
    public static class AuthorityId implements Serializable {
        private String authority;
        private String username;
    }
}
