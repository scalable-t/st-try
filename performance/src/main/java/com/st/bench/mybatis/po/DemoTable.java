package com.st.bench.mybatis.po;

import lombok.Data;

import java.time.LocalDateTime;

/*
create table demo_table (
    id bigint not null auto_increment,
    name varchar(64),
    email varchar(64),
    address varchar(255),
    remark varchar(255),
    status varchar(2),
    age int,
    ext1 varchar(255),
    ext2 varchar(255),
    ext3 varchar(255),
    ext4 varchar(255),
    ext5 varchar(255),
    ext6 varchar(255),
    ext7 varchar(255),
    ext8 varchar(255),
    ext9 varchar(255),
    ext10 varchar(255),
    ext11 varchar(255),
    ext12 varchar(255),
    ext13 varchar(255),
    ext14 varchar(255),
    ext15 varchar(255),
    ext16 varchar(255),
    ext17 varchar(255),
    ext18 varchar(255),
    ext19 varchar(255),
    ext20 varchar(255),
    ext21 varchar(255),
    ext22 varchar(255),
    ext23 varchar(255),
    ext24 varchar(255),
    ext25 varchar(255),
    ext26 varchar(255),
    ext27 varchar(255),
    ext28 varchar(255),
    ext29 varchar(255),
    ext30 varchar(255),
    ext31 varchar(255),
    ext32 varchar(255),
    ext33 varchar(255),
    ext34 varchar(255),
    ext35 varchar(255),
    ext36 varchar(255),
    ext37 varchar(255),
    ext38 varchar(255),
    ext39 varchar(255),
    ext40 varchar(255),
    ext41 varchar(255),
    ext42 varchar(255),
    ext43 varchar(255),
    ext44 varchar(255),
    ext45 varchar(255),
    ext46 varchar(255),
    ext47 varchar(255),
    ext48 varchar(255),
    ext49 varchar(255),
    ext50 varchar(255),
    creatorId bigint(32),
    updaterId bigint(32),
    createDatetime datetime not null DEFAULT CURRENT_TIMESTAMP,
    updateDatetime datetime not null DEFAULT CURRENT_TIMESTAMP,
    primary key (id)
);
 */

/**
 * @author abomb4 2022-04-12
 */
@Data
public class DemoTable {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String remark;

    private String status;
    private Integer age;

    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private String ext6;
    private String ext7;
    private String ext8;
    private String ext9;
    private String ext10;
    private String ext11;
    private String ext12;
    private String ext13;
    private String ext14;
    private String ext15;
    private String ext16;
    private String ext17;
    private String ext18;
    private String ext19;
    private String ext20;
    private String ext21;
    private String ext22;
    private String ext23;
    private String ext24;
    private String ext25;
    private String ext26;
    private String ext27;
    private String ext28;
    private String ext29;
    private String ext30;
    private String ext31;
    private String ext32;
    private String ext33;
    private String ext34;
    private String ext35;
    private String ext36;
    private String ext37;
    private String ext38;
    private String ext39;
    private String ext40;
    private String ext41;
    private String ext42;
    private String ext43;
    private String ext44;
    private String ext45;
    private String ext46;
    private String ext47;
    private String ext48;
    private String ext49;
    private String ext50;

    private Long creatorId;
    private Long updaterId;
    private LocalDateTime createDatetime;
    private LocalDateTime updateDatetime;

}
