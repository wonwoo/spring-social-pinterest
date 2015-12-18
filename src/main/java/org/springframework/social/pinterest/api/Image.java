package org.springframework.social.pinterest.api;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Image {

	private Original original;

	public static class Original {
		private String url;
		private Integer width;
		private Integer height;

		public String getUrl() {
			return url;
		}

		public Integer getWidth() {
			return width;
		}

		public Integer getHeight() {
			return height;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Original [url=");
			builder.append(url);
			builder.append(", width=");
			builder.append(width);
			builder.append(", height=");
			builder.append(height);
			builder.append("]");
			return builder.toString();
		}

	}

	public Original getOriginal() {
		return original;
	}

	public Original getProfile() {
		return original;
	}

	@JsonSetter(value = "original")
	public void setOriginal(Original original) {
		this.original = original;
	}

	@JsonSetter(value = "60x60")
	public void setProfile(Original original) {
		this.original = original;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image [original=");
		builder.append(original);
		builder.append("]");
		return builder.toString();
	}

}
