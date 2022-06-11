PROBLEM 1: Sales Tax
--------------------

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions. 

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

INPUT:
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT:
Output 1:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68





SOLUTION
--------

Solution is provided in Java. Source code is available in ./src folder. 
Main file: ./src/main/java/com/salestax/SalesTaxApplication.java

Environment setup:
Java 1.8
Spring Tool Suite (IDE)
Junit 4

How to run the project?
There are two ways:
1. Import this Java project in your IDE with the given specifications for environment setup and run the project or “SalesTaxApplication.java” present in src/main/java/com/salestax. Default input files are provided in assets folder for program input
      (./assets/input1.txt, ./assets/input2.txt, ./assets/input3.txt).
      Or you can provide full path of your input file(s) as command line    
      arguments. Output will be displayed in console.

2. “SalesTaxApplication.jar” is an execuatable jar provided in parent directory. You can run it using java -jar <jar-file> <command-line-args-if-any>. If no command line argument is provided and it is running from same parent directory then it will take input files from assets folder.


Executions commands and screenshots are provided in Problem_Solution_Details.docx