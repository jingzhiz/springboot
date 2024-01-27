package com.itheima.service.impl;

import com.itheima.mapper.DeptLogMapper;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
	@Autowired
	private DeptLogMapper deptLogMapper;

	@Override
	// @Transactional(propagation = Propagation.REQUIRED) // 事务传播行为 - 默认：调用方法堆栈中存在事务，则加入那个事务中
	@Transactional(propagation = Propagation.REQUIRES_NEW) // 事务传播行为 - 另起一个事务
	public void insert(DeptLog deptLog) {
		deptLogMapper.insert(deptLog);
	}
}
