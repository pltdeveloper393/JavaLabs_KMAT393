package com.adminski;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {
    private static final List<String> ErrMESSAGES = List.of(
            "[!] Неверный ввод значения ранга. ", // 0
            "[!] Неверный ввод значения ранга. Введите число от 0 до 5.", // 1
            "Аккаунт заблокирован",     // 2
            "Превышен лимит попыток",   // 3
            "Сервер недоступен"         // 4
    );

    public static String show(int index) {
        return ErrMESSAGES.get(index);
    }
}