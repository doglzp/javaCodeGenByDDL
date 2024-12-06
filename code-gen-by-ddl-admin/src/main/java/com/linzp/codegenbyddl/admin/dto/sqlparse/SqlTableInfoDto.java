package com.linzp.codegenbyddl.admin.dto.sqlparse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * sql 解析的表信息
 *
 * @author linzp
 * @date 2023/02/10 16:24
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlTableInfoDto implements Serializable {

    private static final long serialVersionUID = 602484746537649277L;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表注释
     */
    private String tableComment;

    /**
     * 表的主键数量
     */
    private Integer primaryKeyCount;

}
