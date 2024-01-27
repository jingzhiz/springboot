package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
	// public static Logger log = LoggerFactory.getLogger(DeptController.class);

	@Autowired
	private DeptService deptService;


	@GetMapping
	public Result list() {
		log.info("http Get /depts: 请求进入，查询全部部门");
		List<Dept> deptList = deptService.list();
		return Result.success(deptList);
	}

	@GetMapping("/{id}")
	public Result get(@PathVariable Integer id) {
		log.info("http Get /depts/{id}: 请求进入，根据id查询部门");
		Dept dept = deptService.get(id);
		return Result.success(dept);
	}

	@PostMapping
	public Result add(@RequestBody Dept dept) {
		log.info("http Post /depts: 请求进入，添加部门");
		if (deptService.add(dept) > 0) {
			return Result.success();
		} else {
			return Result.error("添加失败");
		}
	}

	@PutMapping
	public Result update(@RequestBody Dept dept) {
		log.info("http Put /depts: 请求进入，根据id更新部门");
		if (deptService.update(dept) > 0) {
			return Result.success();
		} else {
			return Result.error("更新失败");
		}
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Integer id) throws Exception {
		log.info("http Delete /depts: 请求进入，根据id删除部门");

		deptService.delete(id);

		return Result.success();
	}
}