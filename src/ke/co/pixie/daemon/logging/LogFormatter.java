package ke.co.pixie.daemon.logging;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * <p>Log file formatter.</p>
 * <p>Title: JavaDaemon.java</p>
 * <p>Description: Formats log files</p>
 * <p>Created on 16 August 2010, 23:48</p>
 * <p>Copyright: Copyright (c) 2012,
 * <a href="mailto:brian@pixie.co.ke">Brian Ngure</a></p>
 * <hr />
 * <i>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 * </i>
 * <p>&nbsp;</p>
 * <i>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * </i>
 * <p>&nbsp;</p>
 * <i>
 * You should have received a copy of the GNU General Public License along with
 * this library; if not, see <http://www.gnu.org/licenses/>.
 * </i>
 * <hr />
 * @since 1.0
 * @author <a href="brian@pixie.co.ke">Brian Ngure</a>
 * @version Version 1.0
 */
@SuppressWarnings({ "ClassWithoutLogger", "FinalClass" })
public final class LogFormatter extends Formatter {
    /**
     * Date format for log files.
     */
    private final transient SimpleDateFormat df
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor.
     */
    public LogFormatter() {
        super();
    }

    /**
     * The log file formatter.
     *
     * @param rec the log record
     *
     * @return the formatted log string
     */
    @Override
    public String format(final LogRecord rec) {
        long logTime = rec.getMillis();
        Date logDate = new Date(logTime);
        String dateTime = df.format(logDate);

        StringBuilder buf = new StringBuilder(30);
        buf.append(dateTime);
        buf.append("\t");
        buf.append(rec.getLevel().getName());
        buf.append("\t");
        buf.append(formatMessage(rec));
        buf.append("\n");

        return buf.toString();
    }
}
