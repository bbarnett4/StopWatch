package Project;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.Timer;

public class StopWatch extends JFrame implements ActionListener {

      private JLabel output;

      private JButton start, stop, reset;

      private Timer timer;

      private long startTime; 

      private double extraTime = 0; 

      public StopWatch() {

            super("StopWatch");

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            setLayout(new GridLayout(2, 1));

            output = new JLabel("0.0", JLabel.CENTER);

            output.setFont(new Font("verdana", Font.BOLD, 25));

            add(output);

            JPanel buttons = new JPanel();

            start = new JButton("Start");

            start.setMnemonic('s');

            stop = new JButton("Stop");

            stop.setMnemonic('p');

            reset = new JButton("Reset");

            reset.setMnemonic('r');

            buttons.add(start);

            buttons.add(stop);

            buttons.add(reset);

            add(buttons);

            setSize(500, 300);

            setVisible(true);


            start.addActionListener(this);

            stop.addActionListener(this);

            reset.addActionListener(this);

            timer = new Timer(0, this);

            timer.setDelay(100);

      }

      public static void main(String[] args) {

            new StopWatch();

      }

      @Override

      public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(timer)) {

                  long current = System.currentTimeMillis();

                  double secondsElapsed = (double) (current - startTime) / 1000.0;

                  secondsElapsed += extraTime;

                  output.setText(String.format("%.1f", secondsElapsed));

            } 
            
            else if (e.getSource().equals(start)) {

                  if (!timer.isRunning()) {

                        startTime = System.currentTimeMillis();

                        timer.start();

                  }

            } 
            
            else if (e.getSource().equals(stop)) {

                  if (timer.isRunning()) {

                        long current = System.currentTimeMillis();

                        double secondsElapsed = (double) (current - startTime) / 1000.0;

                        extraTime += secondsElapsed;

                        timer.stop();

                  }

            } 
            
            else {

                  if (timer.isRunning()) {

                        timer.stop();

                  }

                  startTime = System.currentTimeMillis();

                  extraTime = 0;

                  output.setText("0.0");

            }

      }

}