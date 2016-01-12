package org.springframework.social.pinterest.api;

public class Page {

    private String cursor;
    private String next;

    public String getCursor() {
        return cursor;
    }

    public String getNext() {
        return next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Page{");
        sb.append("cursor='").append(cursor).append('\'');
        sb.append(", next='").append(next).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
