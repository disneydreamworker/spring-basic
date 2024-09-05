package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    //INSTANCE; //객체 한개만 만들고 사용할게~ 싱글톤 패턴을 적용한거야~~
    //여러 개의 컨트롤러는 하나의 객체를 통해서만 서비스 이용 가능. -> 관리하기 편함

    INSTANCE;

    public void register(TodoDTO dto) { //글 하나를 등록하는 기능

    }

    public List<TodoDTO> getList(){ //등록된 글 목록 반환하는 기능

        //10개의 글을 만들어서 글 전체의 리스트 객체를 반환함
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("todo..." + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }

    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("sample todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }



}
