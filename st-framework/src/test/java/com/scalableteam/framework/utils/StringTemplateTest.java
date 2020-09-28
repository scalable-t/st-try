package com.scalableteam.framework.utils;

import org.junit.Assert;
import org.junit.Test;
import org.scalableteam.framework.utils.StringTemplate;

import java.util.Arrays;

/**
 * @author abomb4 2020-09-28 15:25:57
 */
public class StringTemplateTest {

    @Test
    public void testStr() {
        Arrays.asList(
                new CaseDefault("aaa{0}bbb", new Object[]{"xxx"}, "aaaxxxbbb"),
                new CaseDefault("aaa{0}bbb", new Object[]{}, "aaa{0}bbb"),
                new CaseDefault("aaa{{0}bbb", new Object[]{"xxx"}, "aaa{xxxbbb"),
                new CaseDefault("aaa{{{0}bbb", new Object[]{"xxx"}, "aaa{{xxxbbb")
        ).forEach(CaseDefault::validate);
    }

    @Test
    public void testConfiguredStr() {
        Arrays.asList(
                new CaseConfig("aaa{{{0}bbb", "{{{", "}", new Object[]{"xxx"}, "aaaxxxbbb"),
                new CaseConfig("aaa{{{{1}bbb", "{{{", "}", new Object[]{"xxx", "fff"}, "aaa{fffbbb"),
                new CaseConfig("aaa10}111}1111}bbb", "1", "}", new Object[]{"xxx", "fff"}, "aaaxxx111}1111}bbb")
        ).forEach(CaseConfig::validate);
    }

    static class CaseDefault {
        final String template;
        final Object[] params;
        final String expected;

        public CaseDefault(String template, Object[] params, String expected) {
            this.template = template;
            this.params = params;
            this.expected = expected;
        }

        void validate() {
            Assert.assertEquals("Failed. Template: " + template + ", params: " + Arrays.deepToString(params), expected, StringTemplate.str(template, params));
        }
    }

    static class CaseConfig {
        final String template;
        final String prefix;
        final String suffix;
        final Object[] params;
        final String expected;

        public CaseConfig(String template, String prefix, String suffix, Object[] params, String expected) {
            this.template = template;
            this.prefix = prefix;
            this.suffix = suffix;
            this.params = params;
            this.expected = expected;
        }

        void validate() {
            final StringTemplate.TemplateConfig conf = StringTemplate.TemplateConfig.builder()
                    .setPrefix(this.prefix)
                    .setSuffix(this.suffix)
                    .build();
            Assert.assertEquals("Failed. Template: " + template + ", prefix: " + prefix + ", suffix: " + suffix + ", params: " + Arrays.deepToString(params),
                    expected, StringTemplate.str(template, conf, params));
        }
    }
}
