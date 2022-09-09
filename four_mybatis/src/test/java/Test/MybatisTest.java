package Test;


import com.lyc.four.pojo.Books;
import com.lyc.four.pojo.Orders;
import com.lyc.four.pojo.Person;
import com.lyc.four.pojo.Users;
import com.lyc.four.utils.MyBatisUtils;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {
    @Test
    public void  findPersonByIdTest1() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Person person = sqlSession.selectOne("com.lyc.four.mapper.PersonMapper.findPersonById", 1);
        System.out.println(person);
        sqlSession.close();
    }

    @Test
    public void  findPersonByIdTest2() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Person person = sqlSession.selectOne("com.lyc.four.mapper.PersonMapper.findPersonById2", 1);
        System.out.println(person);
        sqlSession.close();
    }

    @Test
    public void  findUserWithOrders() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Users users = sqlSession.selectOne("com.lyc.four.mapper.UsersMapper.findUserWithOrders", 1);
        System.out.println(users);
        sqlSession.close();
    }
    @Test
    public void  findOrdersWithProductTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
       Orders orders = sqlSession.selectOne("com.lyc.four.mapper.OrdersMapper.findOrdersWithProduct", 1);
        System.out.println(orders);
        sqlSession.close();
    }


    @Test
    public void  findBookByIdTest1() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Books books1 = sqlSession.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books1.toString());
        Books books2 = sqlSession.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books2.toString());
        sqlSession.close();
    }


    @Test
    public void  findBookByIdTest2() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Books books3 = sqlSession.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books3.toString());
        Books books4=new Books();
        books4.setId(3);
        books4.setBookName("Mysql数据库入门");
        books4.setPrice(40.0);
        sqlSession.update("com.lyc.four.mapper.BookMapper.updateBook",books4);
        sqlSession.commit();
        Books books5 = sqlSession.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books3.toString());


        sqlSession.close();
    }



    @Test
    public void  findBookByIdTest3() {
        SqlSession sqlSession1 = MyBatisUtils.getSession();
        SqlSession sqlSession2 = MyBatisUtils.getSession();


        Books books6 = sqlSession1.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books6.toString());
        sqlSession1.close();


        Books books7 = sqlSession2.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books7.toString());
        sqlSession1.close();


    }


    @Test
    public void  findBookByIdTest4() {
        SqlSession sqlSession1 = MyBatisUtils.getSession();
        SqlSession sqlSession2 = MyBatisUtils.getSession();
        SqlSession sqlSession3 = MyBatisUtils.getSession();

        Books books8 = sqlSession1.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books8.toString());
        sqlSession1.close();


        Books books9=new Books();
        books9.setId(2);
        books9.setBookName("javaee web");
        books9.setPrice(45.0);
        sqlSession2.update("com.lyc.four.mapper.BookMapper.updateBook",books9);
        sqlSession2.commit();
        sqlSession2.close();


        Books books10 = sqlSession3.selectOne("com.lyc.four.mapper.BookMapper.findBookById", 1);
        System.out.println(books10.toString());
        sqlSession3.close();


    }
}
