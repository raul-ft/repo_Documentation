package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * The class Atmosphere creates an atmosphere with al its parameters being capable of set new values for the parameters.
 */
public class Atmosphere {
    // Constants for error messages
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    /**
     * this constructor creates an atmosphere with this parameters:
     * @param composition the composition of the new atmosphere
     * @param lastObservation the date of the last observation of the atmosphere
     * @param airQuality the grade of the air quality of the atmosphere
     * @param pressure  the pressure of the atmosphere
     * @param density the density of the atmosphere
     * @param hasClouds tells if it has clouds in the atmosphere
     */
    // Constructor
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    /**
     * sets a new composition
     * @param composition the new composition
     * @throws IllegalArgumentException throws an exception if the composition is null or if its empty or if its different to a letters or numbers
     */
    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new IllegalArgumentException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    /**
     * sets a new last observation
     * @param lastObservation the new date
     * @throws  IllegalArgumentException throws an exception if the date is null or if the new date is after the local date at the moment
     */
    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    /**
     * sets a new air quality
     * @param airQuality the new air quality
     * if the air quality is lower than 0, it sets to 0, if air quality is higher than 100, it sets to 100.
     */
    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     * sets a new pressure
     * @param pressure the new pressure
     * @throws IllegalArgumentException if the pressure is lower than 0.
     */
    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new IllegalArgumentException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }

    /**
     * sets a new density
     * @param density the new density
     * @throws IllegalArgumentException if the density is lower than 0
     * */
    public void setDensity(double density) {
        if (density < 0) {
            throw new IllegalArgumentException(INVALID_DENSITY);
        }
        this.density = density;
    }

    /**
     * this method returns a boolean if the atmosphere has clouds or not
     * @return a boolean to see if the atmosphere has clouds
     */
    public boolean hasClouds() {
        return hasClouds;
    }

    /**
     * sets a new value for hasClouds()
     * @param hasClouds the new value
     */
    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
