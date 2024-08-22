# NFL Schedule

I like the NFL.

I am trying to learn Kotlin.

This project combines the two! It is a simple Spring application that calls an API and returns the next NFL game of the selected team. 

## Work in Progress
🚧 **This project is currently a work in progress.** 🚧  

Expect frequent changes and updates.  
Contributions and feedback are welcome!

## Getting Started

These instructions will the project up and running on your local machine for development and testing purposes.

### Prerequisites

* **Java Development Kit (JDK) 17 or higher:** [https://www.oracle.com/uk/java/technologies/downloads/#java17](https://www.oracle.com/uk/java/technologies/downloads/#java17)
* **Gradle Build Tool:** [https://gradle.org/install/](https://gradle.org/install/) (Or use your IDE's integrated Gradle support)
* **Git:** [https://git-scm.com/](https://git-scm.com/) (If you're cloning the repository)

### Setting Environment Variables

The application requires an environment variable for the NFL API key. To obtain this, you will need to subscribe to 
the [Tank01 NFL Live In-Game Real Time Statistics NFL](https://rapidapi.com/tank01/api/tank01-nfl-live-in-game-real-time-statistics-nfl)
on [Rapid API](https://rapidapi.com/)  
Follow the instructions below to set the environment variable on your operating system.

#### On macOS/Linux

1. Open a terminal.
2. Add the following line to your shell configuration file (`.bashrc`, `.zshrc`, etc.):
    ```sh
    export NFL_API_KEY=your_api_key_here
    ```
3. Reload the shell configuration:
    ```sh
    source ~/.bashrc  # or source ~/.zshrc
    ```

#### On Windows

1. Open Command Prompt or PowerShell.
2. Set the environment variable using the following command:
    ```sh
    setx NFL_API_KEY "your_api_key_here"
    ```

### Build the project
```
./gradlew build
```  
### Usage
1. Run the application:
```
./gradlew bootRun
```
2. Access the application: Open your web browser and navigate to http://localhost:8080 (or the port specified in your application.properties).

