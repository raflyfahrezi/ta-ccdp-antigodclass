/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.login.loginFrame;
import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author Azis Naufal
 */
public class main {
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
        loginFrame loginFrame = new loginFrame();
        loginFrame.setVisible(true);
    }
}
