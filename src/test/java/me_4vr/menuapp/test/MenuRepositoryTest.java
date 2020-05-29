package me_4vr.menuapp.test;

import me_4vr.menuapp.BaseTest;
import me_4vr.menuapp.entity.Menu;
import me_4vr.menuapp.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;

public class MenuRepositoryTest extends BaseTest {

  Logger logger = LoggerFactory.getLogger(MenuRepositoryTest.class);

  @Autowired MenuRepository repo;

  @Test
  void testNewMenu() {
    Menu m = new Menu();
    m.setName("M#100");
    m.setSequence(100);
    repo.save(m);
    logger.info(m.toString());
    assertThat(m.getId(), any(Long.class));
  }
}
