# movie-theater-sim
cs 241 final
# Movie Theater Simulator

*A Java final project using ADTs, algorithms, and JUnit testing.*

---

## **Project Overview**

The Movie Theater Simulator is a Java-based command-line application that models a simplified movie theater ticketing process. It allows theater managers to simulate customer flow, ticket purchases, revenue generation, and transaction logging. The program demonstrates the use of multiple abstract data types and includes full JUnit testing.

---

## **Team Members**

* **Michael:** Customer Queue (Queue ADT)
* **Briana:** Movie Manager (HashMap ADT)
* **Silas:** Transaction History (Stack ADT)

---

## **Data Structures Used**

### **Queue**

Used to model customers waiting in line. Processes customers in FIFO order.

### **HashMap**

Stores movie information, ticket prices, tickets sold, and revenue per movie.

### **Stack**

Tracks transaction history. Supports undoing the most recent transaction and generating movie rankings.

---

## **Features**

### **Customer Simulation**

* Users can specify the number of customers.
* Each customer is assigned a movie choice.
* Queue processes customers in order of arrival.

### **Movie Management**

* Stores three movies with customizable ticket prices.
* Tracks ticket sales and calculates revenue.
* Determines the most profitable movie.

### **Transaction Logging**

* Every ticket sale creates a transaction entry.
* Allows undoing the latest sale.
* Generates a ranking of movies based on number of purchases.

### **Simulation Output**

* Tickets sold per movie
* Total revenue
* Number of customers processed
* Number of transactions
* Movie ranking by popularity