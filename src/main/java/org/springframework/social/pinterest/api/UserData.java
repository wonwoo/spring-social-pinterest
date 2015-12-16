package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class UserData<T> {

    private T data;

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserData{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
