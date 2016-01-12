package org.springframework.social.pinterest.api;

public class Media {

	private String type;

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Media{");
		sb.append("type='").append(type).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
