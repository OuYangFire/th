package com.ouyang.ssm.dao;

import com.ouyang.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    @Select("SELECT * FROM TRAVELLER WHERE id IN(SELECT TRAVELLERID FROM ORDER_TRAVELLER WHERE ORDERID=#{ordersId})")
    public List<Traveller>findByOrdersId(String ordersId);
}
