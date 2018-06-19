package com.imooc.controller;

<<<<<<< HEAD

import com.imooc.config.ProjectUrlConfig;
=======
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
<<<<<<< HEAD
=======
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2

import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    @Autowired
<<<<<<< HEAD
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;
=======
    private WxMpService wxMpService;    //Mp是微信公众账号的意思
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){

        //1. 配置
        //2. 调用方法
<<<<<<< HEAD
        String url = projectUrlConfig.getWechatMpAuthorize()  +"/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    //重定向的,这个方法可以获取到
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                          @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
=======
        // 服务器的url 得得到code   项目的地址
        String url = "http://jvabgg.natappfree.cc/sell/weixin/userInfo";                                //TODO  为什么网页url就要encode
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        //上面那句url是重定向的~，即入口的项目地址
        return "redirect:" + redirectUrl;
    }

    //上面的url会跳到下面这个方法上，这个是获取用户信息
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
          wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        }catch (WxErrorException e){
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();
<<<<<<< HEAD

        return "redirect:" + returnUrl + "?openid=" + openId;
    }



    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatOpenAuthorize() + "/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url, WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN, URLEncoder.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }


    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        log.info("wxMpOAuth2AccessToken={}", wxMpOAuth2AccessToken);
        String openId = wxMpOAuth2AccessToken.getOpenId();

=======
        //重定向
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}
