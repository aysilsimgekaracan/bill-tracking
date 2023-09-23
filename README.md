# Bill Tracking System
This web application built with Spring Boot enables users to register for a service. The signup page presents a form for the user to fill out with their username, name, surname, email, and password. Upon submission of the form, the application stores the new user in the database and then shows a list of all users on the expenses page. The expenses page shows a dropdown list of users and allows the user to select a specific user and view their expenses. The add expense page shows a list of all users and takes inputs about expense such as expense name, amount, date etc and store expense to the database. It also has a delete button for each expense, allowing the user to remove the expense from the database.

## Screens

### Register Screen
Accessible from:http://localhost:8080/adduser

<img width="780" alt="Screenshot 2023-09-23 at 15 10 53" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/ab6a778a-062f-4d46-aa7a-ce5e5a569036">

The form for signing up includes fields for the user to enter their username, name, surname,
email, and password. When the user submits the form, it is sent to the server as a POST
request to the URL "/signup".

The "adduser" method in the controller receives the form data as an instance of the "User"
class, which is annotated with "@ModelAttribute". This means that the form data should be
mapped to the fields of the "User" object. The method then calls the "signup" method of the
"userServiceImpl" object to store the new user in the MySQL database.

Finally, the method returns the "expenses" view, which is a Thymeleaf template that displays
the list of expenses.

### Login Screen

Accessible from:http://localhost:8080/
<img width="793" alt="Screenshot 2023-09-23 at 15 11 20" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/09a14f31-86b5-43cd-88a0-e88e3a6838cc">

The HTML template has a form that allows the user to enter their username and password.
When the form is submitted, it makes a POST request to the "/login" endpoint with the form
data as the request body. The form data is bound to a "User" object and passed as an
argument to the login method in the controller.

The login method in the controller uses the provided username and password to try to log
the user in. It first checks if the given username exists in the database then if it exists it gets
the user by the username and checks if the passwords are matched. If the login is
successful, it returns the "expenses" page. If the login is not successful, it redirects the user
back to the login page by returning "redirect:/".


### Expenses Screen
<img width="603" alt="Screenshot 2023-09-23 at 15 11 41" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/89c99424-4dbb-475b-9dcc-389a23dbd0e0">

The web page shows a list of users and enables the user to choose one of them to view their
expenses.
<img width="770" alt="Screenshot 2023-09-23 at 15 11 49" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/bd2d127b-e0eb-421a-820c-24dec7dddda7">

The selected user's expenses are displayed in a table. The user can also add new expenses
or delete existing ones from this page. The Java code has two controllers, one for displaying
the expenses page and one for handling requests to select a user and display their
expenses. The "expense" method of the first controller is responsible for displaying the
expenses page, which includes a form for selecting a user and a table for displaying their
expenses. The "selectUser" method of the second controller is responsible for handling
requests to select a user and display their expenses. It does this by retrieving the list of all


users and the expenses for the selected user, and adding them to the model to be displayed
on the expenses page.

### Add Expense Screen
<img width="768" alt="Screenshot 2023-09-23 at 15 11 57" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/312cd4f7-f6a5-44af-b169-44bfbc7a6fcf">

An HTML file provides a form that allows a user to input information about a new expense,
such as the name, amount, date, and description. When the user submits the form, the data
is sent to the server as a POST request and sent to the "/addexpense" URL. The associated
Java code then takes this request and creates a new Expense object using the form data,
saving it to the database using the expenseServiceImpl.addExpense() method. If the
expense is added successfully, the user is redirected to the "expenses" page. If the addition
is unsuccessful, the user is returned to the page for adding an expense.


## Project Demonstration

First let’s sign up for Bill Tracking application.
<img width="843" alt="Screenshot 2023-09-23 at 15 12 07" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/97905ba6-d012-40cb-97db-e846ff282ff3">

As it can be seen It successfully writes to the database.
<img width="779" alt="Screenshot 2023-09-23 at 15 12 15" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/e2958f76-aed6-4d56-8d5b-39a15a8c7cf2">


After user information is written to the database, it redirects to the expenses page.
<img width="745" alt="Screenshot 2023-09-23 at 15 12 23" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/0ff7a519-6ae2-4247-8b6b-5772d7db29d4">
<img width="772" alt="Screenshot 2023-09-23 at 15 12 35" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/b918b3b7-1c29-4082-9df5-a23e276991fd">

Login panel also redirects to the expenses page after successful authentication.


Let’s add an expense by clicking the “Add Expense” button.
<img width="717" alt="Screenshot 2023-09-23 at 15 12 42" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/51dd2cd4-fa03-4fc8-b948-5ceba1157c83">
<img width="739" alt="Screenshot 2023-09-23 at 15 12 49" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/a5691af3-5cc7-4d23-b541-d48b6de5a11a">
<img width="829" alt="Screenshot 2023-09-23 at 15 13 00" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/47427792-c684-4377-81bd-b2267e73e4b1">


As it can be seen, it successfully writes into the database.
<img width="798" alt="Screenshot 2023-09-23 at 15 13 09" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/403a469f-2967-4e88-9b65-0fba88796d08">

Also it is possible to delete expenses from the expense list.
<img width="815" alt="Screenshot 2023-09-23 at 15 13 17" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/4f91f64c-f266-4c86-87ca-e733532529df">
<img width="822" alt="Screenshot 2023-09-23 at 15 13 28" src="https://github.com/aysilsimgekaracan/billtracking/assets/43148881/f95217ff-30a6-430a-af90-da6d46c6ce4e">

When we check the database, It can be seen that the operation is successful.
