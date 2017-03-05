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
	private Font font = new Font("", Font.BOLD,14);			//设置字体类型和大小
	private Font font2 = new Font("", Font.BOLD,30);
	
	JButton resetButton = null;
	public GameFrame(){
		
		JFrame jf = new JFrame();
		//jf.setSize(WIDTH,HEIGH);
		jf.setBounds(500, 50, 500, 600);
		
		Container c = jf.getContentPane();//主容器
		c.setLayout(null);
		
		JPanel scorePanel = new JPanel();//最上面的分数面板
		scorePanel.setBounds(0, 0, 500, 40);
		scorePanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		scorePanel.setLayout(null);
		c.add(scorePanel);
		
		maxScoreLabel = new JLabel("最高分:");//最高分标签
		maxScoreLabel.setBounds(10,5,50,30);
		scorePanel.add(maxScoreLabel);
		
		maxScoreText = new JTextField("暂不可用");//得分标签
		maxScoreText.setBounds(60, 5, 150, 30);
		maxScoreText.setEditable(false);
		scorePanel.add(maxScoreText);
		
		JLabel recentScoreLabel = new JLabel("当前分数:");
		recentScoreLabel.setBounds(240, 5, 60, 30);
		scorePanel.add(recentScoreLabel);
		
		recentScore = new JTextField();
		recentScore.setBounds(300, 5, 150, 30);
		recentScore.setEditable(false);
		scorePanel.add(recentScore);
		
		JPanel mainPanel = new JPanel();//显示方块面板
		mainPanel.setBounds(0,40,500,500);
		mainPanel.setLayout(new GridLayout(4,4));
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				label[i][j] = new JLabel();
				label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				label[i][j].setFont(font2);
				label[i][j].setOpaque(true);//设置可以修改背景颜色
				label[i][j].setText("");
				label[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));//设置方块边框颜色
				mainPanel.add(label[i][j]);
			}
		}
		c.add(mainPanel);
		
		JPanel tipPanel = new JPanel();
		tipPanel.setBounds(0,540,500,20);
		tipPanel.setLayout(null);
		tips = new JLabel("Tips：使用上、下、左、右键或者W、S、A、D键控制");//提示标签
		tips.setBounds(20,0,350,20);
		resetButton = new JButton("重新开始!");
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
		maxScoreText.addKeyListener(new KeyAdapter(){//为最高分标签添加按键监听器
			public void keyPressed(KeyEvent e){
				 doKeyPressed(e);  //按键动作
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
		maxScoreText.grabFocus();//重新获取焦点，要不焦点可能会到按钮那里
	}
	
	public void doKeyPressed(KeyEvent e) {  //判断按键并移动
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
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
	 * 设置颜色
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
