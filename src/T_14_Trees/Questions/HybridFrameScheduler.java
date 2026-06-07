package src.T_14_Trees.Questions;

class HybridFrameScheduler {
    private final Object syncLock = new Object();
    private boolean cpuReady = false;
    private boolean gpuReady = false;

    void startSimulation() {
        Thread cpuThread = new Thread(this::cpuTask, "CPU-Thread");
        Thread gpuThread = new Thread(this::gpuTask, "GPU-Thread");

        cpuThread.start();
        gpuThread.start();
    }

    void cpuTask() {
        while (true) {
            long start = System.currentTimeMillis();
            simulateLogicWork(); // Game logic, AI, physics
            synchronized (syncLock) {
                cpuReady = true;
                syncLock.notifyAll();
            }
            waitForGPU();
            adjustCPUFrequency(start);
        }
    }

    void gpuTask() {
        while (true) {
            synchronized (syncLock) {
                while (!cpuReady) {
                    try { syncLock.wait(); } catch (InterruptedException e) {}
                }
            }
            renderFrame(); // GPU rendering simulation
            gpuReady = true;
            cpuReady = false; // Prepare for next frame
        }
    }

    void waitForGPU() {
        while (!gpuReady) Thread.yield();
        gpuReady = false;
    }

    void simulateLogicWork() { busyWait(10); }  // Simulate CPU time
    void renderFrame() { busyWait(8); }         // Simulate GPU time

    void adjustCPUFrequency(long start) {
        long elapsed = System.currentTimeMillis() - start;
        if (elapsed > 16) System.out.println("Adjusting CPU priority...");
    }

    void busyWait(int ms) {
        long end = System.currentTimeMillis() + ms;
        while (System.currentTimeMillis() < end);
    }

    public static void main(String[] args) {
        new HybridFrameScheduler().startSimulation();
    }
}
