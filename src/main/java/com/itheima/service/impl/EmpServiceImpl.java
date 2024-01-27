package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	@Override
	public Emp login(Emp emp) {
		return empMapper.getByUsernameAndPassword(emp);
	}

	@Override
	public Emp get(Integer id) {
		return empMapper.get(id);
	}

	// @Override
	// public PageBean page(Integer page, Integer pageSize) {
	// 	long total = empMapper.getTotal();
	// 	List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);
	//
	// 	PageBean pageBean = new PageBean(total, empList);
	//
	// 	return pageBean;
	// }

	@Override
	public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
		PageHelper.startPage(page, pageSize);

		Page<Emp> pageContent = (Page<Emp>) empMapper.list(name, gender, begin, end);

		PageBean pageBean = new PageBean(pageContent.getTotal(), pageContent.getResult());

		return pageBean;
	}

	@Override
	public int add(Emp emp) {
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		return empMapper.add(emp);
	}

	@Override
	public int update(Emp emp) {
		emp.setUpdateTime(LocalDateTime.now());
		return empMapper.update(emp);
	}

	@Override
	public void delete(List<Integer> ids) {
		empMapper.delete(ids);
	}
}
