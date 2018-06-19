package com.imooc.controller;


<<<<<<< HEAD
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
=======
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
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
<<<<<<< HEAD
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

=======
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法....");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd898fcb01713c658&secret=29d8a650db31472aa87800e3b0d739f2&code=" + code + "&grant_type=authorization_code";

        //TODO   要返回json串，string.class不是很理解
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
    }
}
