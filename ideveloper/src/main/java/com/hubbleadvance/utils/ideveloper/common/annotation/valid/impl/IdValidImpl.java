package com.hubbleadvance.utils.ideveloper.common.annotation.valid.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hubbleadvance.utils.ideveloper.common.annotation.valid.IdValid;
@Service
public class IdValidImpl implements ConstraintValidator<IdValid, String>{
    private int type;
    
    @Override
    public void initialize(IdValid constraintAnnotation) {
        this.type = constraintAnnotation.type();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = false;
        switch (type) {
        case 1:
            result = checkSnowFlakeStrId(value);
            break;
        case 2:
            result = check32UUID(value);
            break;
        default:
            break;
        }
        return result;
    }
    
    private boolean checkSnowFlakeStrId(String id) {
        if (id != null && StringUtils.isNumeric(id) && id.length() == 18) {
            return true;
        }
        return false;
    }

    private boolean check32UUID(String id) {
        if (id != null && StringUtils.isAlphanumeric(id) && id.length() == 32) {
            return true;
        }
        return false;
    }
}
