package com.ssg.springex.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum ModelUtil {
    INSTANCE;
    private ModelMapper modelMapper;

    ModelUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) //ModelMapper 사용 할게
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE) //접근제한자를 private으로 설정
                .setMatchingStrategy(MatchingStrategies.STRICT); //필드의 모든 순서와 속성이 동일해야 매칭할게 <=> LOOSE
    }

    public ModelMapper get() {
        return this.modelMapper;
    }
}
