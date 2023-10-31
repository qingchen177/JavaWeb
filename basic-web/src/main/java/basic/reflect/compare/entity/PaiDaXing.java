package basic.reflect.compare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author qingchen
 * @date 31/10/2023 上午 9:29
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PaiDaXing {
    //------------------------------  利用Comparator比较  ----------------------------------

    String name;
    Integer age;
}
