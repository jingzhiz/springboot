package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

	@Autowired
	private AliOSSUtils aliOSSUtils;

	// @PostMapping("/upload")
	// public Result upload(String username, String age, MultipartFile image) throws Exception {
	// 	log.info("文件上传: {}, {}, {}", username, age, image);
	//
	// 	String originFilename = image.getOriginalFilename();
	// 	String extname = originFilename.substring(originFilename.lastIndexOf("."));
	// 	String uniqueFilename = UUID.randomUUID() + extname;
	//
	// 	log.info("获取到的新文件名：{}", uniqueFilename);
	//
	// 	// 将接受到的文件存储到本地磁盘中
	// 	image.transferTo(new File("D:\\Java\\Study\\JavaWeb\\springboot-web\\upload\\" + uniqueFilename));
	//
	// 	return Result.success();
	// }

	@PostMapping("/upload")
	public Result upload(MultipartFile image) throws Exception {
		String url = aliOSSUtils.upload(image);
		return Result.success(url);
	}
}
