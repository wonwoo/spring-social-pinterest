package org.springframework.social.pinterest.api;

public class BoardPin extends PinterestObject{

	private String attribution;
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

	public String getAttribution() {
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
		StringBuilder builder = new StringBuilder();
		builder.append("BoardPin [attribution=");
		builder.append(attribution);
		builder.append(", creator=");
		builder.append(creator);
		builder.append(", url=");
		builder.append(url);
		builder.append(", media=");
		builder.append(media);
		builder.append(", created_at=");
		builder.append(created_at);
		builder.append(", original_link=");
		builder.append(original_link);
		builder.append(", note=");
		builder.append(note);
		builder.append(", color=");
		builder.append(color);
		builder.append(", link=");
		builder.append(link);
		builder.append(", board=");
		builder.append(board);
		builder.append(", image=");
		builder.append(image);
		builder.append(", counts=");
		builder.append(counts);
		builder.append(", id=");
		builder.append(id);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append("]");
		return builder.toString();
	}

}
