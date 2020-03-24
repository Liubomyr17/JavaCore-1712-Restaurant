package com.company;

/*

1712 Restaurant

1. Understand what the program does. The waiter for some reason does not take the prepared dishes back to the tables :(
2.Fix a mistake.
Hint: this is one line

Requirements:
1. The Restaurant class should contain a list of cooks and waiters (a public static field of threads of type List).
2. The Manager class must contain an order queue (private final orderQueue field of type Queue).
3. The Manager class must contain a queue with prepared dishes (private final field of dishesQueue of type Queue).
4. The Manager class must implement the Singleton pattern.
5. The Waiter class must implement the Runnable interface.
6. The Cook class must implement the Runnable interface.
7. If there are no ready meals in the queue, the Waiter class thread must receive an order from the table and add it to the order queue.
8. If there are ready meals in the queue, the Waiter class thread should take the dish from the queue and place the order for the table.
9. If there are no orders in the order queue, the Cook class thread should rest (the cook is resting).
10. If there are orders in the order queue, the Cook-class thread must prepare the dish and add it to the queue with ready-made dishes.


 */

/*

import java.util.ArrayList;
import java.util.List;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;




public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);
        threads.add(waiter);

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }


    public class Cook implements Runnable {
        public boolean continueWorking = true;

        @Override
        public void run() {
            boolean needToWait;
            while (continueWorking || needToCookOrders()) {
                try {
                    synchronized (this) {
                        needToWait = !needToCookOrders();
                        if (!needToWait) {
                            cooking();
                        }
                    }
                    if (continueWorking && needToWait) {
                        System.out.println("Повар отдыхает");
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                }
            }
        }

        private boolean needToCookOrders() {
            return !Manager.getInstance().getOrderQueue().isEmpty();
        }

        private void cooking() throws InterruptedException {
            Manager manager = Manager.getInstance();
            Order order = manager.getOrderQueue().poll();           // cook gets order from a queue
            System.out.println(String.format(
                    "Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
            Thread.sleep(order.getTime());                          // to cook dish
            Dishes dishes = new Dishes(order.getTableNumber());     // this is a cooked dish
            manager.getDishesQueue().add(dishes);                   // fix! add dish to dishes queue
            System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
        }
    }


    public class Dishes {
        private byte tableNumber;

        public Dishes(byte tableNumber) {
            this.tableNumber = tableNumber;
        }

        public byte getTableNumber() {
            return tableNumber;
        }
    }

    public class Manager {      //singleton
        private static Manager ourInstance = new Manager();

        private final List<Table> restaurantTables = new ArrayList<Table>(10);
        private int currentIndex = 0;

        private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();    // очередь с заказами
        private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();  // очередь с готовыми блюдами

        public synchronized static Manager getInstance() {
            return ourInstance;
        }

        private Manager() {               // создаем 10 столов
            for (int i = 0; i < 10; i++) {
                restaurantTables.add(new Table());
            }
        }

        public synchronized Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
            Table table = restaurantTables.get(currentIndex);
            currentIndex = (currentIndex + 1) % 10;
            return table;
        }

        public Queue<Order> getOrderQueue() {
            return orderQueue;
        }

        public Queue<Dishes> getDishesQueue() {
            return dishesQueue;
        }
    }


    public class Order {
        private long time;
        private byte tableNumber;

        public Order(byte tableNumber) {
            time = (long) (Math.random() * 200);
            this.tableNumber = tableNumber;
        }

        public long getTime() {
            return time;
        }

        public byte getTableNumber() {
            return tableNumber;
        }
    }


class Table {
        private static byte tableNumber;
        private byte number = ++tableNumber;

        public Order getOrder () {
            return new Order(number);
        }
    }}

*/

