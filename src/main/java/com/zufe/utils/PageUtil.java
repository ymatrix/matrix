package com.zufe.utils;

/**
 * 用于构造Page
 * 
 * @author 蒋永亮
 * @version 1.00 2011-8-31
 */
public class PageUtil {
	
	/**
	 * 
	 * 构造方法
	 *
	 * @param everyPage  每页显示数
	 * @param totalCount  总记录数
	 * @param currentPage  当前页数
	 * @return TODO
	 */
	public static Page createPage(int everyPage, int totalCount, int currentPage) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		if(currentPage>totalPage)currentPage=totalPage;
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage, hasNextPage);
	}

	public static Page createPage(Page page, int totalCount) {
		int everyPage = getEveryPage(page.getEveryPage());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		if(currentPage>totalPage)currentPage=totalPage;
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage, hasNextPage);
	}

	public static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}

	public static int getCurrentPage(int currentPage) {
		return currentPage <= 0 ? 1 : currentPage;
	}

	public static int getTotalPage(int everyPage, int totalCount) {
		int totalPage = 0;
		if (totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}

	public static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
}
