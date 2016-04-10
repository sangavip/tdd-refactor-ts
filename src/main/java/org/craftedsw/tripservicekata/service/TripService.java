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
   * @should _return_empty_trip_when_user_logged_in_no_friends
   * @should _return_empty_trip_when_user_logged_in_has_friends_no_trips
   * @should _return_trip_list_when_user_logged_in_has_friends_with_trips
   */
  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException, CollaboratorCallException {
    System.out.println("inside getTripsByUser");
    List<Trip> tripList = new ArrayList<Trip>();
    User loggedUser = getLoggedInUser();
    System.out.println("got the loggedUser " + loggedUser.toString());
    boolean isFriend = false;
    System.out.println("isFriend = " + isFriend);
    if (loggedUser != null) {
      System.out.println("user.getFriends() = " + user.getFriends());
      for (User friend : user.getFriends()) {
        if (friend.equals(loggedUser)) {
          isFriend = true;
          break;
        }
      }
      System.out.println("isFriend = " + isFriend);
      if (isFriend) {
        tripList = findTripsByUser(user);
      }
      System.out.println("tripList = " + tripList);
      return tripList;
    } else {
      throw new UserNotLoggedInException();
    }
  }

  public List<Trip> findTripsByUser(User user) throws CollaboratorCallException {
    List<Trip> tripList;
    TripDAO tripDAO = new TripDAO();
    tripList = tripDAO.findTripsByUser(user);
    return tripList;
  }

  public User getLoggedInUser() throws CollaboratorCallException {
    return UserSession.getInstance().getLoggedUser();
  }

}
