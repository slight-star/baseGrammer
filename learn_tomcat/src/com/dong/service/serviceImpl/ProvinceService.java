package com.dong.service;

import com.dong.domain.Province;

import java.util.List;

/**
 * @author dfx
 */
public interface ProvinceService {
    public abstract List<Province> findProvince();
    public abstract String findAllJson();
}
