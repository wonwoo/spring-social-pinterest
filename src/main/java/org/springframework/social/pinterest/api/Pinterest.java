package org.springframework.social.pinterest.api;

import org.springframework.social.ApiBinding;

/**
 * Created by wonwoo on 15. 12. 15..
 */
public interface Pinterest extends ApiBinding, PinterestRestApi {

	UserOperations userOperations();

	BoardsOperations boardsOperations();

	PinsOperations pinsOperations();
}
