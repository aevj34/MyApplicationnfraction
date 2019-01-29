package com.example.myapplication.services;

import android.support.annotation.NonNull;

import com.example.myapplication.model.Infraction;
import com.example.myapplication.model.Plate;
import com.example.myapplication.model.PreventiveMeasure;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class PlateService {


    public Plate getPlate(String URL, String plateNumber){

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;

        Plate plate = new Plate();
        List<PreventiveMeasure> preventiveMeasures;
        List<Infraction> infractions;
        infractions = new ArrayList<Infraction>();
        preventiveMeasures = new ArrayList<PreventiveMeasure>();

        try {

            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+ "\n");
            }

            result = buffer.toString();
            JSONObject jObject = new JSONObject(result);

            plate.setSoatStart(jObject.getJSONObject("result").getJSONObject("soat").getString("start"));
            plate.setSoatEnd(jObject.getJSONObject("result").getJSONObject("soat").getString("end"));
            plate.setSoatState(jObject.getJSONObject("result").getJSONObject("soat").getString("message"));

            plate.setCitvStart(jObject.getJSONObject("result").getJSONObject("citv").getString("start"));
            plate.setCitvEnd(jObject.getJSONObject("result").getJSONObject("citv").getString("end"));
            plate.setCitvState(jObject.getJSONObject("result").getJSONObject("citv").getString("message"));

            JSONArray jsonArrayInfractions = jObject.getJSONObject("result").getJSONObject("infraction").getJSONArray("detail");

            for (int i = 0; i < jsonArrayInfractions.length(); i++) {

                JSONObject jsonObj = jsonArrayInfractions.getJSONObject(i);
                Infraction infraction = new Infraction();
                infraction.setTypeDenomination(jsonObj.getString("typeDenomination"));
                infractions.add(infraction);
            }
            plate.setInfractions(infractions);

            JSONArray jsonArraypreventiveMeasures = jObject.getJSONObject("result").getJSONObject("infraction").getJSONArray("preventiveMeasures");

            for (int i = 0; i < jsonArraypreventiveMeasures.length(); i++) {

                JSONObject jsonObj = jsonArraypreventiveMeasures.getJSONObject(i);
                PreventiveMeasure preventiveMeasure = new PreventiveMeasure();
                preventiveMeasure.setDenomination(jsonObj.getString("denomination"));
                preventiveMeasures.add(preventiveMeasure);
            }
            plate.setPreventiveMeasures(preventiveMeasures);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


}
