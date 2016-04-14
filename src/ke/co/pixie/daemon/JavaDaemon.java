package ke.co.pixie.daemon;

import java.util.logging.Level;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

import ke.co.pixie.daemon.logging.DaemonLogger;

/**
 * <p>Java UNIX daemon template.</p>
 * <p>Title: JavaDaemon.java</p>
 * <p>Description: This class implements the following methods to enable the
 * Java Daemon:<br /><br />
 * <ul>
 * <li>void init(String[] arguments): Here open configuration files, create a
 * trace file, create ServerSockets, Threads, etc</li>
 * <li>void start(): Start the Thread, accept incoming connections, etc</li>
 * <li>void stop(): Inform the Thread to terminate the run(), close the
 * ServerSockets, db connections, etc</li>
 * <li>void destroy(): Destroy any object created in init()</li>
 * </ul>
 * </p>
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
public final class JavaDaemon implements Daemon, Runnable {
    /**
     * The worker thread that does all the work.
     */
    private transient Thread worker;
    /**
     * Flag to check if the worker thread should run.
     */
    private transient boolean working = false;

    /**
     * Used to configuration files, create a trace file, create ServerSockets,
     * Threads, etc.
     *
     * @param context the DaemonContext
     *
     * @throws DaemonInitException on error
     */
    @Override
    public void init(final DaemonContext context) throws DaemonInitException {
        worker = new Thread(this);
        DaemonLogger.log(Level.INFO, "Initializing daemon...");
    }

    /**
     * Starts the daemon.
     */
    @Override
    public void start() {
        working = true;
        worker.start();
        DaemonLogger.log(Level.INFO, "Starting daemon...");
    }

    /**
     * Stops the daemon. Informs the thread to terminate the run().
     */
    @Override
    public void stop() {
        working = false;
        DaemonLogger.log(Level.INFO, "Stopping daemon...");
    }

    /**
     * Destroys the daemon. Destroys any object created in init().
     */
    @Override
    public void destroy() {
        DaemonLogger.log(Level.INFO, "Destroying daemon...");
    }

    /**
     * Runs the thread. The application runs inside an "infinite" loop.
     */
    @Override
    @SuppressWarnings({"SleepWhileHoldingLock", "SleepWhileInLoop"})
    public void run() {
        int i = 0;
        while (working) {
            try {
                DaemonLogger.log(Level.SEVERE, "Test: " + i);
                i++;
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                DaemonLogger.log(Level.SEVERE, ex.getMessage());
            }
        }
    }
}
