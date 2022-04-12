package com.st.bench.mybatis;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author abomb4 2022-04-12
 */
class SpringContextTest {

    @Test
    void getInstance() {

        SpringContext instance = SpringContext.getInstance();
        DataSource bean = instance.getBean(DataSource.class);
        assertNotNull(bean);
    }
}