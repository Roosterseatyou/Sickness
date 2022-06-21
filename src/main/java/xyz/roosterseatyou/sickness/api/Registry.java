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
