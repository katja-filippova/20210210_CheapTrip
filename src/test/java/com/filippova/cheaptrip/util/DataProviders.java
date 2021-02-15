package com.filippova.cheaptrip.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> fillInTripFromTripsCSVFile() throws IOException {
        List<Object[]> tripList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(DataProviders.class.getResourceAsStream("/Trips.csv")));
        String line = bufferedReader.readLine();
        while (line != null) {
            tripList.add(line.split(","));
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return tripList.iterator();
    }

    @DataProvider
    public Iterator<Object[]> usingDBCityCSVFile() throws IOException {
        List<Object[]> tripList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(DataProviders.class.getResourceAsStream("/DBCity.csv")));
        String line = bufferedReader.readLine();
        while (line != null) {
            tripList.add(line.split(","));
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return tripList.iterator();
    }
}

