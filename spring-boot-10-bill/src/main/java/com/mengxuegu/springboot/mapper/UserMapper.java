package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserByUsername(String username);
    List<User> getUsers(User user);
    User getUserById(Integer id);
    int addUser(User user);
    int deleteUserById(Integer id);
    int updateUser(User user);
}
