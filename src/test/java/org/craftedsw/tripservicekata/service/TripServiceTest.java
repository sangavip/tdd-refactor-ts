package org.craftedsw.tripservicekata.service;


import org.craftedsw.tripservicekata.model.User;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TripServiceTest {
  /**
   * @see TripService#getTripsByUser(User)
   * @verifies _return_empty_trip_when_user_logged_in_no_friends
   */
  @Test
  public void getTripsByUser_should_return_empty_trip_when_user_logged_in_no_friends() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(getLoggedTestUserNoFriends());
    when(tripService.getTripsByUser(new User())).thenCallRealMethod();
    Assert.assertEquals(0, tripService.getTripsByUser(new User()).size());
  }

  public User getLoggedTestUserNoFriends() {
    User user = new User();
    user.setUserID("logged_in_user_001");
    return user;
  }

  public User getLoggedTestUserWithFriends() {
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

  /**
   * @see TripService#getTripsByUser(User)
   * @verifies _return_empty_trip_when_user_logged_in_has_friends_no_trips
   */
  @Test
  public void getTripsByUser_should_return_empty_trip_when_user_logged_in_has_friends_no_trips() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(getLoggedTestUserNoFriends());
    when(tripService.getTripsByUser(getLoggedTestUserWithFriends())).thenCallRealMethod();
    tripService.getTripsByUser(getLoggedTestUserWithFriends());
    Assert.assertEquals(0, tripService.getTripsByUser(getLoggedTestUserWithFriends()).size());
  }

}
