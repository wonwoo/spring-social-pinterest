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
		final StringBuffer sb = new StringBuffer("Data{");
		sb.append("data=").append(data);
		sb.append(", page=").append(page);
		sb.append('}');
		return sb.toString();
	}
}
