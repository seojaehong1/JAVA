package sec01.exam01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;



public class HashSet {
	public static void main(String[] args) {
		Set<String> list = new java.util.HashSet<String>();
		
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add("java");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println();
		
		for(String str : list) {
			System.out.println(str);
		}
		
	}
}
