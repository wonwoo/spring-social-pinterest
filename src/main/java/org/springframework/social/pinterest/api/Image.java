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

}
