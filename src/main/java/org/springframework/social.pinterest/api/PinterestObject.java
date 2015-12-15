package org.springframework.social.pinterest.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestObject {

    private Map<String, Object> extraData;

    public PinterestObject() {
        this.extraData = new HashMap<String, Object>();
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }


    protected void add(String key, Object value) {
        extraData.put(key, value);
    }

}
