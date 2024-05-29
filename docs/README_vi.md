# Ứng Dụng Android Điều Khiển Đèn IoT Và Hiển Thị Nhiệt Độ
## Ngôn Ngữ
- [English](../README.md)
## Tổng Quan Dự Án
- Repository này chứa mã nguồn cho ứng dụng Android tương tác với hệ thống IoT sử dụng vi điều khiển ESP32-C3. Ứng dụng cho phép người dùng điều khiển đèn 220V từ xa và giám sát nhiệt độ bằng cảm biến DS18B20 thông qua MQTT qua TCP.
- [Liên Kết Video Demo](https://24ffdk-my.sharepoint.com/:v:/g/personal/toan5tb1drivedev_24ffdk_onmicrosoft_com/EdekrNNiyAdAr4RuuM1K9csBAXf8sxO2ubKTF2UoG07UlA?e=lwrZPB) 

## Tính Năng
- Điều khiển đèn 220V từ xa qua MQTT
- Hiển thị nhiệt độ thực tế từ cảm biến DS18B20
- Giao diện thân thiện với người dùng

## Công Nghệ Sử Dụng
- **Phần cứng**:
  - ESP32-C3
    
    ![ESP32-C3](https://i.ebayimg.com/images/g/WkEAAOSw1iZli80j/s-l500.jpg)
    
  - Cảm Biến Nhiệt Độ DS18B20
    
     <img src="https://i.ebayimg.com/images/g/6sYAAOSwnmxfhlJE/s-l1600.webp" alt="ESP32-C3" width="70%"/>
        
  - Module Rơ-le 5V 1 kênh
    
    ![Relay](https://bizweb.dktcdn.net/100/005/602/files/ad4.jpg?v=1465956650836)
    
  - Bóng Đèn Led
    
    <img src="https://kawaled.com/image/catalog/bulb-tru---tron-led2/den-led-tron-led2-a60-9w.jpg" alt="Led Bulb" width="70%"/>
    
- **Phần Mềm**: Android (Java/Kotlin), ESP-IDF Visual Studio Code Extension, MQTT Explorer

## Hướng Dẫn Cài Đặt
1. **Thiết lập Mosquitto MQTT Broker trên Google Cloud's Compute Engine**:
   - Tạo một máy ảo (VM) trên Google Cloud Platform với Ubuntu 20.04 Server.
   - Kết nối với VM của bạn bằng SSH.
   - Cài đặt Mosquitto MQTT Broker:
     ```sh
     sudo apt update
     sudo apt install -y mosquitto mosquitto-clients
     ```
   - Kích hoạt Mosquitto để khởi động cùng hệ thống và khởi động dịch vụ Mosquitto:
     ```sh
     sudo systemctl enable mosquitto
     sudo systemctl start mosquitto
     ```
   - Xác minh rằng Mosquitto đang chạy:
     ```sh
     sudo systemctl status mosquitto
     ```
2. **Sơ đồ hướng dẫn nối mạch điện**:

    ![Sơ đồ nối dây](https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/S%C6%A1%20%C4%91%E1%BB%93%20n%E1%BB%91i%20d%C3%A2y.png)
3. **Cài Đặt VS Code và ESP-IDF Extension**:
   - [Download Visual Studio Code](https://code.visualstudio.com/download)
   - Làm theo hướng dẫn trong repository sau để cài đặt extension ESP-IDF: [vscode-esp-idf-extension](https://github.com/espressif/vscode-esp-idf-extension/blob/master/docs/tutorial/install.md).
   - Clone repository sau để thiết lập ESP32-C3: [IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20](https://github.com/toandevnguyen/IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20)
     ```sh
     git clone https://github.com/toandevnguyen/IoT-ESP32-C3-MQTT-TCP-RemoteLed-DS18B20.git
     ```
   - Mở dự án trong VS Code.
   - Cấu hình cài đặt MQTT broker trong mã nguồn của ứng dụng.
   - Build và nạp code vào module ESP32-C3.
     
4. **Cài Đặt Ứng Dụng Di Động**:
   - Clone repository: [RemoteLights220V-DS18B20](https://github.com/toandevnguyen/RemoteLights220V-DS18B20)
     ```sh
     git clone https://github.com/toandevnguyen/RemoteLights220V-DS18B20.git
     ```
   - Mở dự án trong Android Studio.
   - Cấu hình cài đặt MQTT broker trong mã nguồn của ứng dụng.
   - Build và chạy ứng dụng trên thiết bị Android.
   - Đây là một số hình ảnh của giao diện ứng dụng:
   
   <div align="center">
     <figure >
       <img src="https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/SplashScreen.jpg" alt="Screen 1" width="300"/>
       
     </figure>
     <figure >
       <img src="https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/TurnOffLed.jpg" alt="Screen 2" width="300"/>
       
     </figure>
     <figure >
       <img src="https://github.com/toandevnguyen/RemoteLights220V-DS18B20/blob/main/TurnOnLed.jpg" alt="Screen 3" width="300"/>
       
     </figure>
   </div>
   
## Sử Dụng
- Sử dụng ứng dụng để kết nối với hệ thống IoT.
- Điều khiển đèn 220V và xem dữ liệu nhiệt độ theo thời gian thực.

## Đóng Góp
Hoan nghênh đóng góp! Vui lòng xem [CONTRIBUTING.md](CONTRIBUTING.md) để biết hướng dẫn.

## Giấy Phép
Dự án này được cấp phép theo giấy phép MIT - xem file [LICENSE](LICENSE) để biết chi tiết.

