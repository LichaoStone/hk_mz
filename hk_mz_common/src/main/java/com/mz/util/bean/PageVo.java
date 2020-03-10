package com.mz.util.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年4月24日 下午3:16:58
* 
*/
@SuppressWarnings("hiding")
public class PageVo<Object> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2224195827236783070L;
	public PageVo() {
		
	}
	public PageVo(Page<Object> page) {
		this.total = page.getTotal();
		this.rows = page.getResult() ;
		this.pages = page.getPages() ;
	}
	private Map<String, Object> map ; 
	public Map<String, Object> getMap() {
		if (map == null) {
			map = new HashMap<String,Object>(0);
		}
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	private long total ;
	private List<Object> rows ;
	
	private Object list ;
	
	private int pages ;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Object getList() {
		return list;
	}
	public void setList(Object list) {
		this.list = list;
	}
	
}
