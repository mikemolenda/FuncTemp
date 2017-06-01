package com.mikemolenda.functemp;

import java.util.*;
import java.util.stream.DoubleStream;

/**
 * Creates a Map of city latitudes to their average annual temperatures.
 * Loosely follows the example in https://www.smashingmagazine.com/2014/07/dont-be-scared-of-functional-programming/
 */
public class Main {

    public static void main(String[] args) {

        List<CityWeather> weather = new ArrayList<>();

        weather.add(new CityWeather("Chicago", 41.8781, -87.6298, new int[]{32, 34, 43, 55, 65, 75, 81, 79, 73, 61, 47, 36}));
        weather.add(new CityWeather("Peoria", 40.69, -89.68, new int[]{33, 38, 50, 63, 73, 82, 86, 84, 77, 65, 50, 36}));
        weather.add(new CityWeather("New York", 40.69, -74.0, new int[]{39, 42, 50, 60, 71, 79, 85, 83, 76, 65, 54, 44}));
        weather.add(new CityWeather("Los Angeles", 25.7905, -80.3163, new int[]{67, 67, 67, 69, 70, 73, 77, 79, 78, 75, 71, 67}));
        weather.add(new CityWeather("Miami", 41.881832, -87.623177, new int[]{76, 78, 80, 83, 87, 89, 91, 91, 89, 86, 82, 78}));
        weather.add(new CityWeather("Anchorage", 61.169, -150.028, new int[]{23, 27, 34, 44, 56, 63, 65, 64, 55, 40, 28, 25}));

        // Transform weather list to stream of average annual temps
        DoubleStream avgAnnualTemp = weather.stream().map(CityWeather::getAvgHighTemps).mapToDouble(Main::avgArray);

        // Transform weather list to stream of latitudes
        DoubleStream latitudes = weather.stream().mapToDouble(CityWeather::getLatitude);

        // Map average annual temperatures to latitudes and print
        System.out.println("latitude=[average annual temperatures]");
        combine(latitudes.toArray(), avgAnnualTemp.toArray(), new HashMap<Double, List<Double>>()).entrySet().stream().forEach(System.out::println);

    }

    /* Calculates the sum of the elements of an array of ints */
    private static int sumArray(int[] arr) {
        // Use stream reduce to sum the elements of the array, with a reference to sum()
        return Arrays.stream(arr).reduce(0, Main::sum);
    }

    /* Calculate the average of the values in an array of ints */
    private static double avgArray(int[] arr) {
        return divide(sumArray(arr), (arr.length - 1));
    }

    /* Add two ints */
    private static int sum(int a, int b) {
        return a + b;
    }

    /* Divide the first int by the second */
    private static double divide(int a, int b) {
        return (double) a / b;
    }

    /* Map temperatures to latitudes */
    private static Map<Double, List<Double>> combine (double[] keys, double[] vals, Map<Double, List<Double>> mapped) {

        // Add head element of values to List mapped to keys
        if (mapped.containsKey(keys[0])) {
            mapped.get(keys[0]).add(vals[0]);
        } else {
            mapped.put(keys[0], new ArrayList<Double>(Arrays.asList(vals[0])));
        }

        // Recurse, with the first element of the arrays removed
        double[] keysRemain = Arrays.copyOfRange(keys, 1, keys.length);
        double[] valsRemain = Arrays.copyOfRange(vals, 1, vals.length);

        if (keysRemain.length > 0) {
            return combine(keysRemain, valsRemain, mapped);
        } else {
            return mapped;
        }

    }

}
