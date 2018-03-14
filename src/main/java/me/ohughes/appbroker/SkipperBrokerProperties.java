package me.ohughes.appbroker;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public class SkipperBrokerProperties {
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
