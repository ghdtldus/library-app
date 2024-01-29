package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//유저 관련 기능
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }


    // UserCreateRequest의 정보를 데이터베이스에 저장하는 POST API
    // Create
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    // 데이터베이스에서 모든 사용자 정보를 가져오는 GET API
    //Read
    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    //유저 업데이트하는 PUT API진입 지점&HTTP Body를 객체로 변환.
    //Update
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        //  userService.updateUser에서 함수 받아오기
        userService.updateUser(request);
    }

    //Delete
    //유저 삭제하는 DELETE API진입 부분
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }


}
