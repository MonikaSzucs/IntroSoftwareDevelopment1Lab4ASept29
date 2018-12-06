
/**
 * Write a description of class RoyalBankAccount here.
 *
 * @author Monika Szucs
 * @version September 29, 2018
 */
public class RoyalBankAccount
{
    // instance variables
    private static final    double  MAX_DEPOSITE = 10000.0;
    private static final    String  MOTTO = "You're Poorer than you think.";
    private static          double  primeInterestRate = 0.025;
    private                 double  personalInterestRate;
    private                 double  balanceUSD;
    private                 int     pin;
    private                 String  firstName;
    private                 String  lastName;
    private                 boolean overdraft;
    private                 double  overdraftAmount;
    private final           int     personalAccountNumber;

    /**
     * Constructor for objects of class RoyalBankAccount
     */
    public RoyalBankAccount(double  thePersonalInterestRate, 
                            double  theBalanceUSD, 
                            int     thePin,
                            String  theFirstName,
                            String  theLastName,
                            boolean theOverdraft,
                            double  theOverdraftAmount,
                            int     thePersonalAccountNumber)
    {
        // initialise instance variables
        setPersonalInterestRate(thePersonalInterestRate);
        setBalanceUSD(theBalanceUSD);
        setPin(thePin);
        setFirstName(theFirstName);
        setLastName(theLastName);
        setOverdraft(theOverdraft);
        setOverdraftAmount(theOverdraftAmount);
        
        personalAccountNumber = thePersonalAccountNumber;
    }

    /**
     * method Mutator
     *
     * @param  thePersonalInterestRate  is the interest rate from the bank
     * 
     */
    public void setPersonalInterestRate(double thePersonalInterestRate)
    {
        if(thePersonalInterestRate > 0.0){
            personalInterestRate = thePersonalInterestRate;
        }
        else{
            throw new IllegalArgumentException("No interest on your account");
        }
    }
    
    /**
     * method Mutator
     *
     * @param  theBalanceUSD  is the balance in USD
     * 
     */
    public void setBalanceUSD(double theBalanceUSD)
    {
        if(theBalanceUSD > 0.0){
            balanceUSD = theBalanceUSD;
        }
        else{
            throw new IllegalArgumentException("No balance");
        }
    }
    
    /**
     * method Mutator
     *
     * @param  thePin is the pin for the account
     * 
     */
    public void setPin(int thePin)
    {
        if(thePin > 0){
            pin = thePin;
        }
        else{
            throw new IllegalArgumentException("No PIN");
        }
    }
    
    /**
     * method Mutator
     *
     * @param  theFirstName is the first name of the person
     * 
     */
    public void setFirstName(String theFirstName)
    {
        if(theFirstName != null){
            firstName = theFirstName;
        }
        else{
            throw new IllegalArgumentException("No first name");
        }
    }
    
    /**
     * method Mutator
     *
     * @param  theLastName is the last name of the person
     * 
     */
    public void setLastName(String theLastName)
    {
        if(theLastName != null){
            lastName = theLastName;
        }
        else{
            throw new IllegalArgumentException("No last name");
        }
    }
    
    /**
     * method Mutator
     *
     * @param  theOverdraft is what is overdrafted
     * 
     */
    public void setOverdraft(boolean theOverdraft)
    {
            overdraft = theOverdraft;
    }
    
    /**
     * method Mutator
     *
     * @param  theOverdraftAmount is what is the amount overdrafted
     * 
     */
    public void setOverdraftAmount(double theOverdraftAmount)
    {
        if(theOverdraftAmount > 0.0){
            overdraftAmount = theOverdraftAmount;
        }
        else{
            throw new IllegalArgumentException("No overdraft amount");
        }
    }
    
    public void withdraw(double theWithdraw){
        if(theWithdraw <= 0.0){
            return;
        }
        
        if(overdraft && (theWithdraw > (balanceUSD + overdraftAmount))){
            return;
        }
        
        if (!overdraft && (theWithdraw > balanceUSD)){
            return;
        }
        
        balanceUSD = (balanceUSD - theWithdraw);
    }
    
    public void deposit(double theDeposit){
        /** My old way
            if(theDeposit <= 0.0){
        return;
        }
        
        if(theDeposit > MAX_DEPOSITE){
        System.out.println("The manger will be contacting you. Thank you for your deposit.");
        }
        
        balanceUSD = (balanceUSD + theDeposit);
        */
        
        if(depositUSD>0.0){
            balanceUSD = balanceUSD + theDeposite;
            
            if(depositeUSD > MAX_DEPOSITE){
                System.out.println("The manager will be contacting you. Thannk you for your deposite.");
            }
        }
        else{
            throw new IllegalArgumentException("Negative deposite not allowed");
        }
    }
    
    public double getPrimeInterestRate(){
        return primeInterestRate;
    }
    
    public String getMOTTO(){
        return MOTTO;
    }
}
