
public final class MethodTypeInfo implements CpInfo {
	byte tag;
	short descriptor_index;
	
	MethodTypeInfo(byte _tag, short _descriptor_index) {
		tag = _tag;
		descriptor_index = _descriptor_index;
	}
}
