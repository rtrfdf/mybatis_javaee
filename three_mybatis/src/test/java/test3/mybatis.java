package test3;

import com.lyc.three.pojo.Customer;
import com.lyc.three.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mybatis {
    @Test
    public void findCustomerByNameAndJobsTest(){
   SqlSession session= MyBatisUtils.getSession();
        Customer customer=new Customer();
        //customer.setUsername("joy");
        customer.setJobs("teacher");
        List<Customer> list=session.selectList("com.lyc.three.mapper.CustomerMapper.findCustomerByNameAndJobs",customer);
        for (Customer customer2: list) {
            System.out.println(customer2);
        }
        session.close();
    }


    @Test
    public void findCustomerByNameOrJobsTest(){
        SqlSession session= MyBatisUtils.getSession();
        Customer customer=new Customer();
        //customer.setUsername("gds");
        customer.setJobs("teacher");
        List<Customer> list=session.selectList("com.lyc.three.mapper.CustomerMapper.findCustomerByNameOrJobs",customer);
        for (Customer customer2: list) {
            System.out.println(customer2);
        }
        session.close();
    }

    @Test
    public void  updateCustomerBySetTest(){
        SqlSession sqlSession=MyBatisUtils.getSession();
        Customer customer=new Customer();
        customer.setId(3);
        customer.setPhone("1255465");
        int rows=sqlSession.update("com.lyc.three.mapper.CustomerMapper.updateCustomerBySet",customer);
        if(rows >0){
            System.out.println("你修改了"+rows+"条数据");
        }else {
            System.out.println("你修改失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findByArrayTest(){
        SqlSession sqlSession=MyBatisUtils.getSession();
        Integer[] roleIds={1,3};
        List<Customer> customers=sqlSession.selectList("com.lyc.three.mapper.CustomerMapper.findByArray",roleIds);
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public  void  findByMapTest(){
        SqlSession sqlSession=MyBatisUtils.getSession();
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        Map<String,Object> conditionMap=new HashMap<>();
        conditionMap.put("id",ids);
        conditionMap.put("jobs","teacher");
        List<Customer> customers=sqlSession.selectList("com.lyc.three.mapper.CustomerMapper.findByMap",conditionMap);
        for (Customer customer: customers) {
            System.out.println(customer);
        }

        sqlSession.close();
    }
}
