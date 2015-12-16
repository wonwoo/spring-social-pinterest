package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class Data<T> {

	private T data;
	private Page page;

	public T getData() {
		return data;
	}

	public Page getPage() {
		return page;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Data [data=");
		builder.append(data);
		builder.append(", page=");
		builder.append(page);
		builder.append("]");
		return builder.toString();
	}

}
