class Track {
    private String shape;
    private int laneCount;
    private int length;
    private String weatherCondition;

    public Track(String shape, int laneCount, int length, String weatherCondition) {
        this.shape = shape;
        this.laneCount = laneCount;
        this.length = length;
        this.weatherCondition = weatherCondition;
    }

    // Getters for track properties
    public String getShape() {
        return shape;
    }

    public int getLaneCount() {
        return laneCount;
    }

    public int getLength() {
        return length;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }
}
