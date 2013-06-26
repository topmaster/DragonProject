package by.goncharov.dragon.core.entity;

import java.util.HashMap;
import java.util.Map;

import by.goncharov.dragon.core.utils.CommonConstants;

/**
 * Description of ContactType class
 *
 * @author Mikita Hancharou
 * @created 28.05.13 13:07
 */
public enum ContactType {

    OWNER(CommonConstants.CONTACT_TYPE_OWNER, "contact.type.owner"),
    FAMILIAR(CommonConstants.CONTACT_TYPE_ACQUAINTANCE, "contact.type.acquaintance"),
    CANDIDATE(CommonConstants.CONTACT_TYPE_CANDIDATE, "contact.type.candidate"),
    CUSTOMER(CommonConstants.CONTACT_TYPE_CUSTOMER, "contact.type.customer"),
    DISTRIBUTOR(CommonConstants.CONTACT_TYPE_DISTRIBUTOR, "contact.type.distributor"),
    DROPPED_OUT(CommonConstants.CONTACT_TYPE_DROPPED_OUT, "contact.type.dropped_out");

    private static final Map<Integer, ContactType> MAP = new HashMap<Integer, ContactType>();

    private final Integer type;
    private final String key;
    private String labelKey;

    static {
        for (ContactType contactType : ContactType.values()) {
            MAP.put(contactType.getType(), contactType);
        }
    }

     ContactType(int type, String key) {
         this.type = type;
         this.key = key;
     }

    public Integer getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public static ContactType getEnum(Long type) {
        return MAP.get(type);
    }
}
