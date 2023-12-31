package n1ex05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class N1ex05 {

	public static void main(String[] args) {		
		
		SerExampleCar ferrari = new SerExampleCar("Ferrari", "Huracan", 500);
		
		String absolutePathSort = new File("").getAbsolutePath();
		
		String absolutePath = absolutePathSort + "./src/n1ex05/ferrari.ser";
		serializeObject(ferrari, absolutePath);
		
		
		SerExampleCar deserializedFerrari = (SerExampleCar) deserializeObject(absolutePath);
		System.out.println("Deserialized car: " + deserializedFerrari.getBrand() + " " + deserializedFerrari.getModel());

	}

	public static void serializeObject(Object object, String filePath) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
			outputStream.writeObject(object);
			System.out.println("Object serialized and saved to: " + filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object deserializeObject(String filePath) {

		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
			Object object = inputStream.readObject();
			System.out.println("Object deserialized from: " + filePath);
			return object;

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
