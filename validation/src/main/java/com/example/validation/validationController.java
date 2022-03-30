package com.example.validation;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class validationController {


    @GetMapping("/singleNumTest")
    public String singleNumTest(@NotNull @Min(1) Integer id){

        return "success";
    }

    @GetMapping("/singleStringTest")
    public String singleStringTest(@NotBlank @Length(min = 6, max = 10) String name){

        return "success";
    }

    @GetMapping("/singleStrNumTest")
    public String singleStrNum(@NotBlank @Pattern(regexp = "^[1-9][0-9]*$") String num){
        return num;
    }
}
