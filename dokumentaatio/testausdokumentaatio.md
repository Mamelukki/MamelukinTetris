# Testausdokumentaatio

### Puuttuvat testit
Yksikkötestauksessa on puutteita Pelilauta-luokan osalta. Testaamatta on jäänyt graafiseen puoleen liittyvät metodit, joita ei ole tarvettakana testata. Muutamia oleellisia puutteita on kuitenkin ohjelman logiikassa: yksikkötestien ulkopuolelle on jäänyt esimerkiksi metodit käännä, tyhjennäRivit ja tarkistaRivit. Kaikki näistä tuntuivat haastavilta testata yksikkötesteinä. 

Lisäksi Tetromino-luokassa on testaamatta pari mutaatiota sekä yksi rivi. Puuttuva rivi on kuitenkin vain getteri ja mutaatiot liittyvät Random-tyyppiseen muuttujaan, jonka testaaminen ei liene kovin oleellista. Käytännössä tämä random arpoo eri tetrominot ja itse pelissä jokaista näitä seitsemää tetrominoa tulee säännöllisen epäsäännöllisesti, eli random vaikuttaisi toimivan.  

### Testaus käytännössä
Puuttuvia yksikkötestejä olen paikannut käytännön testauksella. Testien kirjoittaminen on tuntunut työläältä ja haastavalta, ja toisaalta itse pelissä mahdolliset ongelmat ja toimivuudet tulevat selkeästi esiin. Palat kääntyvät pelilaudalla oikein, peli pudottaa täyden rivin yläpuolella olevat palojen osat alaspäin rivin tyhjentyessä. Peli myös päättyy, mikäli pelilaudalle ei mahdu uutta Tetrominoa.  

### Havaitut bugit
En havainnut ohjelmassani bugeja. Tähän voisin kuitenkin sivuhuomautuksena mainita, että IPala kääntyy välillä niin, että se nousee rivin ylöspäin. En ollut tajunnut ongelmaa, ennen kuin ohjaaja kysyi asiasta demotilaisuudessa, enkä saanut lopulliseen versioon tilannetta korjattua. IPala käännetään siis samalla tavalla kuin muutkin palat, mutta osassa käännöksissä kyseinen pala siis nousee rivin ylöspäin, vaikka näin ei suinkaan kuuluisi tapahtua. Ongelma ei kuitenkaan vaikuta pelin toimivuuteen. Pelin sulkemistapa ei myöskään ole paras mahdollinen.  
