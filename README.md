# CalculatingGrandePointAverage

Kullanıcı tarafından girilen 3 adet notun ortalamasını bulup sonucu gösteren uygulamamız.


## Geliştirme Adımları

Öncelikle activity_main.xml dosyası tasarımımızı yapıyoruz.


- 3 adet **EditText** kullanıcıdan girdi alınabilecek 
- 2 adet **Buttton** hesaplama ve ekranı temizlemek için
- 1 adet **TextView** hesaplanan sonucun yazdırılması için

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
            
             <Button
            android:id="@+id/cleanButton"
            android:onClick="clean"
            android:layout_gravity="center"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="clean"
            android:layout_marginTop="100dp"/>

    </LinearLayout>

 // Örnek olarak gösterbilmek için her araçtan bir tane olacak şekilde ayarlandı
```
Proje içerisinde 
>app > src > main > res > layout 
Kısmından tümüne ulaşabilirsiniz

activity_main.xml tasarımımız bu kadardı şimdi MainActivity.kt sınıfımızın içinde kodlarımızı yazıyoruz

İlk olarak **onCreate** fonksiyonu içerisinde butonumuza verdiğimiz id'si ile **setOnClickListener** diyip açılan body içerisinde butona tıklanınca ne olacağını yazıyoruz
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

**if** bloğunun içerisinde kullanıcıdan alınan girdileri degişkene aktarıyoruz
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

Sağlanan koşullar durumunda TextView'e yazdırılan sonucu 50'ye eşit veya yüksek ise yeşil 50'den düşük ise kırmızı renk ile yazdırıyoruz
Renkleri oluşturmak için values > color.xml  içerisinde yapıyoruz

**setOnClickListener** içerisinde ilk kontrol ettiğimiz **if()** durumunda kullanıcı EditText'leri eksik girdiğinde resultText ekranında kullanıcıya bilgi mesajı gösteriyoruz.
```
else{
                binding.resultText.text="fill in all fields"
            }
```

Son olarak kullanıcının girdilerini alıp hesaplayıp ekranda gösterdikten sonra tekrar bir hesaplama yapabilmesi için ekranı temizleyip ilk haline dönderiyoruz.

Temizleme butonunu görünüm tarafından yani xml tarafından çağırılan bir fonksiyon olarak MainActivity sınıfımızın içinde ama onCreate fonksiyonun dışında yazıyoruz. Hesaplama butonundaki gibi tıklanınca ne olacagını yazabilmemiz için farklı bir yöntem. İstenilen duruma göre her ikiside kullanılabilir.

Temizleme butonunu activity_main.xml içerisinde tasarlarken **onClick** metoduna verilen isimle MainActivity sınıfı içerisinde oluşturulan fonksiyon ismi aynı olmalı ve **fun clean (view : View) {** görünüm tarafından çağırılacagını belirtmek için View parametresi verilmeli.
```
 fun clean (view : View) {
        binding.examText.text.clear()
        binding.examText2.text.clear()
        binding.examText3.text.clear()
        binding.resultText.setText("")
    }
```
Artık programımız çalışmaya hazır.


