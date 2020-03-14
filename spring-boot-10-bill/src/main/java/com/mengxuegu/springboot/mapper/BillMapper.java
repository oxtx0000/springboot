package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.BillProvider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {

    List<BillProvider>getBills(Bill bill);
    BillProvider getBillByBid(Integer bid);
    int addBill(Bill bill);
    int updateBill(Bill bill);
    int deleteBillByBid(Integer bid);
}
