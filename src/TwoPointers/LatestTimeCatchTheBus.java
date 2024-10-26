package src.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatestTimeCatchTheBus {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int arrivalIndex = 0;
        List<List<Integer>> occupied = new ArrayList<>();

        for(int departTime : buses){
            List<Integer> persons = new ArrayList<>();
            int j = capacity;
            for(int i = arrivalIndex; j > 0 && i < passengers.length ; i++, j--){
                if(passengers[i] <= departTime){
                    persons.add(passengers[i]);
                    arrivalIndex++;
                }else{
                    break;
                }
            }
            occupied.add(persons);
        }
        int arriveAt = -1;
        List<Integer> persons = occupied.get(occupied.size() - 1);
        if(persons.size() == capacity){
            arriveAt = persons.get(capacity - 1) - 1;
            arrivalIndex--;
        }else{
            arriveAt = buses[buses.length - 1];
        }

        // Just check if you are overlapping with prior person
        for(int i = arrivalIndex - 1; i >= 0; i--){
            if(passengers[i] == arriveAt) arriveAt--;
            else if(passengers[i] != arriveAt){
                break;
            }
        }

        return arriveAt;
    }
}
