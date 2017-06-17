package com.niit.configuration;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
@ComponentScan(basePackages="com.niit")
public class WebSocketconfiguration implements WebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println("REGISTER STOME ENDPOINTS...");
		registry.addEndpoint("/portfolio").withSockJS();
	}
	public void configureMessageBroker(MessageBrokerRegistry  configurer) {
		System.out.println("CONFIGURE MESSAGE BROKER REGISTRY");
		configurer.enableSimpleBroker("/queue/", "/topic/");
		configurer.setApplicationDestinationPrefixes("/app");
	}
	public void configureClientInboundChannel(ChannelRegistration registration) {
		System.out.println("register sockt");
	}

	public void configureClientOutboundChannel(ChannelRegistration registration) {
		System.out.println("register outbound");
	}

	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
	
	}

	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		
		
	}

	public boolean configureMessageConverters(List<MessageConverter> arg0) {
		
		return true;
	}

	public void configureWebSocketTransport(WebSocketTransportRegistration arg0) {
		
	}


}

