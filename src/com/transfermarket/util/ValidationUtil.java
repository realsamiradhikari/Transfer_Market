package com.transfermarket.util;

import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * A utility class for validating user inputs in the Transfer Market
 * application. Provides methods to validate text fields, combo boxes, and
 * specific data like Player IDs. Ensures inputs are non-empty, correctly
 * formatted, and within valid ranges. Highlights invalid fields with red
 * borders and error messages, with options to reset to defaults.
 *
 * @author Samir Adhikari
 */
public class ValidationUtil {

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s'-]+$");

    /**
     * Validates if a text field is not empty. Highlights the text field and
     * displays an error message if validation fails. Resets the field and error
     * label if validation succeeds.
     *
     * @param value The value to validate (String).
     * @param errorLabel The label to display error messages.
     * @param textField The text field to apply validation on.
     * @param fieldName The name of the field for error messages.
     * @return true if the field is not empty, false otherwise.
     */
    public static boolean isNotEmpty(String value, JLabel errorLabel, JTextField textField, String fieldName) {
        if (value.isEmpty()) {
            errorLabel.setText(fieldName + " Can't be Empty");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED);  //Make the Border Red
            return false;
        }
        errorLabel.setText(""); //Clears the error Message
        resetTextFieldBorder(textField);
        return true;
    }

    /**
     * Validates if the Player ID is a non-empty integer and within a valid
     * range (1 to 10,000). Highlights the text field and displays an error
     * message if validation fails. Resets the field and error label if
     * validation succeeds.
     *
     * @param playerId The Player ID to validate.
     * @param errorLabel The label to display error messages.
     * @param textField The text field to apply validation on.
     * @return true if the Player ID is valid, false otherwise.
     */
    public static boolean validatePlayerID(String playerId, JLabel errorLabel, JTextField textField) {
        // Check if the field is empty
        if (!isNotEmpty(playerId, errorLabel, textField, "Player ID")) {
            return false;
        }

        try {
            // Parse and validate the integer value
            int id = Integer.parseInt(playerId);

            // Check if the Player ID exceeds the range
            if (id < 1 || id > 10000) {
                errorLabel.setText("Player ID must lie in 1 to 10,000.");
                errorLabel.setForeground(Color.RED);
                setTextFieldBorder(textField, Color.RED); // Make the border red
                return false;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Player ID must be an integer.");
            errorLabel.setForeground(Color.RED);
            setTextFieldBorder(textField, Color.RED); // Make the border red
            return false;
        }

        // Clear error message and reset the border if validation succeeds
        errorLabel.setText("");
        resetTextFieldBorder(textField); // Reset to default border
        return true;
    }

    /**
     * Validates if the Player Name is not empty and contains only alphabets.
     * Highlights the text field and displays an error message if validation
     * fails. Resets the field and error label if validation succeeds.
     *
     * @param playerName The Player Name to validate.
     * @param errorLabel The label to display error messages.
     * @param textField The text field to apply validation on.
     * @return true if the Player Name is valid, false otherwise.
     */
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

    /**
     * Validates if the Age is not empty and is an integer between 10 and 40.
     * Highlights the text field and displays an error message if validation
     * fails. Resets the field and error label if validation succeeds.
     *
     * @param age The Age to validate.
     * @param errorLabel The label to display error messages.
     * @param textField The text field to apply validation on.
     * @return true if the Age is valid, false otherwise.
     */
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

    /**
     * Validates if the Market Value is not empty and is a positive number and
     * is in between the market range 0 and 100,000,000. Highlights the text
     * field and displays an error message if validation fails. Resets the field
     * and error label if validation succeeds.
     *
     * @param marketValue The Market Value to validate.
     * @param errorLabel The label to display error messages.
     * @param textField The text field to apply validation on.
     * @return true if the Market Value is valid, false otherwise.
     */
    public static boolean validateMarketValue(String marketValue, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(marketValue, errorLabel, textField, "Market Value")) {
            return false; // Stop if the field is empty
        }
        try {
            double parsedValue = Double.parseDouble(marketValue);
            if (parsedValue < 0 || parsedValue > 1000000000) {
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

    /**
     * Validates if the Contract Duration is not empty and is a positive integer
     * (months) and is in between the 0 and 96 months(default). Highlights the
     * text field and displays an error message if validation fails. Resets the
     * field and error label if validation succeeds.
     *
     * @param duration The Contract Duration to validate.
     * @param errorLabel The label to display error messages.
     * @param textField The text field to apply validation on.
     * @return true if the Contract Duration is valid, false otherwise.
     */
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

    /**
     * Validates if a valid option is selected in the ComboBox. Highlights the
     * ComboBox and displays an error message if validation fails. Resets the
     * field and error label if validation succeeds.
     *
     * @param selectedValue The selected value in the ComboBox.
     * @param errorLabel The label to display error messages.
     * @param comboBox The ComboBox to validate.
     * @param defaultValue The default value to compare against.
     * @param fieldName The name of the field for error messages.
     * @return true if a valid option is selected, false otherwise.
     */
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

    /**
     * Validates if Goal Contributions is not empty and is between the range of
     * 0 and 1500. Highlights the text field and displays an error message if
     * validation fails. Resets the field and error label if validation
     * succeeds.
     *
     * @param goals The Goal Contributions to validate.
     * @param errorLabel The label to display error messages.
     * @param textField The text field to validate.
     * @return true if Goal Contributions are valid, false otherwise.
     */
    public static boolean validateGoalContribution(String goals, JLabel errorLabel, JTextField textField) {
        if (!isNotEmpty(goals, errorLabel, textField, "G/A Contributions")) {
            return false;
        }
        try {
            int parsedGoals = Integer.parseInt(goals);
            if (parsedGoals < 0 || parsedGoals > 1500) {
                errorLabel.setText("G/A  must be between 0 and 1500.");
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

    /**
     * Utility method to set the border of a JTextField to a specific color.
     *
     * @param textField The JTextField whose border needs to be updated.
     * @param color The Color to set as the border color.
     */
    private static void setTextFieldBorder(JTextField textField, Color color) {
        Border currentBorder = textField.getBorder();
        if (currentBorder instanceof TitledBorder) {
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

    /**
     * Resets the border of a JTextField to its default look-and-feel-defined
     * state.
     *
     * @param textField The JTextField whose border will be reset.
     */
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

    /**
     * Sets the border of a JComboBox to a specific color, preserving the title
     * if it exists.
     *
     * @param comboBox The JComboBox whose border will be updated.
     * @param color The color to set for the border.
     */
    private static void setComboBoxBorder(JComboBox<String> comboBox, Color color) {
        Border currentBorder = comboBox.getBorder();
        if (currentBorder instanceof TitledBorder) {
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

    /**
     * Resets the border of a JComboBox to its default look-and-feel-defined
     * state.
     *
     * @param comboBox The JComboBox whose border will be reset.
     */
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
