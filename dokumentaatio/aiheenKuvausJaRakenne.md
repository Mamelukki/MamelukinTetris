# Aiheen kuvaus ja rakenne

### Aihemäärittely: Tetris

_Aihe:_ Toteutan ohjelmoinnin harjoitustyönä yksinkertaistetun version Tetriksestä. Peli on muuten kuten perinteinen Tetris, mutta joitakin ominaisuuksia on yksinkertaisuuden vuoksi poistettu, esimerkiksi pelin tahti ei nopeudu pelin edetessä ja pelissä ei ole menu-valikkoa. Pelin idea on täyttää rivejä ja saada siten mahdollisimman paljon pisteitä. 

_Käyttäjät:_ pelaaja

_Käyttäjän toiminnot:_ 
- Palojen siirtäminen (nuoli vasen tai nuoli oikea)
- Palojen kääntäminen (nuoli ylös)
- Uuden pelin aloittaminen (sovelluksen käynnistys)
- Pelin lopettaminen (painamalla x)
- Palojen pudottaminen nopealla vauhdilla (nuoli alas)


### Luokkakaavio


![Luokkakaavio](https://yuml.me/bf80dc51)

Teknisistä syistä en saanut oikeaoppisesti merkattua PelinKulku-luokkaa abstraktiksi, mutta ajattelin silti, että sen olisi hyvä näkyä luokkakaaviossa, joten päädyin tällaiseen ratkaisuun. 

### Sekvenssikaavioita käyttötapauksista


![Käyttötapaus: Palan kääntäminen](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IFBhbGFuIGvDpMOkbnTDpG1pbmVuCk1haW4gLT4gVGV0cmlzOiBuZXcABQcoKQAMEXJ1bigpCgAlBiAtPiBOYXBwYWltaXN0b25LdXVudGVsaWphAD8GAAYWADILUGVsaWxhdXQAKQcABgkoKQoAEgkAgRIIb21pbm8AgRMKAAoFAIEVCwBwGFZLX1VQCgCBEBYAgWkMdACBeAUua2Fhbm5hAIFVDQCBGgtwAIEoCAAeCgCBEBh0AIErCC5zZXVyYWF2YUthYW5ub3MAgjcHAIFKBQCBdQ9yZXR1cm4gdHVsb3MAgXMOAIIeC29ua29UaWxhYSgAIwUsIHgsIHkAgiEPAIEnDG9pc3RhAIImDABBGACBKAoAgUcWAIMiC21lcmtpdHNlADMkcmVwYWludCgp&s=napkin)


![Käyttötapaus: Palan siirtäminen oikealle](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IFBhbGFuIHNpaXJ0w6RtaW5lbiBvaWtlYWxsZQpNYWluIC0-IFRldHJpczogbmV3AAUHKCkADBFydW4oKQoAJQYgLT4gTmFwcGFpbWlzdG9uS3V1bnRlbGlqYQA_BgAGFgAyC1BlbGlsYXV0ACkHAAYJKCkKABIJAIESCG9taW5vAIETCgAKBQCBFQsAcBhWS19SSUdIVAoAgRMWAIFsDHQAgXsFLmxpaWt1TwCCFgcAgV8NAIEkC3AAgTIILnNpaXJyYQAlCwCBIhh0AIE9CC5zZXVyYWF2YUthYW5ub3MAgkkHAIFcBQCCBw9yZXR1cm4gdHVsb3MAggUOAIIwC29ua29UaWxhYSgAIwUsIHgsIHkAgjMPAIEvDG9pc3RhAII4DABBGHgrKwBcGW1lcmtpdHNlACQkcmVwYWludACDQhQAhE4FAIFeBwCDXQg&s=napkin)
