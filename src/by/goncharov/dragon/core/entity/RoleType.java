package by.goncharov.dragon.core.entity;

import by.goncharov.dragon.core.utils.CommonConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Description of RoleType class
 *
 * @author Mikita Hancharou
 * @created 17.14.14 20:32
 */
public enum RoleType {

    ADMIN(CommonConstants.ADMIN_ROLE_TYPE, "role.type.ADMIN");

    private static final Map<Integer, RoleType> MAP = new HashMap<Integer, RoleType>();
    private final Integer type;
    private final String key;
    private String labelKey;

    static {
        for (RoleType roleType : RoleType.values()) {
            MAP.put(roleType.getType(), roleType);
        }
    }

    private RoleType(int type, String key) {
        this.type = type;
        this.key = key;
    }

    public static RoleType getEnum(Integer type) {
        return MAP.get(type);
    }

    public Integer getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getLabelKey() {
//        this.setLabelKey(Utils.getProperty(this.getKey()));
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }
}
