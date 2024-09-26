package com.radiance.ai.assistant.common.exception.convert;

import org.springframework.core.Conventions;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

/**
 * 自定义解析器抽象类
 *
 * @author juncong.sh
 * @date 2022/7/8 01:24
 * @since 1.0.0
 */
public abstract class AbstractCustomizeResolver implements HandlerMethodArgumentResolver {

    /**
     * 校验
     *
     * @param parameter     方法参数
     * @param mavContainer  ModelAndView 容器
     * @param webRequest    内部 web 请求
     * @param binderFactory web 数据绑定工厂
     * @param arg           参数
     * @author juncong.sh
     * @date 2022/7/13 00:50
     * @since 1.0.1.siji-village-redis-SNAPSHOT
     */
    protected void valid(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
        WebDataBinderFactory binderFactory, Object arg) throws Exception {
        String name = Conventions.getVariableNameForParameter(parameter);
        WebDataBinder binder = binderFactory.createBinder(webRequest, arg, name);
        if (arg != null) {
            validateIfApplicable(binder, parameter);
            if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(binder, parameter)) {
                throw new MethodArgumentNotValidException(parameter, binder.getBindingResult());
            }
        }
        mavContainer.addAttribute(BindingResult.MODEL_KEY_PREFIX + name, binder.getBindingResult());
    }

    /**
     * 可应用校验
     *
     * @param binder    web 数据绑定
     * @param parameter 方法参数
     * @author juncong.sh
     * @date 2022/7/13 00:52
     * @since 1.0.1.siji-village-redis-SNAPSHOT
     */
    protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation ann : annotations) {
            Validated validatedAnn = AnnotationUtils.getAnnotation(ann, Validated.class);
            if (validatedAnn != null || ann.annotationType().getSimpleName().startsWith("Valid")) {
                Object hints = (validatedAnn != null ? validatedAnn.value() : AnnotationUtils.getValue(ann));
                Object[] validationHints = (hints instanceof Object[] ? (Object[])hints : new Object[] {hints});
                binder.validate(validationHints);
                break;
            }
        }
    }

    /**
     * 必填项绑定异常验证
     *
     * @param binder    web 数据绑定
     * @param parameter 方法参数
     * @return {@link Boolean} 必填验证
     * @author juncong.sh
     * @date 2022/7/13 00:50
     * @since 1.0.1.siji-village-redis-SNAPSHOT
     */
    protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter parameter) {
        int i = parameter.getParameterIndex();
        Class<?>[] paramTypes = parameter.getMethod().getParameterTypes();
        boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
        return !hasBindingResult;
    }

}
