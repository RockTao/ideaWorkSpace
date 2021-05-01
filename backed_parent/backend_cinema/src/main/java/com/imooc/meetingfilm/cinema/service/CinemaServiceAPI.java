package com.imooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.imooc.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.imooc.meetingfilm.utils.Exception.CommonServiceException;

public interface CinemaServiceAPI {

//    b保存影院的方法
    void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException;
//获取影院列表

    IPage<DescribeCinemaRespVO> describeCinemas(int nowPage,int pageSize)throws CommonServiceException ;

}
