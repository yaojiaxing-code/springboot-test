package cn.practice.test.service.impl;

import cn.practice.test.dao.UserDao;
import cn.practice.test.domian.Users;
import cn.practice.test.service.ZhuCeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class ZhuCeServiceImpl implements ZhuCeService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    //使用@Autoward会报错，idea原因，没问题
    private UserDao userDao;

    @Override
    public Map zhuCe(String phone, String code, Users users) {
        Map<String, String> map = new HashMap<>();
        String yanZhengCode = (String) redisTemplate.boundHashOps("code").get(phone);
        if(!yanZhengCode.equals(code)){
            map.put("res","badCode");
            return map;
        }
        try {
            userDao.save(users);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res","badUser");
            return map;
        }
        return map;
    }
}
