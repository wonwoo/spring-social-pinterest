package org.springframework.social.pinterest.config.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.GenericConnectionStatusView;
import org.springframework.social.pinterest.api.Pinterest;
import org.springframework.social.pinterest.connect.PinterestConnectionFactory;

@Configuration
@ConditionalOnClass({ SocialConfigurerAdapter.class, PinterestConnectionFactory.class })
@ConditionalOnProperty(prefix = "spring.social.pinterest", name = "app-id")
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class PinterestAutoConfiguration {

	@Configuration
	@EnableSocial
	@EnableConfigurationProperties(PinterestProperties.class)
	@ConditionalOnWebApplication
	protected static class PinterestConfigurerAdapter extends SocialConfigurerAdapter {

		@Autowired
		private PinterestProperties properties;

		@Bean
		@ConditionalOnMissingBean(Pinterest.class)
		@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
		public Pinterest pinterest(ConnectionRepository repository) {
			Connection<Pinterest> connection = repository
					.findPrimaryConnection(Pinterest.class);
			return connection != null ? connection.getApi() : null;
		}

		@Bean(name = { "connect/pinterestConnect", "connect/pinterestConnected" })
		@ConditionalOnProperty(prefix = "spring.social", name = "auto-connection-views")
		public GenericConnectionStatusView pinterestConnectView() {
			return new GenericConnectionStatusView("pinterest", "Pinterest");
		}

		@Override
		public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
				Environment environment) {
			configurer.addConnectionFactory(createConnectionFactory());
		}

		private ConnectionFactory<?> createConnectionFactory() {
			return new PinterestConnectionFactory(this.properties.getAppId(),
					this.properties.getAppSecret());
		}

	}

}
