package com.rzx.ssm.mapper;

import com.rzx.ssm.entity.ClasssKey;
import com.rzx.ssm.entity.User;

public interface ClasssMapper {
    int deleteByPrimaryKey(ClasssKey key);

    int insert(ClasssKey record);

    int insertSelective(ClasssKey record);
    
    ClasssKey selectClasssByClasssName(String classsName);
    
 
}