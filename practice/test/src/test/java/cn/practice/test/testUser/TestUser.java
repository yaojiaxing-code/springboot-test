package cn.practice.test.testUser;

import cn.practice.test.Application;
import cn.practice.test.domian.Users;
import cn.practice.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = "cn.practice.test.service")
public class TestUser {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        Users user = userService.findUserByUsername("赵六");
        System.out.println(user.getPassword());
    }

    @Test
    public void test2(){
        Users users = new Users();
        users.setUsername("zhangsan");
        users.setPassword("123");
        Users user = userService.findOne(users);
        System.out.println(user.getPassword());
    }

    @Test
    public void testRedis(){
        redisTemplate.boundValueOps("code").set("9876");
        redisTemplate.delete("code");
        String code = (String) redisTemplate.boundValueOps("code").get();
        System.out.println(code);
    }
}
