package top.qingchen.basicweb.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 审计记录表
 * </p>
 *
 * @author qingchen
 * @since 2023-10-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
@Accessors(chain = true)
@TableName("qingchen_basic_web_audit_record")
@ApiModel(value = "AuditRecord对象", description = "审计记录表")
public class AuditRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("操作类型")
    private String operationType;

    @ApiModelProperty("操作时间")
    private LocalDateTime operationTime;

    @ApiModelProperty("操作耗时")
    private Long operationTimeConsumption;

    @ApiModelProperty("操作类名")
    private String operationClassName;

    @ApiModelProperty("操作方法名")
    private String operationMethodName;

    @ApiModelProperty("操作方法参数")
    private String operationMethodParams;

    @ApiModelProperty("操作方法返回值")
    private String operationReturnValue;

    @ApiModelProperty("创建人id")
    private String createUser;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人id")
    private String updateUser;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
