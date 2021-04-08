# Drip-Monitor
AUTO – BUBBLE  DETECTING DRIP
1. ABSTRACT📄
This project elaborates a way to efficiently monitor the drip level at hospitals, while also detecting any bubble formation in the liquid used; a process that is currently done manually by nurses when they periodically check the drip. In addition to the functional efficiency of this project, it is also cost-effective. With the use of a light sensor, an ultrasonic sensor, a light source, and a microcontroller system, we provide a way to automatically monitor the drip levels. An accompanying app notifies the concerned hospital staff about issues and irregularities pertaining to the drip bottle.

2. INTRODUCTION🗒️
This project greatly increases the efficiency of the hospital staff as a whole. The pandemic has led to a lot of hospitals being completely occupied, and the hostel staff overwhelmed. By not having to conduct manual routine checks on the drip levels and drip conditions of every patient, the workload of the hospital staff is exceedingly diminished. Automation in such essential tasks is the next step towards providing more efficient and convenient healthcare.


3. REQUIREMENTS
3.1Hardware Requirement:

1. Arduino Uno
2. HCSR-04 Ultrasonic sensor
3. Photo-resistor/light sensor
4. Light source
5. Esp8266-01 wifi module



3.2Software Requirement:

1.Android Studio



4. WORKING ⚙
The block diagram above represents the correct working of the model in that first it will measure the level of solution left in the bottle through the ultrasonic sensor and if there are any bubbles formed in that solution and due to which there is an obstacle in the path of flowing the solution through a drip that will be detected by the LDR(light dependent resistor). The data produced by the ultrasonic and LDR  will be sent to the firebase through that again it will be sent to the Mobile  APP and according to the data received by app, there will certain warnings that whether the solution is about to finish or if there are any bubbles formed in that solution or not. 




5.KEY FEATURES OF THE APP🔑

Full detail of the solution whether the solution is about to finish or not to the allocated nurse.
Will give information if bubbles are formed in the solution or not 

