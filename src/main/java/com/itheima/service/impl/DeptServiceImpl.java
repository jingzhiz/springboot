package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private DeptLogService deptLogService;

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
	// @Transactional(rollbackFor = Exception.class) // 开启了事务管理，并针对所有异常
	@Transactional
	public void delete(Integer id) throws Exception {
		try {
			deptMapper.delete(id);
			int i = 1 / 0; // 模拟异常出错
			// if (true) { throw new Exception("错误了。。。"); }

			empMapper.deleteByDeptId(id);
		} finally {
			// 事务传播行为
			DeptLog deptLog = new DeptLog();
			deptLog.setCreateTime(LocalDateTime.now());
			deptLog.setDescription("执行了解散部门的操作，此次解散的ID为" + id);

			deptLogService.insert(deptLog);
		}

	}
}