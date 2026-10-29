package com.adminski;

import java.util.List;

public class ErrorMessage {
    private static final List<String> MESSAGES = List.of(
            "[!] Это не целое число. Введите заново: ",             // 0
            "[!] Это не вещественное число. Введите заново: ",       // 1
            "[!] Нельзя задать отрицательное время. "                   // 2
    );

    public static String show(int index) {
        return MESSAGES.get(index);
    }
}