import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calculator extends JFrame implements ActionListener
{
   private final static Dimension SCREEN_DIM = Toolkit.getDefaultToolkit().getScreenSize();
   private final static Point CENTER_OF_SCREEN = new Point(SCREEN_DIM.width/2,SCREEN_DIM.height/2);
   
   private JTextField display = new JTextField();
   private JButton btn1 = new JButton("1");
   private JButton btn2 = new JButton("2");
   private JButton btn3 = new JButton("3");
   private JButton btn4 = new JButton("4");
   private JButton btn5 = new JButton("5");
   private JButton btn6 = new JButton("6");
   private JButton btn7 = new JButton("7");
   private JButton btn8 = new JButton("8");
   private JButton btn9 = new JButton("9");
   private JButton btn0 = new JButton("0");
   private JButton btnDec = new JButton(".");
   private JButton btnEqual = new JButton("=");
   private JButton btnDiv = new JButton("/");
   private JButton btnMult = new JButton("*");
   private JButton btnMin = new JButton("-");
   private JButton btnAdd = new JButton("+");
   private JPanel btnPnl = new JPanel(new GridLayout(4,4));
   private JPanel bottomPnl = new JPanel(new BorderLayout());
   private JMenuBar jbar = new JMenuBar();
   private JButton clear = new JButton("Clear");
   private JLabel operator = new JLabel();
   
   private ArrayList<Double> argsArr = new ArrayList<Double>();
   private ArrayList<String> opArr = new ArrayList<String>();
   
   private boolean equalJustPressed = false;
   
   public Calculator() //constructor
   {
      setLayout(new BorderLayout());
      display.setEditable(false);
      display.setFont(new Font("Alarm Clock",Font.BOLD,20));
      display.setHorizontalAlignment(JTextField.RIGHT);
      display.setBackground(Color.DARK_GRAY);
      display.setForeground(Color.GREEN.darker());
      operator.setHorizontalAlignment(JLabel.CENTER);
      setTitle("Calculator");
      
      btnPnl.add(btn1);
      btnPnl.add(btn2);
      btnPnl.add(btn3);
      btnPnl.add(btnMult);
      btnPnl.add(btn4);
      btnPnl.add(btn5);
      btnPnl.add(btn6);
      btnPnl.add(btnDiv);
      btnPnl.add(btn7);
      btnPnl.add(btn8);
      btnPnl.add(btn9);
      btnPnl.add(btnMin);
      btnPnl.add(btnDec);
      btnPnl.add(btn0);
      btnPnl.add(btnEqual);
      btnPnl.add(btnAdd);
      
      bottomPnl.add(clear,BorderLayout.CENTER);
      bottomPnl.add(operator,BorderLayout.EAST);
      
      add(display,BorderLayout.NORTH);
      add(btnPnl,BorderLayout.CENTER);
      add(bottomPnl,BorderLayout.SOUTH);
      
      clear.addActionListener(this);
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);
      btn4.addActionListener(this);
      btn5.addActionListener(this);
      btn6.addActionListener(this);
      btn7.addActionListener(this);
      btn8.addActionListener(this);
      btn9.addActionListener(this);
      btn0.addActionListener(this);
      btnDec.addActionListener(this);
      btnEqual.addActionListener(this);
      btnMult.addActionListener(this);
      btnDiv.addActionListener(this);
      btnMin.addActionListener(this);
      btnAdd.addActionListener(this);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      operator.setPreferredSize(new Dimension(btn0.getWidth()*5/4+1,clear.getHeight()));
      setSize(getWidth()*5/4,getHeight()*5/4);
      setLocation(CENTER_OF_SCREEN.x-getWidth()/2,CENTER_OF_SCREEN.y-getHeight()/2);
      setVisible(true);
   }
   
   public String getFormattableString() //method
   {
//       String[] sciNotArr = display.getText().split("E");
      String formattableStr = "";
//       if(!display.getText().contains("E"))
//       {
         for(char c:display.getText().toCharArray())
            if(!new Character(c).equals(new Character(',')))formattableStr+=c;
//       }
//       else display.setText(new Double(Double.parseDouble(sciNotArr[0])*Math.pow(10,Double.parseDouble(sciNotArr[1]))).toString());
      return formattableStr;
   }
   
   public void formatDisplay() //method
   {
      if(display.getText().length()>0&&(operator.getText().equals("")||operator.getText().equals("=")))
      {
         display.setText(display.getText()+" ");
         String[] displayArr = display.getText().split("\\.");
         if(displayArr.length > 0)
         {
            String wholeNums = displayArr[0];
            String remainder = "";
            if(displayArr.length>1)remainder += "."+displayArr[1];
            wholeNums = String.format("%,.0f",Double.parseDouble(wholeNums.split(" ")[0]));
            remainder = remainder.split(" ")[0];
            if(wholeNums.length()+remainder.length()>15&&!remainder.contains("E")) //decimals only
            {
               if(remainder.length()>1)
               {
                  remainder = remainder.substring(0,16-wholeNums.length());
                  if(Integer.parseInt(new Character(remainder.charAt(remainder.length()-1)).toString())>4)
                  {
                     remainder = remainder.substring(0,remainder.length()-2)
                                 +new Integer(Integer.parseInt(new Character(remainder.charAt(remainder.length()-2)).toString())+1).toString();
                  }
               }
            }
            if(wholeNums.length()+remainder.length()>15) //whole numbers only
            {
               display.setText(String.format("%.5E",Double.parseDouble(wholeNums+remainder)));
            }
            else display.setText(wholeNums+remainder);
         }
         else display.setText(String.format("%,d",Integer.parseInt(display.getText().split(" ")[0])));
      }
   }
   
   public void actionPerformed(ActionEvent e) //inherited method from ActionListener
   {
      if(e.getSource()==clear)
      {
         display.setText("");
         argsArr = new ArrayList<Double>();
         opArr = new ArrayList<String>();
         operator.setText("");
      }

      if(e.getSource()==btn1)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn2)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn3)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn4)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn5)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn6)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn7)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn8)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn9)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btn0)
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btnDec&&(!display.getText().contains(".")||operator.getText().contains("=")||operator.getText().contains("*")||operator.getText().contains("/")||operator.getText().contains("+")||operator.getText().contains("-")))
      {
         if(display.getText().length()>14&&operator.getText().equals(""))
            return;
         display.setText(getFormattableString());
         if(equalJustPressed)display.setText("");
         equalJustPressed = false;
         if(!operator.getText().equals("")&&!operator.getText().equals("="))
         {
            argsArr.add(Double.parseDouble(display.getText()));
            opArr.add(operator.getText());
            display.setText("");
         }
         if(display.getText().length()==0)display.setText("0");
         display.setText(  display.getText() + ((JButton)e.getSource()).getText()  );
         operator.setText("");
      }
      
      if(e.getSource()==btnEqual&&opArr.size()>0&&display.getText().length()>0)
      {
         display.setText(getFormattableString());
         operator.setText(((JButton)e.getSource()).getText());
         argsArr.add(Double.parseDouble(display.getText()));
         double result = ((Double)argsArr.get(0)).doubleValue();
         for(int i = 0;i < opArr.size(); i++)
         {
            if(((String)opArr.get(i)).equals("*"))
            {
               result *= ((Double)argsArr.get(i+1)).doubleValue();
            }
            if(((String)opArr.get(i)).equals("/"))
            {
               result /= ((Double)argsArr.get(i+1)).doubleValue();
            }
            if(((String)opArr.get(i)).equals("+"))
            {
               result += ((Double)argsArr.get(i+1)).doubleValue();
            }
            if(((String)opArr.get(i)).equals("-"))
            {
               result -= ((Double)argsArr.get(i+1)).doubleValue();
            }
            
         }
         display.setText(new Double(result).toString());
         argsArr = new ArrayList<Double>();
         opArr = new ArrayList<String>();
         equalJustPressed = true;
      }
      
      if(!display.getText().equals(""))
      {
         if(e.getSource()==btnMult && display.getText()!="")
         {
            operator.setText(((JButton)e.getSource()).getText());
            equalJustPressed = false;
         }
         
         if(e.getSource()==btnDiv && display.getText()!="")
         {
            operator.setText(((JButton)e.getSource()).getText());
            equalJustPressed = false;
         }
         
         if(e.getSource()==btnMin && display.getText()!="")
         {
            operator.setText(((JButton)e.getSource()).getText());
            equalJustPressed = false;
         }
         
         if(e.getSource()==btnAdd && display.getText()!="")
         {
            operator.setText(((JButton)e.getSource()).getText());
            equalJustPressed = false;
         }
      }
   
      formatDisplay();
   }
   
   public static void main(String[]args) //main
   {
      new Calculator();
   }
}