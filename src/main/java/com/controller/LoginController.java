package com.controller;

import com.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: EvenHuang
 * @Date: 2019/6/19 15:53
 */
@Controller
public class LoginController {

    @Autowired
    ManagerMapper managerMapper;

     @RequestMapping(value = "/login",method = RequestMethod.POST)
     public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
         String target=null;
         if(!StringUtils.isEmpty(username)){
             target=managerMapper.getManager(username).getPassword();
             if (target.equals(password)) {
                 //登录成功
                 session.setAttribute("username",username);
                 return "redirect:/main";
             }
             else {
                 //登录失败
                 map.put("msg", "用户名或密码错误");
                 return "login";
             }
         }
         else {
             //登录失败
            map.put("msg", "用户名或密码错误");
                return "login";
         }
     }

     @RequestMapping(value = "/main")
     public String main(){
         return "dashboard";
     }

     @RequestMapping(value = "/login",method = RequestMethod.GET)
     public String login(){
         return "login";
     }
}
