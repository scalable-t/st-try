package com.st.bench.mybatis;

import com.st.bench.mybatis.mapper.DemoTablePlusMapper;
import com.st.bench.mybatis.po.DemoTable;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author abomb4 2022-04-12
 */
@State(Scope.Benchmark)
public class MyBatisPlusBenchmark {

    ThreadLocal<DemoTable> instance = ThreadLocal.withInitial(() -> {
        DemoTable t = new DemoTable();
        t.setName(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setEmail(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setAddress(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setRemark(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setStatus("I");
        t.setAge(RandomUtils.nextInt(10, 60));
        t.setExt1(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt2(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt3(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt4(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt5(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt6(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt7(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt8(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt9(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt10(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt11(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt12(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt13(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt14(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt15(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt16(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt17(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt18(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt19(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt20(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt21(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt22(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt23(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt24(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt25(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt26(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt27(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt28(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt29(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt30(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt31(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt32(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt33(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt34(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt35(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt36(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt37(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt38(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt39(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt40(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt41(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt42(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt43(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt44(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt45(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt46(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt47(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt48(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt49(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setExt50(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setCreatorId(RandomUtils.nextLong(1, 12312311));
        t.setUpdaterId(RandomUtils.nextLong(1, 12312311));
        return t;
    });

    SpringContext springContext;

    DemoTablePlusMapper mapper;

    final AtomicLong lll = new AtomicLong(0);

    @Setup
    public void init() {
        springContext = SpringContext.getInstance();
        mapper = springContext.getBean(DemoTablePlusMapper.class);
        mapper.truncate();
    }

    @Benchmark
    @Threads(-1)
    @Measurement(iterations = 2, time = 60)
    @Warmup(iterations = 1, time = 20)
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void insert() {
        // Do nothing
        DemoTable t = instance.get();
        t.setName(RandomStringUtils.randomAlphanumeric(10, 30));
        t.setId(lll.incrementAndGet());
        mapper.insert(t);
    }
}
