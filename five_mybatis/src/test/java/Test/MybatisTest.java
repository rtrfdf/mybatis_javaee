package Test;

import com.lyc.five.dao.WorkerMapper;
import com.lyc.five.pojo.Worker;
import com.lyc.five.utils.MyBatisUtils;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {
    @Test
    public void findWorkerByIdTest(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        WorkerMapper mapper=sqlSession.getMapper(WorkerMapper.class);
        Worker worker=mapper.selectWorker(3);
        System.out.println(worker.toString());
        sqlSession.close();
    }


    @Test
    public void insertWorkerByIdTest(){
        SqlSession sqlSession= MyBatisUtils.getSession();

        Worker worker=new Worker();

        worker.setId(3);
        worker.setName("周七");
        worker.setAge(36);
        worker.setSex("男");
        worker.setWorker_id("1003");
      WorkerMapper mapper=sqlSession.getMapper(WorkerMapper.class);

      int result =mapper.insertWorker(worker);
        if (result >0) {
            System.out.println("成功插入"+result+"条数据");
        }else {
            System.out.println("插入数据失败");
        }
        System.out.println(worker.toString());
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void updateWorkerByIdTest(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        Worker worker=new Worker();
        worker.setId(3);
        worker.setName("李华");
        worker.setAge(28);
        WorkerMapper mapper=sqlSession.getMapper(WorkerMapper.class);

        int result =mapper.updateWorker(worker);
        if (result >0) {
            System.out.println("成功更新"+result+"条数据");
        }else {
            System.out.println("更新数据失败");
        }
        System.out.println(worker.toString());
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void deleteWorkerByIdTest(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        WorkerMapper mapper=sqlSession.getMapper(WorkerMapper.class);
        int result =mapper.deleteWorker(3);
        if (result >0) {
            System.out.println("成功删除"+result+"条数据");
        }else {
            System.out.println("删除数据失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }


}
