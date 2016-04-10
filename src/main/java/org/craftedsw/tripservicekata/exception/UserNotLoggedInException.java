package org.craftedsw.tripservicekata.exception;

public class UserNotLoggedInException extends Exception {

  private static final long serialVersionUID = -7961657614805117243L;

  public UserNotLoggedInException() {}

  public UserNotLoggedInException(String message) {
    super(message);
  }

  public UserNotLoggedInException(Throwable cause) {
    super(cause);
  }

  public UserNotLoggedInException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserNotLoggedInException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
