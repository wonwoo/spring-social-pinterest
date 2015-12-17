package org.springframework.social.pinterest.api;

public class Const {

	public static final Integer DEFAULT_LIMIT = 25;
	
	public static final String DEFAULT_USER_FIELDS = "account_type,bio,counts,created_at,first_name,id,image,last_name,url,username";
	
	public static final String DEFAULT_BOARDS_FIELDS = "counts,created_at,creator,description,id,image,name,privacy,reason,url";
	
	public static final String DEFAULT_PINS_FIELDS = "attribution,board(counts,created_at,creator,description,id,image,name,privacy,reason,url),color,counts,created_at,creator,id,image,link,media,metadata,note,original_link,url";
}
