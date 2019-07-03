package cn.practice.test.dao;

import cn.practice.test.domian.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserDao {

    @Select("SELECT * from users where username=#{username}")
    Users findUserByUsername(String username);

    @Select("SELECT * from users where username=#{username} and password=#{password}")
    Users findOne(Users users);

    @Insert("insert into users values(null,#{username},#{password})")
    void save(Users users);
}
