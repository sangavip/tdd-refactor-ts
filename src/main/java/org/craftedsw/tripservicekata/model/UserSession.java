package org.craftedsw.tripservicekata.model;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSession {

  private static final UserSession userSession = new UserSession();

  private UserSession() {
    // TODO: Singleton pattern should be taken care by the underlying (DI) framework like spring.
  }

  public static UserSession getInstance() {
    return userSession;
  }

  public User getLoggedUser() throws CollaboratorCallException {
    throw new CollaboratorCallException("UserSession.getLoggedUser() should not be called in an unit test");
  }

}
