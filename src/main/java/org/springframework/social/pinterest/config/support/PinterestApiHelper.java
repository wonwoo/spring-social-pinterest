package org.springframework.social.pinterest.config.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.pinterest.api.Pinterest;

public class PinterestApiHelper implements ApiHelper<Pinterest> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final UsersConnectionRepository usersConnectionRepository;

	private final UserIdSource userIdSource;

	private PinterestApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
		this.usersConnectionRepository = usersConnectionRepository;
		this.userIdSource = userIdSource;
	}

	public Pinterest getApi() {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting API bingding instance for Pinterest");
		}
		Connection<Pinterest> connection = usersConnectionRepository
				.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Pinterest.class);
		if (logger.isDebugEnabled() && connection == null) {
			logger.debug("No current connection; Returning default PinterestTemplate instance.");
		}
		return connection != null ? connection.getApi() : null;
	}

}