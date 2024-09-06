package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dao.TodoDao;
import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.util.ModelUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    //INSTANCE; //객체 한개만 만들고 사용할게~ 싱글톤 패턴을 적용한거야~~
    //여러 개의 컨트롤러는 하나의 객체를 통해서만 서비스 이용 가능. -> 관리하기 편함

    INSTANCE;

    private TodoDao dao;
    private ModelMapper modelMapper;

    //생성자 인젝션을 통해서 DAO를 인젝션 한다

    TodoService() {
        dao = new TodoDao();    //직접 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public void register(TodoDTO dto) throws Exception {
        TodoVO vo = modelMapper.map(dto, TodoVO.class); //dto 객체를 vo에 담을거야!
        //LOG 추가
        // System.out.println("todo vo : " + vo);
        log.info(vo);

        dao.insert(vo);
    }

    public List<TodoDTO> listAll() throws Exception {//등록된 글 목록 반환하는 기능

        List<TodoVO> voList = dao.selectAllList();
        log.info(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(vo->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

/*    public void register(TodoDTO dto) { //글 하나를 등록하는 기능

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
    }*/



}
