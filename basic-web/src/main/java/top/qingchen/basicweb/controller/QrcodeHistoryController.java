package top.qingchen.basicweb.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.qingchen.basicweb.common.pojo.Result;
import top.qingchen.basicweb.service.IQrcodeHistoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 二维码登陆历史表 前端控制器
 * </p>
 *
 * @author qingchen
 * @since 2023-10-27
 */
@Controller
@RequestMapping("/basicweb/qrcodeHistory")
public class QrcodeHistoryController {

    @Autowired
    private IQrcodeHistoryService qrcodeHistoryService;

    //获取登录二维码、放入Token https://mp.weixin.qq.com/s/SLE8-W2llFChu73MxkS5JA


    @RequestMapping(value = "/getLoginQr", method = RequestMethod.GET)
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");

        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        try {
            //这里没啥操作 就是生成一个UUID插入 数据库的表里
            String uuid = qrcodeHistoryService.createQrImg();
            response.setHeader("uuid", uuid);
            // 这里是开源工具类 hutool里的QrCodeUtil
            // 网址：http://hutool.mydoc.io/
            QrCodeUtil.generate(uuid, 300, 300, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * \* 确认身份接口：确定身份以及判断是否二维码过期等
     * \* @param token
     * \* @param userId
     * \* @return
     */
    @RequestMapping(value = "/bindUserIdAndToken", method = RequestMethod.GET)
    @ResponseBody
    public Result bindUserIdAndToken(@RequestParam("token") String token,
                                     @RequestParam("userId") String userId,
                                     @RequestParam(required = false, value = "projId") Integer projId) {

        try {
            return Result.success(qrcodeHistoryService.bindUserIdAndToken(userId, token, projId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

}
