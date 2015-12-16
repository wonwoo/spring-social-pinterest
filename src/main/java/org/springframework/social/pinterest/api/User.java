package org.springframework.social.pinterest.api;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class User extends PinterestObject implements Serializable {


    private String id;
    private String username;
    private String first_name;
    private String last_name;
    private String bio;
    private String created_at;
    private Counts counts;
    private Map<String,Object> image;
    private String account_type;
    private String url;

    public String getBio() {
        return bio;
    }

    public Counts getCounts() {
        return counts;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getImage() {
        return image;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getAccount_type() {
        return account_type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("account_type='").append(account_type).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", bio='").append(bio).append('\'');
        sb.append(", created_at='").append(created_at).append('\'');
        sb.append(", counts=").append(counts);
        sb.append(", image=").append(image);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
