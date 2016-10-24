//package com.universityapp.model;
//
//import com.google.common.collect.Sets;
//import com.universityapp.enums.RoleType;
//import lombok.Getter;
//import lombok.Setter;
//import org.apache.catalina.User;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Set;
//
///**
// * Created by Monika on 10/23/2016.
// */
//@Entity
//@Table(name = "Role")
//public class RoleEntity extends AbstractEntity{
//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private RoleType role;
//
//    @ManyToMany(mappedBy = "roles")
//    private Set<UserEntity> users = Sets.newHashSet();
//
//    public Set<UserEntity> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<UserEntity> users) {
//        this.users = users;
//    }
//
//    public RoleType getRole() {
//        return role;
//    }
//
//    public void setRole(RoleType role) {
//        this.role = role;
//    }
//}
