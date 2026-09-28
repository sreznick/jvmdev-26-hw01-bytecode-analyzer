
public final class AttributeInfo {
	short attribute_name_index;
    int attribute_length;
    byte[] info;

    AttributeInfo(
        short _attribute_name_index,
        int _attribute_length,
        byte[] _info
    ) {
        attribute_name_index = _attribute_name_index;
        attribute_length = _attribute_length;
        info = _info;
    }
}
