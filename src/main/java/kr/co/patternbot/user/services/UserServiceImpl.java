package kr.co.patternbot.user.services;

import kr.co.patternbot.auth.configs.AuthProvider;
import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.auth.exception.SecurityRuntimeException;

import kr.co.patternbot.common.dataStructure.Box;
import kr.co.patternbot.user.domains.Role;
import kr.co.patternbot.user.domains.User;
import kr.co.patternbot.user.domains.UserDTO;
import kr.co.patternbot.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kr.co.patternbot.common.lambda.Lambda.longParse;
import static kr.co.patternbot.common.lambda.Lambda.string;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthProvider provider;
    private final ModelMapper modelMapper;

    //리턴이 디티오기 때문에 리액트로 가는 디비임
    @Override
    public UserDTO login(User user) {
        try{
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            User findUser = repository.findByUsername(user.getUsername()).orElse(null);
            String pw = repository.findByUsername(user.getUsername()).get().getPassword();
            boolean checkPassword = encoder.matches(user.getPassword(), pw);
            String username = user.getUsername();
            List<Role> roles = findUser.getRoles();
            String token = checkPassword ? provider.createToken(username, roles) : "Wrong Password";
            userDTO.setToken(token);
            return userDTO;
        } catch (Exception e) {
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Messenger count() {

        return Messenger.builder().message(string(repository.count())).build();
    }

    @Override
    public Messenger update(User user) {
        return Messenger.builder().message("").build();
    }

    @Override
    public Messenger delete(User user) {
        repository.delete(user);
        return Messenger.builder().message("").build();
    }

    @Override
    public Messenger save(User user) {
        String result = "";
        if(repository.findByUsername(user.getUsername()).isEmpty()){
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder().password(encoder.encode(user.getPassword()))
                    .roles(list).build());
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        return Messenger.builder().message(result).build();
    }

    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L); // userid 타입이 다름
    }

    @Override
    public Messenger existsById(String userid) {
        return repository.existsById(longParse(userid))
                ? Messenger.builder().message("EXIST").build()
                : Messenger.builder().message("NOT_EXIST").build(); // userid 타입이 다름
    }



    @Override
    public List<User> findByUserName(String name) {
        List<User> ls = repository.findAll();
        Box<String, User> box = new Box<>();
        // ls = box.findByUserName(ls, name);
        // ls.stream().filter(...)
        return null;
    }

    @Override
    public Messenger logout() {
        return null;
    }

}