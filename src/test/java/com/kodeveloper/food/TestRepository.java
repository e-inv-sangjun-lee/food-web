package com.kodeveloper.food;

import com.kodeveloper.food.web.sample.Customer;
import com.kodeveloper.food.web.sample.ReactiveCustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestRepository {

    @Autowired
    private ReactiveCustomerRepository repo;
    @Autowired
    private ReactiveCustomerRepository reactiveRepo;

    @Test
    void shouldCreateAPerson() {
        Customer customer = new Customer("first", "last");

        Flux.just(repo, reactiveRepo)
                .subscribe( r -> {
                    Customer saved = r.save(customer).block();

                    assertThat(saved.getId()).isNotNull();
                    assertThat(saved.getFirstName()).isEqualTo("first");
                    assertThat(saved.getLastName()).isEqualTo("last");
                });
    }
}
