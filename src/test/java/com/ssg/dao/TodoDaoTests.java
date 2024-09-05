package com.ssg.dao;

import com.ssg.springex.todo.dao.TodoDao;
import com.ssg.springex.todo.domain.TodoVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoDaoTests {
    TodoDao dao = new TodoDao();
    @Test
    public void testUpdateOne() throws Exception{
        TodoVO voTest = TodoVO.builder().tno(1L).title("updated").dueDate(LocalDate.of(2024,9,5)).finished(true).build();
        dao.updateOne(voTest);
    }

    @Test
    public void testDeleteOne() throws Exception {
        dao.deleteOne(1L);
    }



}

