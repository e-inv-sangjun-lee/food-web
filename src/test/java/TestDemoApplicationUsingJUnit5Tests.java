package com.kodeveloper.food;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestDemoApplicationUsingJUnit5Tests {

    @Test
    void contextLoads() {
    }
    private MockMvc mockMvc;

    @BeforeEach
    void setupMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TransitionController())
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name()))
                .build();
    }

    @Test
    void testRedirect() throws Exception {
        mockMvc.perform(get("/redirect/{id}", 1))
                .andExpect(
                        status().isFound()
                ).andExpect(
                redirectedUrl("/transition/redirect/{id}", 1) // ★★★ リダイレクト時のURL検証
        );
    }

    @Test
    void testForward() throws Exception {
        mockMvc.perform(get("/forward/{id}", 1))
                .andExpect(
                        status().isOk()
                ).andExpect(
                forwardedUrl("/transition/forward/{id}", 1) // ★★★ フォワード時のURL検証
        );
    }

    @Controller
    static class TransitionController {
        @GetMapping("/redirect/{id}")
        String redirect(@PathVariable int id) {
            return "redirect:/transition/redirect/{id}";
        }
        @GetMapping("/forward/{id}")
        String forward(@PathVariable int id) {
            return "forward:/transition/forward/" + id; // 個人的にこういうコードは基本的に書かないけど・・・（サンプルなので・・・）
        }
    }
}
