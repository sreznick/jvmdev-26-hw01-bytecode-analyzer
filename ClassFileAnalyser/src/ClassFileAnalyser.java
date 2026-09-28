import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassFileAnalyser {
	public static void main(String[] args) {
		if (args.length != 1) {
			printHelp();
			return;
		}
		System.out.println("Reading .class file: " + args[0]);
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream(args[0]);
			DataInputStream dataStream = new DataInputStream(fileStream);
			ClassFile classFile = ClassFileParser.parse(dataStream);
			System.out.println("Finished reading");
			for (int i = 0; i < classFile.methods_count; i++) {
				int nameIndex = classFile.methods.get(i).name_index;
				CpInfo methodName = classFile.constant_pool.get(nameIndex - 1);
				if (!methodName.isAnIdiomaticMethodName()) {
					fail("Non-idiomatic method name found: " + methodName);
					return;
				}
			}
			if (classFile.fields_count > 10) {
				fail("The class contains more than 10 fields (" + Integer.toString(classFile.fields_count) + ")");
				return;
			}
			pass();
			return;
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		} catch (EOFException e) {
			System.out.println("Error: The .class file is malformed: unexpected EOF");
		} catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO error while parsing");
			e.printStackTrace();
		}
	}
	
	static void pass() {
		System.out.println("CHECKS PASSED");
	}
	
	static void fail(String message) {
		System.out.println("CHECKS FAILED: " + message);
	}
	
	static void printHelp() {
		System.out.println("usage:");
		System.out.println("java ClassFileAnalyser.java <path to a .class file>");
	}
}
