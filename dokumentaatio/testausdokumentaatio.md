# Testausdokumentaatio

### Puuttuvat testit
Yksikkötestauksessa on puutteita Pelilauta-luokan osalta. Testaamatta on jäänyt graafiseen puoleen liittyvät metodit, joita ei ole tarvettakaan testata. Muutamia oleellisia puutteita on kuitenkin ohjelman logiikassa: yksikkötestien ulkopuolelle on jäänyt esimerkiksi metodit kaanna, tyhjennaRivit ja tarkistaRivit. Näiden testaaminen yksikkötesteinä tuntui hankalalta ja työläältä. 

Lisäksi Tetromino-luokassa on testaamatta pari mutaatiota sekä yksi rivi. Puuttuva rivi on kuitenkin vain getteri ja mutaatiot liittyvät Random-tyyppiseen muuttujaan, jonka testaaminen ei liene kovin oleellista. Käytännössä tämä random arpoo eri tetrominot ja itse pelissä jokaista näitä seitsemää tetrominoa tulee "säännöllisen epäsäännöllisesti", eli random vaikuttaisi toimivan.  

### Testaus käytännössä
Puuttuvia yksikkötestejä olen paikannut käytännön testauksella. Peliä pelatessa en huomannut oikeastaan mitään ongelmia (paitsi Havaitut bugit -kohdassa mainitun "häikän") ja Tetris toimii halutulla tavalla: palat kääntyvät pelilaudalla oikein, peli pudottaa täyden rivin yläpuolella olevat palojen osat alaspäin rivin tyhjentyessä, jne. Peli myös päättyy, mikäli pelilaudalle ei mahdu uutta Tetrominoa. Vaikka yksikkötestauksessa on siis puutteita, on ohjelmaa kokeiltu käytännössä ja peliä on pelattu monta kertaa eri tavoin ilman havaittuja virheitä. 

### Havaitut bugit
En havainnut ohjelmassani bugeja. Tähän voisin kuitenkin sivuhuomautuksena mainita, että _IPala_ kääntyy välillä niin, että se nousee rivin ylöspäin. En ollut tajunnut ongelmaa, ennen kuin ohjaaja kysyi asiasta demotilaisuudessa, enkä saanut lopulliseen versioon tilannetta korjattua. IPala käännetään siis samalla tavalla kuin muutkin palat, mutta osassa käännöksissä kyseinen pala siis nousee rivin ylöspäin, vaikka näin ei suinkaan kuuluisi tapahtua. Ongelma ei kuitenkaan vaikuta pelin toimivuuteen.
