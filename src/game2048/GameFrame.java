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
	
	private JLabel tips = null;
	private Font font = new Font("", Font.BOLD,14);			//设置字体类型和大小
	private Font font2 = new Font("", Font.BOLD,30);
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
		
		JLabel maxScoreLabel = new JLabel("最高分:");//最高分标签
		maxScoreLabel.setBounds(10,5,50,30);
		scorePanel.add(maxScoreLabel);
		
		JTextField maxScoreText = new JTextField("暂不可用");//得分标签
		maxScoreText.setBounds(60, 5, 150, 30);
		maxScoreText.setEditable(false);
		scorePanel.add(maxScoreText);
		
		
		JPanel mainPanel = new JPanel();//显示方块面板
		mainPanel.setBounds(0,40,500,500);
		mainPanel.setLayout(new GridLayout(4,4));
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				label[i][j] = new JLabel();
				label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				label[i][j].setFont(font2);
				label[i][j].setText("");
				label[i][j].setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));//设置方块边框颜色
				mainPanel.add(label[i][j]);
			}
		}
		c.add(mainPanel);
		
		tips = new JLabel("Tips：使用上、下、左、右键或者W、S、A、D键控制");
		tips.setBounds(20,540,500,20);
		c.add(tips);
		
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		function = new Function();
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
				if(function.data[i][j] != 0)
					label[i][j].setText(String.valueOf(function.data[i][j]));
				else
					label[i][j].setText("");
			}
		}
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
	}
	
	public void moveLeft() {
		function.moveLeft();
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
		function.moveRight();
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
		function.moveUp();
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
		function.moveDown();
		if(function.rand()==false) tips.setText("                          GAME　OVER ！");
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
