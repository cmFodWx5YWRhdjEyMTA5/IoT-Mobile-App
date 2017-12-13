# Özet

Arduino ve nem ölçer sensör ile, toprağın nemini anlık ölçerek Thingspeak platformuna yazan uygulamamız ; Thingspeak API'leri üzerinden eş zamanlı olarak mobil uygulamaya aktardığı IOT projesidir.

## Konu Başlıkları
1- Uygulamanın Tanımı

2- Ekipman Listesi ve Kullanılan Teknolojiler

3- Uygulama Adımları
			     
## 1-	Uygulamanın Tanımı

 Toprakta bulunan bitkiler tarafından kullanılabilir su miktarının belirlenmesi için toprak neminin ölçülmesi gerekir.

 Çünkü bitkiler topraktaki suyun tamamından yararlanamazlar. Başka bir ifadeyle bitkiler toprağın iki önemli özelliği olan tarla kapasitesi ile solma noktası arasında bulunan sudan yararlanabilirler. [1]

 Ekip olarak bu projeyi geliştirirken, bu maddeleri göz önünde bulundurarak toprağın ölçülmesinin ne derece önemli olduğunun farkına vardık. Geliştirmiş olduğumuz proje ile, bir çiftçi veyahut bu işle ilgilenen herhangi bir kişi artık toprağın nem değerini digital ortamda görüntüleyebilecek ve bu sayede toprağa müdahele edebilecektir.
 
 Yazılımını yapmış olduğumuz Android uygulaması ile, toprağın nem değerinin kullanıcının isteği doğrultusunda belirlemiş olduğu bir değerin altına indiği zaman uygulamamız otomatik bildirim verecektir.Bu durum da mekan ve zaman fark etmeksizin bu işle uğraşan kişinin zahmetlerini oldukça azaltmaktadır.

## 2-	Ekipman Listesi ve Kullanılan Teknolojiler

-	Arduino(ESP8266 modül ile gömülü)
-	Toprak nemi algılama sensörü
-	Yukarıdaki malzemelerin birbirleri ile bağlantısını sağlamak üzere dişi-erkek atlayıcı
-	Android Studio IDE
-	Arduino IDE
-	Thingspeak
     
### 2.1 Kullanılan Teknolojilere Yönelik Teknik Bilgiler:
### 2.1.1 Arduino[2]:
 
 Arduino bir G/Ç kartı ve Processing/Wiring dilinin bir uygulamasını içeren geliştirme ortamından oluşan bir fiziksel programlama platformudur.

 Arduino kartlarının donanımında bir adet Atmel AVR mikrodenetleyici (ATmega328, ATmega2560, ATmega32u4 gibi) ve programlama ve diğer devrelere bağlantı için gerekli yan elemanlar bulunur. Her Arduino kartında en azından bir 5 voltluk regüle entegresi ve bir 16MHz kristal osilator (bazılarında seramik rezonatör) vardır. Arduino kartlarında programlama için harici bir programlayıcıya ihtiyaç duyulmaz, çünkü karttaki mikrodenetleyiciye önceden bir bootloader programı yazılıdır.

### Arduino 'nun temel bileşenleri : 
 
 Arduino geliştirme ortamı (IDE), Arduino bootloader (Optiboot), Arduino kütüphaneleri,	AVRDude (Arduino üzerindeki mikrodenetleyici programlayan yazılım) ve derleyiciden (AVR-GCC) oluşur.
 
 Arduino kütüphaneleri ile kolaylıkla programlama yapabilirsiniz. Analog ve digital sinyalleri alarak işleyebilirsiniz. Sensörlerden gelen sinyalleri kullanarak, çevresiyele etkileşim içerisinde olan robotlar ve sistemler tasarlayabilirsiniz. Tasarladığınız projeye özgü olarak dış dünyaya hareket, ses, ışık gibi tepkiler oluşturabilirsiniz. Bizde uygulamamızda toprak nem değerini bir sensör kullanarak bulut ortamına kaydettik.

### 2.1.2 Toprak Nemi Algılama Sensörü:

 Toprak nem sensörü, toprağın içerisindeki nem miktarını veya ufak ölçekte bir sıvının seviyesini ölçmek için kullanabileceğiniz bir sensördür.[3]

 Nem ölçer problar ölçüm yapılacak ortama batırılarak kullanılır. Toprağın veya içine batırılan sıvının meydana getirdiği dirençten dolayı, prob uçları arasında bir gerilim farkı oluşur. Bu gerilim farkının büyüklüğüne göre de nem miktarı ölçülebilir. Topraktaki nem oranı arttıkça iletkenliği de artmaktadır. Kart üzerinde yer alan trimpot sayesinde hassasiyet ayarı yapılabilmektedir.

 Uygulamamızda, Arduino cihaza bağlı sensör ile bulut ortamına kaydetme işlemi yapıldı.

### 2.1.3 Android Studio IDE:

 Android Studio, Android uygulamalarının geliştirildiği, üst seviye özelliklere sahip ve Google tarafından da önerilen resmi programlama aracıdır.Android uygulamanın programlama dili, bu zamana kadar Java idi, ancak Google yeni bir değişikliğe giderek Android ana programlama dilini Kotlin diline çevirdi. Şu an her iki programlama dilinde de Android uygulama geliştirilebilmektedir.[4]

### 2.1.4 Arduino IDE:

 Arduino IDE, arduino kitleri için geliştirdiği; komutların yazılmasına, derleme işleminin yapılmasına ve son olarakta derlenen kodları doğrudan (Bilgisayarın USB portuna bağlı olan) Arduino kite yüklenmesine olanak sağlayan yazılım geliştirme platformudur.[5]

### 2.1.5 ThingSpeak[6]:

 ThingSpeak IoT çözümleri için geliştirilmiş bulut tabanlı bir uygulamadır.Bu uygulamanın üreticisi MATLAB programlama dili ve IDE’si ile tanıdığımız Mathwork’s firmasıdır.

 ThingSpeak saylamış olduğu kolaylıklarla HTTP protokolü üzerinden kolayca veri kaydetme, pozisyon takibi yapabilme veya IoT cihazlardan veri aktarımı gibi uygulamaları çok hızlı bir şekilde gerçekleştirebilmenizi sağlar.
ThingSpeak IoT uygulamaları için web tarafında harcanacak eforu neredeyse sıfıra indirir ve özellikle geliştirme sürecinde üreticilerin donanım ve gömülü yazılım tarafına daha fazla zaman ayırmasına imkan verir.
Kendi bünyesinde verilerinizi saklar ve istediğinizde bu verileri bilgisayarınıza kayıt edebilirsiniz.


## 3-	Uygulama Adımları

### 3.1 Bulut Katmanı[7]

Öncelikle bulut platform olarak kullanacağımız ThingSpeak [https://thingspeak.com] platformundan üyelik oluştururak giriş yapıyoruz.
	
 ![](http://ismailresatakcan.com/IoT/TS1.png)
          
	~~Resim 1. Dashboard ekranı~~

 Resim 1 üzerindeki New Channel seçeneğine tıklayarak yeni bir proje oluşturuyoruz.
 
 ![](http://ismailresatakcan.com/IoT/TS2.png)
        
	~~Resim 2. Yeni Proje Oluşturma Ekranı~~

 Gerekli bilgileri girerek, projemizi oluşturuyoruz. Resim 2 deki Field’lar ile uygulamamızın bir çok parametreye göre veritabanına yazılmasına karar verebiliriz. Bizim sadece sonuç kısmı olacağından dolayı, Total ekranını oluşturuyoruz.
  
  ![](http://ismailresatakcan.com/IoT/TS3.png)
      
     ~~Resim 3. Dashboard Ekranı~~
		
Resim 3 üzerinden projenin özelliklerine girerek, Arduino veyahut başka bir platform ile paylaşacağımız özel anahtarları elde edeceğiz. 
 
  ![](http://ismailresatakcan.com/IoT/TS4.png)			
   
   ~~Resim 4. Proje Özellikleri~~

 Resim 4 üzerinde yukarıda bulunan tab kısımların bizim diğer platformla paylaşmamızı sağlayacak olan API Keys kısmına girerek, bize ait olan Key kısmını bir yere not alacağız.
Şimdilik bulut platform kısmında yapılacakları tamamladık. Arduino kısmına geçebiliriz.

### 3.2 Arduino Katmanı[8]

Öncelikle, Arduino IDE ve Arduino kartı ile bazı senkronizasyon ayarları yapmamız gerekiyor.
 
 ![](http://ismailresatakcan.com/IoT/A1.png)			 	
        
	~~Resim 5. Arduino Kart seçimi~~

 Resim 5 kısmından Arduino IDE Araçlar sekmesinden ilgili Arduino kartımızı seçiyoruz. Bizim kartımız WeMos D1 mini kartı olduğundan dolayı ilgili kartı seçiyoruz.	 
 
 ![](http://ismailresatakcan.com/IoT/A2.png)	
          
	~~Resim 6. Library yükleme~~
	  
 Resim 5 üzerinden Taslak sekmesine tıklayarak, Library yükle seçeneğine tıklıyoruz. Karşımıza Resim 6 geliyor. Buradan ESP8266 modulünü yükleyerek ilgili framework’ü kurmuş oluyoruz.
 
 ![](http://ismailresatakcan.com/IoT/A3.png)
	
	~~Resim 7. ESP8266 Modülü JSON Data yükleme~~
	
 Resim 5 üzerinden Dosya kısmına tıklayarak Tercihler seçeneğine tıklıyoruz. Resim 7 karşımıza çıkmış oluyor. Ek Devre Kartları Yöneticisi URL’leri kısmına orada yazan JSON formatını ekliyoruz(Sadece link girilebilir).Böylelikle ESP8266 modulü ile ilgili kısımlar halledilmiş oluyor.

 Şimdi kodlamaya başlayabiliriz.

 Öncelikle malzemeler kısmında bahsetmiş olduğumuz, nem ölçer sensörünü Arduino kartına bağlıyoruz.	 
 
 ![](http://ismailresatakcan.com/IoT/A3.png)
        
	~~Resim 8. Toprak Nem Sensörü Arduino Bağlantısı[9]~~
	
 Resim 8 de görüldüğü gibi toprak sensörünü bir ara bağlantı şemasıyla Arduino cihazımıza bağlıyoruz. Burada jumperlar kullanarak, nem sensörümüzü Arduino’ya bağlıyoruz. Ara bağlantı cihazının A0 portunu Arduino’muzun A0 portuna bağlıyoruz. Ara bağlantı cihazının GND çıkışını Arduino’muzun GND portuna bağlıyoruz. Ve ara bağlantı çıkışının VCC çıkışını Arduino cihazımızın 5V portuna bağlıyoruz. 
 
 Bu işlemleri yaptıktan sonra, A0 portuna çıkış verecek olan toprak sensörünü Arduino kodları ile dinlemeye başlıyoruz.
 
 Pseüdo Code:
 Sonuç = dinle(A0) ;

 Not. Orijinal kod burada paylaşılmayacaktır.Kodlarımızı açık kaynak yönetim aracı ve web sitesi olan GitHub.com üzerinden paylaştık. (https://github.com/umut47/IoT) Linkinden kodlara ulaşıp kendi bilgisayarınızda deneyebilirsiniz.
A0 portunun verdiği değerleri dinledikten sonra, ilgili sonucu Thingspeak platformuna ekleme kısmını kodluyoruz. Tabiki bunu yapmadan önce cihazımızın, internete bağlanabilmesi için, Wifi ayarlarını yapıyoruz(ESP8266 modülü). İnternete bağlandıktan sonra, bulut platformuna verilerimizi yazabiliriz.
 
 ![](http://ismailresatakcan.com/IoT/TS5.png)
      
    ~~Resim 8. ThingSpeak’ de değerlerin görülmesi~~
      
 Resim 8 de görüldüğü gibi değerlerimizi bulut platformunda görüyoruz. Bu kısımdan sonra, bulut platformu ile bağlantı kuracak Android mobil uygulama kısmına geçebiliriz.

### 3.3 Android Katmanı
 
 ![](http://ismailresatakcan.com/IoT/TS6.png)
     
    ~~Resim 9. API paylaşım kısmı~~

 	Resim 4 üzerinden API Keys kısmına girdikten sonra Resim 9’daki bizim uygulamamızın paylaşmış olduğu API Keyler önümüze çıkıyor. Bu bağlantılar içerisinde, JSON data’lar paylaşılmış durumdadır.  
 
 ![](http://ismailresatakcan.com/IoT/TS7.png)

    ~~Resim 10. JSON Data~~
	
 Resim 9’daki API’leri GET komutu ile açtığımızda Resim 10’deki JSON data karşımıza geliyor.

 Ve Android programlama ile ilgili sonuçları çekerek, uygulamamızı eş zamanlı bir şekilde tasarlamış oluyoruz. Android ve Arduino kodlarına ulaşmak için . (https://github.com/umut47/IoT) Linkinden kodlara ulaşıp kendi bilgisayarınızda deneyebilirsiniz.

![](http://ismailresatakcan.com/IoT/AN1.png)
     
   ~~Resim 11. Projenin Android kısımda görülmesi~~

## 4. Kaynakça

- [1] akademikpersonel.kocaeli.edu.tr/bpekey/bildiri/bpekey05.10.2015_20.23.01bildiri.pdf

- [2] https://www.arduino.cc/en/Guide/Troubleshooting#upload

- [3] https://medium.com/@ibrahimirdem/toprak-nem-sensörü-ve-arduino-a9ebe8ccc203

- [4] https://developer.android.com/studio/index.html

- [5] https://www.arduino.cc/en/main/software

- [6] https://www.mathworks.com/help/thingspeak/getting-started-with-thingspeak.html

- [7] https://www.mathworks.com/help/thingspeak/collect-data-in-a-new-channel.html

- [8] http://www.elektrobot.net/arduino-ile-esp8266-kullanimi-ve-web-server/

- [9] https://www.youtube.com/watch?v=Nk80L7zp5_4&t=164s


