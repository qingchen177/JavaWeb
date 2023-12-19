package top.qingchen.basicweb.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import top.qingchen.JwtUtil;
import top.qingchen.QingChenToken;
import top.qingchen.TokenService;
import top.qingchen.basicweb.aop.BasicWebLog;
import top.qingchen.basicweb.common.constant.GlobalConstant;
import top.qingchen.basicweb.common.constant.myenum.AuditRecordOperation;
import top.qingchen.basicweb.common.pojo.Result;
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

//@Scope("singleton") --------bean的作用域 singleton ioc容器中同名的只有一个实例
//@Scope("prototype") 每次使用新建一个实例

@Slf4j
@Lazy(false)
@RestController
@RequestMapping("/user")
public class BasicWebUserController {

    BasicWebUserController() {
        log.info(GlobalConstant.LOG_PREFIX + "BasicWebUserController 构造方法执行！！！");
    }

    @Autowired
    private IBasicWebUserService service;

    @Autowired
    private QingChenToken qingChenToken;

    @Autowired
    private TokenService tokenService;

    @BasicWebLog(description = "用户登陆", operationType = AuditRecordOperation.LOGIN)
    @PostMapping("/login")
    public Result<String> login(@RequestBody BasicWebUser user) {
        Wrapper<BasicWebUser> wrapper = new LambdaQueryWrapper<BasicWebUser>().eq(BasicWebUser::getName, user.getName()).eq(BasicWebUser::getPassword, user.getPassword());
        BasicWebUser one = service.getOne(wrapper);
        log.info(GlobalConstant.LOG_PREFIX + qingChenToken);
        if (one != null) {
            //登录成功返回token
            Map<String, Object> claims = new HashMap<String, Object>(4);
            claims.put("name", one.getName());
            claims.put("password", one.getPassword());
            claims.put("id", one.getId());
            claims.put("account", one.getAccount());
            return Result.success(JwtUtil.genJWT(claims));
        }
        return Result.error("登陆失败！账号或者密码输入错误！");
    }

    @BasicWebLog(description = "注册", operationType = AuditRecordOperation.SIGN)
    @PostMapping("/sign")
    public Result<Boolean> sign(@RequestBody BasicWebUser user) {
        boolean save = service.save(user);
        return Result.success(save);
    }

    @GetMapping("/auto/token")
    public Result<String> token(){
        String token = tokenService.getToken();
        return Result.success(token);
    }

}
