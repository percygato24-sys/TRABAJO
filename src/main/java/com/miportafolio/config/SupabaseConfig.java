package com.miportafolio.config;

import java.io.InputStream;
import java.util.Properties;

public class SupabaseConfig {

    private static String supabaseUrl;
    private static String supabaseKey;

    static {
        try (InputStream input = SupabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                supabaseUrl = prop.getProperty("supabase.url");
                supabaseKey = prop.getProperty("supabase.key");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSupabaseUrl() {
        return supabaseUrl;
    }

    public static String getSupabaseKey() {
        return supabaseKey;
    }
}