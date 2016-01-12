package org.springframework.social.pinterest.api;

import org.springframework.core.io.Resource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class PinsData {

	private String board;
	private String note;
	private String link;
	private Resource image;
	private String image_url;
	private String image_base64;

	public PinsData() {
	}

	public PinsData(String board, String note, String link, Resource image, String image_url, String image_base64) {
		super();
		this.board = board;
		this.note = note;
		this.link = link;
		this.image = image;
		this.image_url = image_url;
		this.image_base64 = image_base64;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setImage(Resource image) {
		this.image = image;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public void setImage_base64(String image_base64) {
		this.image_base64 = image_base64;
	}

	public String getBoard() {
		return board;
	}

	public String getNote() {
		return note;
	}

	public String getLink() {
		return link;
	}

	public Resource getImage() {
		return image;
	}

	public String getImage_url() {
		return image_url;
	}

	public String getImage_base64() {
		return image_base64;
	}

	public MultiValueMap<String, Object> toRequestParameters() {
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		if(board != null){
			parameters.add("board", board);
		}
		if(note != null){
			parameters.add("note", note);
		}
		if (link != null) {
			parameters.add("link", link);
		}
		if (image != null) {
			parameters.add("image", image);
		}
		if (image_url != null) {
			parameters.add("image_url", image_url);
		}
		if(image_base64 != null){
			parameters.add("image_base64", image_base64);
		}
		return parameters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinsData [board=");
		builder.append(board);
		builder.append(", note=");
		builder.append(note);
		builder.append(", link=");
		builder.append(link);
		builder.append(", image=");
		builder.append(image);
		builder.append(", image_url=");
		builder.append(image_url);
		builder.append(", image_base64=");
		builder.append(image_base64);
		builder.append("]");
		return builder.toString();
	}

}
