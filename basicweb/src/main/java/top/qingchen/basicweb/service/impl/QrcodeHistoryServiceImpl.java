package top.qingchen.basicweb.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.qingchen.basicweb.common.util.UUIDUtil;
import top.qingchen.basicweb.entity.QrcodeHistory;
import top.qingchen.basicweb.mapper.QrcodeHistoryMapper;
import top.qingchen.basicweb.service.IQrcodeHistoryService;
import top.qingchen.basicweb.websocket.WebSocketServer;

import java.util.Date;

/**
 * <p>
 * 二维码登陆历史表 服务实现类
 * </p>
 *
 * @author qingchen
 * @since 2023-10-27
 */
@Service
public class QrcodeHistoryServiceImpl extends ServiceImpl<QrcodeHistoryMapper, QrcodeHistory> implements IQrcodeHistoryService {

    /**
     * 生成一个UUID
     *
     * @return
     */
    @Override
    public String createQrImg() {
        String uuid = UUIDUtil.getUUID();
        QrcodeHistory qrcodeHistory = new QrcodeHistory().setId(uuid);
        this.save(qrcodeHistory);
        return uuid;
    }

    @Override
    public String bindUserIdAndToken(String userId, String token, Integer projId) throws Exception {

        QrcodeHistory qrLoginToken = new QrcodeHistory();
        qrLoginToken.setId(token);
        qrLoginToken = this.getById(token);

        if (null == qrLoginToken) {
            throw new Exception("错误的请求！");
        }

        Date createDate = new Date(qrLoginToken.getCreateTime().getTime()+ 30*60*60*1000);
        Date nowDate = new Date();
        if (nowDate.getTime() > createDate.getTime()) {//当前时间大于校验时间

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 500);
            jsonObject.put("msg", "二维码失效！");
            WebSocketServer.sendInfo(jsonObject.toJSONString(), token);

            throw new Exception("二维码失效！");
        }

        qrLoginToken.setLoginTime(new Date());
        qrLoginToken.setUserId(userId);

        boolean i = this.updateById(qrLoginToken);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "ok");
        jsonObject.put("userId", userId);
        if (projId != null) {
            jsonObject.put("projId", projId);
        }
        WebSocketServer.sendInfo(jsonObject.toJSONString(), token);

        if (i) {
            return null;
        } else {
            throw new Exception("服务器异常！");
        }
    }
}
