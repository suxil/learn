package com.learn.core.util;

import com.learn.core.exception.GlobalCommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/21 22:32
 * <p>
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.core.utils
 */
public final class ValidatorUtils {

    private static final Logger log = LoggerFactory.getLogger(ValidatorUtils.class);

    private ValidatorUtils() {
    }

    private final static ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();

    public static Validator getValidator() {
        return VALIDATOR_FACTORY.getValidator();
    }

    public static <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violationSet = validation(object, groups);
        if (!violationSet.isEmpty()) {
            violationSet.iterator().forEachRemaining(violation -> {
                log.debug("validate object {} current field {} validate error, total size {}.", object.getClass(), violation.getPropertyPath(), violationSet.size());
                String msg = MessageUtils.getMessage("error.validate.field.null", violation.getPropertyPath());
                throw new GlobalCommonException(violation.getMessageTemplate() + ", " + msg);
            });
        }
    }

    public static <T> Set<ConstraintViolation<T>> validation(T object, Class<?>... groups) {
        return getValidator().validate(object, groups);
    }

    public static <T> Set<ConstraintViolation<T>> validationProperty(T object, String propertyName, Class<?>... groups) {
        return getValidator().validateProperty(object, propertyName, groups);
    }

    public static <T> Set<ConstraintViolation<T>> validationValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        return getValidator().validateValue(beanType, propertyName, value, groups);
    }

}
