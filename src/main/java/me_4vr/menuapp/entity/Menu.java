package me_4vr.menuapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Data
@AllArgsConstructor
@Table("TBL_MENU")
public class Menu {

    public Menu() {
        this.id = null;
        this.parentId = null;
    }

    @Id
    private Long id;
    @Column("PRNT_ID")
    private Long parentId;
    private String name;
    @Column("SEQ")
    private int sequence;
    private String url;
}
