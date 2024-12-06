package com.linzp.codegenbyddl.admin.dto.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 实体字段Dto
 *
 * @author linzp
 * @date 2023/02/13 10:40
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityFiledTemplateDto implements Serializable {

    private static final long serialVersionUID = 6245711515241541328L;

    /**
     * 字段名称
     */
    private String filedName;

    /**
     * 原始字段名称(即表字段名称)
     */
    private String sourceFiledName;

    /**
     * 字段类型
     */
    private String filedType;

    /**
     * 是否为主键
     *
     * @see com.linzp.codegenbyddl.admin.enums.YesOrNoEnum
     */
    private Boolean primaryKey;

    /**
     * 是否为逻辑删除字段
     *
     * @see com.linzp.codegenbyddl.admin.enums.YesOrNoEnum
     */
    private Boolean logicDelete;

    /**
     * 是否为乐观锁字段
     *
     * @see com.linzp.codegenbyddl.admin.enums.YesOrNoEnum
     */
    private Boolean optimisticVersion;

    /**
     * 日期格式化
     * 仅当 filedType 为日期类型时有效
     */
    private String dateFormat;

    /**
     * 字段注释
     */
    private String comment;

}
