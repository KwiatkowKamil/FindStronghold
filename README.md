# FindStronghold

A simple utility that allows to find the Minecraft stronghold location based on 2 ender eye throws.
<p align="center">
<img src="ReadmeResource/diagram.png" width="500"></br>
Based on the diagram, an equality can be stated:</br>
<img src="https://latex.codecogs.com/svg.image?x_C&space;-&space;x_A=(y_C-y_A)tan(\alpha)"></br>
Analogously, the same can be written for the second ray:</br>
<img src="https://latex.codecogs.com/svg.image?x_C&space;-&space;x_B=(y_C-y_B)tan(\beta)" title="x_C - x_B=(y_C-y_B)tan(\beta)" /></br>
Combining those equations the y coordinate of the intersection point can be derived:</br>
<img src="https://latex.codecogs.com/svg.image?y_C&space;=&space;\frac{tan(\alpha)y_A&space;-&space;tan(\beta)y_B&space;-&space;x_A&space;&plus;&space;y_B}{tan(\alpha)&space;-&space;tan(\beta)}" title="y_C = \frac{tan(\alpha)y_A - tan(\beta)y_B - x_A + y_B}{tan(\alpha) - tan(\beta)}" /></br>
Plugging in the value into either of the previous equations gives us the x coordinate:</br>
<img src="https://latex.codecogs.com/svg.image?x_C&space;=&space;(y_C&space;-&space;y_A)tan(\alpha)&space;&plus;&space;x_A" title="x_C = (y_C - y_A)tan(\alpha) + x_A"/>
</p>
