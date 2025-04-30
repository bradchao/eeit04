package tw.brad.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Student;

public class Brad51 {
	public static void main(String[] args) {
		Student s1 = new Student("Brad", 76, 45, 32);
		System.out.printf("%s: %d : %f\n", s1.getName(), s1.score(), s1.avg());
		s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.println(s1.getBike());
		
		try (FileOutputStream fout = new FileOutputStream("dir1/brad.score");
				ObjectOutputStream oout = new ObjectOutputStream(fout)){
			oout.writeObject(s1);
			oout.flush();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}


