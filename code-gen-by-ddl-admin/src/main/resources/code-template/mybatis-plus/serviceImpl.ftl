package ${entityTemplate.packageName}.${entityTemplate.moduleName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${entityTemplate.packageName}.${entityTemplate.moduleName}.mapper.${entityTemplate.className}Mapper;
import ${entityTemplate.packageName}.${entityTemplate.moduleName}.entity.${entityTemplate.className};
import ${entityTemplate.packageName}.${entityTemplate.moduleName}.service.${entityTemplate.className}Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ${entityTemplate.comment!''} service 实现
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

@Service("${entityTemplate.camelCaseName}Service")
@Slf4j
@RequiredArgsConstructor
public class ${entityTemplate.className}ServiceImpl extends ServiceImpl<${entityTemplate.className}Mapper, ${entityTemplate.className}> implements ${entityTemplate.className}Service {



}