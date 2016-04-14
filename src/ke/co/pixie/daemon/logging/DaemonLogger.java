package ke.co.pixie.daemon.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>Logger class for the Java Daemon..</p>
 * <p>Title: JavaDaemon.java</p>
 * <p>Description: Logger class for the Java Daemon</p>
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
@SuppressWarnings("FinalClass")
public final class DaemonLogger {
    /**
     * Logger for this application.
     */
    private static final Logger LOGGER
            = Logger.getLogger("ke.co.pixie.daemon.JavaDaemon");

    /**
     * Private constructor.
     */
    private DaemonLogger() {
    }

    /**
     * Logs the message with the specified level.
     *
     * @param level the log level
     * @param message the message to log
     */
    public static void log(final Level level, final String message) {
        LOGGER.log(level, message);
    }
}
