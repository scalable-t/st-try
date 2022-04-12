package com.st.bench.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.bench.mybatis.po.DemoTable;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author abomb4 2022-04-12
 */
@Mapper
public interface DemoTablePlusMapper extends BaseMapper<DemoTable> {

    void truncate();
}
