package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
	/**
	 * 员工登录
	 *
	 * @param emp
	 * @return
	 */
	Emp login(Emp emp);


	/**
	 * 根据id查询员工
	 *
	 * @param id
	 * @return
	 */
	Emp get(Integer id);

	/**
	 * 分页查询
	 *
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

	/**
	 * 添加员工
	 *
	 * @param emp
	 * @return
	 */
	int add(Emp emp);

	/**
	 * 修改员工
	 *
	 * @param emp
	 * @return
	 */
	int update(Emp emp);

	/**
	 * 删除员工
	 *
	 * @param ids
	 * @return
	 */
	int delete(List<Integer> ids);
}
