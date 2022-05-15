package com.feng.edu.controller;

import com.feng.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: feng
 * @DateTime: 2022/5/15 21:32
 */
@RestController
@RequestMapping("/edu/user")
public class EduLoginController {
    @RequestMapping("/login")
    public JsonResult login() {
        return JsonResult.success().add("token", "admin");
    }

    @GetMapping("/info")
    public JsonResult info() {
        return JsonResult.success().add("roles", "[admin]").add("name", "admin").add("avatar", "");
    }
}
