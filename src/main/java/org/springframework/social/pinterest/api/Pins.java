package org.springframework.social.pinterest.api;

import java.io.Serializable;
import java.util.Map;

public class Pins extends PinterestObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> attribution;
    private Creator creator;
    private String url;
    private Media media;
    private String created_at;
    private String original_link;
    private String note;
    private String color;
    private String link;
    private Boards board;
    private Image image;
    private Counts counts;
    private String id;
    private MetaData metadata;

    public Map<String, String> getAttribution() {
        return attribution;
    }

    public Creator getCreator() {
        return creator;
    }

    public String getUrl() {
        return url;
    }

    public Media getMedia() {
        return media;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getOriginal_link() {
        return original_link;
    }

    public String getNote() {
        return note;
    }

    public String getColor() {
        return color;
    }

    public String getLink() {
        return link;
    }

    public Boards getBoard() {
        return board;
    }

    public Image getImage() {
        return image;
    }

    public Counts getCounts() {
        return counts;
    }

    public String getId() {
        return id;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pins{");
        sb.append("attribution=").append(attribution);
        sb.append(", creator=").append(creator);
        sb.append(", url='").append(url).append('\'');
        sb.append(", media=").append(media);
        sb.append(", created_at='").append(created_at).append('\'');
        sb.append(", original_link='").append(original_link).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", board=").append(board);
        sb.append(", image=").append(image);
        sb.append(", counts=").append(counts);
        sb.append(", id='").append(id).append('\'');
        sb.append(", metadata=").append(metadata);
        sb.append('}');
        return sb.toString();
    }
}
