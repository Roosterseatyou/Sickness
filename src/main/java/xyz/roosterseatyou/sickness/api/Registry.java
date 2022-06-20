package xyz.roosterseatyou.sickness.api;

import xyz.roosterseatyou.sickness.Sickness;

import java.util.ArrayList;

public class Registry {
    private static ArrayList<Illness> illnesses = Sickness.illnesses;

    public static void registerIllness(Illness illness) {
        illnesses.add(illness);
        updateRegistry();
    }

    public static void unregisterIllness(Illness illness) {
        illnesses.remove(illness);
        updateRegistry();
    }

    public static ArrayList<Illness> getIllnesses() {
        return illnesses;
    }

    public static Illness getIllness(String name) {
        for (Illness illness : illnesses) {
            if (illness.getName().equals(name)) {
                return illness;
            }
        }
        return null;
    }

    public static boolean isIllness(String name) {
        for (Illness illness : illnesses) {
            if (illness.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRegisteredIllness(Illness illness) {
        return illnesses.contains(illness);
    }

    public static void clearIllnesses() {
        illnesses.clear();
        updateRegistry();
    }

    public static void updateRegistry() {
        Sickness.illnesses = illnesses;
    }
}
