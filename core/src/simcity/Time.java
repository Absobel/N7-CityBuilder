package simcity;

public class Time {

    private float debut;
    public int secondes_init = 8 * 60; // 8 min en secondes = 8h

    private float elapsed_time;

    public Time(float delta) {
        this.debut = delta;
    }

    public void updateTime(float delta) {
        this.elapsed_time += delta;
    }

    public float getTime() {
        float time_sec = secondes_init + (this.elapsed_time - this.debut);
        float total_min = (time_sec / 60) % 24;
        return total_min;
    }
}
