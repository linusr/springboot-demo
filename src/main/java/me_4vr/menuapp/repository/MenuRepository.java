package me_4vr.menuapp.repository;

import me_4vr.menuapp.entity.Menu;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Query("select * from TBL_MENU m where m.prnt_id is null")
    List<Menu> getAllMainMenu();

    @Query("select * from TBL_MENU where prnt_id = :pId")
    List<Menu> findAllChildMenu(@Param("pId") Long parentId);
}
