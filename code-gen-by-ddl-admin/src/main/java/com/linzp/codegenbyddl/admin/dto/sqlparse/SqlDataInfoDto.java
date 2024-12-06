package com.linzp.codegenbyddl.admin.dto.sqlparse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * sql ddl 语句解析结果
 *
 * @author linzp
 * @date 2023/02/10 16:33
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlDataInfoDto implements Serializable {

    private static final long serialVersionUID = -761370043787516563L;

    /**
     * 表信息
     */
    private SqlTableInfoDto sqlTableInfo;

    /**
     * 字段信息
     */
    private List<SqlFiledInfoDto> sqlFiledInfos;

}
