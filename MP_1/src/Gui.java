import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JPanel {
	public JPanel[] mainPanel = new JPanel[2];
	public JPanel bgPanel;
	public JButton[] buttons = new JButton[10];
	public ImageIcon[] buttonsIcon = new ImageIcon[10];
	public JButton[] operations = new JButton[7];
	public ImageIcon[] operationsIcon = new ImageIcon[7];
	public static JTextArea[] textArea = new JTextArea[3];
	public JLabel[] labels = new JLabel[3];
	public JButton enter;
	public JButton credits;
	public ImageIcon creditsIcon;
	public ImageIcon enterIcon;
	public JPanel snapShot = new JPanel();
	public JLabel number = new JLabel("NUMBER");
	public JLabel operator = new JLabel("OPERATOR");
	public JLabel[] snapTitle = new JLabel[4];
	public String[] snapString = {"STACK", "QUEUE", "PSEUDOARRAY", "STACK"};
	public static JTextArea[] table = new JTextArea[4];
	public String input = "";
	private ButtonHandler bh = new ButtonHandler(); 
	public boolean openPressed = false;
	public JScrollPane[] scroll = new JScrollPane[4];
	public static JButton refreshButton;
	public ImageIcon refreshIcon;
	public boolean isRefreshed = true;
	public JButton dot;
	public ImageIcon dotIcon;
	
	public Gui(){
		
		bgPanel = new JPanel();
		bgPanel.setBackground(new Color(41, 214, 180));
		bgPanel.setLayout(new GridLayout(2,1,10,10));
		bgPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bgPanel.setPreferredSize(new Dimension(1200,600));
		this.setPreferredSize(new Dimension(1200,600));
		this.add(bgPanel);
		
		bgPanel.setLayout(null);
		
		buttonsIcon[0] = new ImageIcon("src/images/0.png");
		buttons[0] = new JButton(buttonsIcon[0]);
		buttons[0].setBounds(70,305,60,60);
		buttons[0].addActionListener(bh);
		bgPanel.add(buttons[0]);
		
		buttonsIcon[1] = new ImageIcon("src/images/1.png");
		buttons[1] = new JButton(buttonsIcon[1]);
		buttons[1].setBounds(140,305,60,60);
		buttons[1].addActionListener(bh);
		bgPanel.add(buttons[1]);
		
		buttonsIcon[2] = new ImageIcon("src/images/2.png");
		buttons[2] = new JButton(buttonsIcon[2]);
		buttons[2].setBounds(210,305,60,60);
		buttons[2].addActionListener(bh);
		bgPanel.add(buttons[2]);
		
		buttonsIcon[3] = new ImageIcon("src/images/3.png");
		buttons[3] = new JButton(buttonsIcon[3]);
		buttons[3].setBounds(70,373,60,60);
		buttons[3].addActionListener(bh);
		bgPanel.add(buttons[3]);
		
		buttonsIcon[4] = new ImageIcon("src/images/4.png");
		buttons[4] = new JButton(buttonsIcon[4]);
		buttons[4].setBounds(140,373,60,60);
		buttons[4].addActionListener(bh);
		bgPanel.add(buttons[4]);
		
		buttonsIcon[5] = new ImageIcon("src/images/5.png");
		buttons[5] = new JButton(buttonsIcon[5]);
		buttons[5].setBounds(210,373,60,60);
		buttons[5].addActionListener(bh);
		bgPanel.add(buttons[5]);
		
		buttonsIcon[6] = new ImageIcon("src/images/6.png");
		buttons[6] = new JButton(buttonsIcon[6]);
		buttons[6].setBounds(70,440,60,60);
		buttons[6].addActionListener(bh);
		bgPanel.add(buttons[6]);
		
		buttonsIcon[7] = new ImageIcon("src/images/7.png");
		buttons[7] = new JButton(buttonsIcon[7]);
		buttons[7].setBounds(140,440,60,60);
		buttons[7].addActionListener(bh);
		bgPanel.add(buttons[7]);
		
		buttonsIcon[8] = new ImageIcon("src/images/8.png");
		buttons[8] = new JButton(buttonsIcon[8]);
		buttons[8].setBounds(210,440,60,60);
		buttons[8].addActionListener(bh);
		bgPanel.add(buttons[8]);
		
		operationsIcon[0] = new ImageIcon("src/images/plus.png");
		operations[0] = new JButton(operationsIcon[0]);
		operations[0].setBounds(325,305,60,60);
		operations[0].addActionListener(bh);
		bgPanel.add(operations[0]);
		
		operationsIcon[1] = new ImageIcon("src/images/minus.png");
		operations[1] = new JButton(operationsIcon[1]);
		operations[1].setBounds(395,305,60,60);
		operations[1].addActionListener(bh);
		bgPanel.add(operations[1]);
		
		operationsIcon[2] = new ImageIcon("src/images/times.png");
		operations[2] = new JButton(operationsIcon[2]);
		operations[2].setBounds(465,305,60,60);
		operations[2].addActionListener(bh);
		bgPanel.add(operations[2]);
		
		operationsIcon[3] = new ImageIcon("src/images/divide.png");
		operations[3] = new JButton(operationsIcon[3]);
		operations[3].setBounds(325,373,60,60);
		operations[3].addActionListener(bh);
		bgPanel.add(operations[3]);
		
		operationsIcon[4] = new ImageIcon("src/images/open.png");
		operations[4] = new JButton(operationsIcon[4]);
		operations[4].setBounds(395,373,60,60);
		operations[4].addActionListener(bh);
		bgPanel.add(operations[4]);
		
		operationsIcon[5] = new ImageIcon("src/images/close.png");
		operations[5] = new JButton(operationsIcon[5]);
		operations[5].setBounds(465,373,60,60);
		operations[5].addActionListener(bh);
		operations[5].setEnabled(false);
		bgPanel.add(operations[5]);
		
		buttonsIcon[9] = new ImageIcon("src/images/9.png");
		buttons[9] = new JButton(buttonsIcon[9]);
		buttons[9].setBounds(325,440,60,60);
		buttons[9].addActionListener(bh);
		bgPanel.add(buttons[9]);
		
		operationsIcon[6] = new ImageIcon("src/images/clear.png");
		operations[6] = new JButton(operationsIcon[6]);
		operations[6].setBounds(465,440,60,60);
		operations[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!input.equals("")){
					String temp = input;
					temp = temp.substring(0,temp.length()-1);
					input = temp;
					textArea[0].setText(input);
				}else{
					textArea[0].setText("Clear Operation Unavailable!");
				}
			}
		});
		bgPanel.add(operations[6]);
		
		dotIcon = new ImageIcon("src/images/dot.png");
		dot = new JButton(dotIcon);
		dot.setBounds(395,440,60,60);
		dot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(isRefreshed){
					enter.setEnabled(true);
					input+=".";
					textArea[0].setText(input);
				}else{
					input = "Reset your expression by clicking the reset button.";
					textArea[0].setText(input);
				}
			}
		});
		bgPanel.add(dot);
		
		labels[0] = new JLabel("INPUT INFIX EXPRESSION: ");
		labels[0].setFont(new Font("Impact", Font.ITALIC, 25));
		labels[0].setForeground(new Color(255,255,255));
		labels[0].setBounds(170,15,300,30);
		bgPanel.add(labels[0]);
		
		textArea[0] = new JTextArea();
		textArea[0].setBounds(20,50,555,40);
		textArea[0].setFont(new Font("Serif", Font.BOLD, 20));
		//textArea[0].setBackground(new Color(187, 247, 188));
		textArea[0].setEditable(false);
		bgPanel.add(textArea[0]);
		
		snapShot.setPreferredSize(new Dimension(800,500));
		snapShot.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		snapShot.setBounds(600, 30, 550, 500);
		snapShot.setBackground(new Color(0,0,0,0));
		bgPanel.add(snapShot);
		
		/*snapArea.setEditable(false);
		snapShot.add(snapArea);*/
		
		for(int a = 0;a<4;a++){
			snapTitle[a] = new JLabel(snapString[a]);
			snapTitle[a].setFont(new Font("Impact", Font.ITALIC, 15));
			snapTitle[a].setForeground(new Color(255,255,255));		
		}
		
		snapShot.setLayout(null);
		
		number.setFont(new Font("Impact", Font.ITALIC, 25));
		number.setForeground(new Color(255,255,255));
		number.setBounds(400,5,100,35);
		snapShot.add(number);
		

		operator.setFont(new Font("Impact", Font.ITALIC, 25));
		operator.setForeground(new Color(255,255,255));
		operator.setBounds(140,5,120,35);
		snapShot.add(operator);
		
		snapTitle[0].setBounds(55,35,100,20);
		snapShot.add(snapTitle[0]);
		
		snapTitle[1].setBounds(158,35,100,20);
		snapShot.add(snapTitle[1]);
		
		snapTitle[2].setBounds(245,35,100,20);
		snapShot.add(snapTitle[2]);
		
		snapTitle[3].setBounds(420,35,200,20);
		snapShot.add(snapTitle[3]);
		
		for(int b = 0;b<4;b++){
			table[b] = new JTextArea(100,100);
			table[b].setPreferredSize(new Dimension(100, 440));
			table[b].setBorder(BorderFactory.createLineBorder(Color.WHITE));
			table[b].setEditable(false);
			table[b].setLineWrap(true);
			table[b].setFont(new Font("Serif", Font.BOLD, 20));
			scroll[b] = new JScrollPane(table[b] );
			scroll[b].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS) ;
		}
		
		scroll[0].setBounds(30, 60, 90, 435);
		snapShot.add(scroll[0]);
		
		scroll[1].setBounds(135, 60, 90, 435);
		snapShot.add(scroll[1]);
		
		scroll[2].setBounds(245, 60, 90, 435);
		snapShot.add(scroll[2]);
		
		scroll[3].setBounds(380, 60, 130, 435 );
		snapShot.add(scroll[3]);
		enter = new JButton("ENTER");
		enter.setBounds(200,95,100,35);
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				isRefreshed = false;
				boolean valid = getValidExpression(input);
				if(valid){
					ThreadTry tt = new ThreadTry();
					Thread2 th= new Thread2();
					
					InfixToPostFixs theTrans = new InfixToPostFixs(input); 
					String output = theTrans.convertInToPost(); 
					tt.myPostfix=output;
					
					PostFixEvaluation aParser = new PostFixEvaluation(output);
					double output1 = aParser.checkStr(); 
					tt.myExp=""+output1;
					th.start();
					tt.start();
				}else{
					operations[5].setEnabled(false);
					textArea[0].setText("SYNTAX ERROR!");
					enter.setEnabled(false);
				}
				
				enter.setEnabled(false);
			}
		});
		enter.setEnabled(false);
		bgPanel.add(enter);
		
		refreshButton = new JButton("RESET");
		refreshButton.setBounds(300,95,100,35);
		refreshButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				isRefreshed = true;
				enter.setEnabled(false);
				if(!input.equals("")){
					input = "";
					textArea[0].setText(input);
					textArea[1].setText("");
					textArea[2].setText("");
					table[0].setText("");
					table[1].setText("");
					table[2].setText("");
					table[3].setText("");
					
					InfixToPostFixs.strs= new PseudoArray(50);
					InfixToPostFixs.strsCount=0;
					InfixToPostFixs.infix="";
					InfixToPostFixs.post="";
					
				}else{
					textArea[0].setText("Reset Operation Unavailable!");
				}
			}
		});
		bgPanel.add(refreshButton);
		
		
		labels[1] = new JLabel("EQUIVALENT POSTFIX EXPRESSION: ");
		labels[1].setFont(new Font("Impact", Font.ITALIC, 25));
		labels[1].setForeground(new Color(255,255,255));
		labels[1].setBounds(140,130,340,30);
		bgPanel.add(labels[1]);
		
		textArea[1] = new JTextArea();
		textArea[1].setBounds(20,165,555,40);
		textArea[1].setFont(new Font("Serif", Font.BOLD, 20));
		//textArea[1].setBackground(new Color(187, 247, 188));
		textArea[1].setEditable(false);
		bgPanel.add(textArea[1]);
		
		labels[2] = new JLabel("ANSWER: ");
		labels[2].setFont(new Font("Impact", Font.ITALIC, 25));
		labels[2].setForeground(new Color(255,255,255));
		labels[2].setBounds(180,210,100,30);
		bgPanel.add(labels[2]);
		
		textArea[2] = new JTextArea();
		textArea[2].setBounds(290,210,200,40);
		textArea[2].setFont(new Font("Serif", Font.BOLD, 20));
		//textArea[2].setBackground(new Color(187, 247, 188));
		textArea[2].setEditable(false);
		bgPanel.add(textArea[2]);
		
		creditsIcon = new ImageIcon("src/images/ButtonCredits.png");
		credits = new JButton(creditsIcon);
		credits.setBounds(50,520,95,27);
		credits.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog d = new JDialog();
				JPanel p = new CreditsBgPanel();
				d.add(p);
				d.setVisible(true);
				d.setSize(800,450);
				d.setLocationRelativeTo(bgPanel);
				ImageIcon icon = new ImageIcon("src/images/icon.png");
				Image logo = icon.getImage();
				d.setIconImage(logo);
			}
		});
		//bgPanel.add(credits);
		
	}
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			enter.setEnabled(true);
			if(isRefreshed){
			if(e.getSource() == buttons[0]){
				input += "0";
				textArea[0].setText(input);
				
			}else if(e.getSource() == buttons[1]){
				input += "1";
				textArea[0].setText(input);
			
			}else if(e.getSource() == buttons[2]){
				input += "2";
				textArea[0].setText(input);
				
			}else if(e.getSource() == buttons[3]){
				input += "3";
				textArea[0].setText(input);
				
			}else if(e.getSource() == buttons[4]){
				input += "4";
				textArea[0].setText(input);
				
			}else if(e.getSource() == buttons[5]){
				input += "5";
				textArea[0].setText(input);
				
			}else if(e.getSource() == buttons[6]){
				input += "6";
				textArea[0].setText(input);
			}else if(e.getSource() == buttons[7]){
				input += "7";
				textArea[0].setText(input);
			}else if(e.getSource() == buttons[8]){
				input += "8";
				textArea[0].setText(input);
			}else if(e.getSource() == buttons[9]){
				input += "9";
				textArea[0].setText(input);
			}else if(e.getSource() == operations[0]){
				input += "+";
				textArea[0].setText(input);
			}else if(e.getSource() == operations[1]){
				input += "-";
				textArea[0].setText(input);
			}else if(e.getSource() == operations[2]){
				input += "*";
				textArea[0].setText(input);
			}else if(e.getSource() == operations[3]){
				input += "/";
				textArea[0].setText(input);
			}else if(e.getSource() == operations[4]){
				input += "(";
				operations[5].setEnabled(true);
				textArea[0].setText(input);
			}else if(e.getSource() == operations[5]){
				input += ")";
				textArea[0].setText(input);
			}
			}else{
				input = "Reset your expression by clicking the reset button.";
				textArea[0].setText(input);
			}
		}
	}
	public boolean getValidExpression(String s){
		int len = s.length();
		String temp = "";
		String before = "";
		boolean isValid = true;
		String[] par = {"(", ")"};
		int open = 0;
		int close = 0;
		try{
			for(int i = 0;i<len;i++){
				if(s.substring(i,i+1).equals(par[0])){
					open++;
				}else if(s.substring(i,i+1).equals(par[1])){
					close++;
				}	
			}
			if(close == open){
				for(int a = 0;a<len;a++){
					temp = s.substring(a,a+1);
					if(a == 0){
						if((!Character.isDigit(temp.charAt(0)) && !temp.equals("(")) || temp.equals(")") || (temp.equals("(") && s.substring(a+1,a+2).equals(")"))){
							isValid = false;
							break;
						}
					}else if(a==len-1){
						String before2 =  s.substring(a-1,a);
						if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")){
							isValid = false;
							break;
						}else if(temp.equals(".")){
							isValid = false;
							break;
						}else if(temp.equals(")") && (before2.equals("+") ||before2.equals("-") || before2.equals("*")||before2.equals("/") ) ){
							isValid = false;
							break;
						}
					}else{
						before = s.substring(a-1,a);
						if(!Character.isDigit(s.substring(a,a+1).charAt(0))){
							if((temp.equals(par[1])) && Character.isDigit(before.charAt(0))){
								isValid = true;
							}else if((temp.equals(par[0])) && Character.isDigit(before.charAt(0)) ){
								isValid = false;
								break;
						
							}else if((temp.equals(par[1])) && before.equals(par[0])){
								isValid = false; break;
							}else if((temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) &&(before.equals("+") || before.equals("-") || before.equals("*") || before.equals("/")) ){
					
								isValid = false;
								break;
							}else if((temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) && before.equals("(")){
								isValid = false;
								break;
							}else if(temp.equals(".") && (!Character.isDigit(before.charAt(0)) )){
								System.out.println("473");
								isValid = false;
								break;
							}else if(temp.equals(".") && (!Character.isDigit(s.substring(a+1,a+2).charAt(0)))){
								isValid = false;
								System.out.println("478");
								break;
							}else if(temp.equals(".") && s.substring(a+2,a+3).equals(".")){
								isValid = false;
								System.out.println("482");
								break;
							}
						}else if(Character.isDigit(s.substring(a,a+1).charAt(0))){
							if(before.equals(par[1])){
								isValid = false;
								break;
							}
						}
					}
				}
			}else{
				isValid = false;
			}
		}catch(Exception e){
			isValid = false;
		}
		
		return isValid;
	}
	/* class BackgroundPanel extends JPanel {
		    Image backgroundImage = new ImageIcon("src/images/crazBack.png").getImage();
		    public void paintComponent(Graphics g) {
		      g.drawImage(backgroundImage, 0, 0,getWidth(), getHeight(), this);
		    }
	 }*/
	 class CreditsBgPanel extends JPanel {
		    Image backgroundImage = new ImageIcon("src/images/creditsBg.jpg").getImage();
		    public void paintComponent(Graphics g) {
		      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		    }
	 }
	 
}
