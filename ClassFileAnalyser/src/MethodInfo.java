import java.util.ArrayList;

public final class MethodInfo {
    short access_flags;
    short name_index;
    short descriptor_index;
    short attributes_count;
    ArrayList<AttributeInfo> attributes;
    
    MethodInfo(
        short _access_flags,
        short _name_index,
        short _descriptor_index,
        short _attributes_count,
        ArrayList<AttributeInfo> _attributes
    ) {
        access_flags = _access_flags;
        name_index = _name_index;
        descriptor_index = _descriptor_index;
        attributes_count = _attributes_count;
        attributes = _attributes;
    }
}
