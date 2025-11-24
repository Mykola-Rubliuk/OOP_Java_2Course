package labsheet10.ex3;

class Thermometer {
    private int current_temp;
    private int max_temp;
    private int min_temp;

    public Thermometer() {
        this(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Thermometer(int current_temp) {
        this.current_temp = current_temp;
        this.max_temp = current_temp;
        this.min_temp = current_temp;
    }

    public Thermometer(int current_temp, int max_temp, int min_temp) {
        this.current_temp = current_temp;
        this.max_temp = max_temp;
        this.min_temp = min_temp;
    }

    public int getCurrent_temp() {
        return current_temp;
    }

    public void setCurrent_temp(int current_temp) {
        this.current_temp = current_temp;
    }

    public int getMax_temp() {
        return max_temp;
    }

    private void setMax_temp(int max_temp) {
        this.max_temp = max_temp;
    }

    public int getMin_temp() {
        return min_temp;
    }

    private void setMin_temp(int min_temp) {
        this.min_temp = min_temp;
    }

    public void setTemperature(int temp) {
        updateMaxMinTemp(temp);
    }

    private void updateMaxMinTemp(int newTemp) {
        this.current_temp = newTemp;
        if (newTemp > this.max_temp) {
            setMax_temp(newTemp);
        }
        if (newTemp < this.min_temp) {
            setMin_temp(newTemp);
        }
    }

    @Override
    public String toString() {
        return String.format("""
                Current temperature %s
                Maximum temperature %s
                Minimum temperature %s
                
                """, getCurrent_temp(), getMax_temp(), getMin_temp());
    }
}