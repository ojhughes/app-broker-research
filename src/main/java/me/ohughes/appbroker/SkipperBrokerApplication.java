package me.ohughes.appbroker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.deployer.spi.cloudfoundry.CloudFoundryDeployerAutoConfiguration;
import org.springframework.cloud.deployer.spi.local.LocalDeployerAutoConfiguration;

@SpringBootApplication(exclude = {
		CloudFoundryDeployerAutoConfiguration.class,
		LocalDeployerAutoConfiguration.class,
		ManagementWebSecurityAutoConfiguration.class,
		SecurityAutoConfiguration.class,
		SessionAutoConfiguration.class
})
@EnableConfigurationProperties(SkipperBrokerProperties.class)
public class SkipperBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkipperBrokerApplication.class, args);
	}
}
