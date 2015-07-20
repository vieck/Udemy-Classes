package com.michael.stealth.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Stealth on 7/11/2015.
 */
public class HelperFunctions {
    View rootview;
    Context context;
    String url;
    String country, description, main, name, icon;
    int id, sunrise, sunset, visibility;
    double speed, humidity, latitude, longitude, temperature, pressure, min_temp, max_temp;

    TextView txtCity, txtTemp, txtDescription, txtMinTemp, txtMaxTemp, txtWindSpeed, txtHumidity, txtPressure, txtVisibility, txtSunrise, txtSunset;
    ImageView imageCondition;

    public HelperFunctions(Context context, String url) {
        this.context = context;
        this.url = url;
        rootview = ((Activity) context).getWindow().getDecorView().getRootView();
        imageCondition = (ImageView) rootview.findViewById(R.id.condIcon);
        txtCity = (TextView) rootview.findViewById(R.id.cityText);
        txtTemp = (TextView) rootview.findViewById(R.id.temp);
        txtMinTemp =(TextView) rootview.findViewById(R.id.tempMin);
        txtMaxTemp = (TextView) rootview.findViewById(R.id.tempMax);
        txtDescription = (TextView) rootview.findViewById(R.id.descrWeather);
        txtWindSpeed = (TextView) rootview.findViewById(R.id.windSpeed);
        txtHumidity = (TextView) rootview.findViewById(R.id.hum);
        txtPressure = (TextView) rootview.findViewById(R.id.pressure);
        txtVisibility = (TextView) rootview.findViewById(R.id.visibility);
        txtSunrise = (TextView) rootview.findViewById(R.id.sunrise);
        txtSunset = (TextView) rootview.findViewById(R.id.sunset);
    }

    public JSONObject makeRequest() {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(this.url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String stream;
                while((stream = bufferedReader.readLine()) != null) {
                    builder.append(stream);
                }
                Log.d("JSON","JSON: "+builder.toString());
                return new JSONObject(builder.toString());
            }
        } catch (MalformedURLException e) {
            Log.e("JSON", e.getMessage());
        } catch (IOException e) {
            Log.e("JSON",e.getMessage());
        } catch (JSONException e) {
            Log.e("JSON",e.getMessage());
        }
        return null;
    }

    public boolean seperateJSON(JSONObject jsonObject) throws JSONException{
        if (jsonObject != null) {
            JSONObject coordinates = jsonObject.getJSONObject("coord");
            longitude = coordinates.getDouble("lon");
            latitude = coordinates.getDouble("lat");

            JSONObject sys = jsonObject.getJSONObject("sys");
            country = sys.getString("country");
            sunrise = sys.getInt("sunrise");
            sunset = sys.getInt("sunset");

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            if (weatherArray.length() > 0) {
                JSONObject weather = weatherArray.getJSONObject(0);
                id = weather.getInt("id");
                main = weather.getString("main");
                description = weather.getString("description");
                icon = weather.getString("icon");
            }

            JSONObject main = jsonObject.getJSONObject("main");
            temperature = main.getDouble("temp");
            min_temp = main.getDouble("temp_min");
            max_temp = main.getDouble("temp_max");
            pressure = main.getDouble("pressure");
            humidity = main.getDouble("humidity");

            JSONObject wind = jsonObject.getJSONObject("wind");
            speed = wind.getDouble("speed");

            visibility = jsonObject.getJSONObject("clouds").getInt("all");

            name = jsonObject.getString("name");
            return true;
        } else {
            return false;
        }
    }

    public void updateScreen() {
        id = id / 100;
        if (icon.contains("d")) {
            switch (id) {
                case 2:
                    imageCondition.setImageResource(R.drawable.thunderstorms);
                    break;
                case 3:
                    imageCondition.setImageResource(R.drawable.slight_drizzle);
                    break;
                case 5:
                    imageCondition.setImageResource(R.drawable.drizzle);
                    break;
                case 6:
                    imageCondition.setImageResource(R.drawable.snow);
                    break;
                case 7:
                    imageCondition.setImageResource(R.drawable.haze);
                    break;
                case 8:
                    imageCondition.setImageResource(R.drawable.sunny);
                    break;
            }
        } else {
            switch (id) {
                case 2:
                    imageCondition.setImageResource(R.drawable.night_thunderstorms);
                    break;
                case 3:
                    imageCondition.setImageResource(R.drawable.night_drizzle);
                    break;
                case 5:
                    imageCondition.setImageResource(R.drawable.night_drizzle);
                    break;
                case 6:
                    imageCondition.setImageResource(R.drawable.snow);
                    break;
                case 7:
                    imageCondition.setImageResource(R.drawable.night_cloudy);
                    break;
                case 8:
                    imageCondition.setImageResource(R.drawable.moon);
                    break;
            }
        }

        txtCity.setText(name);
        txtTemp.setText(temperature + "℉");
        txtDescription.setText(description);
        txtMinTemp.setText(min_temp +"℉");
        txtMaxTemp.setText(max_temp + "℉");
        txtWindSpeed.setText(speed + "mph");
        txtHumidity.setText(humidity + "%");
        txtPressure.setText(pressure + "° HPA");
        txtVisibility.setText(visibility+"%");
        long time = sunrise * (long) 1000;
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss a yyyy");
        format.setTimeZone(TimeZone.getTimeZone("EST"));
        txtSunrise.setText("" + format.format(date));

        time = sunset * (long) 1000;
        date = new Date(time);
        txtSunset.setText("" + format.format(date));
    }
}
