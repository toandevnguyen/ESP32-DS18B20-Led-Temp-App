# Android App for IoT Light Control and Temperature Display
## Project Overview
- This repository contains the code for an Android application that interacts with an IoT system using an ESP32-C3 microcontroller. The app allows users to control 220V lights remotely and monitor temperature using a DS18B20 sensor via MQTT over TCP.
- [Demo Video Link](https://24ffdk-my.sharepoint.com/:v:/g/personal/toan5tb1drivedev_24ffdk_onmicrosoft_com/EdekrNNiyAdAr4RuuM1K9csBAXf8sxO2ubKTF2UoG07UlA?e=lwrZPB) 

## Features
- Remote control of 220V lights via MQTT
- Real-time temperature display from DS18B20 sensor
- User-friendly interface

## Technologies Used
- **Hardware**:
  - ESP32-C3
    ![ESP32-C3](https://i.ebayimg.com/images/g/WkEAAOSw1iZli80j/s-l500.jpg)
- DS18B20 sensor,
- 220V relay module
- **Software**: Android (Java/Kotlin), MQTT protocol, TCP communication

## Setup Instructions
1. **Backend Setup**:
   - Follow the instructions in the [IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20](https://github.com/yourusername/IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20) repository for hardware and software setup.

2. **Mobile App Setup**:
   - Clone the repository: `git clone https://github.com/yourusername/Android-App-IoT-ESP32C3-MQTT-TCP-RemoteLights220V-DS18B20`
   - Open the project in Android Studio.
   - Configure MQTT broker settings in the app code.
   - Build and run the app on an Android device.

## Usage
- Use the app to connect to the IoT system.
- Control the 220V lights and view real-time temperature data.

## Contributing
Contributions are welcome! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
