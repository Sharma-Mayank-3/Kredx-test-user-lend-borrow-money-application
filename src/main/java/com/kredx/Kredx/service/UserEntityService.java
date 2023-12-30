package com.kredx.Kredx.service;

import com.kredx.Kredx.dto.UserEntityDto;

import java.util.List;

public interface UserEntityService {

    UserEntityDto createUser(UserEntityDto userEntityDto, int roleId);

    UserEntityDto getUserById(int userId);

    List<UserEntityDto> getAllUsers();

}
