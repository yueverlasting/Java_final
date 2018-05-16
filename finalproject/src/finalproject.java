import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.*;

import java.awt.*;



public class finalproject extends Frame  implements ActionListener,KeyListener 
{
	static finalproject frm = new finalproject();
	static Dialog dlg = new Dialog(frm);
	static JPanel pnl=new JPanel();
	static TextArea txa; 
	static Button dlb1 = new Button ("進入遊戲");
	static ImageIcon[] imgs;
	static SpeedJButton[] btns;
	static JLabel bg = new JLabel();
	static JLabel rule = new JLabel();
	static JPanel pnl2=new JPanel();
	static ImageIcon back=new ImageIcon("image/back.png");
	/////////////////////////////////
	static JPanel pnlover=new JPanel();
	static JLabel over = new JLabel();
	static ImageIcon img_gameover=new ImageIcon("image/gameover.jpg");
	////////////////////
	static JPanel pnlwin=new JPanel();
	static JLabel win = new JLabel();
	static ImageIcon img_win=new ImageIcon("image/win.jpg");
	////////////////////
	static ImageIcon img_rule=new ImageIcon("image/rule.jpg");
	static ImageIcon img_end=new ImageIcon("image/end.jpg");
	static ImageIcon img_w1=new ImageIcon("image/w1.gif");
	////////////////////
	
	public static void main(String[] args) 
	{
	int i=0;
	
	int img_back=5;
	int red=img_back;
	
	int img_s1=0;int img_w1=1;//int img_w2=2;int img_w3=3;int img_w4=4;
	int img_b1=5;int img_b2=6;
	int img_b3=7;int img_l1=8;
	int img_l2=9;
	int img_boat=10;
	
	int img_st1=17;int img_st2=18;
	
	int img_car4l=12;int img_car4r=13;
	int img_car5l=14;int img_car5r=15;
	int img_car2=16;int img_car3=11;
	
	int img_over = 20;
	
	//新增圖案		
	imgs=new ImageIcon[25];//暫定
	
	imgs[img_s1]=new ImageIcon("image/s1.png");
	imgs[img_w1]=new ImageIcon("image/w1.gif");

	imgs[img_b1]=new ImageIcon("image/ball1.png");
	imgs[img_b2]=new ImageIcon("image/ball2.png");
	imgs[img_b3]=new ImageIcon("image/ball3.png");
	imgs[img_l1]=new ImageIcon("image/green.png");
	imgs[img_l2]=new ImageIcon("image/red.png");
	imgs[img_boat]=new ImageIcon("image/boat.png");
	
	imgs[img_st1]=new ImageIcon("image/st1.jpg");
	imgs[img_st2]=new ImageIcon("image/st2.jpg");
	
	imgs[img_car3]=new ImageIcon("image/car3.png");
	imgs[img_car2]=new ImageIcon("image/car2.png");
	imgs[img_car4l]=new ImageIcon("image/car4l.png");
	imgs[img_car4r]=new ImageIcon("image/car4r.png");
	imgs[img_car5l]=new ImageIcon("image/car5l.png");
	imgs[img_car5r]=new ImageIcon("image/car5r.png");	
	
	imgs[img_over]=new ImageIcon("image/gameover.png");	
	///////////////////////////////////////
	
	frm.setTitle("小朋友過馬路");
	frm.setBounds(0, 0, 800, 620);//y+20
	frm.setSize(800, 620);
	frm.setLayout(null);
	frm.setResizable(false);
	
	//規則		
	dlg.setTitle("遊戲規則");
	dlg.setBounds(0, 0, 800, 620);
	dlg.setLayout(null);
	dlg.setVisible(true);
	//規則按鍵		
	dlb1.setBounds(600, 540, 120, 50);
	dlb1.addActionListener(frm);
	dlg.add(dlb1);
	
	//規則背景
	rule.setIcon(img_rule);
	pnl2.add(rule);
	pnl2.setBounds(0, 20, 800, 620);
	dlg.add(pnl2);
	dlg.setResizable(false);
	
	////////結束
	pnlover.setBounds(0, 20, 800, 620);
	over.setIcon(img_gameover);
	pnlover.add(over);
	pnlover.setVisible(false);
	////////勝利
	pnlwin.setBounds(0, 20, 800, 620);
	win.setIcon(img_win);
	pnlwin.add(win);
	pnlwin.setVisible(false);
	//背景
	bg.setIcon(back);
	pnl.setBounds(0, 20, 800, 620);
	pnl.add(bg);
	
	
	//新增移動物件	
	
	btns = new SpeedJButton[25]; 
	
	for(i=0;i<btns.length;i++){
		btns[i]=new SpeedJButton();
	}
	
	//人
		
	//設置x.y起始值
	btns[0].x =375;
	btns[0].y =545;
	
	btns[0].addKeyListener(frm);
	btns[0].setLocation(375, 560);
	btns[0].setSize(40,55);
	btns[0].setColor(1, imgs);
	btns[0].color=img_w1;


	//////廢迺部分 (車) (btn1~8)
	
	btns[1].setLocation(0, 500);//walk
	btns[1].setSize(103,50);
	btns[1].setColor(11, imgs);
	btns[1].color=img_car3;
	btns[1].x = 0;
	btns[1].y = 500;
	
	btns[2].setLocation(0, 450);//walk
	btns[2].setSize(150,50);
	btns[2].setColor(16, imgs);
	btns[2].color=img_car2;	
	btns[2].x = 0;
	btns[2].y = 450;
	
	btns[3].setLocation(500, 500);//walk
	btns[3].setSize(103,50);
	btns[3].setColor(11, imgs);
	btns[3].color=img_car3;
	btns[3].x = 500;
	btns[3].y = 500;
	
	btns[4].setLocation(800, 500);//walk
	btns[4].setSize(103,50);
	btns[4].setColor(11, imgs);
	btns[4].color=img_car3;
	btns[4].x = 800;
	btns[4].y = 500;
	
	btns[5].setLocation(300, 500);//1
	btns[5].setSize(103,50);
	btns[5].setColor(11, imgs);
	btns[5].color=img_car3;
	btns[5].x = 300;
	btns[5].y = 500;
	
	btns[6].setLocation(400, 450);//2
	btns[6].setSize(150,50);
	btns[6].setColor(16, imgs);
	btns[6].color=img_car2;
	btns[6].x = 400;
	btns[6].y = 450;
	
	btns[7].setLocation(0, 395);//3
	btns[7].setSize(90,50);
	btns[7].setColor(13, imgs);
	btns[7].color=img_car4r;
	btns[7].x = 0;
	btns[7].y = 395;
	
	btns[8].setLocation(800, 395);//4
	btns[8].setSize(87,50);
	btns[8].setColor(14, imgs);
	btns[8].color=img_car5l;
	btns[8].x = 800;
	btns[8].y = 395;
	
	
	
Timer timer = new Timer(50, new ActionListener() {

public void actionPerformed(ActionEvent e) {
	btns[1].setLocation( (btns[1].getLocation().x+10)%800, btns[1].getLocation().y );
	btns[1].setSize(103, 50);
						
	btns[3].setLocation( (btns[3].getLocation().x+10)%800,btns[3].getLocation().y);
	btns[3].setSize(103, 50);
								
	btns[4].setLocation( (btns[4].getLocation().x+10)%800,btns[4].getLocation().y );
	btns[4].setSize(103, 50);
					    
	btns[5].setLocation( (btns[5].getLocation().x+10)%800,btns[5].getLocation().y );
	btns[5].setSize(103, 50);
	
	judgescar();
	
	}});
					   
	timer.start();
	
						
//車車2	第二排			
Timer timer1 = new Timer(40, new ActionListener() {

public void actionPerformed(ActionEvent e) {
	btns[2].setLocation( (btns[2].getLocation().x+10)%800, btns[2].getLocation().y );
	btns[2].setSize(103, 50);
												
	btns[6].setLocation( (btns[6].getLocation().x+10)%800,btns[6].getLocation().y );
	btns[6].setSize(103, 50);
	
	judgebcar();
	
	}});
	timer1.start();
	
														
	//車車3  垃圾車
	
	Timer timer2 = new Timer(30, new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		if(btns[7].x>=-90 && btns[7].x<250)
			{
				btns[7].setLocation( (btns[7].getLocation().x+5),btns[7].getLocation().y );
				btns[7].setSize(90, 50);
			
				if (btns[7].getLocation().x >= 250)
				{
					btns[7].setData(250,395,1,2);
				}
																

				btns[7].color = btns[7].color;

				btns[7].color = img_car4r;
				btns[7].setIcon(imgs[ btns[7].color ]);
												   
												   
			}

		if(btns[7].x>=250)
			{
				btns[7].setLocation((btns[7].getLocation().x-5),btns[7].getLocation().y);
				btns[7].setSize(150, 50);
					if (btns[7].getLocation().x <= -90)
						{
							btns[7].setData(-90,395,1,2);
						}
					btns[7].color = btns[7].color;
					{btns[7].color = img_car4l;}
					btns[7].setIcon(imgs[ btns[7].color ]);
			}
		judgetrashcar();

	}});

		timer2.start();

	//車車4 小坦克
	Timer timer3 = new Timer(50, new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		//右向左走				
		if(btns[8].x<=800 && btns[8].x>480)
			{
				btns[8].setLocation( (btns[8].getLocation().x-10)%800,btns[8].getLocation().y );
				btns[8].setSize(87, 50);
				if (btns[8].getLocation().x <= 480)
				{
					btns[8].setData(480,395,5,100);
				}
				btns[8].color = btns[8].color;
				btns[8].color = img_car5l;
				btns[8].setIcon(imgs[ btns[8].color ]);
												   
			}

		//左向右走
		if(btns[8].x<=480)
			{
				btns[8].setLocation( (btns[8].getLocation().x+10),btns[8].getLocation().y );
				btns[8].setSize(87, 50);
				if (btns[8].getLocation().x >= 800)
					{
						btns[8].setData(800,395,5,100);
					}
				btns[8].color = btns[8].color;
				btns[8].color = img_car5r;
				btns[8].setIcon(imgs[ btns[8].color ]);
			}
		judgetankcar();

	}});

		timer3.start();
	
	
	/////////阿姨部分
	
	btns[9].setLocation(320,70);
	btns[9].setSize(30,50);
	btns[9].setColor(8, imgs);
	btns[9].color=img_l1;
	
	btns[10].setLocation(700,70);
	btns[10].setSize(30,50);
	btns[10].setColor(8, imgs);
	btns[10].color=img_l1;
	
	btns[11].setLocation(735,45);
	btns[11].setSize(60,102);
	btns[11].setColor(5, imgs);
	btns[11].color=img_b1;
	
	btns[12].setLocation(640,325);//y底-25
	btns[12].setSize(120,30);
	btns[12].setColor(10, imgs);
	btns[12].color=img_boat;
	
	btns[13].setLocation(175,275);//y底-25
	btns[13].setSize(120,30);
	btns[13].setColor(10, imgs);
	btns[13].color=img_boat;
	
	btns[14].setLocation(0,225);//y底-25
	btns[14].setSize(120,30);
	btns[14].setColor(10, imgs);
	btns[14].color=img_boat;
	
	btns[15].setLocation(400,225);//y底-25
	btns[15].setSize(120,30);
	btns[15].setColor(10, imgs);
	btns[15].color=img_boat;
	
	btns[16].setLocation(800,175);//y底-25
	btns[16].setSize(120,30);
	btns[16].setColor(10, imgs);
	btns[16].color=img_boat;
	
//紅綠燈1
	
Thread th3 = new Thread(){
	public void run() { // run() method
		while(true) {
		try {sleep(3500);/*小=快 /短暫睡眠時間*/} 
		catch (InterruptedException e) {e.printStackTrace();}

		btns[9].color = btns[9].color+1;
		if(btns[9].color>img_l2)
			btns[9].color = img_l1;
			btns[9].setIcon(imgs[ btns[9].color ]);
			
			judgelight();
		}}
	};th3.start();  
	
//紅綠燈2
	
Thread th4 = new Thread(){
	public void run() { // run() method
		while(true) {
		try {sleep(4000);/*小=快 /短暫睡眠時間*/}
		catch (InterruptedException e) {e.printStackTrace();}

		btns[10].color = btns[10].color+1;
		if(btns[10].color>img_l2)
			btns[10].color = img_l1;
			btns[10].setIcon(imgs[ btns[10].color ]);
			
			judgelight();
			
		}}
	};th4.start();
	
//氣球
Thread th2 = new Thread(){
	public void run() { // run() method
		while(true) {
		try {sleep(200);/*小=快 /短暫睡眠時間*/} 
		catch (InterruptedException e) {e.printStackTrace();}

		btns[11].color = btns[11].color+1;
		if(btns[11].color>img_b3)
			{btns[11].color = img_b1;
			btns[11].setIcon(imgs[ btns[11].color ]);}
			
		judgeball();
		}}};th2.start(); 
		
		//船1		
		
		Thread th5 = new Thread(){

					public void run() { // run() method
					while(true) {
					try {

					sleep(40);//小=快 /短暫睡眠時間

					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
				if(btns[12].x>135 && btns[12].x<=640) //1.移動規則在位置135-640(以下left
				{
					btns[12].setLocation(
							(btns[12].getLocation().x-6), btns[12].getLocation().y);

					btns[12].setSize(120, 30);

					if (btns[12].getLocation().x <= 135){ //2.目前位置小於135位置回到135(準備向右
						btns[12].setData(135,335,1,2);
					}	
					
				}

				if(btns[12].x<=135) //1.<135 turn right
				{
					btns[12].setLocation(
							(btns[12].getLocation().x+6),btns[12].getLocation().y);

					btns[12].setSize(120, 30);
							
					if (btns[12].getLocation().x >= 640){ //2.若目前位置超過640位置回到640(準備再向左
						btns[12].setData(640,335,1,2);
					}							
							
				}
				 boatmove();
				 boatdie();
				}}};th5.start();
				
				
			//船2		

		Thread th6 = new Thread(){

					public void run() { // run() method
					while(true) {
					try {

					sleep(80);//小=快 /短暫睡眠時間

					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
				if(btns[13].x>146 && btns[13].x<=710) 
				{
					btns[13].setLocation(
							(btns[13].getLocation().x-8), btns[13].getLocation().y);

					btns[13].setSize(120, 30);

					if (btns[13].getLocation().x <= 175){ 
						btns[13].setData(146,285,1,2);
					}	
					
				}

				if(btns[13].x<=146) 
				{
					btns[13].setLocation(
							(btns[13].getLocation().x+8),btns[13].getLocation().y);

					btns[13].setSize(120, 30);
							
					if (btns[13].getLocation().x >= 710){ 
						btns[13].setData(710,285,1,2);
					}					
							
				}
				boatmove();
				boatdie();
				}}};th6.start();
				
				
			//船3,4	
				
		Thread th7 = new Thread(){

					public void run() { // run() method
					while(true) {
					try {

					sleep(45);//小=快 /短暫睡眠時間

					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				btns[14].setLocation(

						(btns[14].getLocation().x+5)%800, 

						btns[14].getLocation().y);
				
				btns[15].setLocation(

						(btns[15].getLocation().x+5)%800, 

						btns[15].getLocation().y);
				
				boatmove();
				boatdie();
				}}};th7.start();
				
			//船5

		Thread th8 = new Thread(){

					public void run() { // run() method
					while(true) {
					try {

					sleep(35);//小=快 /短暫睡眠時間

					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
								
					btns[16].setLocation(

							(btns[16].getLocation().x-5)%800, 

							btns[16].getLocation().y);
					
					if(btns[16].getLocation().x<-120)
						btns[16].setLocation(800,btns[16].getLocation().y);
					
				boatmove();
				boatdie();
				}}};th8.start();
		
		
	    frm.add(pnlwin);
		frm.add(pnlover);
		
		frm.add(btns[0]);//人
		//1-6 cars
		frm.add(btns[1]);
		frm.add(btns[2]);
		frm.add(btns[3]);
		frm.add(btns[4]);
		frm.add(btns[5]);
		frm.add(btns[6]);
		frm.add(btns[7]);
		frm.add(btns[8]);
		//
		frm.add(btns[9]);frm.add(btns[10]);//紅綠燈
		frm.add(btns[11]);//氣球
		frm.add(btns[12]);frm.add(btns[13]);frm.add(btns[14]);frm.add(btns[15]);frm.add(btns[16]);//船
		
		
		frm.add(pnl);
		
		
		
		
	dlg.addWindowListener(new WindowAdapter()
	{public void windowClosing(WindowEvent e)
	{System.exit(0);}});
	
	frm.addWindowListener(new WindowAdapter()
	{public void windowClosing(WindowEvent e)
	{System.exit(0);}});
	
	frm.setVisible(true);
	
	//按鈕透明

	for(i=0;i<25;i++){
	btns[i].setOpaque(true);
	btns[i].setContentAreaFilled(false);
	btns[i].setBorderPainted(false);
	}
	
	}
	
	


	

@Override

	public void actionPerformed(ActionEvent e){
		Button btn=(Button) e.getSource();
		if(btn==dlb1){
			dlg.setVisible(false);
		}
	}

public void keyPressed(KeyEvent e)
{
	int i = e.getKeyCode();
	
	if(i == KeyEvent.VK_UP)	{
	
		
		if(btns[0].y-25 >= 100)
			btns[0].y = btns[0].y-50;
		btns[0].setLocation(btns[0].getLocation().x,btns[0].y);
		judge();
		boatmove();
	}
	
	if(i == KeyEvent.VK_DOWN)	{
		if(btns[0].y+55 <= 620)
			btns[0].y = btns[0].y+50;
		btns[0].setLocation(btns[0].getLocation().x,btns[0].y);
		judge();
		boatmove();
	}
	
	if(i == KeyEvent.VK_RIGHT)	{
		if(btns[0].x+30 <= 800)
		{	btns[0].x = btns[0].x+25;
			btns[0].setLocation(btns[0].x,btns[0].getLocation().y);			
		}
		judge();
		boatmove();
		
	}
	
	if(i == KeyEvent.VK_LEFT)	{
		if(btns[0].x-25 >= 0)
		{	btns[0].x = btns[0].x-25;
			btns[0].setLocation(btns[0].x,btns[0].getLocation().y);
		}
		judge();
		boatmove();
		
	}
	
}




@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
	

public static void judgescar()
{
	if(btns[0].x >= btns[1].getLocation().x  &&
	   btns[0].x <= btns[1].getLocation().x+80 &&
	   btns[0].y >= btns[1].getLocation().y-10 &&
	   btns[0].y <= btns[1].getLocation().y+25 )
		disappear();
	
	if(btns[0].x >= btns[3].getLocation().x-10  &&
			   btns[0].x <= btns[3].getLocation().x+80 &&
			   btns[0].y >= btns[3].getLocation().y-10 &&
			   btns[0].y <= btns[3].getLocation().y+25 )
		disappear();
	if(btns[0].x >= btns[4].getLocation().x-10  &&
			   btns[0].x <= btns[4].getLocation().x+80 &&
			   btns[0].y >= btns[4].getLocation().y-10 &&
			   btns[0].y <= btns[4].getLocation().y+25 )
		disappear();
	if(btns[0].x >= btns[5].getLocation().x-10  &&
			   btns[0].x <= btns[5].getLocation().x+80 &&
			   btns[0].y >= btns[5].getLocation().y-10 &&
			   btns[0].y <= btns[5].getLocation().y+25 )
		disappear();
		
	
}

public static void judgebcar()
{
	if(btns[0].x >= btns[2].getLocation().x-10 &&
	   btns[0].x <= btns[2].getLocation().x+80 &&
	   btns[0].y >= btns[2].getLocation().y-10 &&
	   btns[0].y <= btns[2].getLocation().y+25 )
		disappear();
	
	if(btns[0].x >= btns[6].getLocation().x-10  &&
			   btns[0].x <= btns[6].getLocation().x+70 &&
			   btns[0].y >= btns[6].getLocation().y-10 &&
			   btns[0].y <= btns[6].getLocation().y+25 )
		disappear();

	
}

public static void judgetrashcar()
{
	if(btns[0].x >= btns[7].getLocation().x-10 &&
	   btns[0].x <= btns[7].getLocation().x+70 &&
	   btns[0].y >= btns[7].getLocation().y-10 &&
	   btns[0].y <= btns[7].getLocation().y+25 )
		disappear();
	
}

public static void judgetankcar()
{
	if(btns[0].x >= btns[8].getLocation().x-10 &&
	   btns[0].x <= btns[8].getLocation().x+80 &&
	   btns[0].y >= btns[8].getLocation().y-10 &&
	   btns[0].y <= btns[8].getLocation().y+25 )
		disappear();
	
}
 
public static void judgeball()
{
	if(btns[0].x >= btns[10].getLocation().x+5 &&
	   btns[0].x <= btns[10].getLocation().x+50 &&
	   btns[0].y >= btns[10].getLocation().y &&
	   btns[0].y <= btns[10].getLocation().y+50)
		win();
}

public static void judge()
{
	judgescar();
	judgebcar();
	judgetrashcar();
	judgetankcar();
	judgeball();
	judgelight();

}

public static void judgelight()
{   int img_l2 = 9;
	if(btns[10].color == img_l2 &&
	   btns[0].getLocation().x >= 125 &&
	   btns[0].getLocation().x <= 275 &&
	   btns[0].y >= 50 &&
	   btns[0].y <= 120 )
		disappear();
	
	if(btns[10].color == img_l2 &&
			   btns[0].getLocation().x >= 425 &&
			   btns[0].getLocation().x <= 675 &&
			   btns[0].y >= 50 &&
			   btns[0].y <= 120 )
		disappear();
	
}

public static void boatmove()
{
	if(btns[0].getLocation().x >= btns[12].getLocation().x    &&
	   btns[0].getLocation().x <= btns[12].getLocation().x+95 &&
	   btns[0].getLocation().y >= btns[12].getLocation().y-50 &&
	   btns[0].getLocation().y <= btns[12].getLocation().y-10 )
				
	 {btns[0].setLocation(btns[12].getLocation().x+20,btns[0].y);}
		
	 if(btns[0].getLocation().x >= btns[13].getLocation().x    &&
	    btns[0].getLocation().x <= btns[13].getLocation().x+95 &&
	    btns[0].getLocation().y >= btns[13].getLocation().y-50 &&
		btns[0].getLocation().y <= btns[13].getLocation().y-10 ) 
						
	 {
		 btns[0].setLocation(btns[13].getLocation().x+20,btns[0].y);
		 if(btns[0].getLocation().x <=180)
		 {
			 //disappear();
		 }
	 
	 }
					
	 if(btns[0].getLocation().x >= btns[14].getLocation().x    &&
		btns[0].getLocation().x <= btns[14].getLocation().x+95 &&
		btns[0].getLocation().y >= btns[14].getLocation().y-50 &&
		btns[0].getLocation().y <= btns[14].getLocation().y-10)
						
	 {btns[0].setLocation(btns[14].getLocation().x+20,btns[0].y);}

	 if(btns[0].getLocation().x >= btns[15].getLocation().x    &&
		btns[0].getLocation().x <= btns[15].getLocation().x+95 &&
		btns[0].getLocation().y >= btns[15].getLocation().y-50 &&
		btns[0].getLocation().y <= btns[15].getLocation().y-10 )
						
	 {btns[0].setLocation(btns[15].getLocation().x+20,btns[0].y);}
					
	 if(btns[0].getLocation().x >= btns[16].getLocation().x    &&
		btns[0].getLocation().x <= btns[16].getLocation().x+95 &&
		btns[0].getLocation().y >= btns[16].getLocation().y-40 &&
		btns[0].getLocation().y <= btns[16].getLocation().y-10)
						
	 {btns[0].setLocation(btns[16].getLocation().x+20,btns[0].y);
	  btns[0].x = btns[0].getLocation().x;
	 }

}

public static void boatdie()
{		
	if(	 btns[0].getLocation().y >= btns[12].getLocation().y-50 &&
		 btns[0].getLocation().y <= btns[12].getLocation().y-10 &&
		(btns[0].getLocation().x < btns[12].getLocation().x ||
		 btns[0].getLocation().x > btns[12].getLocation().x+95) )
			
		disappear();
	
	if(	 btns[0].getLocation().y >= btns[13].getLocation().y-50 &&
		 btns[0].getLocation().y <= btns[13].getLocation().y-10 &&
		(btns[0].getLocation().x < btns[13].getLocation().x ||
		 btns[0].getLocation().x > btns[13].getLocation().x+95) )
					
		disappear();

	if(	 btns[0].getLocation().y >= btns[14].getLocation().y-50 	&&
			 btns[0].getLocation().y <= btns[14].getLocation().y-10 &&
			(btns[0].getLocation().x < btns[14].getLocation().x 	||
			btns[0].getLocation().x > btns[14].getLocation().x+95) &&
			(btns[0].getLocation().x < btns[14].getLocation().x 	||
			 btns[0].getLocation().x > btns[14].getLocation().x+95) )
				
			disappear();
	
	if(	 btns[0].getLocation().y >= btns[15].getLocation().y-50 	&&
			 btns[0].getLocation().y <= btns[15].getLocation().y-10 &&
			(btns[0].getLocation().x < btns[14].getLocation().x 	||
			 btns[0].getLocation().x > btns[14].getLocation().x+95) &&
			(btns[0].getLocation().x < btns[15].getLocation().x 	||
			 btns[0].getLocation().x > btns[15].getLocation().x+95) )
				
			disappear();

	if( btns[0].getLocation().y >= btns[16].getLocation().y-50 &&
		btns[0].getLocation().y <= btns[16].getLocation().y-10 &&
	   (btns[0].getLocation().x < btns[16].getLocation().x ||
		btns[0].getLocation().x > btns[16].getLocation().x+95) )
						
	 	disappear();
}

public static void disappear()
{
	int j;
	for(j=0;j<=16;j++)
	{
		btns[j].setVisible(false);
	}
	pnlover.setVisible(true);

}

public static void win()
{
	int j;
	for(j=0;j<=16;j++)
	{
		btns[j].setVisible(false);
	}
	pnlwin.setVisible(true);
	
}

}