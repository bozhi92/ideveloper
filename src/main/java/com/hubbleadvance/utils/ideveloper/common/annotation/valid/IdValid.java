package com.hubbleadvance.utils.ideveloper.common.annotation.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.hubbleadvance.utils.ideveloper.common.annotation.valid.impl.IdValidImpl;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IdValidImpl.class)
public @interface IdValid {
    int type() default 1;
    String message() default "id参数错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
