package com.prisc.summer_screen.view;

public class ViewUtil {

    public static boolean validateSerieName(String serie){
        return serie != null && !serie.isEmpty() && !serie.isBlank();
    }

    public static int validateUserOption(String userOption, int min, int max){
        int userOptionInt = -1;

        try {
          userOptionInt = Integer.parseInt(userOption);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (userOptionInt >= min && userOptionInt <= max){
            return userOptionInt;
        } else {
            return -1;
        }
    }

}
