package com.jianing.eflinkage.mapper;

import com.jianing.eflinkage.pojo.LinkedUser;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface InfoMapper {
    public List<LinkedUser> list(Integer id, LocalDate contactDate, String mobileId, String wechatName, String gameName, String gameId, Integer daysLogged);
}
