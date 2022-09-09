package com.lyc.five.dao;

import com.lyc.five.pojo.Worker;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WorkerMapper {
    @Select("select * from mybatis.tb_worker where id=#{id} ")
    Worker selectWorker(int id);


    @Insert("insert into mybatis.tb_worker(name,age,sex,worker_id) values (#{name},#{age},#{sex},#{worker_id})")
    int insertWorker(Worker worker);

    @Update("update mybatis.tb_worker set  name=#{name},age=#{age} where id=#{id}")
    int updateWorker(Worker worker);

    @Delete("delete from mybatis.tb_worker where id=#{id}")
    int deleteWorker(int id);
}
