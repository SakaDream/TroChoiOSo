/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakadream.game.numbers.func;

import com.sakadream.game.numbers.objects.Dot;
import com.sakadream.game.numbers.objects.Option;
import com.sakadream.game.numbers.objects.Vector;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

/**
 *
 * @author Phan Ba Hai
 */
public class Function {
    public static final String FREE_MODE = "Free Mode", TIME_LEFT_MODE = "Time Left Mode",
            EASY = "Easy", MEDIUM = "Medium", HARD = "Hard", FILENAME = "option.dat";
    public static Option o = new Option();
    public static int time = 0;
    public static Timer timer;
    public static List<JButton> listBtn = new ArrayList<JButton>();
    public static List<Dot> listD = new ArrayList<Dot>();
    public static List<String> listCheck = new ArrayList<String>();
    public static List<String> list, shuffle;
    public static int n = 0, shuffleNum = 0;
    public static List<String> listNum = new ArrayList<String>();
    private static int min, sec;
    private static boolean isPause = false;
    
    public static void open() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Option option = new Option();
            option = (Option) ois.readObject();
        
            o.setMode(option.getMode());
            o.setDifficulty(option.getDifficulty());
            o.setTime(option.getTime() * 60);
        } catch (FileNotFoundException fnfe) {
            File file = new File(FILENAME);
            file.createNewFile();
            
            o.setMode(FREE_MODE);
            o.setDifficulty(EASY);
            o.setTime(300);
        
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
            fos.close();
        }
    }
    
    public static void createListCheck() {
        for(int i = 1; i < n * n; i++) {
            listCheck.add(i - 1, String.valueOf(i));
        }
        listCheck.add(n * n - 1, "");
    }
    
    public static void createListNum() {
        for(int i = 0; i < n * n; i++) {
            if(listNum.size() > n * n) {
                listNum.remove(i);
            }
            listNum.add(i, listBtn.get(i).getText());
        }
    }

    public static JButton createButton() {
        final JButton b = new JButton(shuffle.get(shuffleNum));
        b.setFont(new Font("Tamoha" , Font.BOLD, 20));
        shuffleNum++;
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Dot d1 = listD.get(getBtnIndex(b));
                Dot d2 = getButtonDotByText("");
                JButton b2 = getButtonByDot(d2);
                Vector v = getVector(d1, d2);
                double l = Length(v);
                if(l == 1) {
                    changeBtn(b, b2);
                }
                createListNum();
                if(isWin()) {
                    timer.cancel();
                    JOptionPane.showMessageDialog(null, "Chúc mừng! Bạn đã giải đuợc ô số!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        return b;
    }
    
    public static Dot createDot(int xB, int yB) {
        Dot d = new Dot();
        d.setX(xB);
        d.setY(yB);
        d.setIndex(convertToIndex(xB, yB));
        return d;
    }
    
    public static int convertToIndex(int x, int y) {
        return x * n + y;
    }
    
    public static Dot convertToXY(int i) {
        int x = i / n;
        int y = i % n;
        final Dot d = new Dot(x, y);
        return d;
    }
    
    public static int getBtnIndex(JButton b) {
        return listBtn.indexOf(b);
    }
    
    private int getDotIndex(Dot d) {
        return listD.indexOf(d);
    }
    
    public static Dot getButtonDotByText(String text) {
        Dot d = null;
        for(int index = 0; index < n * n; index++) {
            JButton btn = listBtn.get(index);
            if(btn.getText().equals("")) {
                d = listD.get(getBtnIndex(btn));
            }
        }
        return d;
    }
    
    public static JButton getButtonByDot(Dot d) {
        int i = d.getIndex();
        JButton b = listBtn.get(i);
        return b;
    }
    
    public static void changeBtn(JButton a, JButton b) {
        String stra = a.getText();
        String strb = b.getText();
        String tmp = "";
        tmp = stra;
        stra = strb;
        strb = tmp;
        a.setText(stra);
        b.setText(strb);
    }
    
    public static Vector getVector(Dot a, Dot b) {
        int xa = a.getX(), xb = b.getX(), ya = a.getY(), yb = b.getY();
        Vector v = new Vector(xb - xa, yb - ya);
        return v;
    }
    
    public static double Length(Vector v) {
        int vx = v.getVx(), vy = v.getVy();
        return Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2));
    }
    
    public static void createPanel(JPanel panBtn) {
        if(o.getDifficulty().equals(EASY)) {
            n = 3;
        } else if(o.getDifficulty().equals(MEDIUM)) {
            n = 4;
        } else n = 5;
        createListCheck();
        shuffle = new ArrayList<String>(listCheck);
        Collections.shuffle(shuffle);
        panBtn.setLayout(new GridLayout(n, n));
            for(int i = 0; i < n * n; i++) {
                int x = i / n;
                int y = i % n;
                JButton btn = createButton();
                Dot d = createDot(x, y);
                listBtn.add(btn);
                listD.add(d);
                panBtn.add(btn);
            }
    }
    
    public static void run(JLabel lblTime, JFrame maingame) {
        if(o.getMode().equals(FREE_MODE)) {
            time = (isPause) ? time : 0;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    min = time / 60;
                    sec = time - min * 60;
                    String strMin = "", strSec = "";
                    if(min < 10) {
                        strMin = "0" + String.valueOf(min);
                    } else strMin = String.valueOf(min);
                    if(sec < 10) {
                        strSec = "0" + String.valueOf(sec);
                    } else strSec = String.valueOf(sec);
                    lblTime.setText(strMin + " : " + strSec);
                    time += 1;
                }
            }, 0, 1000);
        } else {
            time = (isPause) ? time : o.getTime();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    min = time / 60;
                    sec = time - min * 60;
                    String strMin = "", strSec = "";
                    if(min < 10) {
                        strMin = "0" + String.valueOf(min);
                    } else strMin = String.valueOf(min);
                    if(sec < 10) {
                        strSec = "0" + String.valueOf(sec);
                    } else strSec = String.valueOf(sec);
                    lblTime.setText(strMin + " : " + strSec);
                    time -= 1;
                    if(time == 0) {
                        timer.cancel();
                        JOptionPane.showMessageDialog(null, "Hết giờ!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }, 0, 1000);
        }
    }
    
    public static void start(JPanel panBtn, JLabel lblTime, JFrame maingame) {
        timer = new Timer();
        createPanel(panBtn);
        if(o.getMode().equals(TIME_LEFT_MODE)) {
            o.getTime();
        }
        run(lblTime, maingame);
        isPause = false;
    }
    
    public static void pause(JLabel lblTime) {
        String strMin = String.valueOf(min);
        String strSec = String.valueOf(sec);
        lblTime.setText(String.valueOf(min) + " : " + String.valueOf(sec));
        time = min * 60 + sec;
        timer.cancel();
        isPause = true;
    }
    
    public static void resume(JLabel lblTime, JFrame maingame) {
        timer = new Timer();
        run(lblTime, maingame);
        isPause = false;
    }
    
    public static void stop(JLabel lblTime) {
        lblTime.setText("00 : 00");
        time = 0;
        timer.cancel();
        isPause = false;
        
        try {
            list.clear();
        } catch(NullPointerException npe) { }
        try {
            listBtn.clear();
        } catch(NullPointerException npe) { }
        try {
            listCheck.clear();
        } catch(NullPointerException npe) { }
        try {
            listD.clear();
        } catch(NullPointerException npe) { }
        try {
            listNum.clear();
        } catch(NullPointerException npe) { }
        n = 0;
        shuffleNum = 0;
    }
    
    public static boolean isWin() {
        int count = 0;
        for(int i = 0; i < n * n; i++) {
            if(listCheck.get(i).equals(listNum.get(i)))
                count++;
        }
        if(count == n * n) return true;
        else return false;
    }
    
    public static void saveOption(JRadioButton rFM, JComboBox cbbDif, JSlider sldTime) throws FileNotFoundException, IOException {
        String mode = "";
        if(rFM.isSelected()) {
            mode = FREE_MODE;
        } else mode = TIME_LEFT_MODE;
        String difficulty = cbbDif.getSelectedItem().toString();
        int time = sldTime.getValue();
        
        o.setMode(mode);
        o.setDifficulty(difficulty);
        o.setTime(time);
        
        FileOutputStream fos = new FileOutputStream(FILENAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        oos.close();
        fos.close();
    }
    
    public static void openOption(JRadioButton rFM, JRadioButton rTLM, JComboBox cbbDif, JSlider sldTime) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILENAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Option option = new Option();
        option = (Option) ois.readObject();
        
        o.setMode(option.getMode());
        o.setDifficulty(option.getDifficulty());
        o.setTime(option.getTime());
        
        if(o.getMode().equals(FREE_MODE)) {
            rFM.setSelected(true);
        } else rTLM.setSelected(true);
        cbbDif.setSelectedItem(o.getDifficulty());
        sldTime.setValue(o.getTime());
    }
}
