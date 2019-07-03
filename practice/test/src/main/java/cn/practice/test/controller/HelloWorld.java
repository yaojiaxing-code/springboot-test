package cn.practice.test.controller;

import cn.practice.test.domian.Users;
import cn.practice.test.service.SendMessage;
import cn.practice.test.service.UserService;
import cn.practice.test.service.ZhuCeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class HelloWorld {

    @Autowired
    private UserService userService;

    @Autowired
    private SendMessage sendMessage;

    @Autowired
    private ZhuCeService zhuCeService;

    @RequestMapping("/test1")
    public String hello(String username){
        Users user = userService.findUserByUsername(username);
        return user.getPassword();
    }

    @RequestMapping("/test2")
    //public Map denLu(String username,String password){
    public Map denLu(@RequestBody Users users, HttpServletResponse response,HttpServletRequest request){
        System.out.println("denlu request"+request);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        Users user = userService.findOne(users);
        //将登录信息记录在cookie上
        Cookie cookie = new Cookie("denLu", users.getUsername());
        cookie.setMaxAge(24*60*60); //cookie有效时间一天
        System.out.println("1  :"+request.getContextPath());
        //cookie.setPath(request.getContextPath());  // 相同路径
        cookie.setPath("/");  // 不同servlet之间共享cookie
        cookie.setDomain("test.cn");
        response.addCookie(cookie);
        System.out.println("cookie:"+cookie.getName()+" "+cookie.getValue()
                +" "+cookie.getPath()+" "+cookie.getDomain());
        if(user!=null){
            map.put("res",true);
            return map;
        }else {
            map.put("res",false);
            return map;
        }
    }

    @RequestMapping("/sendCode")
    public void zhuce(String phone){
        sendMessage.sendMessage(phone);
    }

    @RequestMapping("/zhuCe")
    public Map zhuCe(String phone,String code,@RequestBody Users users){
//        System.out.println("phone:"+phone);
//        System.out.println("code:"+code);
//        System.out.println("password:"+users.getPassword());
        Map map = zhuCeService.zhuCe(phone, code, users);
        return map;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        System.out.println("out request"+request);
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("denLu".equals(cookie.getName())){
                cookie.setValue("logout");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                cookie.setDomain("test.cn");
                System.out.println("cookie:"+cookie.getName()+" "+cookie.getValue()
                        +" "+cookie.getPath()+" "+cookie.getDomain());
                //cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+" "+cookie.getValue());
        }*/
        Cookie cookie = new Cookie("denLu", null);
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath());  // 相同路径
        cookie.setPath("/");  // 相同路径
        cookie.setDomain("test.cn");
        response.addCookie(cookie);
        //request.getRequestDispatcher("/denlu.html").forward(request,response);
        response.sendRedirect("/denlu.html");
    }

}
