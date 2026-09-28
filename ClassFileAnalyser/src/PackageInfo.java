
public final class PackageInfo implements CpInfo {
	byte tag;
	short name_index;
	
	PackageInfo(byte _tag, short _name_index) {
		tag = _tag;
		name_index = _name_index;
	}
}
