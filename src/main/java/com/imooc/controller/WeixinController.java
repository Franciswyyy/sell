package com.imooc.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void atuh(@RequestParam("code") String code){
        log.info("进入auth方法。。。。");
        log.info("code={}", code);

        String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6b108bf4cc0a136d&secret=892b727d50ae36b276519e55d0a8f866&code="+code+"&grant_type=authorization_code";

        //用来接收json格式的
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);

        JSONObject jsonObject = JSONObject.parseObject(response);
        String access_token = jsonObject.getString("access_token");
        log.info("access_token={}", access_token);
        String openIdUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+ access_token +"&openid=OPENID&lang=zh_CN";

        String openIdResponse = restTemplate.getForObject(openIdUrl, String.class);
        log.info("openIdResponse={}", openIdResponse);
    }
}
