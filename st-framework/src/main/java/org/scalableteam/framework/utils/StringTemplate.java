package org.scalableteam.framework.utils;

import java.util.ArrayList;

/**
 * Simple string template util using params index to replacing
 *
 * @author abomb4 2020-09-28 14:07:22
 */
public class StringTemplate {

    private static final String DEFAULT_PREFIX = "{";
    private static final String DEFAULT_SUFFIX = "}";
    private static final TemplateConfig DEFAULT_CONFIG = TemplateConfig.builder().build();
    private static final int MAX_NUM_LENGTH = 5;

    /**
     * Simple string template replacing function, replace {num} to params[num].
     * <p>
     * eg:
     * <pre>
     * // name1 hit name2, but name2 eviaed.
     * StringTemplate.str("{0} hit {1}, but {1} eviaed.", "name1", "name2");
     * </pre>
     *
     * @param template String template
     * @param params   Params for replacing
     * @return replaced string
     */
    public static String str(String template, Object... params) {
        return str(template, DEFAULT_CONFIG, params);
    }

    /**
     * Simple string template replacing function, replace {num} to params[num].
     *
     * @param template String template
     * @param config   You can customize prefix and suffix,
     *                 default prefix and suffix is {@link #DEFAULT_PREFIX} and {@link #DEFAULT_SUFFIX}
     * @param params   Params for replacing
     * @return replaced string
     */
    public static String str(String template, TemplateConfig config, Object... params) {
        if (template == null || "".equals(template)) {
            return template;
        }

        int paramLength = 0;
        final ArrayList<String> strings = new ArrayList<>(params.length);
        for (Object param : params) {
            final String s = param == null ? "null" : param.toString();
            strings.add(s);
            paramLength += s.length();
        }
        // try think each input params only appears once
        final StringBuilder sb = new StringBuilder(template.length() + paramLength);
        final String prefix = config.getPrefix();
        final String suffix = config.getSuffix();

        final char[] chars = template.toCharArray();

        // parse context
        ParseState state = ParseState.PREFIX;
        int tempMatchCount = 0;
        StringBuilder tempNum = new StringBuilder(MAX_NUM_LENGTH);
        StringBuilder tempBuffer = new StringBuilder(MAX_NUM_LENGTH + prefix.length() + suffix.length());

        // parse
        for (int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            switch (state) {
                case PREFIX:
                    if (prefix.charAt(0) == c) {
                        if (prefix.length() == 1) {
                            state = ParseState.NUM;
                        } else {
                            state = ParseState.PREFIX_MORE;
                            tempMatchCount = 1;
                        }
                        tempBuffer.append(c);
                    } else {
                        sb.append(c);
                    }
                    break;
                case PREFIX_MORE:
                    if (prefix.charAt(tempMatchCount) == c) {
                        // matched
                        tempMatchCount++;
                        if (tempMatchCount == prefix.length()) {
                            // prefix match success
                            tempMatchCount = 0;
                            state = ParseState.NUM;
                        }
                        tempBuffer.append(c);
                    } else {
                        // Prefix match failed, return to 'start' + 1
                        sb.append(tempBuffer.charAt(0));
                        tempMatchCount = 0;
                        state = ParseState.PREFIX;
                        i -= tempBuffer.length();
                        tempBuffer.setLength(0);
                    }
                    break;
                case NUM:
                    // Must be pure number
                    if (Character.isDigit(c)) {
                        tempMatchCount = 1;
                        tempNum.append(c);
                        tempBuffer.append(c);
                        state = ParseState.NUM_OR_SUFFIX;
                    } else {
                        // Not num, match failed
                        sb.append(tempBuffer.charAt(0));
                        tempMatchCount = 0;
                        state = ParseState.PREFIX;
                        i -= tempBuffer.length();
                        tempBuffer.setLength(0);
                    }
                    break;
                case NUM_OR_SUFFIX:
                    // Pure number or match suffix
                    if (Character.isDigit(c)) {
                        tempMatchCount++;
                        tempNum.append(c);
                        tempBuffer.append(c);
                        state = ParseState.NUM_OR_SUFFIX;
                    } else if (suffix.charAt(0) == c) {
                        // match suffix
                        if (suffix.length() == 1) {
                            // All match, try replace with param
                            String text = tempBuffer.toString() + c;
                            if (tempNum.length() <= MAX_NUM_LENGTH) {
                                final int number = Integer.parseInt(tempNum.toString());
                                if (number < strings.size()) {
                                    text = strings.get(number);
                                }
                            }
                            sb.append(text);
                            tempMatchCount = 0;
                            tempNum.setLength(0);
                            tempBuffer.setLength(0);
                            state = ParseState.PREFIX;
                        } else {
                            // Continues match suffix
                            state = ParseState.PREFIX_MORE;
                            tempMatchCount = 1;
                            tempBuffer.append(c);
                        }
                    } else {
                        // Not num, not suffix, match failed
                        sb.append(tempBuffer.charAt(0));
                        tempMatchCount = 0;
                        state = ParseState.PREFIX;
                        i -= tempBuffer.length();
                        tempBuffer.setLength(0);
                    }
                    break;
                case SUFFIX_MORE:
                    if (suffix.charAt(tempMatchCount) == c) {
                        // matched
                        tempMatchCount++;
                        if (tempMatchCount == suffix.length()) {
                            // suffix match success, try replace with param
                            String text = tempBuffer.toString() + c;
                            if (tempNum.length() <= MAX_NUM_LENGTH) {
                                final int number = Integer.parseInt(tempNum.toString());
                                if (number < strings.size()) {
                                    text = strings.get(number);
                                }
                            }
                            sb.append(text);
                            tempMatchCount = 0;
                            tempNum.setLength(0);
                            tempBuffer.setLength(0);
                            state = ParseState.PREFIX;
                        }
                    } else {
                        // Suffix match failed
                        sb.append(tempBuffer.charAt(0));
                        tempMatchCount = 0;
                        state = ParseState.PREFIX;
                        i -= tempBuffer.length();
                        tempNum.setLength(0);
                        tempBuffer.setLength(0);
                    }
                    break;
                default: {
                    throw new IllegalStateException("Unkonwn TemplateUtil bug");
                }
            }
        }

        return sb.toString();
    }

    private enum ParseState {
        PREFIX, PREFIX_MORE, NUM, NUM_OR_SUFFIX, SUFFIX_MORE
    }

    public static class TemplateConfig {
        private final String prefix;
        private final String suffix;

        public static TemplateConfigBuilder builder() {
            return new TemplateConfigBuilder();
        }

        public TemplateConfig(String prefix, String suffix) {
            if (prefix == null || "".equals(prefix)) {
                throw new IllegalArgumentException("prefix cannot be null or empty");
            }
            if (suffix == null || "".equals(suffix)) {
                throw new IllegalArgumentException("suffix cannot be null or empty");
            }
            if (Character.isDigit(suffix.charAt(0))) {
                throw new IllegalArgumentException("suffix cannot starts with a number");
            }
            this.prefix = prefix;
            this.suffix = suffix;
        }

        public String getSuffix() {
            return suffix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    public static class TemplateConfigBuilder {
        private String prefix = DEFAULT_PREFIX;
        private String suffix = DEFAULT_SUFFIX;

        public TemplateConfig build() {
            return new TemplateConfig(prefix, suffix);
        }

        public String getPrefix() {
            return prefix;
        }

        public TemplateConfigBuilder setPrefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public String getSuffix() {
            return suffix;
        }

        public TemplateConfigBuilder setSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }
    }
}
