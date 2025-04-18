import java.util.Objects;

/**
 * Groks are bad actors in a game.  Groks have the ability to ingest
 * a PowerPill to replenish their energy.  This makes them difficult
 * to kill.
 *
 * @author (You Again)
 * @version (0.1)
 */
public class Grok
{
    private static final int MAX_POWER_LEVEL = 100;
    private static final int DEFAULT_POWER_LEVEL = 50;
    private static final int MAX_NUMBER_OF_POWERPILLS = 5;

    // instance variables
    private int powerLevel;
    private PowerPill[] powerPill;
    private int numOfPowerPills;

    // accessor variables

    /*
     * Initializes a Grok object to the default power level of 50.
     */
    private void init(int powerLevel)
    {
        setPowerLevel(powerLevel > 10 ? powerLevel : 10 );
        powerPill = new PowerPill[MAX_NUMBER_OF_POWERPILLS];
        numOfPowerPills = 0;
    }

    public Grok()
    {
        init(DEFAULT_POWER_LEVEL);
    }

    /*
     * Initializes a Grok object to power powerLevel
     */
    public Grok(int powerLevel)
    {
        init(powerLevel);
    }

    // accessor methods

    /*
     * Returns the power level of this Grok.
     * @return returns the power level of this Grok
     */
    public int getPowerLevel()
    {
        return powerLevel;
    }

    /**
     * Returns true if this Grok can pick up a power pill;
     * otherwise returns false.
     *
     * @return Returns true if this Grok can pick up a power pill;
     *         otherwise returns false.
     */
    public boolean canPickUpPowerPill(){
        return numOfPowerPills < powerPill.length;
    }

    // mutator methods

    /*
     * Sets the power level of this Grok.
     * @param powerLevel the power value to set for this Grok.
     */
    public void setPowerLevel(int powerLevel)
    {
        if (powerLevel > MAX_POWER_LEVEL){
            this.powerLevel = MAX_POWER_LEVEL;
        } else if (powerLevel < 0){
            this.powerLevel = 0;
        } else {
            this.powerLevel = powerLevel;
        }
    }

    /*
     * Stores the pill for later use.  If there is no space left
     * nothing happens.
     * @param pill The PowerPill that this Grok picks up to store
     */
    public void pickUpPowerPill(PowerPill pill)
    {
        if (numOfPowerPills < powerPill.length){
            powerPill[numOfPowerPills] = pill;
            numOfPowerPills++;
        }
    }

    /**
     * Takes the last pill this Grok picked up.  The power of the pill
     * is added to this Grok's power level.
     */
    public void takePowerPill()
    {
        if (numOfPowerPills > 0){
            PowerPill pillToIngest = powerPill[numOfPowerPills-1];
            numOfPowerPills--;
            powerPill[numOfPowerPills] = null;
            setPowerLevel(powerLevel+pillToIngest.getPower());
        }
    }

    /**
     * Takes the pill that has a name given by name.  If there is a
     * pill with that name, this Grok takes it; otherwise nothing
     * happens.
     *
     * @param name The name of the pill this Grok wants to ingest.
     */
    public void takePowerPill(String name)
    {
        /*
         * Search for name in array and if found keep a reference to
         * that pill then copy all power pills over so that the
         * consumed power pill is removed from the array and there
         * are no gaps in the array.
         */
        PowerPill pillToIngest = null;
        boolean isFound = false;
        for (int checker = 0; checker < powerPill.length; checker++){
            if (!isFound){
                if (Objects.equals(powerPill[checker].getName(), name)){
                    isFound = true;
                    pillToIngest = powerPill[checker];
                    setPowerLevel(powerLevel+pillToIngest.getPower());
                    powerPill[checker] = null;
                    numOfPowerPills--;
                }
            }
            else{
                powerPill[checker-1] = powerPill[checker];
            }
        }
    }

    /*
     * Invoked when this Grok takes a hit.  The power level of
     * this Grok is reduced by 5.
     */
    public void tookHit()
    {
        setPowerLevel(powerLevel - 5);
    }
}
