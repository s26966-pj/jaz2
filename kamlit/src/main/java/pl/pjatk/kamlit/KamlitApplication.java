package pl.pjatk.kamlit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class KamlitApplication {
	private final ConfigProperties configProperties;

	public KamlitApplication(ConfigProperties configProperties) {
		this.configProperties = configProperties;
		execProcess();
	}
	public static void main(String[] args) {
		SpringApplication.run(KamlitApplication.class, args);
	}

	public void execProcess() {
		configProperties.printProperties();
	}

}
