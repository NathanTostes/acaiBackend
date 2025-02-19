package com.acai.acaibackend;

import com.acai.acaibackend.model.Customer;
import com.acai.acaibackend.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer pacoca = new Customer("Nathan Tostes", "nathantostes@gmail.com",
                    LocalDate.of(2007, 4, 5));
            Customer leiteEmPo = new Customer("Maria Joana", "maju@gmail.com",
                    LocalDate.of(2000, 2, 20));

            repository.saveAll(
                    List.of(pacoca, leiteEmPo)
            );
        };
    }

}
