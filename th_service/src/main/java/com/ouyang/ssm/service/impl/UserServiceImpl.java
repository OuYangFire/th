package com.ouyang.ssm.service.impl;

import com.ouyang.ssm.dao.IUserDao;
import com.ouyang.ssm.domain.Role;
import com.ouyang.ssm.domain.UserInfo;
import com.ouyang.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        User user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(), userInfo.getStatus()==0?true:false,true,true,true,getAuthority(userInfo.getRoles()));
//        userInfo.getStatus()==0?true:false,true,true,true,
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("Role_"+role.getRoleName()));
        }
        return list;
    }


}
