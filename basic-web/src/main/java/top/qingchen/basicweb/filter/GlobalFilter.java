package top.qingchen.basicweb.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import top.qingchen.basicweb.common.constant.GlobalConstant;
import top.qingchen.basicweb.common.exception.GlobalExceptionHandle;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局过滤器
 *
 * @author qingchen
 * @date 13/10/2023 下午 4:08
 */
@Slf4j
@WebFilter(filterName = "globalFilter", urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "sensitiveWord", value = "zz")})
public class GlobalFilter implements Filter {

    /**
     * 敏感词汇
     */
    private List<String> sensitiveWords = new ArrayList<>();

    @Autowired
    private GlobalExceptionHandle globalExceptionHandle;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(GlobalConstant.LOG_PREFIX + "初始化全局过滤器！");

        String sensitiveWord = filterConfig.getInitParameter("sensitiveWord");
        sensitiveWords.add(sensitiveWord);
//        System.out.println("-----------获取Filter全部key:value------------");
//        //得到所有配置参数的名字
//        Enumeration<String> names = filterConfig.getInitParameterNames();
//        while (names.hasMoreElements()) {
//            //得到每一个名字
//            String name = names.nextElement();
//            System.out.println(name + " = " + filterConfig.getInitParameter(name));
//        }
//        System.out.println("-----------end.....------------");

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info(GlobalConstant.LOG_PREFIX + "进入全局过滤器！");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info(GlobalConstant.LOG_PREFIX + "请求地址：" + request.getRequestURI());

        //TODO: request.getInputStream() 只能读一次就没了
//        // 敏感词汇检查
//        // 获取请求体中的数据流
//        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
//        String line;
//        StringBuilder requestBody = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            requestBody.append(line);
//        }
//        reader.close();
//
//        // 处理请求体中的数据
//        log.info(GlobalConstant.LOG_PREFIX + "POST请求体中的数据：" + requestBody);
//        JSONObject jsonObject = JSONObject.parseObject(requestBody.toString());
//        String name =(String) jsonObject.get("name");
//        for (String sensitiveWord : sensitiveWords) {
//            //对所有敏感词汇进行过滤
//            if (name.contains(sensitiveWord)) {
//                //报错
//                globalExceptionHandle.ex(new BasicWebException("包含敏感词！"));
//            }
//        }
        //放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info(GlobalConstant.LOG_PREFIX + "销毁全局过滤器！");
        Filter.super.destroy();
    }
}
