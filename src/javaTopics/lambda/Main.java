package javaTopics.lambda;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//https://www.youtube.com/watch?v=0ada8fAMpVs
public class Main {
    public static void main(String[] args) {
        HotelService service = new HotelService();
//        using old methods, creating new methods for each filtering option
        System.out.println("Five star hotels "+service.filterBy5Star());
        System.out.println("Hotels less than 10000 per night "+service.filterByCostPerNightBelow(10000));
        int price=4000;
//        implementing Filtering condition interface by creating new anonymous class
        FilteringCondition  filterlessThanAPrice= new FilteringCondition() {
            @Override
            public boolean filter(Hotel hotel) {
                return hotel.getCostPerNight()<=price;
            }
        };
//        passing the filtering condition to the function of hotel service that accepts
        List<Hotel> hotelsLessThanAPrice = service.filterHotels(filterlessThanAPrice);
        System.out.println("Hotels less than 4001 "+hotelsLessThanAPrice);
//        or using anonymous inner class
        List<Hotel> fourStarHotels = service.filterHotels(new FilteringCondition() {
            @Override
            public boolean filter(Hotel hotel) {
                return hotel.getType()==HotelType.FOUR_STAR;
            }
        });
        System.out.println("Four star hotels "+fourStarHotels);
//        or
        List<Hotel> twoStarHotels = service.filterHotels((hotel)->{ return hotel.getType()==HotelType.TWO_STAR;});
//        can remove (_) param bracket if only on param in function
//        also remove the return statement and {_} if you only have one line of code
        List<Hotel> threeStarHotels = service.filterHotels(hotel -> hotel.getType()==HotelType.THREE_STAR);

////        comparator
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        Collections.sort methods takes a collection and a comparator as parameter
        Collections.sort(list,(a,b)->b-a);
        System.out.println(list);
        // above or below, list.sort takes comparator as a param
        list.sort((a,b)->a-b);
        System.out.println(list);

        //// thread
//        implementing a runnable as javaTopics.lambda.lambda
//         storing javaTopics.lambda.lambda in a reference
        Runnable counting= ()-> {
            for (int i = 1; i <=10; i++) {
                try{
                    Thread.sleep(500);
                    System.out.println(i);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        };
        Thread t = new Thread(counting);
        Thread t2 = new Thread(counting);
        t.start();
        t2.start();
    }
}
