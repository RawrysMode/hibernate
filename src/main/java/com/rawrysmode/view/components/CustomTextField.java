package com.rawrysmode.view.components;

import com.rawrysmode.assets.colors.CustomColors;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {

    public CustomTextField(String text, int width, int height) {
        super(text);
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        setBackground(CustomColors.GREY_COLOR);
        setForeground(CustomColors.LIGHT_GREY_COLOR);
        setCaretColor(CustomColors.LIGHT_GREY_COLOR);
        setFont(new Font("JetBrains Mono Light", Font.PLAIN, 11));
    }

    public CustomTextField() {
        super();
        setBackground(CustomColors.GREY_COLOR);
        setForeground(CustomColors.LIGHT_GREY_COLOR);
        setCaretColor(CustomColors.LIGHT_GREY_COLOR);
        setFont(new Font("JetBrains Mono Light", Font.PLAIN, 11));
    }

}
