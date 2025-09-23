package javaTopics.lambda;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
    List<Hotel> hotels;
    HotelService() {
        hotels = new ArrayList<>();
        hotels.add(new Hotel(10000,"Raddison Blu",HotelType.FIVE_STAR));
        hotels.add(new Hotel(4000,"Raddison Green",HotelType.FIVE_STAR));
        hotels.add(new Hotel(2000,"Krishna Cottage",HotelType.TWO_STAR));
        hotels.add(new Hotel(6000,"Tuli International",HotelType.FOUR_STAR));
    }

    public List<Hotel> filterBy5Star(){
        List<Hotel> filtered = new ArrayList<>();
        for(Hotel h: hotels){
            if (isHotel5Star(h)) filtered.add(h);
        }
        return filtered;
    }
    public  boolean isHotel5Star(Hotel h){
        return h.getType()==HotelType.FIVE_STAR;
    }
//    the filter function is similar, its just that the filter function is different
    public  List<Hotel> filterByCostPerNightBelow(int price){
        List<Hotel> filtered = new ArrayList<>();
        for(Hotel h: hotels){
            if (isHotelCostLessThan(h,price)) filtered.add(h);
        }
        return filtered;
    }
    public  boolean isHotelCostLessThan(Hotel h, int price){
        return h.getCostPerNight()<price;
    }
//    Modified to use interface
    public  List<Hotel> filterHotels(FilteringCondition condition){
        List<Hotel> filtered = new ArrayList<>();
        for(Hotel h: hotels){
            if (condition.filter(h)) filtered.add(h);
        }
        return filtered;
    }
}
