package me_4vr.menuapp.controller;

import me_4vr.menuapp.entity.Menu;
import me_4vr.menuapp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired MenuService svc;

  @GetMapping(value = "/")
  List<Menu> getMainMenu() {
    return svc.getMainMenu();
  }

  @GetMapping(value = "/{menuId}")
  List<Menu> getChildMenu(@PathVariable String menuId) {
    return svc.getSubMenu(Long.parseLong(menuId));
  }

  @PostMapping(value = "/")
  Long saveNewMenu(@RequestBody Menu menu) {
    menu = svc.saveMenu(menu);
    return menu.getId();
  }
}
