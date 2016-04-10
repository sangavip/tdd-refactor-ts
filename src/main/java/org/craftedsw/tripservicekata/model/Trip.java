package org.craftedsw.tripservicekata.model;

public class Trip {
  private String tripID;

  public String getTripID() {
    return tripID;
  }

  public void setTripID(String tripID) {
    this.tripID = tripID;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((tripID == null) ? 0 : tripID.hashCode());
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
    Trip other = (Trip) obj;
    if (tripID == null) {
      if (other.tripID != null)
        return false;
    } else if (!tripID.equals(other.tripID))
      return false;
    return true;
  }

}
