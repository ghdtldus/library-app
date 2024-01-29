package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//현재 유저가 있는지 없는지 등을 확인하고 예외 처리 &로직 역할
public class UserService {
    //UserRepository에서 받아올거임
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    //생성 C
    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge());
    }


    // Read
    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }

    //업데이트 U
    public void updateUser( UserUpdateRequest request) {
        // userRepository.isUserNotExist함수에서 받아온 값에 따라 예외처리
        if (userRepository.isUserNotExist( request.getId())) {
            throw new IllegalArgumentException();
        }

        //UserRepository.updateUserName함수에서 받아와 업데이트하는 로직역할
        userRepository.updateUserName(request.getName(), request.getId());
    }

    //삭제 D
    public void deleteUser(String name){
        //만약 존재하지 않는다면 true일테니IllegalArgumentException()을 던진다
        if (userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);
    }



}
