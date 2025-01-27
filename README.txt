*Overview*
This folder includes three separate files titled, Main, Product, and Inventory, each with an important task that
allows users to add products, update product information, delete products, and view the current inventory. The
system was created with Java and incorporates the data structure ArrayList, in order to contain the inventory.
I believe that it may only be able to run if all the files are in the same folder.

*Product*
The Product class contains variables that each new product that is dealt with will contain, setters and getters
for manipulating each product, and a constructor to assign each product with its variables.

*Inventory*
The Inventory class contains an ArrayList that contains all of the products that will be added, deleted, updated,
viewed, and searched for. It contains methods such as addProduct, that will add a product to the arraylist, updateProduct,
that will update a selected product, deleteProduct, that will delete a selected product, viewInventory, that will allow
users to view all variables associated with all products in the inventory, and searchProduct, that will search for a
specific product with a matching keyword. 

*Main*
The Main class contains pre-inserted data that will automatically generate when the program is ran. This is to ensure that
the view and search methods begin at the beginning of the program running. Construction of the CLI is then began after that,
along with a switch functionality that will process each case according to the input command that is associated with the name
of the options. Switches allow for ease of use for the user as well as the programmer. The add case will take you step by step 
through a series of prompts that will attach each input item to its corresponding variable and will add them all to the product
constructor in order to create a product. This product will then be added to the products arraylist, and if a variable is input 
incorrectly, then an error message will be displayed. The update case will go through each variable that you would like to change, 
and if you would not like to change a certain variable you can skip it. The delete case will remove a specific product from the 
products arraylist by accessing the deletion lambda from the Inventory class. The view case will display a detailed menu showing
all products and their associated variables that are within the products arraylist. The search case will search for a specific
product based off the name searched for. There are error messages displayed if there is no input and if there is not a product
matching the name entered. There is also an exit case that will end the program after entered. There is lastly a default case that
assumes there is an invalid input and displays an error message unless there is a correct comman entered. You must type in the name
of the case, not the number, and it is not case sensitive, as it will automatically bring characters to lower case no matter if they
are input as upper case or not.

*AI/Copilot Usage*
Using Copilot enabled me to spend more time and even help me with more detailed methods rather than using that time on easier methods 
such as setters and getters. Copilot was able to assist me when I ran into problems more specifically on the search case in the Main
class. It was really cool being able to highlight code and have Copilot right above where my code was and be able to add what it suggested
to change with one click. Also, using Copilot helped highlight the fact that it is not right a bit of the time and needs to be closely
observed in order to synthesize correctly. Creating this assignment became much easier by having Copilot help with the easy and hard bits
of this assignment. I enjoyed having its suggestions and quickness enhancements offered to me within VSCode. 
Example prompts used include:
"How can I make an if statement within the search case that will throw an error message when a product that does not exist is entered?"
"Help me with commenting on the code."
"Help me with the display for the view case in the main class."
