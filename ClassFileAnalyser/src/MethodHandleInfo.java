
public final class MethodHandleInfo implements CpInfo {
	byte tag;
	byte reference_kind;
	short reference_index;
	MethodHandleInfo(byte _tag, byte _reference_kind, short _reference_index) {
		tag = _tag;
		reference_kind = _reference_kind;
		reference_index = _reference_index;
	}
}
