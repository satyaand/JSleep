package com.satyaAnandaSulistioJSleepJS;

import com.satyaAnandaSulistioJSleepJS.dbjson.Serializable;

import java.util.regex.*;

/**
 * This class is the class for Account object, which presence is fundamental throughout the program. This class contains fields for basic Account credentials.
 *
 * @author Satya Ananda Sulistio
 * @version 1.0
 */

public class Account extends Serializable
{
    /**
     * The name registered on the account
     *
     * This field is public, which means it can also be accessed from other classes outside the package.
     *
     * @since 1.0
     */
    public String name;

    /**
     * The email registered on the account.
     *
     * This field is public, which means it can also be accessed from other classes outside the package.
     *
     * @since 1.0
     */
    public String email;

    /**
     * The password registered on the account.
     *
     * In the practice, password field is encrypted using MD5 within the JSON file.
     *
     * This field is using non-primitive type String.
     *
     * @since 1.0
     */
    public String password;

    /**
     * This field contains information regarding whether the account has a renter role or not.
     *
     * This field uses type Renter which is a reference to the class according to the name.
     *
     * @since 1.0
     */
    public Renter renter;

    /**
     * This field stores the balance that can be used for payment inquiries.
     *
     * This field can be deducted or added throughout the course of the program.
     *
     * This field uses type double (primitive) so it offers flexibility in arithmetics.
     *
     * @since 1.0
     */
    public double balance;

    /**
     * This field contains a non-mutable REGEX that can be used to format the REGEX pattern.
     *
     * It can be used to validate email.
     *
     * @since 1.0
     */
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]*[.]{1}[a-zA-Z]*$";

    /**
     * This field contains a non-mutable REGEX that can be used to format the REGEX pattern.
     *
     * It can be used to validate password.
     *
     * @since 1.0
     */
    public final static String REGEX_PASSWORD = "^(?!.*\\s)(?!.*[@#$%^&-+=!_])(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

    /**
     * This is a constructor for a new Account given the initial value based on the parameters.
     *
     * @param name the initial name for the newly created account
     * @param email the initial email for the newly created account
     * @param password the initial password for the newly created account
     */
    public Account(String name, String email, String password)
    {
        // initialise instance variables
        this.name = name;
        this.email = email;
        this.password = password;
        this.renter = null;
        this.balance = 0;
    }

    /**
     * Print the Account fields' values
     *
     * This method doesn't take any arguments.
     *
     * @return string containing Account fields and their values
     */
    public String toString(){
        return ("Account{name=" + name + ", email=" + email + ", password=" + password + ", id=" + id + "}");
    }

    /**
     * This method validates whether an email and password matches the correct REGEX pattern.
     *
     * This method doesn't take any arguments.
     *
     * @return boolean value that indicates whether the email and passwords match the REGEX pattern
     */
    public boolean validate(){
        if(email == null || password == null || email.isBlank() || password.isBlank()){
            return false;
        }
        boolean mEmail = Pattern.compile(REGEX_EMAIL).matcher(email).matches();
        boolean mPass = Pattern.compile(REGEX_PASSWORD).matcher(password).matches();
        return (mEmail && mPass);
    }


    public Object write(){
        return null;
    }
}
