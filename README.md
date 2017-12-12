                                                                   
1-	Uygulamanın Tanımı

Toprakta bulunan bitkiler tarafından kullanılabilir su miktarının belirlenmesi için toprak neminin ölçülmesi gerekir.
Çünkü bitkiler topraktaki suyun tamamından yararlanamazlar. Başka bir ifadeyle bitkiler toprağın iki önemli özelliği olan tarla kapasitesi ile solma noktası arasında bulunan sudan yararlanabilirler.
Ekip olarak bu projeyi geliştirirken, bu maddeleri göz önünde bulundurarak toprağın ölçülmesinin ne derece önemli olduğunun farkına vardık. Geliştirmiş olduğumuz proje ile, bir çiftçi veyahut bu işle ilgilenen herhangi bir kişi artık toprağın nem değerini digital ortamda görüntüleyebilecek ve bu sayede toprağa müdahele edebilecektir.
Yazılımını yapmış olduğumuz Android uygulaması ile, toprağın nem değerinin kullanıcının isteği doğrultusunda belirlemiş olduğu bir değerin altına indiği zaman uygulamamız otomatik bildirim verecektir.Bu durum da mekan ve zaman fark etmeksizin bu işle uğraşan kişinin zahmetlerini oldukça azaltmaktadır.
2-	Ekipman Listesi ve Kullanılan Teknolojiler

-	Arduino(ESP8266 modül ile gömülü)
-	Toprak nemi algılama sensörü
-	Yukarıdaki malzemelerin birbirleri ile bağlantısını sağlamak üzere dişi-erkek atlayıcı
-	Android Studio IDE
-	Arduino IDE
-	Thingspeak
       2.1 Kullanılan Teknolojilere Yönelik Teknik Bilgiler:
       2.1.1 Arduino:
Arduino bir G/Ç kartı ve Processing/Wiring dilinin bir uygulamasını içeren geliştirme ortamından oluşan bir fiziksel programlama platformudur.
Arduino kartlarının donanımında bir adet Atmel AVR mikrodenetleyici (ATmega328, ATmega2560, ATmega32u4 gibi) ve programlama ve diğer devrelere bağlantı için gerekli yan elemanlar bulunur. Her Arduino kartında en azından bir 5 voltluk regüle entegresi ve bir 16MHz kristal osilator (bazılarında seramik rezonatör) vardır. Arduino kartlarında programlama için harici bir programlayıcıya ihtiyaç duyulmaz, çünkü karttaki mikrodenetleyiciye önceden bir bootloader programı yazılıdır.

Arduino 'nun temel bileşenleri : Arduino geliştirme ortamı (IDE), Arduino bootloader (Optiboot), Arduino kütüphaneleri,	AVRDude (Arduino üzerindeki mikrodenetleyici programlayan yazılım) ve derleyiciden (AVR-GCC) oluşur.
Arduino kütüphaneleri ile kolaylıkla programlama yapabilirsiniz. Analog ve digital sinyalleri alarak işleyebilirsiniz. Sensörlerden gelen sinyalleri kullanarak, çevresiyele etkileşim içerisinde olan robotlar ve sistemler tasarlayabilirsiniz. Tasarladığınız projeye özgü olarak dış dünyaya hareket, ses, ışık gibi tepkiler oluşturabilirsiniz. Bizde uygulamamızda toprak nem değerini bir sensör kullanarak bulut ortamına kaydettik.
2.1.2 Toprak Nemi Algılama Sensörü:
Toprak nem sensörü, toprağın içerisindeki nem miktarını veya ufak ölçekte bir sıvının seviyesini ölçmek için kullanabileceğiniz bir sensördür.
Nem ölçer problar ölçüm yapılacak ortama batırılarak kullanılır. Toprağın veya içine batırılan sıvının meydana getirdiği dirençten dolayı, prob uçları arasında bir gerilim farkı oluşur. Bu gerilim farkının büyüklüğüne göre de nem miktarı ölçülebilir. Topraktaki nem oranı arttıkça iletkenliği de artmaktadır. Kart üzerinde yer alan trimpot sayesinde hassasiyet ayarı yapılabilmektedir.
Uygulamamızda, Arduino cihaza bağlı sensör ile bulut ortamına kaydetme işlemi yapıldı.
2.1.3 Android Studio IDE:
Android Studio, Android uygulamalarının geliştirildiği, üst seviye özelliklere sahip ve Google tarafından da önerilen resmi programlama aracıdır.Android uygulamanın programlama dili, bu zamana kadar Java idi, ancak Google yeni bir değişikliğe giderek Android ana programlama dilini Kotlin diline çevirdi. Şu an her iki programlama dilinde de Android uygulama geliştirilebilmektedir.
2.1.4 Arduino IDE:
Arduino IDE, arduino kitleri için geliştirdiği; komutların yazılmasına, derleme işleminin yapılmasına ve son olarakta derlenen kodları doğrudan (Bilgisayarın USB portuna bağlı olan) Arduino kite yüklenmesine olanak sağlayan yazılım geliştirme platformudur.
2.1.5 ThingSpeak:
ThingSpeak IoT çözümleri için geliştirilmiş bulut tabanlı bir uygulamadır.Bu uygulamanın üreticisi MATLAB programlama dili ve IDE’si ile tanıdığımız Mathwork’s firmasıdır.
ThingSpeak saylamış olduğu kolaylıklarla HTTP protokolü üzerinden kolayca veri kaydetme, pozisyon takibi yapabilme veya IoT cihazlardan veri aktarımı gibi uygulamaları çok hızlı bir şekilde gerçekleştirebilmenizi sağlar.
ThingSpeak IoT uygulamaları için web tarafında harcanacak eforu neredeyse sıfıra indirir ve özellikle geliştirme sürecinde üreticilerin donanım ve gömülü yazılım tarafına daha fazla zaman ayırmasına imkan verir.
Kendi bünyesinde verilerinizi saklar ve istediğinizde bu verileri bilgisayarınıza kayıt edebilirsiniz.


3-	Uygulama Adımları

3.1 Bulut Katmanı

Öncelikle bulut platform olarak kullanacağımız ThingSpeak [https://thingspeak.com] platformundan üyelik oluştururak giriş yapıyoruz.

 
				Resim 1. Dashboard ekranı

Resim 1 üzerindeki New Channel seçeneğine tıklayarak yeni bir proje oluşturuyoruz.
 
			Resim 2. Yeni Proje Oluşturma Ekranı
Gerekli bilgileri girerek, projemizi oluşturuyoruz. Resim 2 deki Field’lar ile uygulamamızın bir çok parametreye göre veritabanına yazılmasına karar verebiliriz. Bizim sadece sonuç kısmı olacağından dolayı, Total ekranını oluşturuyoruz.
 
				Resim 3. Dashboard Ekranı
		
Resim 3 üzerinden projenin özelliklerine girerek, Arduino veyahut başka bir platform ile paylaşacağımız özel anahtarları elde edeceğiz. 
			Resim 4. Proje Özellikleri

Resim 4 üzerinde yukarıda bulunan tab kısımların bizim diğer platformla paylaşmamızı sağlayacak olan API Keys kısmına girerek, bize ait olan Key kısmını bir yere not alacağız.
Şimdilik bulut platform kısmında yapılacakları tamamladık. Arduino kısmına geçebiliriz.
