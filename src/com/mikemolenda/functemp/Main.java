package com.mikemolenda.functemp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<CityWeather> weather = new ArrayList<>();

        weather.add(new CityWeather("Chicago", 41.8781, -87.6298, new int[]{32, 34, 43, 55, 65, 75, 81, 79, 73, 61, 47, 36}));
        weather.add(new CityWeather("New York", 40.69, -74.0, new int[]{39, 42, 50, 60, 71, 79, 85, 83, 76, 65, 54, 44}));
        weather.add(new CityWeather("Los Angeles", 25.7905, -80.3163, new int[]{67, 67, 67, 69, 70, 73, 77, 79, 78, 75, 71, 67}));
        weather.add(new CityWeather("Miami", 41.881832, -87.623177, new int[]{76, 78, 80, 83, 87, 89, 91, 91, 89, 86, 82, 78}));
        weather.add(new CityWeather("Anchorage", 61.169, -150.028, new int[]{23, 27, 34, 44, 56, 63, 65, 64, 55, 40, 28, 25}));

        System.out.println(sumArray(0, weather.get(0).getAvgHighTemps()));
        System.out.println(avgArray(weather.get(0).getAvgHighTemps()));
    }

    /* Recursively calculate the sum of the elements of an array */
    private static int sumArray(int currentTotal, int[] arr) {
        // Add first int of array to running total
        currentTotal += arr[0];

        // Remove first int of array
        int[] remain = Arrays.copyOfRange(arr, 1, arr.length);

        // If any elements left in array, recursively call function
        if (remain.length > 0) {
            return sumArray(currentTotal, remain);
        } else {
            return currentTotal;
        }

    }


    private static double avgArray(int[] arr) {
        return (double) sumArray(0, arr) / (arr.length - 1);
    }

}
