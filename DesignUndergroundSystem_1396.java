package LeetCode;

import java.util.*;

class Passenger {
    int checkInTime;
    int checkOutTime;
    String checkInStation;
    String checkOutStation;
    
    public Passenger(int checkInTime, String checkInStation) {
        this.checkInTime = checkInTime;
        this.checkInStation = checkInStation;
    }
    
    public void checkOut(int checkOutime, String checkOutStation) {
        this.checkOutTime = checkOutime;
        this.checkOutStation = checkOutStation;
    }
}

class Route {
    String startStation;
    String endStation;
    
    int totalNumberOfTrains;
    int totalTimeSpentInTrips;
    
    public Route(String startStation, String endStation) {
        this.startStation = startStation;
        this.endStation = endStation;
    }
    
    public double getAverageTime() {
        return (double) this.totalTimeSpentInTrips / this.totalNumberOfTrains;
    }
    
    public void addTrip(int startTime, int endTime) {
        this.totalNumberOfTrains += 1;
        this.totalTimeSpentInTrips += (endTime - startTime);
    }
}

public class DesignUndergroundSystem_1396 {
    
    Map<String, Route> routeMap;
    // key: startStation + "," + endStation
    // value: route
    
    Map<Integer, Passenger> passengerMap;
    // key: passenger ID
    // value: Passenger
    
    public DesignUndergroundSystem_1396() {
        this.routeMap = new HashMap<>();
        this.passengerMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        passengerMap.putIfAbsent(id, new Passenger(t, stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (this.passengerMap.containsKey(id)) {
            Passenger p = passengerMap.get(id);
            p.checkOut(t, stationName);
            
            routeMap.putIfAbsent(p.checkInStation + "," + p.checkOutStation,
                new Route(p.checkInStation, p.checkOutStation));
            Route route = routeMap.get(p.checkInStation + "," + p.checkOutStation);
            route.addTrip(p.checkInTime, p.checkOutTime);
            routeMap.put(p.checkInStation + "," + p.checkOutStation, route);
            
            passengerMap.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return this.routeMap.get(startStation + "," + endStation).getAverageTime();
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
