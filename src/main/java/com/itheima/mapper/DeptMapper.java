package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
	/**
	 * 查询所有部门
	 *
	 * @return
	 */
	@Select("select * from dept")
	List<Dept> list();

	@Select("select * from dept where id = #{id}")
	Dept get(Integer id);

	/**
	 * 添加部门
	 *
	 * @param dept
	 * @return
	 */
	@Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
	int add(Dept dept);

	/**
	 * 修改部门
	 *
	 * @param dept
	 * @return
	 */
	@Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
	int update(Dept dept);

	/**
	 * 根据id删除部门
	 *
	 * @param id
	 * @return
	 */
	@Delete("delete from dept where id = #{id}")
	int delete(Integer id);
}