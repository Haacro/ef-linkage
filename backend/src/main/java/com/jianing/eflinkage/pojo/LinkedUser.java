package com.jianing.eflinkage.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedUser {

    private Integer id;
    private LocalDate contactDate;
    private String mobileId;
    private String wechatName;
    private String gameName;
    private String gameId;
    private Integer daysLogged;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}