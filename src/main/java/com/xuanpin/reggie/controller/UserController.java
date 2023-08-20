package com.xuanpin.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuanpin.reggie.common.R;
import com.xuanpin.reggie.pojo.User;
import com.xuanpin.reggie.service.UserService;
import com.xuanpin.reggie.utils.SampleUtils;
import com.xuanpin.reggie.utils.ValidateCodeUtils;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 发送手机验证码
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user){
        String phone = user.getPhone();
        if(StringUtils.isNotEmpty(phone)){
            //生成4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code= {}",code);
            //aliyun_sms发送验证码
//            try {
//                SampleUtils.sendMessage(code,phone);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            //将验证码保存在redis中，5min
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return R.success("手机验证码短信发送成功");
        }
        return R.error("短信发送失败");
    }


    @PostMapping("login")
    public R<User> login(@RequestBody Map map, HttpSession session){
        //前端用户输入的信息
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();

        //在redis中获取缓存的验证码
        Object codeInSession = redisTemplate.opsForValue().get(phone);
        if(codeInSession != null && codeInSession.equals(code)){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);

            User user = userService.getOne(queryWrapper);
            if(user == null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            //用户登录成功删除redis中缓存的验证码
            redisTemplate.delete(phone);
            return R.success(user);
        }
        return R.error("登录失败");
    }
}
