package com.linzp.codegenbyddl.admin.dto.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 模板Dto
 *
 * @author linzp
 * @date 2023/02/13 10:55
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDto implements Serializable {

    private static final long serialVersionUID = 202428862454804466L;

    /**
     * 表信息
     */
    private EntityTemplateDto entityTemplate;

    /**
     * 表字段信息
     */
    private List<EntityFiledTemplateDto> entityFiledTemplates;

}
