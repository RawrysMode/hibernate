package com.rawrysmode.view.components;

import com.rawrysmode.assets.colors.CustomColors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomComboBox<E> extends JComboBox<E> {

    public CustomComboBox(ArrayList<E> list, E object) {
        super();
        setBackground(CustomColors.DARK_GREY_COLOR);
        setForeground(CustomColors.LIGHT_GREY_COLOR);
        setFont(new Font("JetBrains Mono Light", Font.PLAIN, 12));

        list.forEach(this::addItem);
        setSelectedItem(object);
    }

}
