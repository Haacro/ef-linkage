package com.jianing.eflinkage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jianing.eflinkage.mapper.InfoMapper;
import com.jianing.eflinkage.pojo.LinkedUser;
import com.jianing.eflinkage.pojo.PageBean;
import com.jianing.eflinkage.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, Integer id, LocalDate contactDate, String mobileId, String wechatName, String gameName, String gameId, Integer daysLogged) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);

        //执行查询
        List<LinkedUser> empList = infoMapper.list(id, contactDate, mobileId, wechatName, gameName, gameId, daysLogged);
        Page<LinkedUser> p = (Page<LinkedUser>) empList;

        //封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }
}
