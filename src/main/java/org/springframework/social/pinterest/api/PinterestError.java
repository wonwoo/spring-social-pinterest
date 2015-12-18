package org.springframework.social.pinterest.api;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public class PinterestError {

	private String message;
	private String type;
	private String param;
	private String status;
	private String code;
	private String host;
	private String generated_at;
	private String data;

	public PinterestError() {
	}

	public String getType() {
		return type;
	}

	public PinterestError(String message, String type, String param) {
		super();
		this.type = type;
		this.message = message;
		this.param = param;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getGenerated_at() {
		return generated_at;
	}

	public void setGenerated_at(String generated_at) {
		this.generated_at = generated_at;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PinterestError [message=");
		builder.append(message);
		builder.append(", type=");
		builder.append(type);
		builder.append(", param=");
		builder.append(param);
		builder.append(", status=");
		builder.append(status);
		builder.append(", code=");
		builder.append(code);
		builder.append(", host=");
		builder.append(host);
		builder.append(", generated_at=");
		builder.append(generated_at);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
}
