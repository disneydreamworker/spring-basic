package com.ssg.springex.web2.service;


import com.ssg.springex.web2.dao.MemberDAO;
import com.ssg.springex.web2.domain.MemberVO;
import com.ssg.springex.web2.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    //여러 곳에서 동일한 객체로 사용할 수 있도록 enum으로
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        //생성자 인젝션
        memberDAO = new MemberDAO();
        modelMapper = new ModelMapper();
    }

    public MemberDTO login (String mid, String mpw) throws Exception {
        MemberVO memberVO = memberDAO.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

}
