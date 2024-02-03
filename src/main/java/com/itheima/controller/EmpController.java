package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpService empService;

	@GetMapping("/{id}")
	public Result get(@PathVariable Integer id) {
		log.info("http Get /emps/{id}: 请求进入，根据id查询员工");
		Emp emp = empService.get(id);
		return Result.success(emp);
	}

	@GetMapping
	public Result page(
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer pageSize,
			String name,
			Short gender,
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
	) {
		log.info("http Get /emps: 请求进入，分页查询员工");
		PageBean empPage = empService.page(page, pageSize, name, gender, begin, end);

		return Result.success(empPage);
	}

	@Log
	@PostMapping
	public Result add(@RequestBody Emp emp) {
		log.info("http post /emps: 请求进入，添加员工");
		int i = empService.add(emp);
		if (i > 0) {
			return Result.success();
		} else {
			return Result.error("添加失败");
		}
	}

	@Log
	@PutMapping
	public Result update(@RequestBody Emp emp) {
		log.info("http put /emps: 请求进入，修改员工");
		int i = empService.update(emp);
		if (i > 0) {
			return Result.success();
		} else {
			return Result.error("修改失败");
		}
	}

	@Log
	@DeleteMapping("/{ids}")
	public Result delete(@PathVariable List<Integer> ids) throws Exception {
		log.info("http delete /emps: 请求进入，删除员工");
		empService.delete(ids);
		return Result.success();
	}
}
