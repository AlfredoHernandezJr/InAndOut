package cs134.miracosta.edu.ahernandez.model;

public class Order {

    // Instance variables
    private int mCheeseburgers ;
    private int mDoubleDoubles ;
    private int mFrenchFries ;
    private int mLargeDrinks ;
    private int mMediumDrinks ;
    private int mSmallDrinks ;
    private int mShakes ;

    // Unchanging values.
    private static final double PRICE_CHEESEBURGER = 2.15 ;
    private static final double PRICE_DOUBLE_DOUBLE = 3.60 ;
    private static final double PRICE_FRENCH_FRIES = 1.65 ;
    private static final double PRICE_LARGE_DRINK = 1.75 ;
    private static final double PRICE_MEDIUM_DRINK = 1.55 ;
    private static final double PRICE_SHAKE = 2.20 ;
    private static final double PRICE_SMALL_DRINK = 1.45 ;
    private static final double TAX_RATE = 0.08 ;

    /**
     * Default constructor for the Order object. Defaults the items to zero.
     */
    public Order()
    {
        mCheeseburgers = 0 ;
        mDoubleDoubles = 0 ;
        mFrenchFries = 0 ;
        mLargeDrinks = 0 ;
        mMediumDrinks = 0 ;
        mSmallDrinks = 0 ;
        mShakes = 0 ;
    }

    /**
     * Returns the number of cheeseburgers.
     * @return number of cheeseburgers.
     */
    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    /**
     * Sets the number of cheeseburgers.
     * @param cheeseburgers amount entered by the user.
     */
    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    /**
     * Returns the number of double doubles ordered.
     * @return number of double doubles.
     */
    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }

    /**
     * Sets the number of double doubles in the order.
     * @param doubleDoubles number of double doubles to be ordered.
     */
    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }

    /**
     * Returns the number of french fries ordered.
     * @return number of french fries.
     */
    public int getFrenchFries() {
        return mFrenchFries;
    }

    /**
     * Sets the number of french fries ordered.
     * @param frenchFries number french fries to be ordered.
     */
    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    /**
     * Returns the number of large drinks ordered.
     * @return number of large drinks.
     */
    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    /**
     * Sets the number of large drinks in an order.
     * @param largeDrinks number of large drinks to be ordered.
     */
    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    /**
     * Returns the number of medium drinks in the order.
     * @return number of medium drinks.
     */
    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    /**
     * Sets the number of medium drinks ordered.
     * @param mediumDrinks number of drinks to be ordered.
     */
    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    /**
     * Returns the number of small drinks ordered.
     * @return number of small drinks ordered.
     */
    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    /**
     * Sets the number of small drinks ordered.
     * @param smallDrinks number of small drinks ordered.
     */
    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    /**
     * Returns the number of shakes in the order.
     * @return number of shakes.
     */
    public int getShakes() {
        return mShakes;
    }

    /**
     * Sets the number of shakes for an order.
     * @param shakes number of shakes ordered.
     */
    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    /**
     * Calculates the subtotal cost of the order.
     * @return subtotal of order.
     */
    public double calculateSubtotal()
    {
        return (mCheeseburgers * PRICE_CHEESEBURGER) +
                (mDoubleDoubles * PRICE_DOUBLE_DOUBLE) +
                (mFrenchFries * PRICE_FRENCH_FRIES) +
                (mShakes * PRICE_SHAKE) +
                (mSmallDrinks * PRICE_SMALL_DRINK) +
                (mMediumDrinks * PRICE_MEDIUM_DRINK) +
                (mLargeDrinks * PRICE_LARGE_DRINK) ;
    }

    /**
     * Returns the amount of tax owed based on the order.
     * @return amount of tax.
     */
    public double calculateTax()
    {
        return calculateSubtotal() * TAX_RATE ;
    }

    /**
     * Calculates the total price of the order based on the subtotal and amount of tax.
     * @return total price of order.
     */
    public double calculateTotal()
    {
        return calculateSubtotal() + calculateTax() ;
    }

    /**
     * Adds up all of the number of entered items.
     * @return number of ordered items.
     */
    public int getNumberItemsOrdered()
    {
        return mCheeseburgers + mDoubleDoubles + mFrenchFries + mShakes + mSmallDrinks + mMediumDrinks + mLargeDrinks ;
    }

    /**
     * Returns the price of a cheeseburger.
     * @return price of cheeseburger.
     */
    public double getPriceCheeseburger() {
        return PRICE_CHEESEBURGER;
    }

    /**
     * Returns the price of a double double.
     * @return price of a double double.
     */
    public double getPriceDoubleDouble() {
        return PRICE_DOUBLE_DOUBLE;
    }

    /**
     * Returns the price of french fries.
     * @return price of french fries.
     */
    public double getPriceFrenchFries() {
        return PRICE_FRENCH_FRIES;
    }

    /**
     * Returns the price of a large drink.
     * @return price of large drink.
     */
    public double getPriceLargeDrink() {
        return PRICE_LARGE_DRINK;
    }

    /**
     * Returns the price of a medium drink.
     * @return price of a medium drink.
     */
    public double getPriceMediumDrink() {
        return PRICE_MEDIUM_DRINK;
    }

    /**
     * Returns the price of a shake.
     * @return price of shake.
     */
    public double getPriceShake() {
        return PRICE_SHAKE;
    }

    /**
     * Returns the price of a small drink.
     * @return price of small drink.
     */
    public double getPriceSmallDrink() {
        return PRICE_SMALL_DRINK;
    }

    /**
     * Returns the tax rate.
     * @return Tax rate for california.
     */
    public double getTaxRate() {
        return TAX_RATE;
    }
}
