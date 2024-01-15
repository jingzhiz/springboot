package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> list() {
		return deptMapper.list();
	}

	@Override
	public Dept get(Integer id) {
		return deptMapper.get(id);
	}

	@Override
	public int add(Dept dept) {
		dept.setCreateTime(LocalDateTime.now());
		dept.setUpdateTime(LocalDateTime.now());
		return deptMapper.add(dept);
	}

	@Override
	public int update(Dept dept) {
		dept.setUpdateTime(LocalDateTime.now());
		return deptMapper.update(dept);
	}

	@Override
	public int delete(Integer id) {
		return deptMapper.delete(id);
	}
}