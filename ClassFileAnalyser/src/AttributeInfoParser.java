import java.io.DataInputStream;
import java.io.IOException;

class AttributeInfoParser {
	static AttributeInfo parse(DataInputStream str) throws IOException {
		short attribute_name_index = (short) str.readUnsignedShort();
    	int attribute_length = str.readInt();
    	byte[] info = new byte[attribute_length];
    	for (int i = 0; i < attribute_length; i++) {
    		info[i] = (byte) str.readUnsignedByte();
    	}
    	return new AttributeInfo(
    		attribute_name_index,
    		attribute_length,
    		info
    	);
	}
}
