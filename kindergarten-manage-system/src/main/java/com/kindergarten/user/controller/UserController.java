package com.kindergarten.user.controller;

import com.kindergarten.user.vo.LoginParam;
import com.kindergarten.user.vo.LoginVO;
import com.kindergarten.user.vo.UserInfoVO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public LoginVO login(@RequestBody LoginParam loginParam, HttpSession session) {
        session.setAttribute(loginParam.getUsername(),loginParam);
        return new LoginVO(loginParam.getUsername(), loginParam.getUsername());
    }

    @PostMapping("/logout")
    public void logout(String token,HttpSession session) {
        session.removeAttribute(token);
    }

    @GetMapping("/info")
    public UserInfoVO info() {
        UserInfoVO userinfo = new UserInfoVO();
        userinfo.setRoles(Collections.singletonList("admin"));
        userinfo.setName("张三");
        return userinfo;
    }
}
