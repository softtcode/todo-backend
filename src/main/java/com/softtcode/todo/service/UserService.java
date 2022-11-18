package com.softtcode.todo.service;

import com.softtcode.todo.model.entity.User;
import com.softtcode.todo.model.request.RegisterFormRequest;
import com.softtcode.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public void register(RegisterFormRequest requestForm) {
        User requestUser = new User();
        requestUser.setEmail(requestForm.getEmail());
        requestUser.setPassword(requestForm.getPassword());
        save(requestUser);
    }
    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
