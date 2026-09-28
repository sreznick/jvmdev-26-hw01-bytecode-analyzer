
public final class IntegerInfo implements CpInfo {
	byte tag;
	int bytes;
	
	IntegerInfo(byte _tag, int _bytes) {
		tag = _tag;
		bytes = _bytes;
	}
}
