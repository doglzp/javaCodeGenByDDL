package com.linzp.codegenbyddl.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.linzp.codegenbyddl.admin.dto.ddlSql.DDLSqlDto;
import com.linzp.codegenbyddl.admin.dto.config.UserConfigurationDto;
import com.linzp.codegenbyddl.admin.properties.ConfigurationProperty;
import com.linzp.codegenbyddl.admin.properties.DataTypeMappingProperty;
import com.linzp.codegenbyddl.admin.service.CodeGenService;
import com.linzp.codegenbyddl.admin.vo.ResponseVo;
import com.linzp.codegenbyddl.admin.properties.SqlTemplateProperty;
import com.linzp.codegenbyddl.admin.vo.TemplateVo;

import java.util.*;

/**
 * 代码生成
 *
 * @author linzp
 * @date 2023/02/14 09:14
 **/

@RestController
@RequestMapping("/code-gen")
@Slf4j
@RequiredArgsConstructor
public class CodeGenController {

    private final CodeGenService codeGenService;

    private final SqlTemplateProperty sqlTemplateProperty;

    private final ConfigurationProperty configurationProperty;

    private final DataTypeMappingProperty dataTypeMappingProperty;

    /**
     * 代码生成
     *
     * @param ddlSqlDto ddl sql 语句 请求对象
     * @return 模板生成结果
     */
    @PostMapping
    public ResponseVo<TemplateVo> codeGen(@RequestBody @Validated DDLSqlDto ddlSqlDto) {
        // 补全 用户自定义配置
        UserConfigurationDto userConfigurationDto = UserConfigurationDto.of(
                ddlSqlDto.getPackageName(),
                ddlSqlDto.getModuleName(),
                ddlSqlDto.getAuthor(),
                ddlSqlDto.getTablePrefix(),
                ddlSqlDto.getCreateDatetime(),
                configurationProperty
        );

        // 执行代码生成
        return ResponseVo.success(codeGenService.codeGen(userConfigurationDto, null, ddlSqlDto));
    }

    /**
     * 获取可使用的模板名称列表
     *
     * @return 模板名称列表
     */
    @GetMapping("/template-names")
    public ResponseVo<List<String>> listTemplateNames() {
        // 禁用
        if (!sqlTemplateProperty.getEnabled()) {
            return ResponseVo.success(Collections.emptyList());
        }
        Set<String> templateNames = configurationProperty.getAvailableTemplates();
        return ResponseVo.success(new ArrayList<>(templateNames));
    }

    /**
     * 获取 数据库类型 与 Java 类型 映射关系
     *
     * @return 数据库类型 与 Java 类型 映射关系
     */
    @GetMapping("/data-types")
    public ResponseVo<Map<String, String>> listDataTypes() {
        return ResponseVo.success(dataTypeMappingProperty.getMapping());
    }

}
