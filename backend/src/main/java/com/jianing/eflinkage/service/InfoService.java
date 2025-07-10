package com.jianing.eflinkage.service;

import com.jianing.eflinkage.pojo.PageBean;

import java.time.LocalDate;

public interface InfoService {
    PageBean page(Integer page, Integer pageSize, Integer id, LocalDate contactDate, String mobileId, String wechatName, String gameName, String gameId, Integer daysLogged);
}
