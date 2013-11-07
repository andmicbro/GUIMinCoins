package guimincoins;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
////////////////////////////// Andrew Brown
////////////////////////////////////////////Class GUIMinCoins

class GUIMinCoins extends JFrame
{
    //========================================================= Variables
    
    private JTextField Coins = new JTextField(3);
    private JTextField Quarters = new JTextField(3);
    private JTextField Dimes = new JTextField(3);
    private JTextField Nickels = new JTextField(3);
    private JTextField Pennies = new JTextField(3);
    
    //=========================================================== Main
    
    public GUIMinCoins()
    {
        // Initiaizing components
        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(new calcButtonListener());
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new clearButtonListener());
        
        // Setting up coin field components
        Coins.addActionListener(new calcButtonListener());
        Quarters.setEditable(false);
        Dimes.setEditable(false);
        Nickels.setEditable(false);
        Pennies.setEditable(false);
        
        
        //Panel & Layout
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(6,2,5,16));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        
        
        content.add(new JLabel("Enter Change(1-99): "));
        content.add(Coins);
        Coins.setBorder(emptyBorder);
        
        content.add(new JLabel("Quarters"));
        content.add(Quarters);
        Quarters.setBorder(emptyBorder);
        
        content.add(new JLabel("Dimes"));
        content.add(Dimes);
        Dimes.setBorder(emptyBorder);
        
        content.add(new JLabel("Nickels"));
        content.add(Nickels);
        Nickels.setBorder(emptyBorder);
        
        content.add(new JLabel("Pennies"));
        content.add(Pennies);
        Pennies.setBorder(emptyBorder);
        
        content.add(calcButton);
        content.add(clearButton);
        
        setContentPane(content);
        pack();
        setTitle("Minimum Coins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        
    }//==============================================End public GUIMinCoins
    
    ////////////////////////////////////////////////////// calcButtonListener
    class calcButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Getting string info from input
            String coinStr = Coins.getText();
            int coinsIn = Integer.parseInt(coinStr);
            
            int coins2quarters = 0;
            int coins2dimes = 0;
            int coins2nickels = 0;
            int coins2pennies = 0;
            
            // Calculations
            while(coinsIn>=25)
            {
                coins2quarters++;
                coinsIn = coinsIn - 25;
            }
            
            while(coinsIn>=10)
            {
                coins2dimes++;
                coinsIn = coinsIn - 10;
            }
            
            while(coinsIn>=5)
            {
                coins2nickels++;
                coinsIn = coinsIn - 5;
            }
            
            while(coinsIn>=1)
            {
                coins2pennies++;
                coinsIn = coinsIn - 1;
            }
            
            //Final string to output
            
            Quarters.setText(""+coins2quarters);
            Dimes.setText(""+coins2dimes);
            Nickels.setText(""+coins2nickels);
            Pennies.setText(""+coins2pennies);
            
        }//End actoinPerformed calcButton 
        
    }//End calcButtonListener ================================================
    
    ///////////////////////////////////////////////////// clearButtonListener
    class clearButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Coins.setText("");
            Quarters.setText("");
            Dimes.setText("");
            Nickels.setText("");
            Pennies.setText("");
            
        }//End actionPerformed clearButton 
        
    }//End clearButtonListener ===============================================
    
    //=========================================================== method main
    public static void main(String[] args)
    {
        GUIMinCoins window = new GUIMinCoins();
        window.setVisible(true);
        
        System.out.println("Thank You For Using Minimum Coins!");
    }///End method main
    
}//End class GUIMinCoins