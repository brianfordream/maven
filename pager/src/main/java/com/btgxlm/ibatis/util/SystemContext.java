package com.btgxlm.ibatis.util;

public class SystemContext {

	/*
	 * 存储排序列明，根据order指定的列进行排序
	 */
	static ThreadLocal<String> order=new ThreadLocal<String>();
	/*
	 * 存储记录总数
	 */
	static ThreadLocal<Integer> pageTotal=new ThreadLocal<Integer>();
	/*
	 * 存储分页大小
	 */
	static ThreadLocal<Integer> pageOffset=new ThreadLocal<Integer>();
	/*
	 * 存储分页起始位置
	 */
	static ThreadLocal<Integer> pageIndex=new ThreadLocal<Integer>();
	/*
	 * 存储排序方式 desc或者asc
	 */
	static ThreadLocal<String> sort=new ThreadLocal<String>();

	public static String getOrder() {
		return order.get();
	}
	public static Integer getPageTotal() {
		return pageTotal.get();
	}
	public static Integer getPageOffset() {
		return pageOffset.get();
	}
	public static Integer getPageIndex() {
		return pageIndex.get();
	}
	public static String getSort() {
		return sort.get();
	}
	
	public static void  setOrder(String _order) {
		order.set(_order);
	}
	public static void setPageTotal(Integer _pageCount) {
		pageTotal .set(_pageCount);
	}
	public static void setPageOffset(Integer _pageOff) {
		pageOffset .set(_pageOff);
	}
	public static void setPageIndex(Integer _pageStart) {
		pageIndex.set(_pageStart);
	}
	public static void setSort(String _sort) {
		sort.set(_sort);
	}
}
