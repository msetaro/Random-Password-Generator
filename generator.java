package password;

import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.IOException;


public class generator {

    
    public static void main(String[] args) throws IOException {
        
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        
        String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
            "z", "!", "@", "#", "$", "%", "^", "&", "*", "+", "=", "~", ":", 
            ";", "_" };      
        
        int randNum = 0;
        int randChar = 0;
        int chance = 0;
        int capsChance = 0;
        String caps = "";
        
        
        
        String password = "";
        
        // ask the user how many characters the password should be
        
        
        String numOfChars = JOptionPane.showInputDialog("How many characters do "
                + "you want your password to be?");
        
        int lenOfPW = Integer.parseInt(numOfChars);
        
        //ask user if special characters are ok
        
        String spChar = JOptionPane.showInputDialog("Should your password "
                + "contain any special characters? (Y/N)");
        
        if (spChar.equalsIgnoreCase("Y")){
            //chars w/ special char = 40 in len
            
            for (int i = 0; i < lenOfPW; i++){
                randNum = (int)(Math.random() * 10);
                randChar = (int)(Math.random() * 40);
                chance = (int)(Math.random() * 101);
                capsChance = (int)(Math.random() * 101);
                

                
                if (chance >= 50){
                    password += nums[randNum];
                    
                }
                else
                    if (capsChance >= 50){
                        caps = chars[randChar];
                        password += caps.toUpperCase();
                    }
                    else    
                        password += chars[randChar]; 
                    
            }//end of for
        }//end of if if special chars == true
        
        
        if (spChar.equalsIgnoreCase("N")){
            //chars w/ special char = 26 in len
            
            for (int i = 0; i < lenOfPW; i++){
                randNum = (int)(Math.random() * 10);
                randChar = (int)(Math.random() * 26);
                chance = (int)(Math.random() * 101);
                capsChance = (int)(Math.random() * 101);
                

                
                if (chance >= 50){
                    password += nums[randNum];
                    
                }
                else
                    if (capsChance >= 50){
                        caps = chars[randChar];
                        password += caps.toUpperCase();
                    }
                    else    
                        password += chars[randChar]; 
                    
            }//end of for
        }//end of if if special chars == false   
           
           
           
        
        System.out.println("Your password is: " + password);
        
        String txt = JOptionPane.showInputDialog("Would you like to save your "
                + "password to a .txt file? (Y/N)");
        
        if (txt.equalsIgnoreCase("Y")){
            PrintWriter fileWriter = new PrintWriter("password.txt", "UTF-8");
            fileWriter.write( "Your password is: " + password );
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "Thank You! Your password was "
                    + "saved to \"password.txt\" in the project folder");
        }
        else
            JOptionPane.showMessageDialog(null, "Thank You!");
        
        
            
        
    }
    
}
