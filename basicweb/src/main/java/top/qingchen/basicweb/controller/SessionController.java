package top.qingchen.basicweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qingchen.basicweb.aop.BasicWebLog;
import top.qingchen.basicweb.common.pojo.Result;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author qingchen
 * @date 13/10/2023 下午 1:21
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @BasicWebLog
    @GetMapping("set")
    public Result<Boolean> setsession(HttpSession session) {
        session.setAttribute("name", "qingchen");
        return Result.success(true);
    }

    @BasicWebLog
    @GetMapping("get")
    public Result<Boolean> getsession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("id = " + id);
        Object attribute = session.getAttribute("name");
        System.out.println("attribute = " + attribute);
        Enumeration<String> attributeNames = session.getAttributeNames();
        System.out.println("attributeNames = " + attributeNames.toString());
        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext = " + servletContext);
        long lastAccessedTime = session.getLastAccessedTime();
        System.out.println("lastAccessedTime = " + lastAccessedTime);
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println("maxInactiveInterval = " + maxInactiveInterval);
        long creationTime = session.getCreationTime();
        System.out.println("creationTime = " + creationTime);
        System.out.println("-------------------------------------");
        return Result.success(true);
    }

    @GetMapping("del")
    public Result<Boolean> delsession(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return Result.success(true);
    }
}
