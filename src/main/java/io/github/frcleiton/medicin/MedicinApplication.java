package io.github.frcleiton.medicin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicinApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner run(@Autowired final MedicamentoRepository repository) {
//		return new CommandLineRunner() {
//			public void run(String... args) throws Exception {
//				Medicamento med = new Medicamento();
//				med.setDescricao("Cimegripe cápsula");
//				
//				repository.save(med);
//				
//				
//			}
//		};
//	}

}
