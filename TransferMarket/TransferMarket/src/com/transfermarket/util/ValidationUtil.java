package com.transfermarket.util;

import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class ValidationUtil {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s'-]+$");

    
    /**
     * Method to validate if a field is not empty
     */
    
    public static  boolean isNotEmpty(String value,JLabel errorLabel,JTextField textField,String fieldName){
        if(value.isEmpty()){
            errorLabel.setText(fieldName+" Can't be Empty");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED);  //Make the Border Red
            return false;  
        }
        errorLabel.setText(""); //Clears the error Message
        resetTextFieldBorder(textField);
        return true;  
    }
    
    
     // Validate Player ID (must be an integer)
    public static boolean validatePlayerID(String playerId, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(playerId, errorLabel, textField, "Player ID")) {
            return false; // Stop if the field is empty
        }
        try {
            Integer.parseInt(playerId); // Check if it's a valid integer
        } catch (NumberFormatException e) {
            errorLabel.setText("Player ID must be integer.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Make the border red
            return false;
        }
        errorLabel.setText(""); // Clear error message
        resetTextFieldBorder(textField); // Reset to default border
        return true;
    }
    
     // Validate Player Name (alphabets only)
    public static boolean validatePlayerName(String playerName, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(playerName, errorLabel, textField, "Name")) {
            return false; // Stop if the field is empty
        }
        if (!NAME_PATTERN.matcher(playerName).matches()) {
            errorLabel.setText("Name must contain alphabets only.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Make the border red
            return false;
        }
        errorLabel.setText(""); // Clear error message
        resetTextFieldBorder(textField); // Reset to default border
        return true;
    }
    
    // Validate Age (must be an integer between 10 and 40)
    public static boolean validateAge(String age, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(age, errorLabel, textField, "Age")) {
            return false; // Stop if the field is empty
        }
        try {
            int parsedAge = Integer.parseInt(age);
            if (parsedAge < 10 || parsedAge > 40) {
                errorLabel.setText("10<Age<40");
                errorLabel.setForeground(Color.RED);
                setTextFieldBorder(textField, Color.RED); // Make the border red
                return false;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Age must be an integer.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Make the border red
            return false;
        }
        errorLabel.setText(""); // Clear error message
        resetTextFieldBorder(textField); // Reset to default border
        return true;
    }
    
    // Validate Market Value (must not be negative)
    public static boolean validateMarketValue(String marketValue, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(marketValue, errorLabel, textField, "Market Value")) {
            return false; // Stop if the field is empty
        }
        try {
            double parsedValue = Double.parseDouble(marketValue);
            if (parsedValue < 0 || parsedValue >1000000000) {
                errorLabel.setText("0 < MarketValue < 100,000,000.");
                errorLabel.setForeground(Color.RED);
                setTextFieldBorder(textField, Color.RED); // Make the border red
                return false;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Market Value must be a double.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Make the border red
            return false;
        }
        errorLabel.setText(""); // Clear error message
        resetTextFieldBorder(textField); // Reset to default border
        return true;
    }
    
    // Validate Contract Duration (must be a positive integer)
    public static boolean validateContractDuration(String duration, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(duration, errorLabel, textField, "Contract Duration")) {
            return false; // Stop if the field is empty
        }
        try {
            int parsedDuration = Integer.parseInt(duration);
            if (parsedDuration <= 0 || parsedDuration > 96) {
                errorLabel.setText("0 <= Duration (months) <= 96.");
                errorLabel.setForeground(Color.RED);
                setTextFieldBorder(textField, Color.RED); // Make the border red
                return false;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Duration (months) must be a valid integer.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Make the border red
            return false;
        }
        errorLabel.setText(""); // Clear error message
        resetTextFieldBorder(textField); // Reset to default border
        return true;
    }
    
    // Validate ComboBox (must not be the default value)
    public static boolean validateComboBox(String selectedValue, JLabel errorLabel, JComboBox<String> comboBox, String defaultValue, String fieldName) {
        if (selectedValue.equals(defaultValue)) {
            errorLabel.setText(fieldName + " must be selected.");
            errorLabel.setForeground(Color.RED);
            setComboBoxBorder(comboBox, Color.RED); // Make the border red
            return false;
        }
        errorLabel.setText(""); // Clear error message
        resetComboBoxBorder(comboBox); // Reset to default border
        return true;
    }
    
    // Validate Goal Contributions (must be a positive integer or zero)
    public static boolean validateGoalContribution(String goals, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(goals, errorLabel, textField, "G/A Contributions")) {
            return false;
        }
        try {
            int parsedGoals = Integer.parseInt(goals);
            if (parsedGoals < 0) {
                errorLabel.setText("G/A  must be zero or positive.");
                errorLabel.setForeground(Color.RED);
                setTextFieldBorder(textField, Color.RED); // Red border for error
                return false;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("G/A  must be a valid integer.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Red border for error
            return false;
        }
        errorLabel.setText("");
        resetTextFieldBorder(textField); // Reset border to default
        return true;
    }

    
    // Utility method to set the border of a text field to a specific color
    private static void setTextFieldBorder(JTextField textField, Color color) {
        Border currentBorder = textField.getBorder();
        if(currentBorder instanceof TitledBorder) {
            TitledBorder titledBorder = (TitledBorder) currentBorder;
            textField.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(color),
                titledBorder.getTitle(),
                titledBorder.getTitleJustification(),
                titledBorder.getTitlePosition(),
                titledBorder.getTitleFont(),
                titledBorder.getTitleColor()
            ));
        } else {
            textField.setBorder(BorderFactory.createLineBorder(color));
        }
    }

    public static void resetTextFieldBorder(JTextField textField) {
    Border currentBorder = textField.getBorder();
    if (currentBorder instanceof TitledBorder) {
        // Preserve the titled border properties
        TitledBorder titledBorder = (TitledBorder) currentBorder;
        textField.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), // Default border color, adjust if necessary
            titledBorder.getTitle(),
            titledBorder.getTitleJustification(),
            titledBorder.getTitlePosition(),
            titledBorder.getTitleFont(),
            titledBorder.getTitleColor()
        ));
    } else {
        // Reset to the default simple border if it wasn't a titled border
        textField.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
    }
}


   // Utility method to set the border of a ComboBox to a specific color
    private static void setComboBoxBorder(JComboBox<String> comboBox, Color color) {
        Border currentBorder = comboBox.getBorder();
        if(currentBorder instanceof TitledBorder) {
            TitledBorder titledBorder = (TitledBorder) currentBorder;
            comboBox.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(color),
                titledBorder.getTitle(),
                titledBorder.getTitleJustification(),
                titledBorder.getTitlePosition(),
                titledBorder.getTitleFont(),
                titledBorder.getTitleColor()
            ));
        } else {
            comboBox.setBorder(BorderFactory.createLineBorder(color));
        }
    }
    
    //Utility method to reset the comboBox border to it's default value.
    
   public static void resetComboBoxBorder(JComboBox<String> comboBox) {
    Border currentBorder = comboBox.getBorder();
    if (currentBorder instanceof TitledBorder) {
        // Preserve the titled border properties
        TitledBorder titledBorder = (TitledBorder) currentBorder;
        comboBox.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), // Default border color, adjust if necessary
            titledBorder.getTitle(),
            titledBorder.getTitleJustification(),
            titledBorder.getTitlePosition(),
            titledBorder.getTitleFont(),
            titledBorder.getTitleColor()
        ));
    } else {
        // Reset to the default border if it wasn't a titled border
        comboBox.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("ComboBox.border"));
    }
} 
}