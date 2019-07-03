package cn.practice.test.service.impl;

import cn.practice.test.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class SendMessageImpl implements SendMessage{

    @Resource
    //@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void sendMessage(String phone) {
        //生成验证码
        String code = (long) (Math.random() * 10000) + "";
        System.out.println("code:"+code);
        //存入redis
        redisTemplate.boundHashOps("code").put(phone,code);
        //使用activemq
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("template_code", "SMS_164826656");
        map.put("sign_name", "姚氏品优购");
        //map.put("param", "{\"code\":\"123456\"}");
        map.put("param","{\"code\":\""+code+"\"}");
        System.out.println(map);
        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
