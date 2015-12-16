package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 16..
 */
public class Counts {

    private Integer pins;
    private Integer following;
    private Integer followers;
    private Integer boards;
    private Integer likes;

    public Integer getBoards() {
        return boards;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getPins() {
        return pins;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("counts{");
        sb.append("boards=").append(boards);
        sb.append(", pins=").append(pins);
        sb.append(", following=").append(following);
        sb.append(", followers=").append(followers);
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
}
