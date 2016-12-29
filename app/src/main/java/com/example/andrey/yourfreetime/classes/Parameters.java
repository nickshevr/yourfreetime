package com.example.andrey.yourfreetime.classes;

public class Parameters
{
private static String choosen_category;
    private static String choosen_type;
    public static String getChoosen_category() {
        return choosen_category;
    }

    public static void setChoosen_category(String choosen_category) {
        Parameters.choosen_category = choosen_category;
    }

    public static String getChoosen_type() {
        return choosen_type;
    }

    public static void setChoosen_type(String choosen_type) {
        Parameters.choosen_type = choosen_type;
    }
}
