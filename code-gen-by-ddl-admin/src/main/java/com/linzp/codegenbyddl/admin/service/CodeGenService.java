package com.linzp.codegenbyddl.admin.service;

import com.linzp.codegenbyddl.admin.dto.ddlSql.DDLSqlDto;
import com.linzp.codegenbyddl.admin.dto.config.UserConfigurationDto;
import com.linzp.codegenbyddl.admin.vo.TemplateVo;

import java.util.Map;

/**
 * 代码生成 service
 *
 * @author linzp
 * @date 2023/02/14 08:17
 **/

public interface CodeGenService {

    /**
     * 代码生成
     *
     * @param userConfigurationDto 用户自定义配置
     * @param mapping              类型映射
     * @param ddlSqlDto            ddl sql 语句 & 模板名称
     * @return 代码生成结果
     */
    TemplateVo codeGen(UserConfigurationDto userConfigurationDto, Map<String, String> mapping, DDLSqlDto ddlSqlDto);

}
