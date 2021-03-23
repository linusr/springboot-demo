package me_4vr.menuapp.service;

import me_4vr.menuapp.common.NotFoundException;
import me_4vr.menuapp.entity.Menu;
import me_4vr.menuapp.mapper.MenuMapper;
import me_4vr.menuapp.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class MenuService {

  private final MenuRepository repo;
  private final MenuMapper mapper;
  Logger logger = LoggerFactory.getLogger(MenuService.class);

  public MenuService(MenuRepository repo, MenuMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  private Optional<List<Menu>> getValidMenus(List<Menu> menus) {
    var resList =
        menus.stream()
            .filter((it) -> !it.getUrl().isEmpty())
            .peek((it) -> logger.info("Menu : {}", it))
            .collect(Collectors.toList());
    return resList.size() > 0 ? Optional.of(resList) : Optional.empty();
  }

  public List<Menu> getMainMenu() {
    CompletableFuture<Optional<List<Menu>>> future =
        CompletableFuture.supplyAsync(mapper::getAllMainMenu).thenApply(this::getValidMenus);
    Optional<List<Menu>> menus = Optional.empty();
    try {
      menus = future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return menus.orElseGet(List::of);
  }

  public List<Menu> getSubMenu(Long parentId) {
    return getValidMenus(repo.findAllChildMenu(parentId)).orElseThrow(NotFoundException::new);
  }

  public Menu saveMenu(Menu menu) {
    return repo.save(menu);
  }
}
