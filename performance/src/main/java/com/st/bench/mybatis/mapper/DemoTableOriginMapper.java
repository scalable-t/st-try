package com.st.bench.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.bench.mybatis.po.DemoTable;
import com.st.bench.mybatis.po.DemoTableQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author abomb4 2022-04-12
 */
@Mapper
public interface DemoTableOriginMapper {

    int insert(DemoTable po);

    int updateById(DemoTable update);

    List<DemoTable> queryList(DemoTableQuery query, int offset, int limit);

    long queryCount(DemoTableQuery query);

    void truncate();
}
