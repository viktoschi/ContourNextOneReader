package com.lady.viktoria.contournextonereader.services;

import java.util.HashMap;


public class GattAttributes {
    private static HashMap<String, String> attributes = new HashMap();
    public static String BG_MEASUREMENT = "00002a18-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static String BG_SERVICE = "00001808-0000-1000-8000-00805f9b34fb";

    static {
        // Services.
        attributes.put(BG_SERVICE, "BG Service");
        // Characteristics.
        attributes.put(BG_MEASUREMENT, "BG Measurement");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}