/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakadream.game.numbers.main;

import com.sakadream.game.numbers.func.Function;
import com.sakadream.game.numbers.gui.MainUI;
import com.sakadream.game.numbers.gui.OptionUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Phan Ba Hai
 */
public class main {
    public static void main(String[] args) {
        MainUI maingame = new MainUI();
        maingame.setVisible(true);
        OptionUI optionui = new OptionUI();
        optionui.setVisible(false);
        
        maingame.mNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maingame.panBtn.removeAll();
                Function.stop(maingame.lblTime);
                Function.start(maingame.panBtn, maingame.lblTime, maingame);
            }
        });
        
        maingame.mOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionui.setVisible(true);
                Function.timer.cancel();
            }
        });
        
        maingame.btnPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(maingame.btnPause.getText().equals("Pause")) {
                    maingame.btnPause.setText("Resume");
                    Function.pause(maingame.lblTime);
                } else {
                    maingame.btnPause.setText("Pause");
                    Function.resume(maingame.lblTime, maingame);
                }
            }
        });
        
        maingame.mExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        optionui.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Function.saveOption(optionui.rFM, optionui.cbbDif, optionui.sldTime);
                } catch (IOException ex) {
                    Logger.getLogger(OptionUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                optionui.setVisible(false);
                try {
                    maingame.panBtn.removeAll();
                    Function.stop(maingame.lblTime);
                    Function.open();
                    Function.start(maingame.panBtn, maingame.lblTime, maingame);
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        optionui.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionui.setVisible(false);
            }
        });
        
        optionui.rFM.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(!optionui.rTLM.isSelected()) {
                    optionui.sldTime.setEnabled(false);
                } else optionui.sldTime.setEnabled(true);
            }
        });
        
        optionui.rTLM.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(!optionui.rTLM.isSelected()) {
                    optionui.sldTime.setEnabled(false);
                } else optionui.sldTime.setEnabled(true);
            }
        });
    }
}
