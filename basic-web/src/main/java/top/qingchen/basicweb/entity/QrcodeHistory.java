package top.qingchen.basicweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 二维码登陆历史表
 * </p>
 *
 * @author qingchen
 * @since 2023-10-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
@Accessors(chain = true)
@TableName("qingchen_basic_web_qrcode_history")
@ApiModel(value = "QrcodeHistory对象", description = "二维码登陆历史表")
public class QrcodeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("操作时间")
    private Date loginTime;

    @ApiModelProperty("状态 0有效 1失效")
    private Byte status;

    @ApiModelProperty("创建人id")
    private String createUser;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新人id")
    private String updateUser;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
