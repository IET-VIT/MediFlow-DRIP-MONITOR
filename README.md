# Drip-Monitor
# AUTO – BUBBLE  DETECTING DRIP
![image](https://user-images.githubusercontent.com/76275812/113965879-d1842680-984b-11eb-9123-1319eb61bb4a.png)
## 📄 Abstract
This project elaborates a way to efficiently monitor the drip level at hospitals, while also detecting any bubble formation in the liquid used; a process that is currently done manually by nurses when they periodically check the drip. In addition to the functional efficiency of this project, it is also cost-effective. With the use of a light sensor, an ultrasonic sensor, a light source, and a microcontroller system, we provide a way to automatically monitor the drip levels. An accompanying app notifies the concerned hospital staff about issues and irregularities pertaining to the drip bottle.

## 🗒️ Introduction
This project greatly increases the efficiency of the hospital staff as a whole. The pandemic has led to a lot of hospitals being completely occupied, and the hostel staff overwhelmed. By not having to conduct manual routine checks on the drip levels and drip conditions of every patient, the workload of the hospital staff is exceedingly diminished. Automation in such essential tasks is the next step towards providing more efficient and convenient healthcare.

### 📚 Tech stack
- Arduino Uno
- HCSR-04 Ultrasonic sensor
- Photo-resistor/light sensor
- Light source
- Esp8266-01 wifi module
- ANDROID STUDIO

###  Block Diagram
![image](https://user-images.githubusercontent.com/76275812/113965387-e0b6a480-984a-11eb-8257-ee88194a1fce.png)
### 💡 Circuit Schematic 
![image](https://user-images.githubusercontent.com/76275812/113965453-05128100-984b-11eb-9aae-6446cb0986b2.png)
### ⚙ Working
The block diagram above represents the correct working of the model in that first it will measure the level of solution left in the bottle through the ultrasonic sensor and if there are any bubbles formed in that solution and due to which there is an obstacle in the path of the flowing solution through a drip that will be detected by the LDR. The data produced by the ultrasonic sensor and LDR  will be sent to the firebase through the ESP8266 module. The same data will be sent to the Mobile App, where appropriate warnings can be conveyed to the staff. 
### 🔑 KEY FEATURES OF THE APP
- Full detail of the solution whether the solution is about to finish or not to the allocated nurse.
- Will give information if bubbles are formed in the solution or not 
- Login firebase for staff of the hospital
### 🌈 CONCLUSION
The proposed solution is going to help the hospital staff in a very fruitful manner through which they need not visit the patient's room repeatedly just for checking the drip count or to detect bubble formation. We have successfully solved this problem in a virtual format using IoT.
### FUTURE PROSPECT
To make our system more useful and convinient, we plan on adding a one touch communication portal, through which the patient or their family member can edit request for assistance from a nurse instead of the family member going out to call them, leaving the patient unattended. Apart from this we will switch from displaying a constant message of the flowing drip and bubble formation, to a pop-up, non-dissmissable warning message, for a more efficient and user friendly application.

