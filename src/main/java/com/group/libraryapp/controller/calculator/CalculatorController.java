package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController의 기능 : 바로 아래의 클래스를 API의 진입 지점(controller)으로 만들어준다.
// 클래스 안의 메소드 : API가 사용하는 메소드임
@RestController
public class CalculatorController {

    //API 첫번째
    //클래스의 HTTP 메소드를 get방식으로 매핑하고 HTTP 경로를 써준다
    // 따라서 /add를 치면 이 함수가 호출된다?!
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    //API 두번째
    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
