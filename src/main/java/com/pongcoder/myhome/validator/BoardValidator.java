package com.pongcoder.myhome.validator;

import com.pongcoder.myhome.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        Board b = (Board)obj;
        if(StringUtils.isEmpty(b.getContent())){
            e.rejectValue("content","","내용을 입력하세요.");
        }
    }
}
