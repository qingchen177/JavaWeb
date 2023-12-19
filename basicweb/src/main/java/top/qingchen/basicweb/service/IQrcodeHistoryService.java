package top.qingchen.basicweb.service;

import top.qingchen.basicweb.entity.QrcodeHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 二维码登陆历史表 服务类
 * </p>
 *
 * @author qingchen
 * @since 2023-10-27
 */
public interface IQrcodeHistoryService extends IService<QrcodeHistory> {

    /**
     * 生成一个UUID
     *
     * @return
     */
    String createQrImg();

    String bindUserIdAndToken(String userId, String token, Integer projId) throws Exception;
}
