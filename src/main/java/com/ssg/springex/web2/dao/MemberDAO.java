package com.ssg.springex.web2.dao;

import com.ssg.springex.jdbcEx.ConnectionUtill;
import com.ssg.springex.web2.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select mid, mpw, mname from tbl_member where mid=? and mpw=?";

        @Cleanup Connection connection = ConnectionUtill.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);

        psmt.setString(1, mid);
        psmt.setString(2, mpw);

        @Cleanup ResultSet rs = psmt.executeQuery();

        rs.next();
        MemberVO memberVO = null;
        memberVO = MemberVO.builder()
                .mid(rs.getString(1))
                .mpw(rs.getString(2))
                .mname(rs.getString(3))
                .build();

        return memberVO;
    }
}
