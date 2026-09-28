
public final class FloatInfo implements CpInfo {
	byte tag;
	int bytes;
	
	FloatInfo(byte _tag, int _bytes) {
		tag = _tag;
		bytes = _bytes;
	}
}
