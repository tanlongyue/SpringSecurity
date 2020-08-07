package com.tly.mango.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.tly.mango.entity.LoginBean;
import com.tly.mango.entity.SysUser;
import com.tly.mango.http.HttpResult;
import com.tly.mango.security.JwtAuthenticatioToken;
import com.tly.mango.service.SysUserService;
import com.tly.mango.util.IOUtils;
import com.tly.mango.util.PasswordUtils;
import com.tly.mango.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.setHeader("Cache-Control","no-store, no-cache");
        response.setContentType("image/jpeg");
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpg",out);

        IOUtils.closeQuietly(out);
    }

    /**
     * 用户登录接口
     * */
    @RequestMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean,HttpServletRequest request) throws IOException{
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.buildError("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.buildError("验证码不正确");
        }
        SysUser user = sysUserService.findByName(username);
        if(user == null){
            return HttpResult.buildError("账号不存在");
        }
        if(!PasswordUtils.matches(user.getSalt(),password,user.getPassword())){
            return HttpResult.buildError("密码不正确");
        }
        if(user.getStatus() == 0){
            return HttpResult.buildError("账号已经被锁定，请联系管理员");
        }
        JwtAuthenticatioToken token = SecurityUtils.login(request,username,password,authenticationManager);
        return HttpResult.buildSuccess(token);
    }

}
