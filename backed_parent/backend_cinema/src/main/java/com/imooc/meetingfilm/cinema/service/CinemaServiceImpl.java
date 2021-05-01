package com.imooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.imooc.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.imooc.meetingfilm.cinema.dao.entity.MoocCinemaT;
import com.imooc.meetingfilm.cinema.dao.mapper.MoocCinemaTMapper;
import com.imooc.meetingfilm.utils.Exception.CommonServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements  CinemaServiceAPI {

    @Resource
    MoocCinemaTMapper moocCinemaTMapper;

    private static DescribeCinemaRespVO transform(MoocCinemaT cinema) {
        DescribeCinemaRespVO cinemaRespVO = new DescribeCinemaRespVO();
        cinemaRespVO.setBrandId(cinema.getBrandId().toString());
        cinemaRespVO.setAreaId(cinema.getAreaId().toString());
        cinemaRespVO.setHallTypeIds(cinema.getHallIds());
        cinemaRespVO.setCinemaName(cinema.getCinemaName());
        cinemaRespVO.setCinemaAddress(cinema.getCinemaAddress());
        cinemaRespVO.setCinemaTele(cinema.getCinemaPhone());
        cinemaRespVO.setCinemaImgAddress(cinema.getImgAddress());
        cinemaRespVO.setCinemaPrice(cinema.getMinimumPrice().toString());

        return cinemaRespVO;
    }

    @Override
    public void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException {
        MoocCinemaT moocCinemaT = new MoocCinemaT();
        moocCinemaT.setCinemaName(reqVO.getCinemaName());
        moocCinemaT.setCinemaPhone(reqVO.getCinemaTele());
        moocCinemaT.setBrandId(Integer.parseInt(reqVO.getBrandId()));
        moocCinemaT.setAreaId(Integer.parseInt(reqVO.getAreaId()));
        moocCinemaT.setHallIds(reqVO.getHallTypeIds());
        moocCinemaT.setImgAddress(reqVO.getCinemaImgAddress());
        moocCinemaT.setCinemaAddress(reqVO.getCinemaAddress());
        moocCinemaT.setMinimumPrice(Integer.valueOf(reqVO.getCinemaPrice()));
        moocCinemaTMapper.insert(moocCinemaT);

    }

    @Override
    public IPage<DescribeCinemaRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException {
// 查询实体对象，然后与表现层对象进行交互
        // TODO 提示
        Page<MoocCinemaT> page = new Page<>(nowPage, pageSize);
        IPage<MoocCinemaT> moocCinemaTIPage = moocCinemaTMapper.selectPage(page, null);

        List<DescribeCinemaRespVO> describeCinemaRespVOS = moocCinemaTIPage.getRecords().stream()
                .map(CinemaServiceImpl::transform).collect(Collectors.toList());

        IPage<DescribeCinemaRespVO> respVOIPage = new Page<>();

        BeanUtils.copyProperties(moocCinemaTIPage, respVOIPage);
        respVOIPage.setRecords(describeCinemaRespVOS);
        return respVOIPage;
    }
}
