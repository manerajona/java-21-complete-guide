package com.manerajona.java.programming.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMethods {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.showSeatsAndPrices();
        System.out.println();
        theatre.showReversedSeats();
        System.out.println();
        theatre.showSeatsByPrice();
       /* System.out.println();
        theatre.showShuffleSeats();
        System.out.println();
        theatre.showMaxSeat();
        theatre.showMinSeat();*/
    }

    public static class Theatre {
        private final String theatreName;
        private List<Seat> seats = new ArrayList<>();

        public Theatre(String theatreName, int numRows, int seatsPerRow) {
            this.theatreName = theatreName;
            int lastRow = 'A' + (numRows - 1);
            for (var row = 'A'; row <= lastRow; row++) {
                for (var seatNum = 1; seatNum <= seatsPerRow; seatNum++) {

                    double price = (row > 'D') ? 14 : 12;
                    String seatNumber = row + String.format("%02d", seatNum);

                    seats.add(new Seat(seatNumber, price));
                }
            }
        }

        public boolean reserveSeat(String seatNumber) {
            Seat requestSeat = new Seat(seatNumber, 0);
            int foundSeat = Collections.binarySearch(seats, requestSeat, null);
            return (foundSeat >= 0 ? seats.get(foundSeat).reserved : false);
        }

        public void showSeatsAndPrices() {
            seats.forEach(seat -> System.out.printf("%s (%.2f $) - ", seat.getSeatNumber(), seat.getPrice()));
        }

        public void showSeatsByPrice() {
            List<Seat> seatCopy = new ArrayList<>(this.seats); // This is not a deep copy of each object
            Collections.sort(seats, Comparator.comparingDouble(Seat::getPrice)); // This implements COMPARATOR
            seatCopy.forEach(seat ->  System.out.printf("%s (%.2f $) - ", seat.getSeatNumber(), seat.getPrice()));
        }

        public void showReversedSeats() {
            List<Seat> seatCopy = new ArrayList<>(this.seats); // This is not a deep copy of each object
            Collections.reverse(seatCopy);
            seatCopy.forEach(seat ->  System.out.printf("%s (%.2f $) - ", seat.getSeatNumber(), seat.getPrice()));
        }

        public void showShuffleSeats() {
            List<Seat> seatCopy = new ArrayList<>(this.seats); // This is not a deep copy of each object
            Collections.shuffle(seatCopy);
            seatCopy.forEach(seat -> System.out.printf("%s - ", seat.getSeatNumber()));
        }

        public void showMinSeat() {
            System.out.println("Min:" + Collections.min(seats).getSeatNumber());
        }

        public void showMaxSeat() {
            System.out.println("Max:" + Collections.max(seats).getSeatNumber());
        }

        private static class Seat implements Comparable<Seat> {
            private final String seatNumber;
            private double price;
            private boolean reserved = false;

            public Seat(String seatNumber, double price) {
                this.seatNumber = seatNumber;
                this.price = price;
            }

            public String getSeatNumber() {
                return seatNumber;
            }

            public double getPrice() {
                return price;
            }

            private boolean setReserved(boolean reserved) {
                if (!this.reserved) {
                    this.reserved = reserved;
                    return true;
                } else {
                    return false;
                }
            }

            public boolean reserve() {
                return setReserved(true);
            }

            public boolean cancel() {
                return setReserved(false);
            }

            @Override
            public int compareTo(Seat seat) {
                return (this.seatNumber.compareTo(seat.getSeatNumber()));
            }
        }
    }
}
