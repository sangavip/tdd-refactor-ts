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
   * @param friendUser
   * @return
   * @throws UserNotLoggedInException
   * @throws CollaboratorCallException
   * @should _return_empty_trip_when_user_logged_in_no_friends
   * @should _return_empty_trip_when_user_logged_in_has_friends_no_trips
   * @should _return_trip_list_when_user_logged_in_has_friends_with_trips
   * @should _throw_exception_when_user_not_logged_in
   */
  public List<Trip> getTripsByFriendOfLoggedInUser(User friendUser)
      throws UserNotLoggedInException, CollaboratorCallException {

    return findFriendsTrips(friendUser, getLoggedInUser());

  }

  private List<Trip> findFriendsTrips(User friendUser, User loggedInUser) throws CollaboratorCallException {
    List<Trip> tripList = new ArrayList<Trip>();
    for (User friend : friendUser.getFriends()) {
      if (friend.equals(loggedInUser)) {
        return findTripsByUserFromDAO(friendUser);
      }
    }
    return tripList;
  }

  protected List<Trip> findTripsByUserFromDAO(User user) throws CollaboratorCallException {
    TripDAO tripDAO = new TripDAO();
    return tripDAO.findTripsByUser(user);
  }

  protected User getLoggedInUser() throws CollaboratorCallException, UserNotLoggedInException {
    User loggedInUser = UserSession.getInstance().getLoggedUser();
    if (loggedInUser != null) {
      return loggedInUser;
    }
    throw new UserNotLoggedInException();
  }

}
