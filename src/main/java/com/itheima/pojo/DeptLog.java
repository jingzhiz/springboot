package com.itheima.pojo;

import java.time.LocalDateTime;

public class DeptLog {
	private int id;
	private LocalDateTime createTime;
	private String description;

	public DeptLog() {
	}

	public DeptLog(int id, LocalDateTime createTime, String description) {
		this.id = id;
		this.createTime = createTime;
		this.description = description;
	}

	/**
	 * 获取
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取
	 * @return createTime
	 */
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	/**
	 * 设置
	 * @param createTime
	 */
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "DeptLog{id = " + id + ", createTime = " + createTime + ", description = " + description + "}";
	}
}
