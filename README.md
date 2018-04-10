# KutuphaneOtomasyonSistemi

**Intellij Idea**
>indirdikden sonra ideadan import project dedikden sonra projenin bulunduğu klasörü seçilir.
güncelleme -> idea projesi haline getirildi artik open project diyerek direk acilabilir.
edit runconfigration  menusunden yeni config server secilerek eklenir(+ simgesi)  yüklü olan server secilir 


**Spring Tool Suite**

- eclipse'de yada spring tool suite'de Window->Perspective->Open Perspective->Other->Git yaparak sağ üst bölüme eklenecek görünüm ayarlarından github-perspective'i seçmeniz lazım

- değişen görünümde Git Repositories penceresinden Clone a git repositoryi seçerek çıkan bölümde githubdan projeyi bumanız gerekiyor.

- projeyi local repository olarak ekledikten sonra import a project bölümünden projeyi ekleme seçeneklerinden import as general project'i seç

- sonra import edilen projeyi siliyoruz ama sadece projelerden tamamen dosyaları silmiyoruz.

- projeyi sildikten sonra yine import project penceresinden maven->existing maven projecti işaretliyoruz ve github projesinin oldugu klasördeki projemizi seçiyoruz(genel de windows için c:\users\username\git içinde olur, linux ~home\git) suan proje açılır hale geldi sadece 3-5 ufak ayarlama yapmak gerekiyor.

- başta açtığımız github perspectifinden projemizi bulup remotes->origin in içindeki (kırmızı yukarıya dogru ok bulunan tip)2.seçeneğe sağ tıklamak kaydıyla configure push diyoruz burada ref mappings bölümünden add diyerek remote branch bölümüne kendi adınıza açtığım branchı ekliyoruz.

- herşeyi tamamiyle yaptığımıza göre artık projemizi kullandığımız server farketmeksizin servere ekliyip serveri çalıştırıyoruz

8- genelde kendi gelir ama bilgisayarlarınız hatadan geçilmediği için gelmedi diye var sayarak localhost:8080\KOS yazarak kontrol edebilirsiniz.(8080 yerine server portunu değiştirdiyseniz o portu yazmanız gerekiyor)

9- src\main\resources bölümünden spring-datasource dosyasını bulup kendi databasemize göre güncelliyoruz. mysql kullanıyorsanız sadece parantez içindeki alanlara bilgilerinizi girerek düzenlemeniz gerekiyor.

10- sql tablolarini olusturmak icin dao paketinin içinde bulunan runSqlScript classinin icindeki database ile ilgili bilgilerinizi eksiksiz ve hatasiz olarak doldurduktan sonra javaapp olarak çalıştırın.O sizin gerek duydugunuz veri tabanini tablolariyla birlikte olusturur. 

P.S:projeyi eklemede bi sıkıntı kalmadığına göre geliştirme işlemlerimize başlayabiliriz hayırlısıyla bu arada proje ismi->team-> commit diyerek açtıgımız pencereden ise güncelleme yaptıgımız dosyalarımızı stagged changese ekleyerek tabi commit message bölümünede ilgili düzenlemenizi açıklayıcı bir şekilde yazdıktan sonra commit and push butonuna tıklayarak ilk güncellemenizi yani commitinizi yapmış olursunuz. master bölümünü projenin sağlığı ve güvenliği açısından erişim kısıtı koydum,ben güncellemelerinizi takip edip teker teker projeye yerleştiricem.


