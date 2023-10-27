package com.Himanshu.User.service.Services;

import com.Himanshu.User.service.Models.UserClass;

import java.util.List;

public interface UserService {
    public UserClass saveUser(UserClass userClass);

    public List<UserClass> getAllUser();

    public UserClass getUser(String userId);

    public UserClass updateUser(UserClass userClass);

    public void deleteUser(UserClass userClass);
}
