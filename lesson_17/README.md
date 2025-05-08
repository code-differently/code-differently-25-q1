# Lesson 17: OOP Principles, Part II ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_17))

## Pre-work

Please review the following resources before lecture:

### Required

* [Object-oriented Programming in 7 minutes | Mosh (Video)](https://www.youtube.com/watch?v=pTB0EiLXUC8)
* [Naming Convention In Java Tutorial #77 (Video)](https://www.youtube.com/watch?v=QazDDPtSulY)

### Recommended

* [Naming Conventions - Oracle (Article)](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
* [Test-Driven Development (TDD): A Time-Tested Recipe for Quality Software (Article)](https://semaphoreci.com/blog/test-driven-development)

## Homework

- [ ] Complete [Applying SOLID principles](#applying-solid-principles-bank-atm) exercise.
- [ ] Review [OOP Project](/project_oop/) documentation and complete user stories.

## Applying SOLID Principles (Bank ATM)

Your task for this assignment is add enhancements to an ATM simulator. The [BankAtm][bankatm-file] is at the center of the model, allowing us to add one or more `CheckingAccount` instances and make withdrawals or deposits via cash or check. You will need to implement at least two of the following functional enhancements to the `BankAtm` class WITHOUT adding a new method. Note that you can update existing methods, however.

### Functional Requirements

* We want to support a `SavingsAccount` that works just like the `CheckingAccount`, but doesn't allow you to write checks against the account.
* We want the `BankAtm` class to support the concept of a `BusinessCheckingAccount`. A business account requires that at least one of the owners is a business.
* In addition to supporting checks and cash, we also want to support the concept of another monetary instrument called a `MoneyOrder`. Unlike a `Check`, a `MoneyOrder` withdraws funds from a source account immediately on creation for the purposes of this simulation..
* For traceability, all of the transactions in the `BankAtm` class should logged. Create an `AuditLog` class that keeps a record of all debits and credits to any account and integrate it with the `BankAtm` class. 
* ~~For the `depositFunds` method that accepts a cash amount, we'd like the ability to deposit funds in a variety of currencies. Add a parameter that accepts a currency type and a new object that encapsulates the currency converter logic for converting a cash amount to the account currency type.~~

### Technical Requirements

* You must integrate new features into the `BankAtm` without adding a new public method. Existing public methods may be modified without breaking existing functionality.
* You must update the `BankAtm` tests and may modify or add other applicable tests.
* Feel free to add the minimal number of classes, interfaces, or abstract classes needed to fulfill each requirement.
* You must update existing javadocs and may add new documentation for new types and methods you introduce.

[bank-folder]: ./bank/
[bankatm-file]: ./bank/bank_app/src/main/java/com/codedifferently/lesson17/bank/BankAtm.java