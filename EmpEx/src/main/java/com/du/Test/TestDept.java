package com.du.Test;

import java.util.List;

import com.du.dao.EmpDao;
import com.du.dto.Emp;

public class TestDept {

	public static void main(String[] args) {
		EmpDao d1 = new EmpDao();
		Emp dept = d1.selectOne(10);
		System.out.println(dept);
		
		EmpDao d2 = new EmpDao();
		List<Emp> dept2 = d2.selectList();
		System.out.println(dept2);
		
		
//		DeptDao d3 = new DeptDao();
//		Dept dept3 = d3.updateOne(60, "seo", "hong");
		
//		DeptDao d4 = new DeptDao();
//		Dept dept4 = d4.insertOne(90, "서", "재홍");
//		
		
		EmpDao d5 = new EmpDao();
		Emp dept5 = d5.deleteOne(60);
		
	}

}
