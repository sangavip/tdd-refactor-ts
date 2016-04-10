package org.craftedsw.tripservicekata.service;


import org.craftedsw.tripservicekata.model.User;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TripServiceTest {
  /**
  * @see TripService#getTripsByUser(User)
  * @verifies _return_trip_when_user_logged_in
  */
  @Test
  public void getTripsByUser_should_return_trip_when_user_logged_in() throws Exception {
    TripService tripService = mock(TripService.class);
    when(tripService.getLoggedInUser()).thenReturn(new User());
    
    tripService.getTripsByUser(new User());
  }
  
  // TODO: TEST INCOMPLETE
  public User getTestUser(){
    User user = new User();
    return user;
  }
}