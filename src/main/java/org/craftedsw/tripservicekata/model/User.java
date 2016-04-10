package org.craftedsw.tripservicekata.model;

import java.util.ArrayList;
import java.util.List;

public class User {

  private String userID;
  private List<Trip> trips = new ArrayList<Trip>();
  private List<User> friends = new ArrayList<User>();

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public List<Trip> getTrips() {
    return trips;
  }

  public void setTrips(List<Trip> trips) {
    this.trips = trips;
  }

  public List<User> getFriends() {
    return friends;
  }


  public void setFriends(List<User> friends) {
    this.friends = friends;
  }

  public void addFriend(User user) {
    friends.add(user);
  }

  public void addTrip(Trip trip) {
    trips.add(trip);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((userID == null) ? 0 : userID.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (userID == null) {
      if (other.userID != null)
        return false;
    } else if (!userID.equals(other.userID))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "User [userID=" + userID + ", trips=" + trips + ", friends=" + friends + "]";
  }

}
