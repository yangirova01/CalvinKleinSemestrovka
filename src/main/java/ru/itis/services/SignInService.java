package ru.itis.services;

import ru.itis.dto.UserForm;
import ru.itis.models.User;

public interface SignInService {
    User signIn(UserForm userForm);
}
