package com.linzp.codegenbyddl.admin.dto.ddlSql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ddl sql dto
 *
 * @author linzp
 * @date 2023/02/14 09:19
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DDLSqlDto implements Serializable {

    /**
     * ddl sql 语句
     */
    @NotBlank(message = "ddl sql 语句不能为空")
    private String ddlSql;

    /**
     * 生成模板 名称
     */
    private String templateName;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 作者
     */
    private String author;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 创建日期时间
     */
    private String createDatetime;

}
