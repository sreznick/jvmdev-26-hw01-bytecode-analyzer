
public final class StringInfo implements CpInfo {
	byte tag;
	short string_index;
	
	StringInfo(byte _tag, short _string_index) {
		tag = _tag;
		string_index = _string_index;
	}
}
