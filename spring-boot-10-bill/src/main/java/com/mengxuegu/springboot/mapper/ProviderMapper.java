package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProviderMapper {
    List<Provider>getProviders(Provider provider);
    Provider getProviderByPid(Integer pid);
    int addProvider(Provider provider);
    int updateProvider(Provider provider);
    int deleteProviderByPid(Integer pid);
}
