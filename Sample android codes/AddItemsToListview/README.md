# Topic: How to add items to Listview #
Our sample project is simple, how to add items to listview in Katolin and Java as a comparison. In this running sample i will show you how it's done in both langauges and you see how much time and less complexity it is in Katolin compared to Java.

## Screenshots ##

![Add new Item](screenshots/screen2.png)
![Added items](screenshots/screen1.png)
 ## Java to Katolin simplified ##
The aim of this project and that which will follow is to empahsize how simple and easy to transition from Java based codes to Katolin, as far as Android developement is concerned.

Android developement in Katolin speeds and boots you productivity. This is not an introduction to Katolin in android, rather a quick overview for those who have'nt yet tried it on Katolin or for new comers persuing their dreams in Android developement.
## How to create clases in both. ##
 in both languages the `class` key word is used.

 ## Pre-requisites ##
***
Atlist basic knowladge of creating a project in Android Studio is required.

 in **Java**

  `class AddItemToListActivity extends AppCompatActivity{ }`

 Equivalent to **Katolin**

  `class AddItemToListActivity : AppCompatActivity(){  }`
  ### Create `class` properties. (The following codes should be put in respective classes of course, as shown in the running project) ###

  In **Java.** how to create class variables

  `private ArrayList<String> countries;`.

  Don't forget to add the trailing semi colon `;` on every statement in Java,  Your code can not compile if it is missing. As you will see in Katolin, semi colons are not compulsory. This reduces the time you spend debugging your code due to missing semi colon `;`.

  In **Katolin** to declare variables, we use the key words `val` for constants or immutable variables (varible which never change after their creation), or `var` for mutable variables.

  Example:

  `val countryCode : Int =256`

  `var fName : String = "Kagiri"`

  You do not have to put the semi colon at the end, looks good, rihgt?

  One more thing to note while declaring variables in Katolin. Varibale declaration and assignment is done at same time. If you intend to assigin the varibale later in code, use `lateint` to promise to the compiler not to throw an error that you will assign a value to forementioned varibale later in code, also the varable data type becomes compulsory.

  You do this, `private lateint fName : String`

  You can not do this, `private lateint fName`

 That is enough intro, try to go through and compile the project, it is also comment for better undrstanding what is going on.
