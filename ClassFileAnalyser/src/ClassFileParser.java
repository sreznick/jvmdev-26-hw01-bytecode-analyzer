import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ClassFileParser {
	public static ClassFile parse(DataInputStream str) throws IOException {
		int magic = str.readInt();
		if (magic != 0xCAFEBABE) {
			throw new IllegalArgumentException("Not a .class file");
		}
		short minor_version = (short) str.readUnsignedShort();
		short major_version = (short) str.readUnsignedShort();
		short constant_pool_count = (short) str.readUnsignedShort();
		ArrayList<CpInfo> constant_pool = new ArrayList<CpInfo>(constant_pool_count);
		for (int i = 1; i < constant_pool_count; i++) {
			constant_pool.add(CpInfoParser.parse(str));
		}
		short access_flags = (short) str.readUnsignedShort();
		short this_class = (short) str.readUnsignedShort();
		short super_class = (short) str.readUnsignedShort();
		short interfaces_count = (short) str.readUnsignedShort();
		short[] interfaces = new short[interfaces_count];
		for (int i = 0; i < interfaces_count; i++) {
			interfaces[i] = (short) str.readUnsignedShort();
		}
		short fields_count = (short) str.readUnsignedShort();
		ArrayList<FieldInfo> fields = new ArrayList<FieldInfo>(fields_count);
		for (int i = 0; i < fields_count; i++) {
			fields.add(FieldInfoParser.parse(str));
		}
		short methods_count = (short) str.readUnsignedShort();
		ArrayList<MethodInfo> methods = new ArrayList<MethodInfo>(methods_count);
		for (int i = 0; i < methods_count; i++) {
			methods.add(MethodInfoParser.parse(str));
		}
		short attributes_count = (short) str.readUnsignedShort();
    	ArrayList<AttributeInfo> attributes = new ArrayList<AttributeInfo>(attributes_count);
    	for (int i = 0; i < attributes_count; i++) {
			attributes.add(AttributeInfoParser.parse(str));
		}
		return new ClassFile(
			magic,
			minor_version,
			major_version,
			constant_pool_count,
			constant_pool,
			access_flags,
			this_class,
			super_class,
			interfaces_count,
			interfaces,
			fields_count,
			fields,
			methods_count,
			methods,
			attributes_count,
			attributes
		);
	}
}

