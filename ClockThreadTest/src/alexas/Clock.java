package alexas;

import java.awt.Graphics;
import java.util.Date;
 
/*public class Clock extends java.applet.Applet implements Runnable {
   
	private static final long serialVersionUID = 1L;
	
	private Thread threadObjClock = null;
    public void start() {
        if (threadObjClock == null) {
            threadObjClock = new Thread(this, "My Clock");
            threadObjClock.start();
        }
    }
    public void run() {
    Thread myThread = Thread.currentThread();
        while (threadObjClock == myThread) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){ }
        }
    }
    public void paint(Graphics g) {
        Date now = new Date();
        g.drawString(now.getHours() + ":" +
             now.getMinutes() + ":" +
             now.getSeconds(), 5, 10);
    }
    public void stop() {
        threadObjClock = null;
    }
}
*/

import java.awt.*;
import javax.swing.*;       
import java.util.*;

/*class Clock extends JFrame implements Runnable {
	
	Thread runner; // declare global objects
	Font clockFont;

	public Clock() {
		super("Java clock");
		setSize(350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false); // create window

		clockFont = new Font("Serif", Font.BOLD, 40); // create font instance

		Container contentArea = getContentPane();
		ClockPanel timeDisplay = new ClockPanel();

		contentArea.add(timeDisplay); // add components
		setContentPane(contentArea);
		start(); // start thread running

	}

	class ClockPanel extends JPanel {
		public void paintComponent(Graphics painter) {
			Image pic = Toolkit.getDefaultToolkit().getImage("background.jpg");

			if (pic != null)

				painter.drawImage(pic, 0, 0, this); // create image

			// if I didn't use a background image I would have used the setColor
			// and fillRect methods to set background

			painter.setFont(clockFont); // create clock components
			painter.setColor(Color.black);
			painter.drawString(timeNow(), 60, 40);

		}
	}

	// get current time
	public String timeNow() {
		Calendar now = Calendar.getInstance();
		int hrs = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);

		String time = zero(hrs) + ":" + zero(min) + ":" + zero(sec);

		return time;
	}

	public String zero(int num) {
		String number = (num < 10) ? ("0" + num) : ("" + num);
		return number; // Add leading zero if needed

	}

	public void start() {
		if (runner == null)
			runner = new Thread(this);
		runner.start();
		// method to start thread
	}

	public void run() {
		while (runner == Thread.currentThread()) {
			repaint();
			// define thread task
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread failed");
			}

		}
	}

	// create main method
	public static void main(String[] args) {
		Clock eg = new Clock();
	}
}*/
/*
import java.util.Calendar;
import javax.swing.JLabel;
 
public class Clock implements Runnable {
 
     JLabel jb;
 
//Constructor takes the clock JLabel
    public Clock(JLabel jb) {
        this.jb = jb;
    }
 
    public void run() {
        while (true) {
            try {
                //Thread sleeps & updates ever 1 second, so the clock changes every 1 second.
                jb.setText(timeNow());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
 
//Gets the current time.
    public String timeNow() {
        Calendar now = Calendar.getInstance();
        int hrs = now.get(Calendar.HOUR_OF_DAY);
        int min = now.get(Calendar.MINUTE);
        int sec = now.get(Calendar.SECOND);
        String time = zero(hrs) + ":" + zero(min) + ":" + zero(sec);
        return time;
    }
 
    //Sets the zeroes needed within our hh/mm/ss clock.
    public String zero(int num) {
        String number = (num < 10) ? ("0" + num) : ("" + num);
        return number;
    }
    
    public void clock(JLabel jb) {
        Clock c1 = new Clock(jb);
        Thread t1 = new Thread(c1);
        t1.start();
    }
    public static void main(String[] args) {
    	
		Clock eg = new Clock(jb);
	}
}*/
import java.awt.Color; 
import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.Font; 
import javax.swing.JFrame; 
import java.awt.event.WindowEvent; 
import java.awt.event.WindowListener; 
import java.util.Date; 
 
 
import javax.swing.JLabel; 
 
 
 
import javax.swing.UIManager; 
import javax.swing.UnsupportedLookAndFeelException; 
 
 
public class Clock extends JFrame implements Runnable, WindowListener{ 

	Thread timer = null;

	String dateToDisplay;

	int hr;
	Date d;
	JLabel dateLabel = new JLabel();
	int hour;
	int minute;
	int second;
	String amPm = "AM";

	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.setSize(200, 80);
		clock.setVisible(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		} catch (UnsupportedLookAndFeelException e) {

		}
		clock.setResizable(false);
		clock.start();

	}

	private void start() {
		if (timer == null) {
			timer = new Thread(this);
			timer.start();
		}
	}

	public void stop() {
		timer = null;
	}

	Clock() {

		this.setLayout(new FlowLayout());

		dateLabel.setBackground(Color.GRAY);
		dateLabel.setForeground(Color.BLACK);
		dateLabel.setFont(new Font("Serif", Font.BOLD, 20));

		this.add(dateLabel);
		//this.setTitle("Clock ");
		this.pack();
		this.setLocationRelativeTo(null);

	}

	public String getFormatedDate(Date d) {
		String formatedDate = " ";
		hour = d.getHours();
		minute = d.getMinutes();
		second = d.getSeconds();
		amPm = (hour < 12) ? "AM" : "PM";
		hr = (hour > 12) ? hour - 12 : hour;

		formatedDate = formatedDate.concat(padElement(hr, '0'));
		formatedDate = formatedDate.concat(":");
		formatedDate = formatedDate.concat(padElement(minute, '0'));
		formatedDate = formatedDate.concat(":");
		formatedDate = formatedDate.concat(padElement(second, '0'));
		formatedDate = formatedDate.concat(" " + amPm);
		return formatedDate;
	}

	private String padElement(int expr, char padChar) {
		String result = "";
		// I'm just padding 2 digit numbers
		if (expr < 10)
			result = result.concat(String.valueOf(padChar));
		result = result.concat(String.valueOf(expr));
		return (result);
	}

	public void run() {
		// Sleep in the timer thread...
		while (timer != null) {
			try {
				timer.sleep(10);
			} catch (InterruptedException e) {
			}
			d = new Date();
			dateToDisplay = getFormatedDate(d);
			dateLabel.setText(dateToDisplay);
		}
		timer = null;

	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent arg0) {
	}

	public void windowClosing(WindowEvent arg0) {
		stop();
		dispose();
		System.exit(0);

	}

	public void windowDeactivated(WindowEvent arg0) {
	}

	public void windowDeiconified(WindowEvent arg0) {
	}

	public void windowIconified(WindowEvent arg0) {
	}

	public void windowOpened(WindowEvent arg0) {
	}

}
