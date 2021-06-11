The Bank app is a web-based application that simulates banking operations. A customer can apply for an account, view their balance, and make withdrawals and deposits. An employee can aprove or deny accounts and view account balances for their customers.

Feature Requirements:
1. Customers of the bank should be able to register with a username and password, and apply to
open an account.
o Customers should be able to apply for joint accounts
2. Once the account is open, customers should be able to withdraw, deposit, and transfer funds
between accounts
o All basic validation should be done, such as trying to input negative amounts,
overdrawing from accounts etc.
3. Employees of the bank should be able to view all of their customers information
o This includes, account information
o Account balances
o Personal information
4. Employees should be able to approve/deny open applications for accounts
Technical Requirements:
1. Every Java class should have at least one unit test.
2. Logging should be accomplished using Log4J
a. All transactions should be logged to a file
3. All user interactions should be via a frontend made in HTML, CSS, and JavaScript
4. All information should be persisted using AJAX requests to initiate database operations
5. Backend should be using servlets
