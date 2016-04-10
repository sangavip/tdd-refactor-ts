package org.craftedsw.tripservicekata.service;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.dao.TripDAO;
import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;
import org.craftedsw.tripservicekata.model.UserSession;

public class TripService {

  /**
   * 
   * @param user
   * @return
   * @throws UserNotLoggedInException
   * @throws CollaboratorCallException
   * @should _return_trip_when_user_logged_in
   */
  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException, CollaboratorCallException {
    List<Trip> tripList = new ArrayList<Trip>();
    User loggedUser = UserSession.getInstance().getLoggedUser();
    boolean isFriend = false;
    if (loggedUser != null) {
      for (User friend : user.getFriends()) {
        if (friend.equals(loggedUser)) {
          isFriend = true;
          break;
        }
      }
      if (isFriend) {
        tripList = TripDAO.findTripsByUser(user);
      }
      return tripList;
    } else {
      throw new UserNotLoggedInException();
    }
  }

}
