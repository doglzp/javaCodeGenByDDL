package ${entityTemplate.packageName}.${entityTemplate.moduleName}.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ${entityTemplate.comment!''}
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

@ApiModel(description = "${entityTemplate.comment!''}")
@TableName("${entityTemplate.sourceTableName}")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ${entityTemplate.className} implements Serializable {

    private static final long serialVersionUID = ${entityTemplate.serialVersion}L;

<#list entityFiledTemplates as entityFiledTemplate>
<#if entityFiledTemplate.logicDelete>
    /**
     * ${entityFiledTemplate.comment}
     */
    @TableLogic
    @JSONField(serialize = false)
<#elseif entityFiledTemplate.optimisticVersion>
    /**
     * ${entityFiledTemplate.comment}
     */
    @JSONField(serialize = false)
    @Version
<#else>
<#if entityFiledTemplate.comment??>
    /**
     * ${entityFiledTemplate.comment}
     */
    @ApiModelProperty(value = "${entityFiledTemplate.comment}")
</#if>
<#if entityTemplate.singlePrimaryKey && entityFiledTemplate.primaryKey>
    @TableId(type = IdType.ASSIGN_ID)
</#if>
<#if entityFiledTemplate.filedType == "Long">
    @JsonSerialize(using = ToStringSerializer.class)
</#if>
<#if entityFiledTemplate.dateFormat?? && entityFiledTemplate.dateFormat?length gt 0>
    @JsonFormat(pattern = "${entityFiledTemplate.dateFormat}")
</#if>
<#if entityFiledTemplate.filedName == "isDelete">
    @TableLogic
</#if>
    private ${entityFiledTemplate.filedType} ${entityFiledTemplate.filedName};

</#if>
</#list>
}