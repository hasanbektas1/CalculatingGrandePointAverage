# CalculatingGrandePointAverage

Girilen 3 adet notun ortalamasını bulup sonucu gösteren uygulamamız.


## Geliştirme Adımları

Öncelikle activity_main.xml dosyası tasarımımızı yapıyoruz.


3 adet **EditText** kullanıcıdan girdi alınabilecek 
2 adet **buton** hesaplama ve ekranı temizlemek için
1 adet **TextView** hesaplanan sonucun yazdırılması için

Oluşturulan araçların vertical(dikey) bir düzen içerisinde olması için LinearLayout içine yazıyoruz


```
 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <EditText
            android:id="@+id/examText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:textSize="25sp"
            android:hint="1. Sınav Notunu Giriniz"
            android:gravity="center"
            android:layout_marginTop="50dp"/>

         <Button
            android:id="@+id/calculateButton"
            android:layout_gravity="center"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Calculate"
            android:layout_marginTop="30dp"/>

        <TextView
            android:id="@+id/resultText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Result="
            android:textSize="30sp"
            android:gravity="center"
            android:layout_marginTop="30dp"/>

    </LinearLayout>

 // Örnek olarak gösterbilmek için her araçtan bir tane olacak şekilde ayarlandı
```
Proje içerisinde 
>app > src > main > res > layout 
Kısmından tümüne ulaşabilirsiniz

activity_main.xml tasarımımız bu kadardı şimdi MainActivity.kt sınıfımızın içinde kodlarımızı yazıyoruz

Şimdi ilk olarak butonumuza verdiğimiz id'si ile setOnClickListener diyip açılan body içerisinde butona tıklanınca ne olacağını yazıyoruz
```
binding.calculateButton.setOnClickListener {
        .
        .
        .
}
```
Body'nin içerisinde **if()**  ile kullanıcı tüm EditTexleri eksiksiz girdi mi diye kontrol ediyoruz

```
if (binding.examText.text.isNotEmpty() && binding.examText2.text.isNotEmpty() && binding.examText3.text.isNotEmpty()){
        .
        .
        .        
```

if bloğunun içerisinde kullanıcıdan alınan girdileri degişkene aktarıyoruz
Alınan girdiler ile not orlamasınıda hesapladıktan sonra onuda degişkene aktarıyoruz
```
                var exam1 = binding.examText.text.toString().toInt()
                var exam2 = binding.examText2.text.toString().toInt()
                var exam3 = binding.examText3.text.toString().toInt()

                var average: Float = (exam1+exam2+exam3) / 3.toFloat()
```

Şimdi if bloğu içerisindeyken tekrar if ile not ortalaması 50'ye eşit veya yüksek ise Textview içerisine sonucu yazdırıyoruz
if koşulu sağlanmadıgı takdirde else bloğu içerisinde ortalamanın 50'den düşük olduğu sonucu yazdırıyoruz
```
                if (average >=50){
                    binding.resultText.text="Result: "+average.toString()
                    binding.resultText.setTextColor(getColor(R.color.green))
                }else{
                    binding.resultText.text="Result: "+average.toString()
                    binding.resultText.setTextColor(getColor(R.color.red))
                    }
```

Sağlanan koşullar durumunda TextView'e yazdırılan sonucu 50'ye eşit ve yüksek ise yeşil 50'den düşük ise kırmızı renk ile yazdırıyoruz
Renkleri oluşturmak için values > color.xml  içerisinde yapıyoruz


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

