#include <SoftwareSerial.h>
#define RX 2
#define TX 3
#define echoPin 4                                  // attach pin D4 Arduino to pin Echo of HC-SR04
#define trigPin 5                                  //attach pin D5 Arduino to pin Trig of HC-SR04
long duration;                                     // variable for the duration of sound wave travel
int distance;                                      // variable for the distance measurement
int sensorPin = A0;                                // select the input pin for LDr
int sensorValue = 0;                               // variable to store the value coming from the sensor

String AP = "WIFI_NAME";                           // AP NAME (NAME OF THE WIFI)
String PASS = "PASSWORD";                          // AP PASSWORD( WIFI PASSWORD
String API = "BZR9FU3PUIKOPWZZ";                   // Write API KEY OF FIREBASE WEBSITE
String HOST = "api.thingspeak.com";
String PORT = "80";
String field1 = "field1";
String field2 = "field2";

int countTrueCommand;
int countTimeCommand; 
boolean found = false;
String values1;
String values2;
SoftwareSerial esp8266(RX,TX); 
  
void setup() {
  pinMode(trigPin, OUTPUT);                        // Sets the trigPin as an OUTPUT
  pinMode(echoPin, INPUT);                         // Sets the echoPin as an INPUT
  Serial.begin(9600);
  esp8266.begin(115200);
  sendCommand("AT",5,"OK");
  sendCommand("AT+CWMODE=1",5,"OK");
  sendCommand("AT+CWJAP=\""+ AP +"\",\""+ PASS +"\"",20,"OK");
}

void loop() 
{
 values1 = getSensor1Data();                                    // LDR. Fetches light level from the LDR
 values2= getSensor2Data() ;                                    // HCSR04. Fetches the distance as measured by the ultrasonic sensor
 
 String getData = "GET /update?api_key="+ API +"&"+ field1 +"="+String(values1)+"&"+ field2 +"="+ String(values2);
 
 sendCommand("AT+CIPMUX=1",5,"OK");
 sendCommand("AT+CIPSTART=0,\"TCP\",\""+ HOST +"\","+ PORT,15,"OK");
 sendCommand("AT+CIPSEND=0," +String(getData.length()+4),4,">");
 
 esp8266.println(getData);delay(1500);countTrueCommand++;
 sendCommand("AT+CIPCLOSE=0",5,"OK");
}

String getSensor1Data(){
 sensorValue = analogRead(sensorPin);                           // read the value from the sensor
Serial.println(sensorValue);                                    //prints the values coming from the sensor on the screen

delay (10);
return String(sensorValue);                                     // LDR DATA 
}
String getSensor2Data(){
 
  // Clears the trigPin condition
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
 
  // Sets the trigPin HIGH (ACTIVE) for 10 microseconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
 
  // Reads the echoPin, returns the sound wave travel time in microseconds
  duration = pulseIn(echoPin, HIGH);
 
  // Calculating the distance
  distance = duration * 0.034 / 2; 
 
  // Displays the distance on the Serial Monitor
  distance = 12-distance;// height of container used is 12cm

  return String(distance);// ultrasonic data
}


void sendCommand(String command, int maxTime, char readReplay[]) {
 
  Serial.print(countTrueCommand);
  Serial.print(". at command => ");
  Serial.print(command);
  Serial.print(" ");
 
  while(countTimeCommand < (maxTime*1))
  {
    esp8266.println(command);//at+cipsend
    if(esp8266.find(readReplay))//ok
    {
      found = true;
      break;
    }
  
    countTimeCommand++;
  }
  
  if(found == true)
  {
    Serial.println("OYI");
    countTrueCommand++;
    countTimeCommand = 0;
  }
  
  if(found == false)
  {
    Serial.println("Fail");
    countTrueCommand = 0;
    countTimeCommand = 0;
  }
  
  found = false;
 }
