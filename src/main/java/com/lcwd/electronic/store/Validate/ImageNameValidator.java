package com.lcwd.electronic.store.Validate;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ImageNameValidator implements ConstraintValidator<ImageNameValid,String> {

    private Logger logger= LoggerFactory.getLogger(ImageNameValidator.class);
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        logger.info("Message from isValid()", s);
        if(s.isBlank()){
            return false;
    }
        else{
            return true;
        }
}
}
