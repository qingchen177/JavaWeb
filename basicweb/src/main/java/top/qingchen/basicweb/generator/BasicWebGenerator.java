package top.qingchen.basicweb.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;
import java.util.List;

/**
 * MP代码生成
 *
 * @author qingchen
 * @date 12/10/2023 下午 5:33
 */

public class BasicWebGenerator {
    public static void generate(List<String> tables) {
        FastAutoGenerator.create("jdbc:mysql://liqingchen.top:3306/basic_web?serverTimezone=GMT%2B8&characterEncoding=utf8&useSSL=true&remarks=true&useInformationSchema=true",
                        "root", "177214")
                .globalConfig(builder -> {
                    builder.author("qingchen") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"/basic-web/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("top.qingchen") // 设置父包名
                            .moduleName("basicweb") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("qingchen_basic_web", "t_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
