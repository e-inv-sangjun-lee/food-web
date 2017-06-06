package com.kodeveloper.food;

import com.kodeveloper.food.web.sample.ReactiveCustomerRepository;
import com.kodeveloper.food.web.sample.SampleController;
import com.kodeveloper.food.web.sample.SampleMongoDBController;
import com.kodeveloper.food.web.sample.SampleReactiveMongoDBController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestController {

    @Autowired
    private ReactiveCustomerRepository repo;
    @Autowired
    private ReactiveCustomerRepository reactiveRepo;

    @Test
    void contextLoads() {
    }

    @Test
    void testSampleController() {
        client(SampleController::new).get().uri("/").exchange()
                .expectStatus().isOk()
                .expectBody().consumeAsStringWith( response -> {
                        assertThat(response).contains("<html>");
                        assertThat(response).contains("Hello World!");
                        assertThat(response).contains("</html>");
                });
    }

    @Test
    void testSampleMongoDBController() {
        client(repo, SampleMongoDBController::new).get().uri("/mongo/save/").exchange()
                .expectStatus().isOk()
                .expectBody().consumeAsStringWith( response -> {
                        assertThat(response).contains("kodeveloper");
                });
    }

    @Test
    void testSampleReactiveMongoDBController() {
        client(reactiveRepo, SampleReactiveMongoDBController::new).get().uri("/reactivemongo/save/").exchange()
                .expectStatus().isOk()
                .expectBody().consumeAsStringWith( response -> {
                        assertThat(response).contains("reactive kodeveloper");
                });
    }

    private <T> WebTestClient client(Supplier<T> supplier) {
        return WebTestClient.bindToController(supplier.get()).build();
    }

    private <T1, T2> WebTestClient client(T1 t1, Function<T1, T2> factory) {
        return client(() -> factory.apply(t1));
    }
}
