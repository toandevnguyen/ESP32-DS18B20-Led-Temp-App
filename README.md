# Android App for IoT Light Control and Temperature Display
## Languages
- [Tiếng Việt](docs/README_vi.md)
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
    
  - DS18B20 Temperature Sensor
    
     <img src="https://i.ebayimg.com/images/g/6sYAAOSwnmxfhlJE/s-l1600.webp" alt="ESP32-C3" width="70%"/>
        
  - 1 Channel 5V Relay Module
    
    ![Relay](https://bizweb.dktcdn.net/100/005/602/files/ad4.jpg?v=1465956650836)
    
  - LED Bulb
    
    <img src="https://kawaled.com/image/catalog/bulb-tru---tron-led2/den-led-tron-led2-a60-9w.jpg" alt="LED Bulb" width="70%"/>
    
- **Software**: Android (Java/Kotlin), ESP-IDF Visual Studio Code Extension, MQTT Explorer

## Setup Instructions
1. **Setting Up Mosquitto MQTT Broker on Google Cloud's Compute Engine**:
   - Create a virtual machine (VM) on Google Cloud Platform with Ubuntu 20.04 Server.
   - Connect to your VM using SSH.
   - Install Mosquitto MQTT Broker:
     ```sh
     sudo apt update
     sudo apt install -y mosquitto mosquitto-clients
     ```
   - Enable Mosquitto to start on system boot and start the Mosquitto service:
     ```sh
     sudo systemctl enable mosquitto
     sudo systemctl start mosquitto
     ```
   - Verify that Mosquitto is running:
     ```sh
     sudo systemctl status mosquitto
     ```
2. **Wiring Diagram**:

    ![Wiring Diagram](https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/S%C6%A1%20%C4%91%E1%BB%93%20n%E1%BB%91i%20d%C3%A2y.png)
3. **Installing VS Code and ESP-IDF Extension**:
   - [Download Visual Studio Code](https://code.visualstudio.com/download)
   - Follow the instructions in the following repository to install the ESP-IDF extension: [vscode-esp-idf-extension](https://github.com/espressif/vscode-esp-idf-extension/blob/master/docs/tutorial/install.md).
   - Clone the following repository to set up ESP32-C3: [IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20](https://github.com/toandevnguyen/IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20)
     ```sh
     git clone https://github.com/toandevnguyen/IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20.git
     ```
   - Open the project in VS Code.
   - Configure MQTT broker settings in the application code.
   - Build and flash the code to the ESP32-C3 module.
     
4. **Mobile App Setup**:
   - Clone the repository: [RemoteLights220V-DS18B20](https://github.com/toandevnguyen/RemoteLights220V-DS18B20)
     ```sh
     git clone https://github.com/toandevnguyen/RemoteLights220V-DS18B20.git
     ```
   - Open the project in Android Studio.
   - Configure MQTT broker settings in the application code.
   - Build and run the app on an Android device.
   - Here are some screenshots of the app interface:
   
   <div align="center">
     <figure style="margin-bottom: 20px;">
       <img src="https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/SplashScreen.jpg" alt="Splash Screen" width="300"/>
      
     </figure>
     <figure style="margin-bottom: 20px;">
       <img src="https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/TurnOffLed.jpg" alt="Screen 2" width="300"/>
       
     </figure>
     <figure style="margin-bottom: 20px;">
       <img src="https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/TurnOnLed.jpg" alt="Screen 3" width="300"/>
       
     </figure>
   </div>
   
## Usage
- Use the app to connect to the IoT system.
- Control the 220V lights and view real-time temperature data.

## Contributing
Contributions are welcome! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
