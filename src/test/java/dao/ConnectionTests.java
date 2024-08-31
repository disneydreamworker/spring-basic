package dao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTests {

    @Test //  테스트 코드(메소드)ㅣ를 테스트할 때 사용하는 어노테이션, 파라미터나 리턴 없이 작성하는 것이 룰이다.
    public void test1(){
        int v1 = 10;
        int v2 = 10;
        Assertions.assertEquals(v1, v2);
    }


    @Test //자바코드를 이용해서 설치된 mysql driver와 DB의 연결을 확인하는 테스트 코드
    public void testConnection() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC", "root", "0000");

        Assertions.assertNotNull(connection);

        connection.close();

    }
}