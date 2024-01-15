package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
	/**
	 * 查询全部部门数据
	 *
	 * @return
	 */
	List<Dept> list();

	/**
	 * 根据id查询部门数据
	 *
	 * @return
	 */
	Dept get(Integer id);

	/**
	 * 添加部门数据
	 *
	 * @return
	 */
	int add(Dept dept);

	/**
	 * 修改部门数据
	 *
	 * @return
	 */
	int update(Dept dept);

	/**
	 * 根据id删除部门数据
	 *
	 * @return
	 */
	int delete(Integer id);
}
