package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.brad.apis.Student;

public class Brad52 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("dir1/brad.score");
				ObjectInputStream oin = new ObjectInputStream(fin)){
			Object obj = oin.readObject();
			Student s1 = (Student)obj;
			System.out.printf("%s: %d : %f\n", s1.getName(), s1.score(), s1.avg());
			System.out.println(s1.getBike());
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
