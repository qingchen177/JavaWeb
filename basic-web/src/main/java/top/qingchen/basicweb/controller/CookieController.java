package top.qingchen.basicweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qingchen.basicweb.common.pojo.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qingchen
 * @date 13/10/2023 下午 1:21
 */
@RestController
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("set")
    public Result<Boolean> setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "qingchen");
        response.addCookie(cookie);
        return Result.success(true);
    }

    @GetMapping("get")
    public Result<Boolean> getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String comment = cookie.getComment();
            System.out.println("comment = " + comment);
            String name = cookie.getName();
            System.out.println("name = " + name);
            String domain = cookie.getDomain();
            System.out.println("domain = " + domain);
            int maxAge = cookie.getMaxAge();
            System.out.println("maxAge = " + maxAge);
            String path = cookie.getPath();
            System.out.println("path = " + path);
            boolean secure = cookie.getSecure();
            System.out.println("secure = " + secure);
            String value = cookie.getValue();
            System.out.println("value = " + value);
            int version = cookie.getVersion();
            System.out.println("version = " + version);
            Class<? extends Cookie> aClass = cookie.getClass();
            System.out.println("aClass = " + aClass);
            System.out.println("-------------------------------------");
        }
        return Result.success(true);
    }

    @GetMapping("del")
    public Result<Boolean> delCookie(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String value = cookie.getName();
            if (value.equals("qingchen")) {
                String path = cookie.getPath();
                cookie.setMaxAge(0);
                cookie.setPath(path);
                response.addCookie(cookie);
            }
        }
        return Result.success(true);
    }
}
