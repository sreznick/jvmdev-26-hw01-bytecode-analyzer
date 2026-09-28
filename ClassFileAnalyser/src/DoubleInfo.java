
public final class DoubleInfo implements CpInfo {
	byte tag;
	int high_bytes;
	int low_bytes;
	
	DoubleInfo(byte _tag, int _high_bytes, int _low_bytes) {
		tag = _tag;
		high_bytes = _high_bytes;
		low_bytes = _low_bytes;
	}
}
