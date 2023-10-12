package top.qingchen.basicweb.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author qingchen
 * @date 12/10/2023 下午 7:25
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    String result;
    Integer code;
    T data;
}
