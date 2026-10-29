package com.adminski;

import java.util.List;

public class ErrorMessage {
    private static final List<String> MESSAGES = List.of(
            "[!] Неверный ввод значения звёзд.", // 0
            "[!] Неверный ввод значения звёзд. Введите число от 1 до 5." // 1
    );

    public static String show(int index) {
        return MESSAGES.get(index);
    }
}