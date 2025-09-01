package com.du.Test;

import java.util.List;

import com.du.dao.DeptDao;
import com.du.dto.Dept;

public class TestDept {

	public static void main(String[] args) {
		DeptDao d1 = new DeptDao();
		Dept dept = d1.selectOne(10);
		System.out.println(dept);
		
		DeptDao d2 = new DeptDao();
		List<Dept> dept2 = d2.selectList();
		System.out.println(dept2);
		
		
//		DeptDao d3 = new DeptDao();
//		Dept dept3 = d3.updateOne(60, "seo", "hong");
		
//		DeptDao d4 = new DeptDao();
//		Dept dept4 = d4.insertOne(90, "서", "재홍");
//		
		
		DeptDao d5 = new DeptDao();
		Dept dept5 = d5.deleteOne(60);
		
	}

}
