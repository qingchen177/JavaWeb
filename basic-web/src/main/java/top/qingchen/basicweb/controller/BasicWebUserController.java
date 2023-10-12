package top.qingchen.basicweb.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qingchen.basicweb.common.pojo.Result;
import top.qingchen.basicweb.entity.BasicWebUser;
import top.qingchen.basicweb.service.IBasicWebUserService;

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
    public Result<BasicWebUser> login(@RequestBody BasicWebUser user){
        Wrapper<BasicWebUser> wrapper = new LambdaQueryWrapper<BasicWebUser>().eq(BasicWebUser::getName,user.getName()).eq(BasicWebUser::getPassword,user.getPassword());
        BasicWebUser one = service.getOne(wrapper);
        if (one != null){
            return new Result<BasicWebUser>().setResult("成功").setCode(200).setData(one);
        }
        return new Result<BasicWebUser>().setResult("失败").setCode(400);
    }

}
