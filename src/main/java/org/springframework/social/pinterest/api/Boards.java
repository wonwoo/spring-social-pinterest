package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 16..
 */
public class Boards {

    private String id;
    private String url;
    private String name;
    private String created_at;
    private Creator creator;
    private String description;
    private Image image;
    private String privacy;
    private String reason;
    private Counts counts;

    public Counts getCounts() {
        return counts;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Creator getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrivacy() {
        return privacy;
    }

    public String getReason() {
        return reason;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Boards{");
        sb.append("counts=").append(counts);
        sb.append(", id='").append(id).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", created_at='").append(created_at).append('\'');
        sb.append(", creator=").append(creator);
        sb.append(", description='").append(description).append('\'');
        sb.append(", image=").append(image);
        sb.append(", privacy='").append(privacy).append('\'');
        sb.append(", reason='").append(reason).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
