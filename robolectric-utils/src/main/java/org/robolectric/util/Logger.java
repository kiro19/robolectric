package org.robolectric.util;

/**
 * Logger for Robolectric. For now, it simply prints messages to stdout.
 *
 * <p>
 * Logging can be enabled by setting the property: {@code robolectric.logging.enabled = true}.
 * </p>
 */
public class Logger {
  private static final String LOGGING_ENABLED = "robolectric.logging.enabled";

  public static void strict(String message, Throwable e) {
    if (loggingEnabled()) {
      System.out.print("WARNING: ");
      System.out.println(message);
      e.printStackTrace();
    }
  }

  public static void strict(String message, Object... args) {
    if (loggingEnabled()) {
      System.out.print("WARNING: ");
      System.out.println(String.format(message, args));
    }
  }

  /**
   * Log an info message.
   *
   * @param message Message text.
   * @param args    Message arguments.
   */
  public static void info(String message, Object... args) {
    if (loggingEnabled()) {
      System.out.print("INFO: ");
      System.out.println(String.format(message, args));
    }
  }

  /**
   * Log an error message.
   *
   * @param message Message text.
   * @param args    Message arguments.
   */
  public static void error(String message, Object... args) {
    System.err.print("ERROR: ");
    System.err.println(String.format(message, args));
  }

  /**
   * Log a debug message.
   *
   * @param message Message text.
   * @param args    Message arguments.
   */
  public static void debug(String message, Object... args) {
    if (loggingEnabled()) {
      System.out.print("DEBUG: ");
      System.out.println(String.format(message, args));
    }
  }

  private static boolean loggingEnabled() {
    return Boolean.getBoolean(LOGGING_ENABLED);
  }
}
