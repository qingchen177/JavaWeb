package top.qingchen.basicweb.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qingchen.basicweb.common.pojo.Result;
import top.qingchen.basicweb.common.util.JwtUtil;
import top.qingchen.basicweb.entity.BasicWebUser;
import top.qingchen.basicweb.service.IBasicWebUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author qingchen
 * @since 2023-10-12
 */
@RestController
@RequestMapping("/user")
public class BasicWebUserController {

    @Autowired
    private IBasicWebUserService service;

    @PostMapping("/login")
    public Result<String> login(@RequestBody BasicWebUser user){
        Wrapper<BasicWebUser> wrapper = new LambdaQueryWrapper<BasicWebUser>().eq(BasicWebUser::getName,user.getName()).eq(BasicWebUser::getPassword,user.getPassword());
        BasicWebUser one = service.getOne(wrapper);
        if (one != null){
            //登录成功返回token
            Map<String,Object> claims = new HashMap<String,Object>(4);
            claims.put("name", user.getName());
            claims.put("password", user.getPassword());
            claims.put("id",user.getId());
            claims.put("account",user.getAccount());
            return Result.success(JwtUtil.genJWT(claims));
        }
        return Result.error("登陆失败！账号或者密码输入错误！");
    }

    @PostMapping("/sign")
    public Result<Boolean> sign(@RequestBody BasicWebUser user){
        boolean save = service.save(user);
        return Result.success(save);
    }

}
