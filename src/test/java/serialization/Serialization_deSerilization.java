package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	
	int i = 10;
	int j = 20;
}

public class Serialization_deSerilization {
		
		public static void main(String[] args) throws Exception {
			
			Test test1 = new Test();
			
			//serialization
			FileOutputStream fos = new FileOutputStream("test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(test1);
			
			//deserialization
			FileInputStream fis = new FileInputStream("test.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Test test2 = (Test) ois.readObject();
			
			System.out.println(test2.i+"    "+test2.j);
		}
	}
