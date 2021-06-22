package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.domain.User;

import java.util.List;

/**
 * mapper 接口 定义增删改查接口
 * @author licc
 * @date 2021/05/08
 *
 */
//@Mapper
public interface UserMapper {

    /**
     * 查出所有数据
     * @return 所有用户列表
     */
    List<User> findAll();

    /**
     * 根据ID 查出指定用户
     * @param id id
     * @return 指定用户对象
     */
    User findById(Long id);

    /**
     * 保存用户
     * @param user 待保存用户
     */
    void save(User user);

    /**
     * 根据 名称模糊查询
     * @param name 名称
     * @param age 年龄
     * @return 对象集合
     */
    List<User> selectListByNameLikeAndAgeEqual(@Param("name") String name , @Param("age") Integer age);

}
