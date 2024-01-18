# E-Commerce Checkout System

## Overview

This Java program simulates an e-commerce checkout system with a dynamic pricing strategy and discount rules. It allows users to input the quantity of products, choose gift wrapping options, and calculates the total amount with applied discounts, fees, and shipping costs.

## Features

- **Product Catalog**: Supports three products (Product A, Product B, and Product C) with corresponding prices.
- **Discount Rules**: Four discount rules are implemented to provide the most beneficial discount for the customer:
  - Flat $10 discount if the cart total exceeds $200.
  - 5% discount on the total price of any product if its quantity exceeds 10 units.
  - 10% discount on the cart total if the total quantity exceeds 20 units.
  - 50% discount on quantities above 15 for any single product and if the total quantity exceeds 30.
- **Fees**: Gift wrap fee of $1 per unit and shipping fee of $5 per package (each containing 10 units).
- **Interactive Program**: User-friendly command-line interface to input product quantities and gift wrap preferences.
- **Detailed Output**: Displays a detailed summary of the purchase including the product details, subtotal, applied discount, fees, shipping costs, and the final total.

## Usage

1. **Clone the repository:**
   
    ```bash
    git clone https://github.com/gokul-gajapathi/task.git
    ```

2. **Run the program:**
   
    ```bash
    cd task
    javac Task1.java
    java Task1
    ```

3. **Follow the prompts to input product quantities and gift wrap preferences.**

4. **Review the detailed output containing the purchase summary.**

