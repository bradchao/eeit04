package tw.brad.tutor;

import java.util.HashSet;
import java.util.Iterator;

import tw.brad.apis.Bike;

public class Brad32 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("Brad");
		set.add(new Bike());
		System.out.println(set.size());
		set.add("Brad");
		System.out.println(set.size());
		set.add(123);	// int => auto-boxing => Integer
		System.out.println(set.size());
		set.add(12.3);  // double => auto-boxing => Double
		System.out.println(set.size());
		set.add(123);
		System.out.println(set.size());
		System.out.println("----");
		System.out.println(set);
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		System.out.println("----");
		for (Object obj : set) {
			System.out.println(obj);
		}
		
	}

}
