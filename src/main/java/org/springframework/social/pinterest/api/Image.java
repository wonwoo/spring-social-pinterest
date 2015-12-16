package org.springframework.social.pinterest.api;

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

}
