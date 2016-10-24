//package com.universityapp.service.serviceImpl;
//
//import com.universityapp.model.UserEntity;
//import com.universityapp.service.UserService;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by Monika on 10/23/2016.
// */
////TODO correct it!
//
//@Service("customUserDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//    private UserService userService;
//
//    @Transactional(readOnly=true)
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        UserEntity user = userService.findBy;
//        System.out.println("User : "+user);
//        if(user==null){
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("Username not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                true, true, true, true, user.getAuthorities());
//    }
//}
