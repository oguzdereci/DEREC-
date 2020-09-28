import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class yilan {
       int genislik = 1100;
       int yukseklik = 780;
       int hiz = 250;
       int yon = 2;
       int boyut = 30;
       int uzunluk = 3;
       int puan = 0;
       boolean bekle = false;
       boolean devam = true;
       boolean intro = true;
       int bitti = 0;
       Point yem;
       Point[] yilan;
       Timer t;
       JFrame pencere;
       Platform pl;
       
       @SuppressWarnings("ResultOfObjectAllocationIgnored")
       public static void main(String[] args) {
               new yilan();
       }
       public yilan(){
               yilan = new Point[uzunluk];
               for(int i = 0; i < uzunluk; i++)
                       yilan[i] = new Point(boyut * (uzunluk-i), boyut);
               yem_at();
                // Oyun başlasın ...
               pencere = new JFrame("Yilan");
               pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               pl = new Platform();
               pencere.add(pl);
               pencere.setSize(genislik , yukseklik);
               pencere.setResizable(false);
               pencere.setVisible(true);
               
               pencere.addKeyListener(new KeyListener() {
                       @Override
                       public void keyPressed(KeyEvent e) {
                               if(e.getKeyCode() == 80) bekle();
                               if(intro && e.getKeyCode() == 10) baslat();
                               if(bitti != 0 && e.getKeyCode() == 10) yeniden_baslat();
                               if(!devam) return;
                               switch (e.getKeyCode()) {
                                           case 87:
                                           case 38:
                                                   if(yon != 2)
                                                           yon = 3;
                                           break;
                                           case 65:
                                           case 37:
                                                   if(yon != 0)
                                                       yon = 1;
                                           break;
                                           case 83:
                                           case 40:  
                                                   if(yon != 3)
                                                           yon = 2;
                                           break;
                                           case 68:
                                           case 39:
                                                   if(yon != 1)
                                                            yon = 0;
                                           break;
                                       }
                                       devam = false;
                       }
                       
                       @Override
                       public void keyTyped(KeyEvent e) {
                               // TODO Auto-generated method stub
                           
                       }
                       
                       
                       @Override
                       public void keyReleased(KeyEvent e) {
                                // TODO Auto-generated method stub
                       }
                });
        }
                   
        private void bekle() {
		if(bitti != 0 || intro) return;
		if(bekle){
			bekle = false;
			t.start();
		} else {
			bekle = true;
			t.stop();
			pl.repaint();
		}
	}
	
	private void yeniden_baslat() {
		puan = 0;
		yon = 0;
		bitti = 0;
		uzunluk = 5;
		yilan = new Point[uzunluk];
		for(int i = 0; i < uzunluk; i++)
			yilan[i] = new Point(boyut * (uzunluk-i), boyut);
		t.start();
		yem_at();
		
	}
	
	public void yem_at() {
		while(true) {
			Random salla = new Random();
			yem = new Point(salla.nextInt((genislik / boyut) - 2) * boyut, salla.nextInt((yukseklik / boyut) - 2) * boyut);
			if(yem.x < boyut || yem.y < boyut || yem.x > genislik - (boyut * 3) - 1 || yem.y > yukseklik - (boyut * 6) - 1) continue;
			boolean carpisma = false;
                    for (Point yilan1 : yilan) {
                        if (yilan1.x == yem.x && yilan1.y == yem.y) {
                            carpisma = true;
                        }
                    }
			if(!carpisma) break;
		}
	}
	
	public void baslat() {
		intro = false;
		t.start();
	}
	
	public class Platform extends JPanel {
		private static final long serialVersionUID = 1L;
        private Object yukseklikgr;
		
		public Platform() {
			this.setPreferredSize(new Dimension(550, 550));
			Dimension ekran = getToolkit().getScreenSize();
			pencere.setLocation((ekran.width - genislik) / 2, 
					(ekran.height - yukseklik) / 2);
 
			ActionListener gorev;
                    gorev = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            int _x = 0;
                            int _y = 0;
                            switch (yon) {
                                case 0:
                                    _x = boyut;
                                    break;
                                case 1:
                                    _x = boyut * -1;
                                    break;
                                case 2:
                                    _y = boyut;
                                    break;
                                case 3:
                                    _y = boyut * -1;
                                    break;
                            }
                            
                            for(int i = yilan.length - 1; i >= 0; i--) {
                                if(i == 0) {
                                    yilan[i] = new Point(yilan[i].x + _x, yilan[i].y + _y);
                                } else {
                                    yilan[i] = new Point(yilan[i-1].x, yilan[i-1].y);
                                }
                            }
                            if(carpisma_kontrol()){
                                t.stop();
                            }
                            
                            yem_kontrol();
                            
                            devam = true;
                            repaint();
                        }
                        
                        private void yem_kontrol() {
                            if(yilan[0].x == yem.x && yilan[0].y == yem.y) {
                                puan = puan + 8;
                                yem_at();
                                yilani_uzat();
                            }
                        }
                        
                        private void yilani_uzat() {
                            Point[] klon = new Point[uzunluk];
                            klon = yilan;
                            uzunluk++;
                            yilan = new Point[uzunluk];
                            
                            for(int yubo=0;yubo<=(klon.length-1);yubo++)
                            {
                                yilan[yubo]=klon[yubo];
                            }
                            
                            yilan[yilan.length-1] = new Point(yilan[yilan.length-2].x, yilan[yilan.length-2].y);
                        }
                        
                        private boolean carpisma_kontrol() {
                            if(yilan[0].x < boyut || yilan[0].y < boyut || yilan[0].x > genislik - (boyut * 3) || yilan[0].y > yukseklik - (boyut * 6)) {
                                bitti = 1;
                                return true;
                            }
                            for(int i = 0; i < yilan.length; i++) {
                                if(yilan[i].x == yilan[0].x && yilan[i].y == yilan[0].y && i != 0) {
                                    bitti = 2;
                                    return true;
                                }
                            }
                            return false;
                        }
                    };
			
			t = new Timer(hiz, gorev);
		}
		
                @Override
		public void paint(Graphics g) {
			Graphics2D gr = (Graphics2D) g;
			gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if(intro) {
				gr.setColor(new Color(200, 200, 100));
				gr.fillRect(0, 0, genislik, yukseklik);
				gr.setColor(Color.BLACK);
				gr.setFont(new Font("tahoma", 1, 80));
				gr.drawString("YILANSIIN KARDEŞİM\n ",100, 100);
				gr.setFont(new Font("tahoma", 10, 13));
				gr.drawString("Yılan Oyununa Hoşgeldin Başlamak İçin ENTER'a Bas!", 60, 250);
                                return;
			}
			if(bitti != 0) {
				gr.setColor(new Color(200, 200, 150, 170));
				gr.fillRect(0, 0, genislik, yukseklik);
				gr.setColor(Color.BLACK);
				gr.setFont(new Font("tahoma", 1, 25));
				if(bitti == 2) {
					gr.drawString("Kendini Yedin Dostum!", 150, 150);
					gr.setFont(new Font("tahoma", 1, 13));
					gr.drawString(puan + " Puan Toplayabildin.", 100, 100);
				} else {
					gr.drawString("YANDIN!", 75, 130);
					gr.setFont(new Font("tahoma", 1, 13));
					gr.drawString(puan + " Puan Toplayabildin.", 100, 100);
				}
				
				gr.setFont(new Font("tahoma", 1, 10));
				gr.drawString("Yeniden Oynamak için ENTER'a bas.", 150, 150);
				return;
			}
			
			gr.setColor(new Color(150, 150, 60));
			gr.fillRect(10, 10, genislik, yukseklik);
                        gr.setColor(Color.ORANGE);
			gr.drawRect(boyut, boyut, genislik - (boyut * 3) - 1, yukseklik - (boyut * 6) - 1);
			gr.setFont(new Font("Tahoma", 0, 11));
			gr.drawString("Puan: " + puan, 10, 465);
                    for (Point yilan1 : yilan) {
                        gr.drawRect(yilan1.x, yilan1.y, boyut, boyut);
                    }
 
			gr.fillOval(yem.x, yem.y, boyut, boyut);
			if(bekle) {
				gr.setColor(new Color(120, 120, 100, 190));
				gr.fillRect(0, 0, genislik, yukseklik);
				gr.setColor(Color.RED);
				gr.setFont(new Font("tahoma", 1, 25));
				gr.drawString("Oyuna Devam Et.", 50, 150);
				gr.setFont(new Font("tahoma", 1, 13));
				gr.drawString("Devam etmek için p tuşuna bas!", 50, 170);
				
			}
		}
	}
}