package com.javarush.task.task14.task1416;

/* 
Стой, кто плывет?
*/

public class Solution {
    public static void main(String[] args) {
        CanSwim creature = new Orca();
        creature.swim();
        creature = new Whale();
        creature.swim();
        creature = new RiverOtter();
        creature.swim();
    }

    public static void test(CanSwim creature) {
        creature.swim();
    }

    interface CanWalk {
        void walk();
    }

    interface CanSwim {
        void swim();
    }

    static abstract class SeaCreature implements CanSwim {
        @Override
        public void swim() {
            SeaCreature currentCreature = (SeaCreature) getCurrentCreature();
            currentCreature.displaySwim();
        }

        private void displaySwim() {
            System.out.println(getCurrentCreature().getClass().getSimpleName() + " is swimming");
        }

        abstract CanSwim getCurrentCreature();
    }

    static class Orca extends SeaCreature {
        @Override
        public Orca getCurrentCreature() {
            return this;
        }
    }

    static class Whale extends SeaCreature {
        @Override
        public Whale getCurrentCreature() {
            return this;
        }
    }

    static class RiverOtter implements CanSwim, CanWalk {
        @Override
        public void swim() {
            RiverOtter riverOtter = new RiverOtter();
            riverOtter.displaySwim();
        }

        private void displaySwim() {
            System.out.println(getRiverOtter().getClass().getSimpleName() + " is swimming");
        }

        @Override
        public void walk() {
            RiverOtter riverOtter = new RiverOtter();
            riverOtter.displayWalk();
        }

        private void displayWalk() {
            System.out.println(getRiverOtter().getClass().getSimpleName() + " is walking");
        }

        public RiverOtter getRiverOtter() {
            return this;
        }
    }

}
