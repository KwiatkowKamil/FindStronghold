# FindStronghold

A simple utility that allows to find the Minecraft stronghold location based on 2 ender eye throws.
## Usage
#### Jar example usage
```console 
foo@bar:~$ java -cp "picocli-4.6.1.jar:FindStronghold.jar" FindStronghold [1.0,3.0,270.0] [-1.0,3.0,90.0]
```
#### Console utility 
```shell
Usage: findstronghold [-hV] FIRST_THROW SECOND_THROW
Finds the Minecraft stronghold location based on 2 ender eye throws.
      FIRST_THROW    [<x_coordinates>, <y_coordinates>, <angle_from_y>]
      SECOND_THROW   [<x_coordinates>, <y_coordinates>, <angle_from_y>]
  -h, --help         Show this help message and exit.
  -V, --version      Print version information and exit.

```
##### Example
```console
foo@bar:~$ ./findstronghold-linux-amd64 [7.0,1.0,315.0] [1.0,1.0,45.0]
```
## Dependencies used
* [picocli](https://picocli.info/)
* [JUnit 5](https://junit.org/junit5)

## Math
<p align="center">
<img src="ReadmeResource/diagram.png" width="500"></br>
</p>
Based on the diagram, an equality can be stated:</br>
<p align="center">
<img src="https://latex.codecogs.com/svg.image?x_C&space;-&space;x_A=(y_C-y_A)tan(\alpha)"></br>
</p>
Analogously, the same can be written for the second ray:</br>
<p align="center">
<img src="https://latex.codecogs.com/svg.image?x_C&space;-&space;x_B=(y_C-y_B)tan(\beta)" title="x_C - x_B=(y_C-y_B)tan(\beta)" /></br>
</p>
Combining those equations the y coordinate of the intersection point can be derived:</br>
<p align="center">
<img src="https://latex.codecogs.com/svg.image?y_C&space;=&space;\frac{tan(\alpha)y_A&space;-&space;tan(\beta)y_B&space;-&space;x_A&space;&plus;&space;y_B}{tan(\alpha)&space;-&space;tan(\beta)}" title="y_C = \frac{tan(\alpha)y_A - tan(\beta)y_B - x_A + y_B}{tan(\alpha) - tan(\beta)}" /></br>
</p>
Plugging in the value into either of the previous equations gives us the x coordinate:</br>
<p align="center">
<img src="https://latex.codecogs.com/svg.image?x_C&space;=&space;(y_C&space;-&space;y_A)tan(\alpha)&space;&plus;&space;x_A" title="x_C = (y_C - y_A)tan(\alpha) + x_A"/>
</p>




