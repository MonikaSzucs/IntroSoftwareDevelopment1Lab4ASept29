
/**
 * Account details at Royal Bank.
 *
 * @author Mike Mulder
 * @version 2018-09-29
 */
public class RoyalBankAccount
{
    // Constants
    private static final String BANK_MOTTO = "You're poorer than you think";
    private static final double MAX_DEPOSIT = 10000.0;
    private static final int MIN_PIN_NUMBER = 0;
    private static final double MIN_INTEREST_RATE = 0.0;
    private static final double MAX_INTEREST_RATE = 1.0;
    
    // Class (Static) Variables
    private static double primeInterestRate = 0.025;
    
    // Instance Variables
    private double personalInterestRate;
    private int    pin;
    private double balanceUsd;
    private String firstName;
    private String lastName;
    private boolean isOverdraftAvailable;
    private double overdraftAmountUsd;
    private final String personalAccountNumber;

    /**
     * Constructor for objects of class RoyalBankAccount
     */
    public RoyalBankAccount(double personalInterestRate,
                            int pin,
                            double balanceUsd,
                            String firstName,
                            String lastName,
                            boolean isOverdraftAvailable,
                            double overdraftAmountUsd,
                            String personalAccountNumber)  
    {
        
        setPersonalInterestRate(personalInterestRate);
        setPin(pin);
        setBalanceUsd(balanceUsd);
        setFirstName(firstName);
        setLastName(lastName);
        setIsOverdraftAvailable(isOverdraftAvailable);
        setOverdraftAmountUsd(overdraftAmountUsd);
        
        if (null != personalAccountNumber) {
            this.personalAccountNumber = personalAccountNumber;
        } else {
            throw new IllegalArgumentException("Invalid Personal Account Number");
        }
    }
    
    // Setter Methods
    
    /**
     * @param personalInterestRate The personal interest rate
     */
    public void setPersonalInterestRate(double personInterestRate) {
        if (personalInterestRate >= MIN_INTEREST_RATE && personalInterestRate <= MAX_INTEREST_RATE) {
            this.personalInterestRate = personInterestRate;
        } else {
            throw new IllegalArgumentException("Invalid Personal Interest Rate");
        }
    }
    
    /**
     * @param pin The numeric pin
     */
    public void setPin(int pin) {
        if (pin > MIN_PIN_NUMBER) {
            this.pin = pin;
        } else {
            throw new IllegalArgumentException("Invalid PIN");
        }
    }
    
    /**
     * @param balanceUsd The balance in USD
     */
    public void setBalanceUsd(double balanceUsd) {
        if (balanceUsd > 0.0) {
            this.balanceUsd = balanceUsd;
        } else {
            throw new IllegalArgumentException("Invalid Balance in USD");
        }
    }
    
    /**
     * @param firstName First Name of the account holder
     */
    public void setFirstName(String firstName) {
        if (null != firstName) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid First Name");
        }
    }
    
    /**
     * @param lastName Last Name of the account holder
     */
    public void setLastName(String lastName) {
        if (null != lastName) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid Last Name");
        }
    }
    
    /**
     * @param isOverdraftAvailable Is there an overdraft available on this account
     */
    public void setIsOverdraftAvailable(boolean isOverdraftAvailable) {
        this.isOverdraftAvailable = isOverdraftAvailable;
    }
    
    /**
     * @param overdraftAmountUsd The overdraft amount in USD
     */
    public void setOverdraftAmountUsd(double overdraftAmountUsd) {
        if (overdraftAmountUsd > 0.0) {
            this.overdraftAmountUsd = overdraftAmountUsd;
        } else {
            throw new IllegalArgumentException("Invalid Overdraft Amount in USD");
        }
    }
    
    // Getter Methods
    
    /**
     * @return personalInterestRate Account's interest rate
     */
    public double getPersonalInterestRate() {
        return this.personalInterestRate;
    }
    
    /**
     * @return pin Personal Identification Number
     */
    public double getPin() {
        return this.pin;
    }
    
    /**
     * @return balanceUsd Account Balance in USD
     */
    public double getBalanceUsd() {
        return this.balanceUsd;
    }
    
    /**
     * @return firstName Account Holder First Name
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * @return lastName Account Holder Last Name
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * @return isOverdraftAvailable
     */
    public boolean getIsOverdraftAvailable() {
        return this.isOverdraftAvailable;
    }
    
    /**
     * @return overdraftAmount
     */
    public double getOverdraftAmountUsd() {
        return this.overdraftAmountUsd;
    }

    /**
     * @return personalAccountNumber Whether overdraft is allowed
     */
    public String getPersonalAccountNumber() {
        return this.personalAccountNumber;
    }
    
    /**
     * @return BANK_MOTTO
     */
    public String getBankMotto() {
        return BANK_MOTTO;
    }
    
    /**
     * @return primeInterestRate
     */
    public double getPrimeInterestRate() {
        return primeInterestRate;
    }
    
    // Other Methods
    
    /**
     * Withdraws money from the bank account
     * 
     * @param withdrawalUsd Withdrawal amount
     */
    public void withdraw(double withdrawalUsd) {
        
        // Do not allow negative withdrawals
        if (withdrawalUsd <= 0.0) {
            throw new IllegalArgumentException("Negative withdrawals not allowed");
        }
        
        boolean isOverDraftWithdrawalAllowed = this.isOverdraftAvailable && (withdrawalUsd <= (this.balanceUsd + this.overdraftAmountUsd));
        boolean isRegularWithdrawalAllowed = !this.isOverdraftAvailable && (withdrawalUsd <= this.balanceUsd);
        
        if (isOverDraftWithdrawalAllowed || isRegularWithdrawalAllowed) {
            this.balanceUsd = this.balanceUsd - withdrawalUsd;
        }        
    }
    
    /**
     * Depposits money to the bank account
     * 
     * @param depositUsd Deposit amount
     */
    public void deposit(double depositUsd) {
        
        // Only allow positive deposits
        if (depositUsd > 0.0) {
            this.balanceUsd = this.balanceUsd + depositUsd;
            
            if (depositUsd > MAX_DEPOSIT) {
                System.out.println("The manager will be contacting you. Thank you for your deposit.");
            }
        }  else {
            throw new IllegalArgumentException("Negative deposit not allowed");
        }
    }
}
