package top.qingchen.basicweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.qingchen.basicweb.entity.BasicWebUser;
import top.qingchen.basicweb.mapper.BasicWebUserMapper;
import top.qingchen.basicweb.service.IBasicWebUserService;

import java.util.Collection;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qingchen
 * @since 2023-10-12
 */
@Service
public class BasicWebUserServiceImpl extends ServiceImpl<BasicWebUserMapper, BasicWebUser> implements IBasicWebUserService {

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean removeByIds(Collection<?> list) {
        return super.removeByIds(list);
    }
}
