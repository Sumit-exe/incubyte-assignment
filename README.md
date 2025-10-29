# String Calculator

This is a **Java project** that implements a String Calculator.

## Features

- Add numbers from a string input.
- Support custom delimiters of **any length**, e.g. `//[***]\n1***2***3`.
- Support multiple delimiters, e.g. `//[*][%]\n1*2%3`.
- Default delimiters: comma `,` and newline `\n`.
- Detect negative numbers and throw an exception listing all negatives.
- Ignore numbers **≥ 1000**.

## Requirements

- **JDK 22**
- **Maven**
- **JUnit 5** (included in `pom.xml`)

## How to Run

1. **Clone the repository**

```bash
git clone <repository-url>

2. **Navigate to the project folder**

```bash
cd <project-folder>

3. **Install Maven dependencies**

```bash
mvn install

4. **Locate the test file**

```bash
src/test/java/org/example/CalculatorTest.java

5. **Run the tests**

```Using Maven:
mvn test


# Notes

- The assignment was enjoyable and well-structured, with incremental difficulty.
- Took some help from Google for pattern matching and writing the README.
- All tests were completed successfully within 1 hour.

