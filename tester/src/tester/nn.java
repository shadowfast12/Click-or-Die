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
	
	public nn() {
		//DEFAULT CONSTRUCTOR
		colocho = 0;
		wnum = 0;
		amnt = 0;
		upg=1;
		num=1;
	}
	
	public void no() {
		
		//MAIN FRAME OF GUI
		JFrame f;
		f=new JFrame("CLICK OR DIE BY ZACH BAUMANN");
		
		//TITLE OF MAIN FRAME
		JLabel title = new JLabel("CLICK OR DIE");
		title.setBounds(35, -15, 250, 100);
		title.setFont(new Font("Bauhaus 93", Font.PLAIN, 35));
		f.add(title);
		
		//TEXT OF THE AMOUNT OF MONEY
		JLabel lb1 = new JLabel("MONEY: "+amnt);
		lb1.setBounds(30,50,1000,40);
		lb1.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		f.add(lb1);	
		
		//TEXT OF THE AMOUNT OF UPGRADE
		JLabel lb2 = new JLabel("UPGRADE: "+String.valueOf(upg));
		lb2.setBounds(30,80,300,40);
		lb2.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		f.add(lb2);
		
		//BUTTON TO CLICK FOR MONEY
		JButton b = new JButton("CLICK");
		b.setBounds(65,150,175,75);
		b.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 35));
		f.add(b);
		
		//BUTTON TO UPGRADE
		JButton bb = new JButton("UPGRADE");
		bb.setBounds(80,250,120,30);
		f.add(bb);
		
		//BUTTON TO THE SHOP
		JButton bshop = new JButton("SHOP");
		bshop.setBounds(80,280,120,30);
		f.add(bshop);
		
		//TEXT OF THE AMOUNT OF WORKERS
		JLabel lb3 = new JLabel("Number of Workers: "+wnum);
		lb3.setBounds(30,300,300,40);
		f.add(lb3);	
	
		//OTHER CUSTOMIZE STUFF
		f.setSize(300,400);
		f.getContentPane().setBackground(new Color(colocho, 180, 90));
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//SHOP FRAME OF GUI
		JFrame s;
		s=new JFrame("SHOP");
		s.setLayout(null);
		s.getContentPane().setBackground(new Color(90, colocho, 60));
		
		
		//BUY WORKER
		JButton bw= new JButton("BUY WORKER");
		bw.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		bw.setBounds(50,80,120,40);
		s.add(bw);
		//WORKER COST LABEL
		JLabel bl = new JLabel("WORKERS COST: $"+ 50*(wnum+1));
		bl.setBounds(50,50,300,40);
		s.setSize(300,400);
		s.add(bl);
		
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
					JLabel bl = new JLabel("WORKERS COST: $"+ 50*(wnum+1));
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
				if(num+num*5<=amnt) {
					amnt-=Math.floor(num+num*1.2);
					num++;
					upg++;
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
