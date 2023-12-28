package com.github.gr3gdev.valkyrie.dao.bean;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "`group_authorities`")
@IdClass(GroupAuthority.GroupAuthorityId.class)
@Data
public class GroupAuthority {
    @Id
    private String authority;
    @Id
    private Long groupId;

    @Data
    @EqualsAndHashCode
    public static class GroupAuthorityId implements Serializable {
        private String authority;
        private Long groupId;
    }
}
