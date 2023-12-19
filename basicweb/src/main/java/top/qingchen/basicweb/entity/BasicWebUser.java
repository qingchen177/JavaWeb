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
 * 用户表
 * </p>
 *
 * @author qingchen
 * @since 2023-10-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
@Accessors(chain = true)
@TableName("qingchen_basic_web_user")
@ApiModel(value = "BasicWebUser对象", description = "用户表")
public class BasicWebUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机")
    private String mobile;

    @ApiModelProperty("微信")
    private String wechat;

    @ApiModelProperty("性别{W:女;M:男;N:未知}")
    private String sex;

    @ApiModelProperty("状态 1启用 0禁用 9删除")
    private Byte status;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("密码")
    private String password;

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
