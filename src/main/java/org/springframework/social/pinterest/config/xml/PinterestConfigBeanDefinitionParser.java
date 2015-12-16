package org.springframework.social.pinterest.config.xml;

import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.pinterest.config.support.PinterestApiHelper;
import org.springframework.social.pinterest.connect.PinterestConnectionFactory;
import org.springframework.social.pinterest.security.PinterestAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

public class PinterestConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {
	public PinterestConfigBeanDefinitionParser() {
		super(PinterestConnectionFactory.class, PinterestApiHelper.class);
	}

	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return PinterestAuthenticationService.class;
	}

	@Override
	protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret,
			Map<String, Object> allAttributes) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(PinterestConnectionFactory.class)
				.addConstructorArgValue(appId).addConstructorArgValue(appSecret);
		if (allAttributes.containsKey("app-namespace")) {
			builder.addConstructorArgValue(allAttributes.get("app-namespace"));
		}
		return builder.getBeanDefinition();
	}
}