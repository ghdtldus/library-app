package com.group.libraryapp.dto.user.request;
public class UserCreateRequest {
    private String name;
    private Integer age; //int는 null불가능, Integer은 null가능

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
