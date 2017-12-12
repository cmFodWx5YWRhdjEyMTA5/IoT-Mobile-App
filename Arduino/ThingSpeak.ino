#include <ESP8266WiFi.h>
#define WIFI_SSID "Laks.js"
#define WIFI_PASSWORD "vakumvakumvakum"
WiFiClient client;
const int prob= A0;
int measurement_Total;

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
  }
 
  }
