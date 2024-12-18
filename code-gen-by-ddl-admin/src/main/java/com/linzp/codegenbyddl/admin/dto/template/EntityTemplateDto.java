package com.linzp.codegenbyddl.admin.dto.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.linzp.codegenbyddl.admin.utils.StrUtil.*;

/**
 * 实体模板Dto
 *
 * @author linzp
 * @date 2023/02/13 10:21
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityTemplateDto implements Serializable {

    private static final long serialVersionUID = 5477057889238359353L;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 原始 映射的表名
     */
    private String sourceTableName;

    /**
     * 去除前缀 映射的表名
     */
    private String tableName;

    /**
     * 类名(首字母全大写)
     */
    private String className;

    /**
     * 驼峰命名(除首字母小写，其他字母大写)
     */
    private String camelCaseName;

    /**
     * 蛇形命名(每个单词之间使用 - 连接)
     */
    private String snakeCaseName;

    /**
     * 作者
     */
    private String authorName;

    /**
     * 序列化版本值
     */
    private String serialVersion;

    /**
     * 是否为 单个主键
     *
     * @see com.linzp.codegenbyddl.admin.enums.YesOrNoEnum
     */
    private Boolean singlePrimaryKey;

    /**
     * 创建日期
     * 默认为生成日期时间
     */
    private String createDatetime;

    /**
     * 类注释
     */
    private String comment;

    /**
     * 构造 EntityTemplateDto 对象
     *
     * @param packageName      包名
     * @param moduleName       模块名
     * @param sourceTableName  原始 映射的表名
     * @param tableName        去除前缀 映射的表名
     * @param authorName       作者
     * @param singlePrimaryKey 是否为 单个主键
     * @param createDatetime   创建日期
     * @param comment          类注释
     * @return EntityTemplateDto 对象
     */
    public static EntityTemplateDto of(String packageName, String moduleName, String sourceTableName,
                                       String tableName, String authorName, Boolean singlePrimaryKey,
                                       String createDatetime, String comment) {
        // 构造 各种形式的命名
        // 驼峰命名(首字母大写)
        String className = underlineCase2BigCamelCase(tableName);
        // 驼峰命名(首字母小写)
        String camelCaseName = underlineCase2CamelCase(tableName);
        // 蛇形命名
        String snakeCaseName = underlineCase2SnakeCase(tableName);
        return new EntityTemplateDto(
                packageName,
                moduleName,
                sourceTableName,
                tableName,
                className,
                camelCaseName,
                snakeCaseName,
                authorName,
                generateUniqueId(),
                singlePrimaryKey,
                createDatetime,
                comment
        );
    }

}
