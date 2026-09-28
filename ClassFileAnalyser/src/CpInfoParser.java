import java.io.DataInputStream;
import java.io.IOException;

class CpInfoParser {
	static CpInfo parse(DataInputStream str) throws IOException {
		byte tag = (byte) str.readUnsignedByte();
		switch (tag) {
		case 1:
		{
			short length = (short) str.readUnsignedShort();
			byte[] bytes = new byte[length];
			for (int i = 0; i < length; i++) {
				bytes[i] = (byte) str.readUnsignedByte();
			}
			return new Utf8Info(tag, length, bytes);
		}
		case 3:
		{
			int bytes = str.readInt();
			return new IntegerInfo(tag, bytes);
		}
		case 4:
		{
			int bytes = str.readInt();
			return new FloatInfo(tag, bytes);
		}
		case 5:
		{
			int high_bytes = str.readInt();
			int low_bytes = str.readInt();
			return new LongInfo(tag, high_bytes, low_bytes);
		}
		case 6:
		{
			int high_bytes = str.readInt();
			int low_bytes = str.readInt();
			return new DoubleInfo(tag, high_bytes, low_bytes);
		}
		case 7:
		{
			short name_index = (short) str.readUnsignedShort();
			return new ClassInfo(tag, name_index);
		}
		case 8:
		{
			short string_index = (short) str.readUnsignedShort();
			return new StringInfo(tag, string_index);
		}
		case 9:
		{
			short class_index = (short) str.readUnsignedShort();
		    short name_and_type_index = (short) str.readUnsignedShort();
			return new FieldrefInfo(tag, class_index, name_and_type_index);
		}
		case 10:
		{
			short class_index = (short) str.readUnsignedShort();
		    short name_and_type_index = (short) str.readUnsignedShort();
			return new MethodrefInfo(tag, class_index, name_and_type_index);
		}
		case 11:
		{
			short class_index = (short) str.readUnsignedShort();
		    short name_and_type_index = (short) str.readUnsignedShort();
			return new InterfaceMethodrefInfo(tag, class_index, name_and_type_index);
		}
		case 12:
		{
			short name_index = (short) str.readUnsignedShort();
    		short descriptor_index = (short) str.readUnsignedShort();
			return new NameAndTypeInfo(tag, name_index, descriptor_index);
		}
		case 15:
		{
			byte reference_kind = (byte) str.readUnsignedByte();
		    short reference_index = (short) str.readUnsignedShort();
			return new MethodHandleInfo(tag, reference_kind, reference_index);
		}
		case 16:
		{
			short descriptor_index = (short) str.readUnsignedShort();
			return new MethodTypeInfo(tag, descriptor_index);
		}
		case 17:
		{
			short bootstrap_method_attr_index = (short) str.readUnsignedShort();
		    short name_and_type_index = (short) str.readUnsignedShort();
			return new DynamicInfo(tag, bootstrap_method_attr_index, name_and_type_index);
		}
		case 18:
		{
			short bootstrap_method_attr_index = (short) str.readUnsignedShort();
		    short name_and_type_index = (short) str.readUnsignedShort();
			return new InvokeDynamicInfo(tag, bootstrap_method_attr_index, name_and_type_index);
		}
		case 19:
		{
			short name_index = (short) str.readUnsignedShort();
			return new ModuleInfo(tag, name_index);
		}
		case 20:
		{
			short name_index = (short) str.readUnsignedShort();
			return new PackageInfo(tag, name_index);
		}
		default:
			throw new IllegalArgumentException("The .class file is malformed: invalid tag value in the constant pool");
		}
	}
}
