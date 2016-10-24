//package com.universityapp.model;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Sets;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Set;
//
///**
// * Created by Monika on 10/23/2016.
// */
//@Entity
//@Table(name = "User")
//public class UserEntity extends AbstractEntity implements UserDetails{
//
//    @Column(name = "username", nullable=false)
//    private String username;
//
//    @Column(name = "password", nullable=false)
//    private String password;
//
//    @Column
//    private Boolean enabled;
//
//    @ManyToMany
//    @JoinTable(
//            name = "USER_ROLE",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<RoleEntity> roles = Sets.newHashSet();
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public Set<RoleEntity> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<RoleEntity> roles) {
//        this.roles = roles;
//    }
//
//    @Transient
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = Lists.newArrayList();
//        Set<RoleEntity> userRoles = this.getRoles();
//        if (userRoles != null) {
//            for (RoleEntity role : userRoles) {
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getRole().toString());
//                authorities.add(authority);
//            }
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//}
