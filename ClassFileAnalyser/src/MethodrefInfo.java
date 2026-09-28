
public final class MethodrefInfo implements CpInfo {
	byte tag;
	short class_index;
    short name_and_type_index;
	
	MethodrefInfo(byte _tag, short _class_index, short _name_and_type_index) {
		tag = _tag;
		class_index = _class_index;
		name_and_type_index = _name_and_type_index;
	}
}
