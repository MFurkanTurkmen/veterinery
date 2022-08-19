# PetClinic API Documentation 
Basit Bir veteriner uygulamasıdır. Html, Css ,Js dosyalarını kendim yazmadığım için gereksiz kodlar vardır.
Yetkilendirme yapılmamıştır. Admin Sayfası için `localhost/admin/index` 'e gitmeniz gerekmektedir.Aşağıda detaylı açıklamalar mevcuttur.

## Nasıl Çalıştırılır.
- Projeyi download ediniz ve Intellijde açınız.
- Proje içinde build.gradle dosyasını kontrol ediniz.
- Database olarak postgresql kullanılmıştır.
- Projeyi başlatmadan önce PostgreSql de veritabanını oluşturmanız gerekmektedir.
- PgAdmin'i açarak petclinic adında bir veritabanı oluşturunuz.
- Proje içerisinde ki application.properties dosya ayarlarını yapılandırınız. Aşağıda detaylandırma yapılmıştır.
- Projeyi başlatınız. 
- `localhost/swagger-ui.html` adresine gidiniz.Burada apileri kontrol edebilirsiniz.
- `localhost` adresine giderek.üye olabilir ve giriş yapabilirsiniz.
- `localhost/admin/index` Buradan veya ana sayfada (localhost) en sağ alttan admin sayfasına gidebilirsiniz.


## application.properties dosyası
`server.port= 80`  80 portundan yayın yapmaktadır direkt localhost yazarak ulaşabilirsiniz. Portu degiştirerek istediğiniz portu (örnek:server.port= 8081) yazarak kullanabilirsiniz. (localhost:8081 adresinde yayınlanır.)

`spring.datasource.driver-class-name=org.postgresql.Driver`

`spring.datasource.url=jdbc:postgresql://localhost:5432/***` PostgreSql'de kullanmış olduğunuz Database adını *** ile gösterilen yere yazınız büyük-küçük harflere dikkat ediniz. Değiştirmek istemezseniz petclinic olarak bir veritabanı oluşturabilirsiniz.

`spring.datasource.username=postgres` veritabanına bağlanmak için kullanılacak kullanıcı adını yazınız. Standart olarak postgres kullanılır.

`spring.datasource.password=***` veritabanı bağlantısı için kullanılacak parola. *** ile gösterilen yere parolanızı yazınız.

`spring.jpa.show-sql = true` Sql'leri göstermek için true yapınız.

`spring.jpa.hibernate.ddl-auto = update` Herhangi bir değişiklik yapılmışsa veritabanını güncellemek için update yapınız. Create yaparak veritabanını yeniden oluşturabilirsiniz.

`spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect`

 

## Kullanılan Teknolojiler
``` 
- Spring Boot
- Spring Data JPA
- Maven
- Swagger
- Mapstruct
- Json
- Jpa, Hibernate
- PostgreSql
- Thymeleaf
- Bootstrap
- html
- Css
- Js

``` 

