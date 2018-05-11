package app.model;

public class Weather {

    private String cityName;
    private int degrees;

    public Weather() {
    }

    public Weather(String cityName, int degrees) {
        this.cityName = cityName;
        this.degrees = degrees;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }
}
