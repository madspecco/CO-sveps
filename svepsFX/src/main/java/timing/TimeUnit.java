package timing;

public enum TimeUnit
{

    NANO, MICRO, MILLI, SEC;

    /**
     * Converts time given in nanoseconds to another time unit
     * @param time Time in nanoseconds
     * @param unit Unit to convert to
     * @return Time expressed in given unit
     */
    public static double toTimeUnit(long time, TimeUnit unit)
    {

        switch (unit)
        {
            case NANO:
                return time;
            case MICRO:
                return time/1000.0;
            case MILLI:
                return time/1000000.0;
            case SEC:
                return time/1000000000.0;
            default:
                return time;
        }
    }
}

