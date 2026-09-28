
public final class DynamicInfo implements CpInfo {
	byte tag;
	short bootstrap_method_attr_index;
	short name_and_type_index;

	DynamicInfo(byte _tag, short _bootstrap_method_attr_index, short _name_and_type_index) {
		tag = _tag;
		bootstrap_method_attr_index = _bootstrap_method_attr_index;
		name_and_type_index = _name_and_type_index;
	}
}
