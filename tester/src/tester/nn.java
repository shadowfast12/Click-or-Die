package tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class nn extends Canvas{
	//SET VARIABLES TO DATA TYPE
	
	
	//TOTAL AMOUNT OF CLICKS
	public long amnt;
	//AMOUNT OF UPGRADES
	public int upg;
	//AMOUNT OF MONEY MADE PER CLICK
	public int num;
	//AMOUNT OF WORKERS
	public long wnum;
	//RED VALUE OF RBG
	public int colocho;
	//AMOUNT OF XEROXS
	public long Xero;
	//VALUE OF THE MONEY MADE FROM THE THREADS PER SEC
	public double psec;
	
	public nn() {
		//DEFAULT CONSTRUCTOR
		Xero = 0;
		psec = 0.00d;
		colocho = 0;
		wnum = 0;
		amnt = 0;
		upg=1;
		num=1;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void no() {
						
		//MAIN FRAME OF GUI

		JFrame f;
		f=new JFrame("CLICK OR DIE BY ZACH BAUMAN");

		//TITLE OF MAIN FRAME
		JLabel title = new JLabel("CLICK OR DIE");
		title.setBounds(10, -15, 250, 100);
		title.setFont(new Font("Andalus", Font.PLAIN, 40));
		f.getContentPane().add(title);
		
		//TEXT OF THE MONEY MADE PER SEC FROM THE THREADS
		JLabel lbps = new JLabel(psec+" per second");
		lbps.setBounds(150, 50, 10000, 40);
		lbps.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		f.getContentPane().add(lbps);
		
		//TEXT OF THE AMOUNT OF MONEY
		JLabel lb1 = new JLabel("MONEY: "+amnt);
		lb1.setBounds(10,50,1000,40);
		lb1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		f.getContentPane().add(lb1);	
		
		//TEXT OF THE AMOUNT OF UPGRADE
		JLabel lb2 = new JLabel("UPGRADE: "+String.valueOf(upg));
		lb2.setBounds(10,75,300,40);
		lb2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		f.getContentPane().add(lb2);
		
		//BUTTON TO CLICK FOR MONEY
		JButton b = new JButton("CLICK");
		b.setBounds(5,115,275,130);
		b.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 40));
		b.setBackground(Color.BLACK);
		b.setOpaque(false);
		f.getContentPane().add(b);
		
		//BUTTON TO UPGRADE
		JButton bb = new JButton("UPGRADE");
		bb.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		bb.setOpaque(false);
		bb.setBackground(Color.black);
		bb.setBounds(80,250,120,30);
		f.getContentPane().add(bb);
		
		//BUTTON TO THE SHOP
		JButton bshop = new JButton("SHOP");
		bshop.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		bshop.setBackground(Color.black);
		bshop.setForeground(Color.black);
		bshop.setBounds(80,282,120,30);
		bshop.setOpaque(false);
		f.getContentPane().add(bshop);
		
		//TEXT OF THE AMOUNT OF WORKERS
		JLabel lb3 = new JLabel("NUMBER OF WORKERS: "+wnum);
		lb3.setBounds(10,300,300,40);
		f.getContentPane().add(lb3);	
		
		//TEXT OF THE AMOUNT OF XEROX
		JLabel amtXero = new JLabel("NUMBER OF XEROX: "+Xero);
		amtXero.setBounds(10,315,300,40);
		f.getContentPane().add(amtXero);
	
		//OTHER CUSTOMIZE STUFF
		f.setSize(300,400);
		f.getContentPane().setBackground(new Color(colocho, 180, 90));
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//SHOP FRAME OF GUI
		JFrame s;
		s=new JFrame("SHOP");
		s.getContentPane().setLayout(null);
		s.getContentPane().setBackground(new Color(90, colocho, 60));
		
		//SHOP LABEL TITLE
		JLabel shopl = new JLabel("Le Shop");
		shopl.setFont(new Font("Bauhaus 93", Font.PLAIN, 35));
		shopl.setBounds(80, -18, 250, 100);
		s.getContentPane().add(shopl);
		
		//BUY WORKER
		JButton bw= new JButton("PURCHASE");
		bw.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
		bw.setBackground(Color.black);
		bw.setOpaque(false);
		bw.setBounds(10,80,120,40);
		s.getContentPane().add(bw);
		//WORKER COST LABEL
		JLabel bl = new JLabel("WORKERS COST: $"+ 50*(wnum+1));
		bl.setBounds(10,50,300,40);
		s.setSize(300,400);
		s.getContentPane().add(bl);
		
		//BUY Xerox Alto
		JButton bw2 = new JButton("PURCHASE");
		bw2.setFont(new Font("Haettenschweiler", Font.PLAIN,18));
		bw2.setBackground(Color.black);
		bw2.setOpaque(false);
		bw2.setBounds(10,160,120,40);
		s.getContentPane().add(bw2);
		//XERO COST LABEL
		JLabel Xerol = new JLabel("XEROX COST: $"+ 125*(Xero+1));
		Xerol.setBounds(10,120,300,40);
		s.getContentPane().add(Xerol);
		
		
		
		
		//ACTION TO BUY XEROX
		bw2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(amnt>=125*(Xero+1)) {
					//THREAD FOR XEROX
					amnt-=125*(Xero+1);
					Xero++;
					psec=psec+2;
					lbps.setText(String.valueOf(psec+" per second"));
					lb1.setText(String.valueOf("MONEY: "+amnt));
					Xerol.setText("XEROX COST: $"+125*(Xero+1));
					amtXero.setText("NUMBER OF XEROX: "+Xero);
					class xeroth extends Thread{
						public void run() {
							while(true) {
								try {
									xeroth.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								amnt ++;
								lb1.setText(String.valueOf("MONEY: "+amnt));
							}
						}
					}
					xeroth xer = new xeroth();
					xer.start();
					
				}
			}
		});
		
		//THREAD FOR BACKGROUND COLOR CHANGER OF THE GUI
		class colors extends Thread{
			int amntchn = 1;
			public void run() {
				while(true) {
					try {
						colors.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					colocho=(Integer.sum(amntchn,colocho));
					//changes the red of the RBG values of the background
					f.getContentPane().setBackground(new Color(colocho, 180, 90));
					s.getContentPane().setBackground(new Color(120, colocho, 60));
					
					if(colocho==253) {
						amntchn=-1;
					}
						
					if(colocho==1) {
						amntchn=1;
					}
					
				}
			}
		}
		colors cln = new colors();
		cln.start();
		
		//ACTION OF PURCHASING WORKERS
		bw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(amnt>=50*(wnum+1)) {
					wnum++;
					amnt-=50*wnum;
					psec++;
					lbps.setText(String.valueOf(psec+" per second"));
					bl.setText(String.valueOf("WORKERS COST: $"+ 50*(wnum+1)));
					lb3.setText(String.valueOf("Number of Workers: "+wnum));
					//THREAD FOR THE WORKERS GETTING CLICKS
					class mut extends Thread {
						public void run() {
							while(true) {
								try {
									mut.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								amnt ++;
								lb1.setText(String.valueOf("MONEY: "+amnt));

								
							
						}
						}
					}
					mut mm = new mut();
					mm.start();
				}
			}

		});
		
		//ACTION OF CLICK
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				amnt+=upg;
				lb1.setText(String.valueOf("MONEY: "+amnt));
		
	}
	
	});
		
		//ACTION OF SHOP
		bshop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			s.setVisible(true);
			}
		});

		//ACTION OF PURCHASING UPGRADE
		bb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(Math.pow(4,num)<=amnt) {
					amnt-=Math.round(Math.pow(4,num));
					num++;
					upg++;
					lb1.setText(String.valueOf("MONEY: "+amnt));
					lb2.setText(String.valueOf("LEVEL: "+upg));
					
					
				}
			}
	});
		
	}
	
	//RUNNER STUFF!
	public static void main(String[] args) {
		nn n = new nn();  
		n.no();		
	}	

	}
