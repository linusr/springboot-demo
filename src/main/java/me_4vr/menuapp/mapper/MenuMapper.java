package me_4vr.menuapp.mapper;

import me_4vr.menuapp.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuMapper {

//  @Select("SELECT * FROM TBL_MENU m where m.prnt_id is null")
  List<Menu> getAllMainMenu();

  Menu findMenuById(@Param("id") int id);
}
