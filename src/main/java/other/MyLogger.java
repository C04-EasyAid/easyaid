package other;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *  Classe Singleton MyLogger.
 *
 * @author Giovanni Toriello
 */
public class MyLogger {
  private static MyLogger instance = null;
  private static String logName = "Logger:";
  protected static final Logger log = Logger.getLogger(MyLogger.logName);

  private MyLogger() {
    super();
  }

  public static MyLogger getInstance() {
    if (instance == null) {
      instance = new MyLogger();
      BasicConfigurator.configure();
      log.setLevel(Level.ALL);
    }
    return instance;
  }

  public void info(String myclass, String msg) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    String ora = dtf.format(LocalDateTime.now());
    String data = String.valueOf(LocalDate.now());
    log.info("[" + data + " " + ora + "]" + "[" + myclass + "] " + msg);
  }

  public void error(String myclass, String msg, Exception ce) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    String ora = dtf.format(LocalDateTime.now());
    String data = String.valueOf(LocalDate.now());
    log.error("[" + data + " " + ora + "]" + "[" + myclass + "] " + msg, ce);
  }
}
