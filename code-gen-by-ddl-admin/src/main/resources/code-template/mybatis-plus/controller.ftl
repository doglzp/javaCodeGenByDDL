package ${entityTemplate.packageName}.${entityTemplate.moduleName}.controller;

import ${entityTemplate.packageName}.${entityTemplate.moduleName}.service.${entityTemplate.className}Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* ${entityTemplate.comment!''} controller
*
* @author ${entityTemplate.authorName!''}
* @date ${entityTemplate.createDatetime}
**/

@Api(tags = "${entityTemplate.comment!''}")
@RestController
@RequestMapping("/${entityTemplate.snakeCaseName}")
@Slf4j
public class ${entityTemplate.className}Controller {

    @Resource
    private ${entityTemplate.className}Service ${entityTemplate.camelCaseName}Service;



}