# Sanctioning Application

Background

	Economic sanctions are financial penalties that can be applied by one or more countries to a person, group or a country. These countries release sanctions list to banks which show the parties in which no financial transactions are to be made. This is government mandated.

Problem

	Many times names in a list can be slightly spelled differently due to typos and various other reasons. This is a huge problem if a system cannot detect a name that is actually on a particular sanction list and pays that individual or organization.

Program Detail

	This program is an application that takes a name as its input and screens the name against a stored list of names. 
	The program traverses through a file or system input and takes a name or a list of names and checks the similarity/ matches between the given name and the stored names. 
	The program checks the percentage of how similar is the input to each name of stored names. The program then returns the maximum percentage out of all the possible comparisons of the stored names.

	The program outputs a message containing "Hit" if the percentage of similarity is greater than a 75% match. Contrary, the program prints out the message "No Hit" if that particular condition is not satisfied. In both cases, the percentage corresponding with the current match will be appended to the output of the program. Thus, the output will print "Hit - (Percentage Here)" or "No Hit - (Percentage Here)."

	Initially the program took a dynamic programming approach. However, to improve readability and simplicity this program uses the Apache Commons framework. Commons is a powerful and convenient framework that handles heavy string text processing methods. Additionally, the Jaro Winkler algorithm and Levenshtein distance algorithms were key in the development of the solution.
		
		-You can learn about these algorithms here: 

Running the Program 
	
Originally, this project was created using the NetBeans IDE.

	You will need: 
		-Java JDK 8 or Higher (You can install it here: )
		-IntelliJ/any IDE or Command Prompt/ Terminal
	

	In NetBeans IDE: 
		_ Open NetBeans IDE
		- Go to File > Open Project
		- Navigate to the directory associated with the Sanctioning application and open the base directory.

	In Intellij IDEA IDE:
		-Open Intellij(or any IDE) and navigate to the directory associated to the sanctioning application.
		- Open the pom.xml file associated with project > select Open as Project.
	Note: You may need to run a configuration to this project.

			

Output 
	
	As mentioned before, the application will output a message determining whether a name is a hit or miss in a given sanction list with the corresponding max percentage out of the matches in the list.

Examples
	Please enter the inputs in the prompt when running the program.

		- input: Khristopher Doe   output: Khristopher Doe - Hit 100%
		- input: Iceland	   output: Iceland - Hit 100%
		- input: Khristopher Toe   output: Khristopher Toe - Hit 97.3%
		- input: Royal Arctic Line output: Royal Arctic Line - Hit 100%
		

	 




