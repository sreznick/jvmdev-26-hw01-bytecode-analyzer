
public final class NameAndTypeInfo implements CpInfo {
	byte tag;
	short name_index;
    short descriptor_index;
	
	NameAndTypeInfo(byte _tag, short _name_index, short _descriptor_index) {
		tag = _tag;
		name_index = _name_index;
		descriptor_index = _descriptor_index;
	}
}
