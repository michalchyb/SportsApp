package pl.project.commons;

import pl.project.models.weather.WeatherObject;

public class WeatherHelpers {

    public static final String PROPERTY = System.getProperty("line.separator");

    public static StringBuilder printWeatherForLocation(WeatherObject weatherObject) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current city : ")
                .append(weatherObject.getName())
                .append(PROPERTY)
                .append("Current temperature: ")
                .append(weatherObject.getMain().getTemp())
                .append(PROPERTY)
                .append("Min temperature: ")
                .append(weatherObject.getMain().getTempMin())
                .append(PROPERTY)
                .append("Max temperature: ")
                .append(weatherObject.getMain().getTempMin())
                .append(PROPERTY)
                .append("Humidity: ")
                .append(weatherObject.getMain().getHumidity())
                .append("%")
                .append(PROPERTY);

        return stringBuilder;
    }
}
