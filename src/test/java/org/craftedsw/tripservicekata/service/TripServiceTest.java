package org.craftedsw.tripservicekata.service;


import org.craftedsw.tripservicekata.model.User;
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
    
    tripService.getTripsByUser(new User());
  }

  public User getLoggedTestUserNoFriends() {
    User user = new User();
    user.setUserID("test_user_001");
    return user;
  }
}
