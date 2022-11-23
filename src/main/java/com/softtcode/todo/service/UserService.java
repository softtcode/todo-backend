package com.softtcode.todo.service;

import com.softtcode.todo.helper.JwtHelper;
import com.softtcode.todo.model.entity.User;
import com.softtcode.todo.model.request.LoginFormRequest;
import com.softtcode.todo.model.request.RegisterFormRequest;
import com.softtcode.todo.model.response.LoginResponse;
import com.softtcode.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User dbUser = userRepository.findByEmail(email);
        if (dbUser==null) throw new UsernameNotFoundException("Kullanıcı adı veya şifre hatalı");
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i <dbUser.getRoles().size(); i++) {
            authorities.add(new SimpleGrantedAuthority(dbUser.getRoles().get(i).getName()));
        }
       return new org.springframework.security.core.userdetails.User(dbUser.getEmail(),dbUser.getPassword(),authorities);
    }

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

    public LoginResponse login(LoginFormRequest formRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(formRequest.getEmail(),formRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        String jwtToken = jwtHelper.generateJwt(formRequest.getEmail());
        return new LoginResponse(jwtToken,formRequest.getEmail());
    }

    public Long findById(String email){
        User dbUser = userRepository.findByEmail(email);
        return dbUser.getId();
    }
}
