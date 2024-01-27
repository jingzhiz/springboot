package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
	Emp get(Integer id);

	Emp getByUsernameAndPassword(Emp emp);

	// @Select("select count(*) from emp")
	// long getTotal();

	// @Select("select * from emp limit #{start}, #{pageSize}")
	// List<Emp> page(Integer start, Integer pageSize);

	// @Select("select * from emp")
	List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

	int add(Emp emp);

	int update(Emp emp);

	int delete(List<Integer> ids);

	void deleteByDeptId(Integer deptId);
}
