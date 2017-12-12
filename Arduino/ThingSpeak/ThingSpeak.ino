#include <ESP8266WiFi.h>
#define WIFI_SSID "Laks.js"
#define WIFI_PASSWORD "vakumvakumvakum"
String apiKey = "YB0636AMO077W410";
const char* server = "api.thingspeak.com";
const int prob= A0;
int measurement_Total;
int duration=5;
WiFiClient client;

void setup() {
  // put your setup code here, to run once:
   Serial.begin(9600);

  // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());
}

void loop() {
   measurement_Total = analogRead(prob);
   if (client.connect(server, 80)) {
    String postStr = apiKey;
    postStr += "&field1=";
    postStr += String(measurement_Total);
    postStr += "\r\n\r\n";
   
    //Uplad the postSting with temperature and Humidity information every
    client.print("POST /update HTTP/1.1\n");
    client.print("Host: api.thingspeak.com\n");
    client.print("Connection: close\n");
    client.print("X-THINGSPEAKAPIKEY: " + apiKey + "\n");
    client.print("Content-Type: application/x-www-form-urlencoded\n");
    client.print("Content-Length: ");
    client.print(postStr.length());
    client.print("\n\n");
    client.print(postStr);
     
    Serial.print("Soil wetness: ");
    Serial.println(measurement_Total);
   
  }
  client.stop();

  Serial.println("Waiting…");
  // thingspeak needs minimum 15 sec delay between updates
  delay(duration*1000);
}
