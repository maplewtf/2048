package game2048;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameFrame{
	private JLabel[][] label = new JLabel[4][4];
	private Function function = null;
	private JLabel maxScoreLabel = null;
	private JTextField maxScoreText = null;
	private JTextField recentScore = null;
	private JLabel tips = null;
	private Font font = new Font("", Font.BOLD,14);			//�����������ͺʹ�С
	private Font font2 = new Font("", Font.BOLD,30);
	public GameFrame(){
		
		JFrame jf = new JFrame();
		//jf.setSize(WIDTH,HEIGH);
		jf.setBounds(500, 50, 500, 600);
		
		Container c = jf.getContentPane();//������
		c.setLayout(null);
		
		JPanel scorePanel = new JPanel();//������ķ������
		scorePanel.setBounds(0, 0, 500, 40);
		scorePanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		scorePanel.setLayout(null);
		c.add(scorePanel);
		
		maxScoreLabel = new JLabel("��߷�:");//��߷ֱ�ǩ
		maxScoreLabel.setBounds(10,5,50,30);
		scorePanel.add(maxScoreLabel);
		
		maxScoreText = new JTextField("�ݲ�����");//�÷ֱ�ǩ
		maxScoreText.setBounds(60, 5, 150, 30);
		maxScoreText.setEditable(false);
		scorePanel.add(maxScoreText);
		
		JLabel recentScoreLabel = new JLabel("��ǰ����:");
		recentScoreLabel.setBounds(240, 5, 60, 30);
		scorePanel.add(recentScoreLabel);
		
		recentScore = new JTextField();
		recentScore.setBounds(300, 5, 150, 30);
		recentScore.setEditable(false);
		scorePanel.add(recentScore);
		
		JPanel mainPanel = new JPanel();//��ʾ�������
		mainPanel.setBounds(0,40,500,500);
		mainPanel.setLayout(new GridLayout(4,4));
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				label[i][j] = new JLabel();
				label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				label[i][j].setFont(font2);
				label[i][j].setText("");
				label[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));//���÷���߿���ɫ
				mainPanel.add(label[i][j]);
			}
		}
		c.add(mainPanel);
		
		tips = new JLabel("Tips��ʹ���ϡ��¡����Ҽ�����W��S��A��D������");//��ʾ��ǩ
		tips.setBounds(20,540,500,20);
		c.add(tips);
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		function = new Function();
		init();
		maxScoreText.addKeyListener(new KeyAdapter(){//Ϊ��߷ֱ�ǩ��Ӱ���������
			public void keyPressed(KeyEvent e){
				 doKeyPressed(e);  //��������
			}
		});
		
		
	}
	
	public void init() {
		function.initGame();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0)
					label[i][j].setText(String.valueOf(function.data[i][j]));
				else
					label[i][j].setText("");
			}
		}
		recentScore.setText(String.valueOf(function.maxScore));
	}
	
	public void doKeyPressed(KeyEvent e) {  //�жϰ������ƶ�
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			moveLeft();
		}
		else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
			moveRight();
		}
		else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
			moveDown();
		}
		else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
			moveUp();
		}
		recentScore.setText(String.valueOf(function.maxScore));
	}
	
	public void moveLeft() {
		if(function.moveLeft()==false) return ;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0)
					label[i][j].setText(String.valueOf(function.data[i][j]));
				else
					label[i][j].setText("");
			}
		}
		
	}
	public void moveRight() {
		if(function.moveRight()==false) return;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0)
					label[i][j].setText(String.valueOf(function.data[i][j]));
				else
					label[i][j].setText("");
			}
		}
	}
	public void moveUp() {
		if(function.moveUp()==false) return ;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0)
					label[i][j].setText(String.valueOf(function.data[i][j]));
				else
					label[i][j].setText("");
			}
		}
	}
	public void moveDown() {
		if(function.moveDown()==false) return ;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0)
					label[i][j].setText(String.valueOf(function.data[i][j]));
				else
					label[i][j].setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}
