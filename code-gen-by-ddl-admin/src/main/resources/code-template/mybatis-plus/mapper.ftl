package ${entityTemplate.packageName}.${entityTemplate.moduleName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${entityTemplate.packageName}.${entityTemplate.moduleName}.entity.${entityTemplate.className};
import org.apache.ibatis.annotations.Mapper;

/**
 * ${entityTemplate.comment!''} mapper
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

@Mapper
public interface ${entityTemplate.className}Mapper extends BaseMapper<${entityTemplate.className}> {



}