package top.qingchen.basicweb.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 审计记录表
 * </p>
 *
 * @author qingchen
 * @since 2023-10-17
 */
@TableName("qingchen_basic_web_audit_record")
@ApiModel(value = "AuditRecord对象", description = "审计记录表")
public class AuditRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("操作")
    private String operation;

    @ApiModelProperty("操作时间")
    private LocalDateTime operationTime;

    @ApiModelProperty("操作耗时")
    private Integer operationTimeConsumption;

    @ApiModelProperty("操作内容")
    private String operationContext;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getOperationTimeConsumption() {
        return operationTimeConsumption;
    }

    public void setOperationTimeConsumption(Integer operationTimeConsumption) {
        this.operationTimeConsumption = operationTimeConsumption;
    }

    public String getOperationContext() {
        return operationContext;
    }

    public void setOperationContext(String operationContext) {
        this.operationContext = operationContext;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AuditRecord{" +
                "id = " + id +
                ", operator = " + operator +
                ", operation = " + operation +
                ", operationTime = " + operationTime +
                ", operationTimeConsumption = " + operationTimeConsumption +
                ", operationContext = " + operationContext +
                ", createUser = " + createUser +
                ", createTime = " + createTime +
                ", updateUser = " + updateUser +
                ", updateTime = " + updateTime +
                "}";
    }
}
