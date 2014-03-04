package com.zufe.utils;

/**
 * 这里用一句话描述这个类的作用
 * 
 * @author 蒋永亮
 * @version 1.00 2011-8-31
 */
public class Page {
	/**
	 * 每页显示数量
	 */
	private int everyPage;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 起始点
	 */
	private int beginIndex;
	/**
	 * 是否有上一页
	 */
	private boolean hasPrePage;
	/**
	 * 是否有下一页
	 */
	private boolean hasNextPage;

	/**
	 * 构造方法
	 * @param everyPage2
	 * @param totalCount2
	 * @param totalPage2
	 * @param currentPage2
	 * @param beginIndex2
	 * @param hasPrePage2
	 * @param hasNextPage2
	 */
	public Page(int everyPage, int totalCount, int totalPage,
			int currentPage, int beginIndex, boolean hasPrePage,
			boolean hasNextPage) {

		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}

	/*
	 * 相应的有参无参构造器，getters和setters方法
	 */
	public Page() {

	}

	public int getEveryPage() {
		return this.everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return this.beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasPrePage() {
		return this.hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return this.hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
