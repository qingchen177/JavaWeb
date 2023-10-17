package top.qingchen.basicweb.service.impl;

import top.qingchen.basicweb.entity.AuditRecord;
import top.qingchen.basicweb.mapper.AuditRecordMapper;
import top.qingchen.basicweb.service.IAuditRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审计记录表 服务实现类
 * </p>
 *
 * @author qingchen
 * @since 2023-10-17
 */
@Service
public class AuditRecordServiceImpl extends ServiceImpl<AuditRecordMapper, AuditRecord> implements IAuditRecordService {

}
