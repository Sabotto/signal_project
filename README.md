# Cardio Data Simulator

The Cardio Data Simulator is a Java-based application designed to simulate real-time cardiovascular data for multiple patients. This tool is particularly useful for educational purposes, enabling students to interact with real-time data streams of ECG, blood pressure, blood saturation, and other cardiovascular signals.

## Features

- Simulate real-time ECG, blood pressure, blood saturation, and blood levels data.
- Supports multiple output strategies:
  - Console output for direct observation.
  - File output for data persistence.
  - WebSocket and TCP output for networked data streaming.
- Configurable patient count and data generation rate.
- Randomized patient ID assignment for simulated data diversity.

## Getting Started

### Prerequisites

- Java JDK 11 or newer.
- Maven for managing dependencies and compiling the application.

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/tpepels/signal_project.git
   ```

2. Navigate to the project directory:

   ```sh
   cd signal_project
   ```

3. Compile and package the application using Maven:
   ```sh
   mvn clean package
   ```
   This step compiles the source code and packages the application into an executable JAR file located in the `target/` directory.

### Running the Simulator

After packaging, you can run the simulator directly from the executable JAR:

```sh
java -jar target/cardio_generator-1.0-SNAPSHOT.jar
```

To run with specific options (e.g., to set the patient count and choose an output strategy):

```sh
java -jar target/cardio_generator-1.0-SNAPSHOT.jar --patient-count 100 --output file:./output
```

### Supported Output Options

- `console`: Directly prints the simulated data to the console.
- `file:<directory>`: Saves the simulated data to files within the specified directory.
- `websocket:<port>`: Streams the simulated data to WebSocket clients connected to the specified port.
- `tcp:<port>`: Streams the simulated data to TCP clients connected to the specified port.

## UML Diagrams
The alert generation system is created using interfaces of an alert generation system that is then implemented for alerts based on record type. There is a base alert class, an alert generator (evaluator), an alert factory interface (creator), and an alert strategy pattern interface (used for threshold management). These are used to make alert systems for blood pressure, ECG, and blood oxygen records for patients. The strategy's checkAlert() method checks the thresholds for the measurement of the record. If the threshold limit is passed, a new alert is returned (made by the alert factory). This then goes through the AlertGenerator class, which evaluates the data of the alert before triggering it. The Alert class is used to set and get the data, and of course, each record type uses the same system described previously. Subsystems such as the data storage and patient identification are also being used.
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Project Members
- Maciej: i6404228
- Saman: i6389648
