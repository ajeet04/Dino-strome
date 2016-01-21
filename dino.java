import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.*;
import java.awt.Font;


public class run extends Applet implements Runnable,KeyListener{
	run1 r;
	run2 r2[]=new run2[1];
	run3 r3[]=new run3[1];
	int s;
	int t=0;
	
	
	public void init(){
		addKeyListener(this);
		setSize(425,425);
		setBackground(Color.MAGENTA);
		setBackground(Color.DARK_GRAY);
		//audioClip = getAudioClip(getCodeBase(), "Sound.wav");
	}
public void start(){
	 r=new run1();
	 for(int i=0;i<r2.length;i++){
		 Random s=new Random();
		 
		 r2[i]=new run2(s.nextInt(900)-getWidth());
	 }
	 
	 for(int i=0;i<r3.length;i++){
		 Random s=new Random();
		 
		 r3[i]=new run3();
	 }
	Thread thread =new Thread(this);
	thread.start();
	
}

	@Override
	public void run() {
	while(true){
		r.Ball(this);
		
		
		 for(int i=0;i<r2.length;i++){
			
			 r2[i].plateform(this,r);
		 }
		 Random s=new Random();
		
		 for(int i=0;i<r3.length;i++){
				
			 r3[i].plateform(this,r);
		 }
		repaint();
		try {
			Thread.sleep(15);
			t++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_SPACE:
			r.bounce();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void paint(Graphics g){
		r.paint(g);
		 for(int i=0;i<r2.length;i++){
			r2[i].paint(g);
		 }
		 for(int i=0;i<r3.length;i++){
				r3[i].paint(g);
			 }
		
		
	}

}


 class run1 {
	

	int x=100,y=400,radius=20; 
	
	int dy=0,g=9,t=3;

	public void Ball(run r) {
		 
		y-=dy;
		
		 if(y==270){
			 dy=-dy;
			y-=dy;
	
		 }
		 if(dy<0){
			 if(y==380){
					dy=0;
					y=400;
				} 
		 }
		
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.magenta);
		g.fillOval(x ,y, 20, 20);
		//
		
	}

	public void bounce() {
	  if(y==400){   
	 dy=5;}
	 if((run2.dx==0&& run3.dx==0)){
		 if(run2.i != null){
	 run2.dx=5;
	 run3.dx=5;
	 run2.i="";
	 }
	 }	
	 //audioClip.play();
		
	}
	public int getX() {
		return x;
		
	}
	public int getY() {
		return y;
	}
	
}




 class run2 {
	private static int s;
	int x=700,y=345;
	static int dx=5;
	static int t=0;
	static String i="";
		int p,n;

	public  run2(int x){
		this.x=x;
	}

	public void plateform(run a, run1 b) {
		
		chekForCollision(a,b);
		if(x<10){
		x=a.getWidth()-10;
		
		}
		else
			x-=dx;
		
		}
	

	


	private void chekForCollision(run a,run1 b) {
	
	 if((b.getX()+20>x&&b.getX()-20<x+20)&&(b.getY()+20>y&&b.getY()-20<y+65)){
			a.s=1;
		n=1;
			dx=0;
		run3.dx=0;
		
			i="GAME OVER";	
			t=0;
			
			}
			
			} 
	
	

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		//g.
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 20, 65); 
		g.setColor(Color.RED);
		g.fillRect(x, y, 7,65);
		g.setColor(Color.GREEN);
		g.fillRect(x+14, y, 7,65);
		g.setColor(Color.YELLOW);
		g.fillRect(x, y+40, 20, 40);
		g.setColor(Color.GREEN);
		g.fillRect(x, y+40, 10, 40);
		g.setFont(new Font("Serif",Font.BOLD,30));
		g.drawString(i, 150, 50);
		g.drawString("SCORE"+" "+t, 150, 250);
		//g.drawString("Distance"+p,300,200);
	}

}



class run3 {
	int x,y;
	static int dx=7;

	public run3() {
		
		Random r=new Random();
		x=r.nextInt(500)+100;///////////////////////////////////////////////////////////
		y=270+r.nextInt(75);
	}

	public void plateform(run a, run1 b ) {
	//if(b.s==0){
		checkForCollision(b);
		if(x<10){
			x=a.getWidth()-10;
			Random r=new Random();
				y=r.nextInt(100)+270;
			}
			else
				x-=dx;
				}
	
	

	private void checkForCollision(run1 b) {
		if((b.getX()>x-20&&b.getX()<x+20)&&(b.getY()>y-20&&b.getY()<y+20)){
			
				Random r=new Random();
				x=r.nextInt(300)+20;
				y=270+r.nextInt(100);
				run2.t+=5;
		}
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 20, 20);
		
		
	}

}

