/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.login.LoginFrame;
import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author Azis Naufal
 */
public class Main {
    public static void main(String[] args) {
//        set look and feel
//        light
//        FlatLightLaf.install()
//        dark
//        FlatDarkLaf.install()
//        IntelliJ IDEA
        FlatIntelliJLaf.install();
//        Darcula IntelliJ IDEA
//        FlatDarculaLaf.install();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
