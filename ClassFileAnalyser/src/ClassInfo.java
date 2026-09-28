
public final class ClassInfo implements CpInfo {
	byte tag;
	short name_index;
	
	ClassInfo(byte _tag, short _name_index) {
		tag = _tag;
		name_index = _name_index;
	}
}
