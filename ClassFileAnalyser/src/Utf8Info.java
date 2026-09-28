
public final class Utf8Info implements CpInfo {
	byte tag;
	short length;
	byte[] bytes;
	
	Utf8Info(byte _tag, short _length, byte[] _bytes) {
		tag = _tag;
		length = _length;
		bytes = _bytes;
	}
	
	public boolean isAnIdiomaticMethodName() {
		String methodName = new String(bytes);
		if (methodName.equals("<init>")) {
			return true;
		}
		String camelCasePattern = "^[a-z][a-z0-9]*(([A-Z][a-z0-9]+)*[A-Z]?|([a-z0-9]+[A-Z])*|[A-Z])$";
		return methodName.matches(camelCasePattern);
	}
}
