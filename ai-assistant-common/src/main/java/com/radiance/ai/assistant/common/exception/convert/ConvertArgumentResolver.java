package com.radiance.ai.assistant.common.exception.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转换参数解析器（默认下划线转驼峰，也可以自定义属性名称转换成实体属性名称）
 *
 * @author juncong.sh
 * @date 2022/7/8 01:27
 * @since 1.0.0
 */
public class ConvertArgumentResolver extends AbstractCustomizeResolver {

    /**
     * 匹配_加任意一个字符
     */
    private static final Pattern UNDER_LINE_PATTERN = Pattern.compile("_(\\w)");

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ParameterConvert.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object org = handleParameterNames(parameter, webRequest);
        valid(parameter, mavContainer, webRequest, binderFactory, org);
        return org;
    }

    /**
     * 处理参数
     *
     * @param parameter  方法参数
     * @param webRequest 内部 web 请求
     * @return {@link Object} 返回最终处理过后 controller 层接收到的参数
     * @author juncong.sh
     * @date 2022/7/13 00:47
     * @since 1.0.1.siji-village-redis-SNAPSHOT
     */
    private Object handleParameterNames(MethodParameter parameter, NativeWebRequest webRequest) {
        Object obj = BeanUtils.instantiateClass(parameter.getParameterType());
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(obj);
        Iterator<String> paramNames = webRequest.getParameterNames();
        PropertyField propertyField = getParamPropertyFieldMap(obj);
        Map<String, Field> fieldMap = propertyField.getFieldMap();
        Map<String, Field> paramPropertyFieldMap = propertyField.getParamPropertyFieldMap();
        while (paramNames.hasNext()) {
            String paramName = paramNames.next();
            Object o = webRequest.getParameter(paramName);
            String propertyName;
            if (paramPropertyFieldMap.containsKey(paramName)) {
                propertyName = paramPropertyFieldMap.get(paramName).getName();
            } else {
                propertyName = underLineToCamel(paramName);
            }
            if (fieldMap.containsKey(propertyName)) {
                wrapper.setPropertyValue(propertyName, o);
            }
        }
        return obj;
    }

    /**
     * 获取 ParamProperty 注解标注的实体属性 map 集合
     *
     * @param obj controller get 请求接收的是实体对象
     * @return {@link Map} 返回标注了 ParamProperty 注解的 map 集合
     * @author juncong.sh
     * @date 2022/7/13 00:41
     * @since 1.0.1.siji-village-redis-SNAPSHOT
     */
    private PropertyField getParamPropertyFieldMap(Object obj) {
        Map<String, Field> fieldMap = new HashMap<>();
        Map<String, Field> paramPropertyFieldMap = new HashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean annotationPresent = field.isAnnotationPresent(ParamProperty.class);
            if (annotationPresent) {
                String value = field.getAnnotation(ParamProperty.class).value();
                paramPropertyFieldMap.put(value, field);
            }
            fieldMap.put(field.getName(), field);
        }
        return new PropertyField(fieldMap, paramPropertyFieldMap);
    }

    /**
     * 下换线转驼峰
     *
     * @param source 前端传递的字段属性
     * @return {@link String} 驼峰转换过之后的值
     * @author juncong.sh
     * @date 2022/7/13 00:45
     * @since 1.0.1.siji-village-redis-SNAPSHOT
     */
    private String underLineToCamel(String source) {
        Matcher matcher = UNDER_LINE_PATTERN.matcher(source);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(result);
        return result.toString();
    }

    static class PropertyField {
        /**
         * Controller 层实体类全部属性 Map
         */
        private Map<String, Field> fieldMap;
        /**
         * Controller 层标注了{@link ParamProperty} 注解的属性 Map
         */
        private Map<String, Field> paramPropertyFieldMap;

        public PropertyField() {
        }

        public PropertyField(Map<String, Field> fieldMap, Map<String, Field> paramPropertyFieldMap) {
            this.fieldMap = fieldMap;
            this.paramPropertyFieldMap = paramPropertyFieldMap;
        }

        public Map<String, Field> getFieldMap() {
            return fieldMap;
        }

        public void setFieldMap(Map<String, Field> fieldMap) {
            this.fieldMap = fieldMap;
        }

        public Map<String, Field> getParamPropertyFieldMap() {
            return paramPropertyFieldMap;
        }

        public void setParamPropertyFieldMap(Map<String, Field> paramPropertyFieldMap) {
            this.paramPropertyFieldMap = paramPropertyFieldMap;
        }
    }

}
