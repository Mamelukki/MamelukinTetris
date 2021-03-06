# Käyttöohjeet

### Pelin käynnistäminen
Pelin saa käynnistettyä kaksoisklikkaamalla .jar-tiedostoa (target-kansiossa), ajamalla ohjelman NetBeansissä tai suorittamalla komentoikkunassa komennon

``` 
java -jar Tetris-1.0-SNAPSHOT.jar
``` 

### Pelin sammuttaminen
Peli on mahdollista sammuttaa painamalla ohjelmaruudun x-näppäintä. Peli myös sammuu automaattisesti, kun pelilaudalle ei enää mahdu uutta tetrominoa. Pelin päättymisestä ei tule erillistä ilmoitusta, eikä tuloksia ei ole mahdollista tallettaa mitenkään.

### Peliohjeet ja toiminnot
Peli on toimintaidealtaan hyvin samankaltainen kuin perinteinen Tetris. Tarkoituksena on siis täyttää pelilautaa niin, että rivit tulevat täyteen eikä väliin jää tyhjiä ruutuja. Peli päättyy, kun pelilaudalle ei mahdu enää uutta tetrominoa. Pelin tavoitteena on saada mahdollisimman paljon pisteitä, joita saa sitä mukaa, kun rivejä saa täytettyä. Pisteet kertyvät vakionopeudella. 

Käyttäjän on mahdollista siirtää, kääntää ja pudottaa paloja sekä lopettaa peli. Nämä toiminnot onnistuvat seuraavilla näppäimillä:

x - ohjelman sulkeminen

← palan siirtäminen vasemmalle

↑ palan kääntäminen

→ palan siirtäminen oikealle

↓ palan pudottaminen nopeammin

Palat siis putoavat joka tapauksessa alemmas, mutta niiden putoamista on mahdollista nopeuttaa painamalla nuoli alas -näppäintä. 
