package homework5;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Car car1 = new Car("AS45757");
        Car car2 = new Car("BD35444");
        Car car3 = new Car("CG64635");
        Truck truck1 = new Truck("E32557");
        Bus bus1 = new Bus("GG834883");

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);

        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
       /* executorService.execute(() ->fuelStation.enter(car1.transportNumber));
        executorService.execute(() ->fuelStation.enter(car2.transportNumber));
        executorService.execute(() ->fuelStation.enter(car3.transportNumber));
        executorService.execute(() ->fuelStation.enter(truck1.transportNumber));
        executorService.execute(() ->fuelStation.enter(bus1.transportNumber));*/


        executorService1.execute(() -> {
            try {
                car1.isTankEmpty();
                executorService.execute(() ->fuelStation.enter(car1.transportNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService1.execute(() -> {
            try {
                car3.isTankEmpty();
                executorService.execute(() ->fuelStation.enter(car3.transportNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService1.execute(() -> {
            try {
                car2.isTankEmpty();
                executorService.execute(() ->fuelStation.enter(car2.transportNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService1.execute(() -> {
            try {
                truck1.isTankEmpty();
                executorService.execute(() ->fuelStation.enter(truck1.transportNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService1.execute(() -> {
            try {
                bus1.isTankEmpty();
                executorService.execute(() ->fuelStation.enter(bus1.transportNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }
}

class FuelStation{
    private Semaphore semaphore;

    public FuelStation(){
        this(5);
    }
    public FuelStation(int permits){
        this.semaphore = new Semaphore(permits);
    }

    public void enter(String SPZ){
            try {
                System.out.println("Transport  " + SPZ + " is going to fuel");
                semaphore.acquire();
                System.out.println("Transport " + SPZ + " is fueling...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(SPZ + " is full! FuelStation released...");
            }
    }

}

class Transport {
    double maxVolume;
    double currentVolume;
    double rate;
    String transportNumber;

    public Transport(String transportNumber) {
        this.transportNumber = transportNumber;

    }

    double getMaxVolume(){
        return this.maxVolume;
    }

    double getRate(){
        return this.rate;
    }

    public void isTankEmpty() throws InterruptedException {
        currentVolume= getMaxVolume();
            while (currentVolume > 0) {
                this.currentVolume = currentVolume - getRate();
                  System.out.println(currentVolume);
                Thread.sleep(3000);
            }
            System.out.println("Tank of " + transportNumber + " is Empty! Need to fuel!");
    }

    public void tankIsFull(){
        currentVolume=getMaxVolume();
       // System.out.println(currentVolume);
    }

}

class Car extends Transport {
    public Car( String transportNumber) {
        super(transportNumber);
        this.maxVolume = 20;
        this.rate = 2.5;
    }
}

class Truck extends Transport {
    public Truck( String transportNumber) {
        super(transportNumber);
        this.maxVolume = 60;
        this.rate = 15;
    }
}

class Bus extends Transport {
    public Bus( String transportNumber) {
        super(transportNumber);
        this.maxVolume = 40;
        this.rate = 7.5;
    }
}
