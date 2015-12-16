package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 16..
 */
public class Creator {
   private String url;
   private String first_name;
   private String last_name;
   private String id;

    public String getFirst_name() {
        return first_name;
    }

    public String getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Creator{");
        sb.append("first_name='").append(first_name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
