import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FieldInfoParser {
	static FieldInfo parse(DataInputStream str) throws IOException {
		short access_flags = (short) str.readUnsignedShort();
    	short name_index = (short) str.readUnsignedShort();
    	short descriptor_index = (short) str.readUnsignedShort();
    	short attributes_count = (short) str.readUnsignedShort();
    	ArrayList<AttributeInfo> attributes = new ArrayList<AttributeInfo>();
    	for (int i = 0; i < attributes_count; i++) {
    		attributes.add(AttributeInfoParser.parse(str));
    	}
    	return new FieldInfo(
    		access_flags,
    		name_index,
    		descriptor_index,
    		attributes_count,
    		attributes
    	);
	}
}
