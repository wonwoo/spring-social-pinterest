package org.springframework.social.pinterest.api;

public class Media {

	private String type;

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Media [type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
