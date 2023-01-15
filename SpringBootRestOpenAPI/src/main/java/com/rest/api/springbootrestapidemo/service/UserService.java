package com.rest.api.springbootrestapidemo.service;

import java.util.List;

import com.rest.api.springbootrestapidemo.model.User;

public interface UserService {
    public abstract void saveUser(User user);
    public abstract  List<User> getAllUser();
    public abstract User getUserById(int id);
    public abstract void updateUserById(User user,int id);
    public abstract void deleteUserById(int id);
    public abstract void saveAllUser(List<User> list);
    public abstract void deleteAllUser(List<User> list);
    public abstract User getUserByName(String name);
    public abstract User getUserByNameandCity(String name,String city);
}
