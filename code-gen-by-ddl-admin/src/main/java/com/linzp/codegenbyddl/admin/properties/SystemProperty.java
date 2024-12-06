package com.linzp.codegenbyddl.admin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置
 *
 * @author linzp
 * @version 1.0
 * @date 2023/2/14 21:31
 */

@Data
@Component("systemProperty")
@ConfigurationProperties(prefix = "system-property")
public class SystemProperty {

    /**
     * 流量限制
     */
    private Integer limit = 50;

}
