import java.util.ArrayList;

public final class ClassFile {
	int magic;
	short minor_version;
    short major_version;
    short constant_pool_count;
    ArrayList<CpInfo> constant_pool;
    short access_flags;
    short this_class;
    short super_class;
    short interfaces_count;
    short[] interfaces;
    short fields_count;
    ArrayList<FieldInfo> fields;
    short methods_count;
    ArrayList<MethodInfo> methods;
    short attributes_count;
    ArrayList<AttributeInfo> attributes;
    
    ClassFile(
    		int _magic,
    		short _minor_version,
    		short _major_version,
    		short _constant_pool_count,
    		ArrayList<CpInfo> _constant_pool,
            short _access_flags,
            short _this_class,
            short _super_class,
            short _interfaces_count,
            short[] _interfaces,
            short _fields_count,
            ArrayList<FieldInfo> _fields,
            short _methods_count,
            ArrayList<MethodInfo> _methods,
            short _attributes_count,
            ArrayList<AttributeInfo> _attributes
    ) {
    	magic = _magic;
    	minor_version = _minor_version;
    	major_version = _major_version;
    	constant_pool_count = _constant_pool_count;
    	constant_pool = _constant_pool;
        access_flags = _access_flags;
        this_class = _this_class;
        super_class = _super_class;
        interfaces_count = _interfaces_count;
        interfaces = _interfaces;
        fields_count = _fields_count;
        fields = _fields;
        methods_count = _methods_count;
        methods = _methods;
        attributes_count = _attributes_count;
        attributes = _attributes;
    }
}
