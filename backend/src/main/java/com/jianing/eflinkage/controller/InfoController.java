package com.jianing.eflinkage.controller;

import com.jianing.eflinkage.pojo.PageBean;
import com.jianing.eflinkage.pojo.Result;
import com.jianing.eflinkage.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/info")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10000") Integer pageSize,
                       Integer id, LocalDate contactDate, String mobileId, String wechatName, String gameName, String gameId, Integer daysLogged) {
        //调用service分页查询
        PageBean pageBean = infoService.page(page, pageSize, id, contactDate, mobileId, wechatName, gameName, gameId, daysLogged);
        return Result.success(pageBean);
    }
}
