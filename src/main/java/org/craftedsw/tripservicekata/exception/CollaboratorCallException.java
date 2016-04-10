package org.craftedsw.tripservicekata.exception;

public class CollaboratorCallException extends Exception {

  private static final long serialVersionUID = -5939763630368725518L;

  public CollaboratorCallException() {}

  public CollaboratorCallException(String message) {
    super(message);
  }

  public CollaboratorCallException(Throwable cause) {
    super(cause);
  }

  public CollaboratorCallException(String message, Throwable cause) {
    super(message, cause);
  }

  public CollaboratorCallException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
