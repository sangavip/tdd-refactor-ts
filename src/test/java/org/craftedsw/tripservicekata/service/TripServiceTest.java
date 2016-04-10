package org.craftedsw.tripservicekata.service;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;
import org.junit.Assert;
import org.junit.Test;

public class TripServiceTest {
  /**
   * @see TripService#getTripsByUser(User)
   * @verifies _return_empty_trip_when_user_logged_in_no_friends
   */
  @Test
  public void getTripsByUser_should_return_empty_trip_when_user_logged_in_no_friends() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(getLoggedTestUserNoFriends());
    when(tripService.getTripsByUser(any(User.class))).thenCallRealMethod();
    Assert.assertEquals(0, tripService.getTripsByUser(new User()).size());
  }

  public User getLoggedTestUserNoFriends() {
    User user = new User();
    user.setUserID("logged_in_user_001");
    return user;
  }

  public User getLoggedTestUserWithFriendsNoTrips() {
    User user = new User();
    user.setUserID("friend_user_001");

    User friendUser1 = new User();
    friendUser1.setUserID("friend_user_002");
    User friendUser2 = new User();
    friendUser1.setUserID("logged_in_user_001");
    user.addFriend(friendUser1);
    user.addFriend(friendUser2);

    return user;
  }
  
  public User getLoggedTestUserWithFriendsWithTrips() {
    User user = new User();
    user.setUserID("friend_user_001");

    User friendUser1 = new User();
    friendUser1.setUserID("friend_user_002");
    User friendUser2 = new User();
    friendUser1.setUserID("logged_in_user_001");
    user.addFriend(friendUser1);
    user.addFriend(friendUser2);

    Trip trip1 = new Trip();
    Trip trip2 = new Trip();

    user.addTrip(trip1);
    user.addTrip(trip2);

    return user;
  }

  /**
   * @see TripService#getTripsByUser(User)
   * @verifies _return_empty_trip_when_user_logged_in_has_friends_no_trips
   */
  @Test
  public void getTripsByUser_should_return_empty_trip_when_user_logged_in_has_friends_no_trips() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(getLoggedTestUserNoFriends());
    when(tripService.getTripsByUser(any(User.class))).thenCallRealMethod();
    when(tripService.findTripsByUser(any(User.class))).thenReturn(getLoggedTestUserWithFriendsNoTrips().getTrips());
    
    tripService.getTripsByUser(getLoggedTestUserWithFriendsNoTrips());
    Assert.assertEquals(0, tripService.getTripsByUser(getLoggedTestUserWithFriendsNoTrips()).size());
  }

  /**
   * @see TripService#getTripsByUser(User)
   * @verifies _return_trip_list_when_user_logged_in_has_friends_with_trips
   */
  @Test
  public void getTripsByUser_should_return_trip_list_when_user_logged_in_has_friends_with_trips() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(getLoggedTestUserNoFriends());
    when(tripService.getTripsByUser(any(User.class))).thenCallRealMethod();
    when(tripService.findTripsByUser(any(User.class))).thenReturn(getLoggedTestUserWithFriendsWithTrips().getTrips());
    
    tripService.getTripsByUser(getLoggedTestUserWithFriendsWithTrips());
    Assert.assertEquals(2, tripService.getTripsByUser(getLoggedTestUserWithFriendsWithTrips()).size());
  }

  /**
   * @see TripService#getTripsByUser(User)
   * @verifies _throw_exception_when_user_not_logged_in
   */
  @Test(expected=UserNotLoggedInException.class)
  public void getTripsByUser_should_throw_exception_when_user_not_logged_in() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(null);
    when(tripService.getTripsByUser(any(User.class))).thenCallRealMethod();
    
    tripService.getTripsByUser(new User());
  }

}
