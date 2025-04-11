<div style="text-align:center;"><img src="src/main/resources/pemacs-logo.png"></div>

# Recitation 9 - Using Arrays To Manage Objects

## Learning Outcomes

By the end of this activity, a student should be able to:

1. Implement a simple Java class
2. Include and use static fields.
3. Use the **Generate** feature to generate constructors and simple methods
5. Using an array to manage multiple objects




## The Grok Coalition

Imagine you are writing a video game with a Grok character. The Grok is a simple creature that can pick up and store power pills and eat them when its power level is low to increase its power level by the amount of power available in the power pill. If the Grok takes a hit, its power level is reduced by 5 points.

## The PowerPill Class

A power pill is an object that is available for the Grok to ingest. Once taken, it transfers its power to the Grok. A client can create different power pills with varying levels of power and names. This class was implemented in a previous assignment. In this recitation, you will complete the implementation of the `toString` and `equals` methods using IntelliJ's generator capabilities.

<div style="background-color:#00bbff; padding:5px; margin: 18pt 0; border-radius:8px; border: 1px solid darkgray;">
<p style="font-size:1.2em; font-weight:bold;">Task</p>
<ol>
<li>Use IntelliJ's Generate function to generate the `toString` method for the PowerPill class.
</li>
<li>Use IntelliJ's Generate function to generate the `equals` method.  IntelliJ will also generate the `hash` method as well.</li>
<li>Test the methods by using the included `PowerPill` unit test.</li>
</ol>
</div>


## Grok Class

Groks are bad actors in a game. They can ingest a PowerPill to replenish their energy, making them a challenge to kill. When Groks take a power pill, they take the power level of the pill. When Groks get hit, they lose 5 points of power. 

In a previous exercise, you implemented a version of the `Grok` that must ingest a power pill when they take it. In addition, the `Grok` you implemented can accumulate unlimited power. In this recitation, you will implement a maximum power level that a `Grok` object can attain. You will also implement the ability for a `Grok` object to accumulate power pills without ingesting them and choose when to ingest the power pills. The `Grok` object can also choose which power pill to ingest.

<div style="background-color:#00bbff; padding:5px; margin: 18pt 0; border-radius:8px; border: 1px solid darkgray;">
<p style="font-size:1.2em; font-weight:bold;">Task: Implementing Maximum Energy Attainable</p>
<p>All the methods in the <code>Grok</code> class that need to modify the power level, use the <code>setPowerLevel</code> method. </p>
<ol>
<li> Implment the <code>setPowerLevel</code> method so that the minimum attainable power level is 0 and the maximum attainable level does not exceed the named constant <code>MAXIMUM_POWER_LEVEL</code>.
</li>
<li>Test the method by running the unit test provided with this project.</li>
</ol>
</div>

<div style="background-color:#00bbff; padding:5px; margin: 18pt 0; border-radius:8px; border: 1px solid darkgray;">
<p style="font-size:1.2em; font-weight:bold;">Task: Storing Power Pills</p>
<p>
<code>Grok</code> objects will need to be able to store <code>PowerPill</code> objects by storing them in an array.  The maximum number of <code>PowerPill</code> objects that can be stored is given by the named constant <code>MAX_NUMBER_OF_POWERPILLS</code>.  A <code>PowerPill</code> object is picked up by a <code>Grok</code> object using the <code>pickUpPowerPill</code> method.  This method adds a <code>PowerPill</code> to an array if there is space in the array; otherwise, it does nothing.
</p>
<ol>
<li> Implement the method with the signature <code>public void takePowerPill()</code>.  This method adds the <code>PowerPill</code> object at <code>numOfPowerPills</code> position in the array to the <code>Grok</code> objects power level and decreases the <code>numOfPowerPills</code> available in the array.
</li>
<li>
Implement the method with the signature <code>public void takePowerPill(String name)</code>.  
</li>
<ol type="a">
<li>set <code>pillToIngest</code> to <code>null</code>.  Use this variable to hold the <code>PowerPill</code> object found in the array.
</li>
<li> Iterate through the array and at each iteration, 
<ul>
<li>If the <code>PowerPill</code> has not been found, then check if the current one matches.  If it matches, then assign the <code>PowerPill</code> object to <code>pillToIngest</code> and set <code>isFound</code> to <code>true</code>.
<li>If it has been found, then copy the current <code>PowerPill</code> object to the previous position in the array.</li>
</ul>
<li> If a pill was found, then add the <code>pillToIngest</code> object's power level to this <code>Grok</code>'s power level and decrease the <code>numOfPowerPills</code>
</li>
</ol>
<li>Test the method by running the unit test provided with this project.</li>
</ol>
</div>


# Submitting Your Work

Use the CodeGrade link provided on Blackboard to submit this work when completed.


<span style="font-size:2em;color:green;">Happy Coding!</span>