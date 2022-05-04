package bench;

public interface IBenchmark {
    /**
     * Called to explicitly initialize benchmark data.
     * This call should not be benchmarked.
     *
     * @param size -> size of the data to be initialized
     */
    public void initialize(int size);

    /**
     * Starts the actual benchmarking, optionally after initialize was called
     * Benchmarked call.
     */
    public void run();

    /**
     * Starts the actual benchmarking, optionally after initialize was called
     * Benchmarked call.
     */

    /**
     * Starts the actual benchmarking, optionally after initialize was called
     * Benchmarked call.
     *
     * @param options -> May pass a benchmark option defined by the benchmark class
     *               itself
     */
    public void run(Object options);

    /**
     * Called right before running the algorithm itself to "warm-up" the task at
     * hand. <br>
     * The warm up should do the exact task as the run method, however it should not
     * be timed. <br>
     * The amount of warm-up data/time should be between 10-100% of the total time.
     * <br>
     * This call should not be benchmarked.
     */
    public void warmUp();

    /**
     * @param option -> option
     */
    public void warmUp(Object option);


    /**
     * Stops a benchmark during execution. <br>
     * Should be checked in the main for-loop, or main thread of the benchmark.
     */
    public void cancel();

    /**
     * Called to explicitly release allocated data. <br>
     * This call should not be benchmarked.
     */
    public void clean();

    /**
     * Return the result of the benchmark. <br>
     * This call should not be benchmarked.
     * @return str
     */
    public String getResult();
}
