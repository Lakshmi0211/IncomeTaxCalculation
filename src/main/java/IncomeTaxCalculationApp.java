import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.poc.incometax"})
public class IncomeTaxCalculationApp {
	public static void main(String[] args) {
		SpringApplication.run(IncomeTaxCalculationApp.class, args);
	}
}
