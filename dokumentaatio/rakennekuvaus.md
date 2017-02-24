# Rakennekuvaus

### Pääohjelma

Sovelluksen pääohjelma on Tetris, jossa sijaitsee main-luokka. 

### Logiikka

Pelilogiikkaan kuuluvat luokat ovat _Tetromino_, _Pelilauta_ ja _PelinKulku_. Tetromino-luokka määrittelee Tetris-palat eli tetrominot taulukon avulla. Tetromino-luokka on toteutukseltaan melko yksinkertainen ja pelilogiikan kannalta keskeisimmät metodit liittyvätkin palan kääntämiseen, jossa tetrominon muotoa vastaava taulukko päivittyy. 

Pelilauta-luokka taas sisältää kaikista keskeisimmän pelilogiikan: luokassa on metodit esimerkiksi pelilaudan luomiseen, tetrominon siirtämiseen ja rivien tyhjentämiseen. Pelilauta toteuttaa jonkin verran myös graafiseen käyttöliittymään liittyviä metodeita, vaikka ne eivät kuulukaan logiikkaan. 

PelinKulku-luokka vastaa pelin sisäisestä ajankulusta ja tarjoaa abstraktit metodit pelin yleiseen säätelyyn (esimerkiksi käynnistämiseen ja sammuttamiseen), jotka käyttöliittymäluokka Tetris toteuttaa. 

### Gui

Graafinen käyttöliittymä käsittää luokat _Tetris_, _NappaimistonKuuntelija_ ja _InfoPaneeli_. Tetris on sovelluksen pääohjelma eli sisältää main-luokan. Tämän lisäksi Tetris toteuttaa PelinKulku-luokan abstraktit metodit, jotka liittyvät pelin keskeisiin toimintoihin, kuten pelin käynnistämiseen ja palojen siirtämiseen. 

Tetris hyödyntää myös NappaimistonKuuntelijaa pelikomentojen toteuttamiseen. NappaimistonKuuntelija saa siis käyttäjän syötteen ja ohjaa painettujen nuolinäppäinten mukaan pelin toimintaa. InfoPaneelin tehtävänä on näyttää seuraava pala, rivit ja pisteet, joten se pitää kirjaa pelitilanteesta.  
