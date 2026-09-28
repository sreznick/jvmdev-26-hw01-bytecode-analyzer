
public final class ModuleInfo implements CpInfo {
	byte tag;
	short name_index;
	
	ModuleInfo(byte _tag, short _name_index) {
		tag = _tag;
		name_index = _name_index;
	}
}
