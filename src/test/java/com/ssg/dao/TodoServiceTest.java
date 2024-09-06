package com.ssg.dao;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
@Log4j2
public class TodoServiceTest {
    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void register() throws Exception {
        TodoDTO dto = TodoDTO.builder()
                .title("JDBC TEST REGISTER")
                .dueDate(LocalDate.now())
                .build();
        log.info(dto);
        todoService.register(dto);
    }

}
