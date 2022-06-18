package com.evil.ibet.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.evil.ibet.entity.User;
import com.evil.ibet.util.PropertiesUtil;
import com.evil.ibet.util.WXUtils;
import com.evil.ibet.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Project: iBet
 * @Author: kongz
 * @Date: 2019/1/4 16:50
 */
@Controller
@RequestMapping("wechat")
public class CommonController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody String login(String jsCode, String iv, String encryptedData) {
        Map returnMap = new HashMap();
        Map resultMap = new HashMap();
        String rtnCode = "999";  //999:调用失败 0：新用户（未注册）引导注册  1：已注册
        String rtnMessage = "使用微信登陆失败，请关闭小程序后重试";
        int userId = 0;

        if (!StringUtils.isEmpty(jsCode)) {
            String loginUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" +
                    PropertiesUtil.getPropertie("AppId") + "&secret=" +
                    PropertiesUtil.getPropertie("AppSecret") + "&js_code=" +
                    jsCode + "&grant_type=authorization_code";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(loginUrl, HttpMethod.GET, null, String.class);

            if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseBody = responseEntity.getBody();
                returnMap = JSONObject.parseObject(responseBody);
                String wxOpenId = returnMap.get("openid").toString();
                String sessionKey = returnMap.get("session_key").toString();
                JSONObject userInfo = WXUtils.decodeUserInfo(encryptedData, sessionKey, iv);
                String nickName = userInfo.get("nickName").toString();
                if (!StringUtils.isEmpty(wxOpenId)) {
                    User checkUser = userService.getUserByWxOpenId(wxOpenId);
                    if (checkUser == null) {
                        User user = new User(wxOpenId, nickName);
                        userService.saveUser(user);
                        rtnCode = "0";
                        rtnMessage = "您是新用户，请完成注册";
                        userId = checkUser.getId();
                    } else {
                        if (StringUtils.isEmpty(checkUser.getIdCardNo()) || StringUtils.isEmpty(checkUser.getUserName())) {
                            rtnCode = "0";
                            rtnMessage = "您是新用户，请完成注册";
                            userId = checkUser.getId();
                        } else {
                            rtnCode = "1";
                            rtnMessage = "已注册";
                            userId = checkUser.getId();
                        }
                    }
                }
            }
        }
        resultMap.put("rtnCode",rtnCode);
        resultMap.put("rtnMessage",rtnMessage);
        resultMap.put("userId", userId);
        String returnJsonStr = JSON.toJSONString(resultMap);
        return returnJsonStr;
    }

    @RequestMapping(value = "register", produces="application/json;charset=UTF-8")
    public @ResponseBody String register(String userId, String userName, String phoneNo, String idCardNo) {
        Map resultMap = new HashMap();
        String rtnCode = "999";  //999:调用失败 0：注册成功  1：注册失败
        String rtnMessage = "使用微信登陆失败，请关闭小程序后重试";
        if (!StringUtils.isEmpty(idCardNo) && !StringUtils.isEmpty(userName) && !StringUtils.isEmpty(phoneNo)) {
            User user = new User(Integer.valueOf(userId), userName, idCardNo, phoneNo);
            int count = userService.updateUserById(user);
            if (count == 1) {
                rtnCode = "0";
                rtnMessage = "成功";
            } else {
                rtnCode = "1";
                rtnMessage = "失败，更新结果不唯一";
            }
        }
        resultMap.put("rtnCode", rtnCode);
        resultMap.put("rtnMessage", rtnMessage);
        String returnJsonStr = JSON.toJSONString(resultMap);
        return returnJsonStr;
    }

}
