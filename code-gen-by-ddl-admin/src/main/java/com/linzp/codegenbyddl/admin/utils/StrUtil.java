package com.linzp.codegenbyddl.admin.utils;

import cn.hutool.core.util.IdUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 字符串操作
 *
 * @author linzp
 * @date 2023/02/10 17:06
 **/

public final class StrUtil {

    /**
     * 空字符串
     */
    private static final String BLANK = "";

    /**
     * 单引号
     */
    private static final char SINGLE_QUOTATION_MARK = '\'';

    /**
     * 双引号
     */
    private static final char DOUBLE_QUOTATION_MARK = '\"';

    /**
     * 空格
     */
    private static final char BLANK_CHAR = ' ';

    /**
     * 着重符
     */
    private static final char STAR = '`';

    private static final char UNDER_LINE = '_';

    /**
     * 中划线
     */
    private static final char MIDDLE_LINE = '-';

    private StrUtil() {
    }

    /**
     * 清理 sql 注释中的 " 或 ' 以及 两侧的 空格
     *
     * @param comment sql 注释
     * @return 清理之后的 sql 注释
     */
    public static String cleanSqlComment(String comment) {
        if (StringUtils.isBlank(comment) || comment.length() < 2) {
            return StringUtils.isBlank(comment) ? BLANK : comment;
        }
        // 去除两侧的 " 或 ' 以及 两侧的 空格
        int length = comment.length();
        int left = 0;
        int right = length - 1;
        if ((comment.charAt(left) == SINGLE_QUOTATION_MARK && comment.charAt(right) == SINGLE_QUOTATION_MARK ||
                comment.charAt(left) == DOUBLE_QUOTATION_MARK && comment.charAt(right) == DOUBLE_QUOTATION_MARK)) {
            left++;
            right--;
        }
        while (left < right && comment.charAt(left) == BLANK_CHAR) {
            left++;
        }
        while (left < right && comment.charAt(right) == BLANK_CHAR) {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(comment.charAt(left++));
        }
        return sb.toString();
    }

    /**
     * 清洗 表名 字段名 两侧的 着重符号
     *
     * @param name 表名 | 字段名
     * @return 清洗之后的 表名 | 字段名
     */
    public static String cleanName(String name) {
        if (StringUtils.isBlank(name) || name.length() < 2) {
            return StringUtils.isBlank(name) ? BLANK : name;
        }
        // 去除 表名 字段名 两侧的 着重符号
        int left = 0;
        int right = name.length() - 1;
        while (left < right && name.charAt(left) == STAR) {
            left++;
        }
        while (left < right && name.charAt(right) == STAR) {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(name.charAt(left++));
        }
        return sb.toString();
    }

    public static String underlineCase2BigCamelCase(String underlineCase) {
        return StrUtil.underlineCase2CamelCase(underlineCase, true);
    }

    /**
     * 下划线命名 -> 驼峰命名(首字母小写)
     *
     * @param underlineCase 下划线命名
     * @return 驼峰命名(首字母小写)
     */
    public static String underlineCase2CamelCase(String underlineCase) {
        return StrUtil.underlineCase2CamelCase(underlineCase, false);
    }

    /**
     * 下划线命名 -> 驼峰命名
     *
     * @param underlineCase 下划线命名
     * @param firstLetter   首字母是否大写(true: 首字母大写; false: 首字母小写)
     * @return 驼峰命名
     */
    private static String underlineCase2CamelCase(String underlineCase, boolean firstLetter) {
        Objects.requireNonNull(underlineCase, "下划线命名字符串不能为空");

        StringBuilder sb = new StringBuilder();
        int length = underlineCase.length();
        for (int i = 0; i < length; i++) {
            if (UNDER_LINE == underlineCase.charAt(i)) {
                // 下划线
                firstLetter = true;
                continue;
            }
            if (firstLetter) {
                firstLetter = false;
                sb.append(Character.toUpperCase(underlineCase.charAt(i)));
                continue;
            }
            sb.append(underlineCase.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 下划线命名 -> 蛇形命名
     *
     * @param underlineCase 下划线命名
     * @return 蛇形命名
     */
    public static String underlineCase2SnakeCase(String underlineCase) {
        Objects.requireNonNull(underlineCase, "下划线命名字符串不能为空");

        return underlineCase.replaceAll(String.valueOf(UNDER_LINE), String.valueOf(MIDDLE_LINE));
    }

    /**
     * 雪花算法生成一个唯一的 id
     *
     * @return 唯一 id
     */
    public static String generateUniqueId() {
        return IdUtil.getSnowflakeNextIdStr();
    }

    /**
     * 多个路径合并
     *
     * @param path 文件路径
     * @return 合并路径
     */
    public static String pathMerge(String... path) {
        // 返回空
        if (path == null || path.length == 0) {
            return "";
        }
        return cn.hutool.core.util.StrUtil.join("/", path);
    }

}
