package me_4vr.menuapp.test;

import me_4vr.menuapp.BaseTest;
import me_4vr.menuapp.HSQLDBConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class MenuControllerTests extends BaseTest {

  @Test
  void testMainMenu(@Autowired MockMvc mvc) throws Exception {
    mvc.perform(get("/menu/"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andDo(MockMvcResultHandlers.print()); // .andExpect(content().string("Hello World"));
  }
}
