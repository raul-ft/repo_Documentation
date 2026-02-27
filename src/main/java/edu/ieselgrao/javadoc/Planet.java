package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * @author raul
 * this class creates a planet.
 */
public class Planet {
    // Constants for error messages
    public static final String INVALID_NAME = "[ERROR] Name cannot be null or empty";
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;
    /**
     * @param MIN_MASS the minimum mass
     * @param MIN_RADIUS the minimum radius
     */
    // Attributes
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    private PlanetType type;

    /**
     * This constructor creates a planet with this parameters
     * @param name the name of the planet
     * @param numberOfMoons The number of moons of the planet
     * @param mass the mass of the planet
     * @param radius the radius of the planet
     * @param gravity the gravity of the planet
     * @param lastAlbedoMeasurement the last albedo measurement of the planet
     * @param hasRings if the planet has rings or not
     * @param type the type of the planet type
     */

    // Basic constructor
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }

    /**
     * this constructor creates a planet but with the same parameters and try to set an atmosphere too.
     @param name the name of the planet
      * @param numberOfMoons The number of moons of the planet
     * @param mass the mass of the planet
     * @param radius the radius of the planet
     * @param gravity the gravity of the planet
     * @param lastAlbedoMeasurement the last albedo measurement of the planet
     * @param hasRings if the planet has rings or not
     * @param type the type of the planet type
     *  @param composition the composition of the new atmosphere
     * @param lastObservation the date of the last observation of the atmosphere
     * @param airQuality the grade of the air quality of the atmosphere
     * @param pressure  the pressure of the atmosphere
     * @param density the density of the atmosphere
     * @param hasClouds tells if it has clouds in the atmosphere
     * @throws IllegalArgumentException if the atmosphere is null.
     */

    // Detailed constructor with atmosphere
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (IllegalArgumentException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    /**
     * sets a new name
     * @param name the new name
     * @throws IllegalArgumentException if the new name is null or is empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     * sets a new number of moons
     * @param numberOfMoons the new value
     * @throws IllegalArgumentException if the new number is lower than zero
     */
    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    /**
     * sets a new mass for the planet
     * @param mass the new mass for the planet
     * @throws IllegalArgumentException if the mas is lower than the MIN_MASS
     */
    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new IllegalArgumentException(INVALID_MASS);
        }
        this.mass = mass;
    }
    public double getRadius() {
        return radius;
    }

    /**
     * sets a new radius for the planet
     * @param radius the new radius
     * @throws IllegalArgumentException if the radius is lower than the MIN_RADIUS
     */
    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }
    public double getGravity() {
        return gravity;
    }

    /**
     * sets a new gravity
     * @param gravity the new gravity
     * @throws IllegalArgumentException if the gravity is lower or equal to 0
     */
    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new IllegalArgumentException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }
    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    /**
     * sets a new last albedo measurement
     * @param lastAlbedoMeasurement the new value
     * @throws IllegalArgumentException if the value is null or if the date is after the current date
     */
    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        // last albedo measurement is allowed to be today (LocalDate.now())
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }
    public boolean hasRings() {
        return hasRings;
    }

    /**
     * sets a new value for the rings
     * @param hasRings the new value
     */
    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     * sets an atmosphere to the planet
     * @param composition the new composition
     * @param lastObservation the new observation
     * @param airQuality the new air quality
     * @param pressure the new pressure
     * @param density the new density
     * @param hasClouds the new clouds
     */
    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        // Can propagate IllegalArgumentException
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }

    /**
     * sets a new type to the planet
     * @param type the new type
     * @throws  IllegalArgumentException if the type is null
     */
    public void setType(PlanetType type) {
        if (type == null) {
            throw new IllegalArgumentException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }





}
