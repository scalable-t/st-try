package org.scalableteam.framework.standards;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Standard
 *
 * @author abomb4 2020-08-02 01:45:07
 */
public interface StandardDateFormat {
    /** {@link ZonedDateTime} is required for this pattern */
    String ZONED_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss Z";
    /** {@link ZonedDateTime} is required for this formatter */
    DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(ZONED_DATE_TIME_PATTERN);

    /** Time only */
    String TIME_PATTERN = "HH:mm:ss";
    /** Time only */
    DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
}
