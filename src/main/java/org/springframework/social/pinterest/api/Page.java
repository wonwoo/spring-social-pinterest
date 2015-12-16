package org.springframework.social.pinterest.api;

public class Page {

	private String cursor;
	private String next;

	public String getCursor() {
		return cursor;
	}

	public String getNext() {
		return next;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [cursor=");
		builder.append(cursor);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}

}
