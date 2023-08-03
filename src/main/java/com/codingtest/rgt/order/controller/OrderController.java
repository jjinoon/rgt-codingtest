package com.codingtest.rgt.post.controller;

import com.codingtest.rgt.common.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/codingTest")
public class PostController {

    @GetMapping
    public CommonResponse<?> test() {
        return CommonResponse.success("ok");
    }
}
