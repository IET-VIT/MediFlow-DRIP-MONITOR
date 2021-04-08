# Drip-Monitor
# AUTO – BUBBLE  DETECTING DRIP
![image](https://user-images.githubusercontent.com/76275812/113965879-d1842680-984b-11eb-9123-1319eb61bb4a.png)
## 📄 Abstract
This project elaborates a way to efficiently monitor the drip level at hospitals, while also detecting any bubble formation in the liquid used; a process that is currently done manually by nurses when they periodically check the drip. In addition to the functional efficiency of this project, it is also cost-effective. With the use of a light sensor, an ultrasonic sensor, a light source, and a microcontroller system, we provide a way to automatically monitor the drip levels. An accompanying app notifies the concerned hospital staff about issues and irregularities pertaining to the drip bottle.

## 🗒️ Introduction
This project greatly increases the efficiency of the hospital staff as a whole. The pandemic has led to a lot of hospitals being completely occupied, and the hostel staff overwhelmed. By not having to conduct manual routine checks on the drip levels and drip conditions of every patient, the workload of the hospital staff is exceedingly diminished. Automation in such essential tasks is the next step towards providing more efficient and convenient healthcare.

### 📚 Tech stack
<B>HARDWARE</B>
- Arduino Uno
- HCSR-04 Ultrasonic sensor
- Photo-resistor/light sensor
- Light source
- Esp8266-01 wifi module
</B>SOFTWARE</B>
- ANDROID STUDIO

###  Block Diagram
![image](https://user-images.githubusercontent.com/76275812/113965387-e0b6a480-984a-11eb-8257-ee88194a1fce.png)
### 💡 Circuit Schematic 
![image](https://user-images.githubusercontent.com/76275812/113965453-05128100-984b-11eb-9aae-6446cb0986b2.png)
### ⚙ Working
The block diagram above represents the correct working of the model in that first it will measure the level of solution left in the bottle through the ultrasonic sensor and if there are any bubbles formed in that solution and due to which there is an obstacle in the path of flowing the solution through a drip that will be detected by the LDR(light dependent resistor). The data produced by the ultrasonic and LDR  will be sent to the firebase through that again it will be sent to the Mobile  APP and according to the data received by app, there will certain warnings that whether the solution is about to finish or if there are any bubbles formed in that solution or not. 
### 🔑 KEY FEATURES OF THE APP
- Full detail of the solution whether the solution is about to finish or not to the allocated nurse.
- Will give information if bubbles are formed in the solution or not 
### 🌈 CONCLUSION
The proposed solution is going to help the hospital staff in a very fruitfull manner through which they need not to visit in the patient room repeatedly just for checking the drip count and to detect if there are bubbles formed or not we have successfully solved this problem in a digital way usin IOT.



