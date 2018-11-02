package com.example.test.controller;

import com.example.test.dao.UserMapper;
import com.example.test.entity.User;
import com.example.test.utils.Result;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @program: test
 * @description:生成验证码Controller
 * @author: tankyx
 * @create: 2018-10-31 11:26
 **/
@Controller
public class CaptchaImageCreateController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/kaptcha")
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
       byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        }catch (IllegalArgumentException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 验证的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "imgvrifyControllerDefaultKaptcha",method = RequestMethod.POST)
    @ResponseBody
    public Result imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String vrifyCode, User user){
        Result result = new Result();
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        captchaId = captchaId.toLowerCase();
        String parameter = vrifyCode;
        System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+parameter);
        if (!captchaId.equals(parameter)) {
            result.setCode(400);
            result.setMsg("验证码错误！");
        } else {
            User userDB = userMapper.selectUserByName(user.getUsername());
            if(userDB!=null&&userDB.getPassword().equals(user.getPassword())){
                result.setCode(200);
                result.setMsg("登录成功！");
            }else{
                result.setCode(400);
                result.setMsg("用户名或密码错误！");
            }
        }
        return result;
    }

    public int count(int a,int b){
        return a+b;
    }

    @RequestMapping("/")
    public String index(){
        return "/back/login";
    }

    @RequestMapping("/index")
    public String goindex(){
        return "/back/index";
    }

    @RequestMapping("/info")
    public String info(){
        return "/back/info";
    }

    @RequestMapping("/page")
    public String page(){
        return "/back/page";
    }

    @RequestMapping("/pass")
    public String pass(){
        return "/back/pass";
    }

    @RequestMapping("/adv")
    public String adv(){
        return "/back/adv";
    }

    @RequestMapping("/book")
    public String book(){
        return "/back/book";
    }

    @RequestMapping("/column")
    public String column(){
        return "/back/column";
    }

    @RequestMapping("/list")
    public String list(){
        return "/back/list";
    }

    @RequestMapping("/cate")
    public String cate(){
        return "/back/cate";
    }

    @RequestMapping("/add")
    public String add(){
        return "/back/add";
    }
}
