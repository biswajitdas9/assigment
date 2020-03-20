retail-billing-system
====================


On a retail web site, the following discounts apply: 
 
  1. If the user is an employee of the store, he gets a 30% discount 
  2. If the user is an affiliate of the store, he gets a 10% discount 
  3. If the user has been a customer for over 2 years, he gets a 5% discount. 
  4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). 
  5. The percentage based discounts do not apply on groceries. 
  6. A user can get only one of the percentage based discounts on a bill.  
  
  Write a program in the programming language of your choice with test cases such that given a bill, it finds
  the net payable amount.
  
  Instruction Flowing:
  
  Created this project as maven project. Import this from eclipse as a existing maven project.
  Run mvn eclipse: eclipse
  To run the test cases run mvn clean install.
  
  For code coverage Run with Colver --> junit
  (http://openclover.org/doc/manual/4.2.0/eclipse--configuration-options.html)
  
  
  For code coverage using Coberatura
  
  Run mvn cobertura:cobertura
  
  Goto traget folder of the project ---> site--->index.html
  
  Please find the UML diagram in below location
  (/retail_billing/src/main/resource/img/)