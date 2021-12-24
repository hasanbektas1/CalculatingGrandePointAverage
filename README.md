# CalculatingGrandePointAverage

Bu projemizde Not ortalaması hesaplama yapacagız 
Öncelikle xml kısmında 
3 adet EditText oluşuruyoruz girilecek notlar için
2 adet Button Hesaplama için ve ekranı temizlemek için
1 adet Textview ortalama sonucunu göstermek için veya kullanıcıya herhangi bir mesaj verebilmek için
Oluşturduktan sonra düzenli bir sıra halinde alt alta olması için LinearLayout kullanıyoruz
Daha sonra MainActivity Sınıfımız içerisinde olayları yazıyoruz
İlk önce girilen notlardan sonra hesaplama butonuna tıklayınca ne olacagını yazıyoruz
Hesaplama butonunu setOnClickListener yöntemi ile yazıyoruz
İf koşuluyla bütün not yazılma alanları dolduruldu mu kontrol ediyoruz 
else kısmı ile boş alan bıraktıgında kullanıcıya boşlukları doldurması için mesaj veriyoruz
daha sonra kullanıcının girdigi verileri degişkenlerimize atıyoruz
alınan verileri toplayıp 3e böldükten sonra ortalama degişkenimize atıyoruz sonucu
sonra tekrar if kontorolümüz ile ortalama notunu 50den yüksek ise
yeşil yazıyla ekrana yazdırıyoruz degilse kırmızı yazıyla yazdırıyoruz
Renkleri Values klasörü altında color.xml kısmında kendimiz oluşturuyoruz daha sonra oradan çekiyoruz
Ve son olarak ekranı temizleme butonumuz için clean fonksiyonumuzu oluşturuyoruz
fonksiyon olarak yazmamızın sebebi bu fonksiyon  xml kısmından çagırılacagı için 
iki yönteminde içine tıklanınca ne olacagını yazabiliyoruz 

Saygılar
Hasan Bektaş

