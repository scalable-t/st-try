package com.st.bench.mybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusLanguageDriverAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 加载 spring
 *
 * @author abomb4 2022-04-12
 */
@Import({
        DataSourceAutoConfiguration.class,
        MybatisPlusLanguageDriverAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
})
@MapperScan("com.st.bench.mybatis.mapper")
public class SpringContext {

    private static final Object singleLock = new Object();

    private static SpringContext INSTANCE;

    public static SpringContext getInstance() {
        if (INSTANCE == null) {
            synchronized (singleLock) {
                if (INSTANCE == null) {
                    SpringContext instance = new SpringContext();
                    instance.init();
                    INSTANCE = instance;
                }
            }
        }
        return INSTANCE;
    }

    private ConfigurableApplicationContext applicationContext;

    private boolean init = false;

    /**
     * 加载 spring
     */
    private synchronized void init() {
        if (this.init) {
            return;
        }
        this.applicationContext = SpringApplication.run(this.getClass());
        this.init = true;
    }

    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
