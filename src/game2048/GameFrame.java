package game2048;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameFrame{
	private JLabel[][] label = new JLabel[4][4];
	private Function function = new Function();;
	private JLabel maxScoreLabel = null;
	private JTextField maxScoreText = null;
	private JTextField recentScore = null;
	private JLabel tips = null;
	private Font font = new Font("", Font.BOLD,14);			//�����������ͺʹ�С
	private Font font2 = new Font("", Font.BOLD,30);
	
	JButton resetButton = null;
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
				label[i][j].setOpaque(true);//���ÿ����޸ı�����ɫ
				label[i][j].setText("");
				label[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));//���÷���߿���ɫ
				mainPanel.add(label[i][j]);
			}
		}
		c.add(mainPanel);
		
		JPanel tipPanel = new JPanel();
		tipPanel.setBounds(0,540,500,20);
		tipPanel.setLayout(null);
		tips = new JLabel("Tips��ʹ���ϡ��¡����Ҽ�����W��S��A��D������");//��ʾ��ǩ
		tips.setBounds(20,0,350,20);
		resetButton = new JButton("���¿�ʼ!");
		resetButton.setBounds(375,0,100,20);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        init();
			}
		});
		tipPanel.add(tips);
		tipPanel.add(resetButton);
		c.add(tipPanel);
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
				if(function.data[i][j] != 0){
					label[i][j].setText(String.valueOf(function.data[i][j]));
				}
				else
					label[i][j].setText("");
				setColor(i,j,function.data[i][j]);
			}
		}
		recentScore.setText(String.valueOf(function.maxScore));
		maxScoreText.grabFocus();//���»�ȡ���㣬Ҫ��������ܻᵽ��ť����
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
				if(function.data[i][j] != 0){
					label[i][j].setText(String.valueOf(function.data[i][j]));
					
				}
				else
					label[i][j].setText("");
				setColor(i,j,function.data[i][j]);
			}
		}
		
	}
	public void moveRight() {
		if(function.moveRight()==false) return;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0){
					label[i][j].setText(String.valueOf(function.data[i][j]));
					
				}
				else
					label[i][j].setText("");
				setColor(i,j,function.data[i][j]);
			}
		}
	}
	public void moveUp() {
		if(function.moveUp()==false) return ;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0){
					label[i][j].setText(String.valueOf(function.data[i][j]));
					
				}
				else
					label[i][j].setText("");
				setColor(i,j,function.data[i][j]);
			}
		}
	}
	public void moveDown() {
		if(function.moveDown()==false) return ;
		if(function.rand()==false) tips.setText("                          GAME��OVER ��");
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(function.data[i][j] != 0){
					label[i][j].setText(String.valueOf(function.data[i][j]));
					
				}
				else
					label[i][j].setText("");
				setColor(i,j,function.data[i][j]);
			}
		}
	}
	
	/*
	 * ������ɫ
	 */
	public void setColor(int i,int j,int shu) {
		switch(shu) {
		case 2:
			label[i][j].setBackground(Color.yellow);
			break;
		case 4:
			label[i][j].setBackground(Color.red);
			break;
		case 8:
			label[i][j].setBackground(Color.pink);
			break;
		case 16:
			label[i][j].setBackground(Color.orange);
			break;
		case 32:
			label[i][j].setBackground(Color.magenta);
			break;
		case 64:
			label[i][j].setBackground(Color.LIGHT_GRAY);
			break;
		case 128:
			label[i][j].setBackground(Color.green);
			break;
		case 256:
			label[i][j].setBackground(Color.gray);
			break;
		case 512:
			label[i][j].setBackground(Color.DARK_GRAY);
			break;
		case 1024:
			label[i][j].setBackground(Color.cyan);
			break;
		case 2048:
			label[i][j].setBackground(Color.blue);
			break;
		case 0:
		case 4096:
			label[i][j].setBackground(Color.white);
			break;
		default:
			break;
		}
	}
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					new GameFrame();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
	}
}
