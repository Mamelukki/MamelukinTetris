# Aiheen kuvaus ja rakenne

### Luokkakaavio

![Luokkakaavio](https://yuml.me/bf80dc51)


### Sekvenssikaavioita käyttötapauksista

![Käyttötapaus: Palan kääntäminen](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IFBhbGFuIGvDpMOkbnTDpG1pbmVuCk1haW4gLT4gVGV0cmlzOiBuZXcABQcoKQAMEXJ1bigpCgAlBiAtPiBOYXBwYWltaXN0b25LdXVudGVsaWphAD8GAAYWADILUGVsaWxhdXQAKQcABgkoKQoAEgkAgRIIb21pbm8AgRMKAAoFAIEVCwBwGFZLX1VQCgCBEBYAgWkMdACBeAUua2Fhbm5hAIFVDQCBGgtwAIEoCAAJHwCBFTgATSgAggUYdACCIAguc2V1cmFhdmFLYWFubm9zAIMsBwCCPwUAgmoPcmV0dXJuIHR1bG9zAIJoDgCDEwtvbmtvVGlsYWEoACMFLCB4LCB5AIMWDwCCHAxvaXN0YQCDGwwAQRgAgSgKAIFHFgCEFwttZXJraXRzZQAzJHJlcGFpbnQoKQ&s=napkin)

![Käyttötapaus: Palan siirtäminen oikealle](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IFBhbGFuIHNpaXJ0w6RtaW5lbiBvaWtlYWxsZQpNYWluIC0-IFRldHJpczogbmV3AAUHKCkADBFydW4oKQoAJQYgLT4gTmFwcGFpbWlzdG9uS3V1bnRlbGlqYQA_BgAGFgAyC1BlbGlsYXV0ACkHAAYJKCkKABIJAIESCG9taW5vAIETCgAKBQCBFQsAcBhWS19SSUdIVAoAgRMWAIFsDHQAgXsFLmxpaWt1TwCCFgcAgV8NAIEkC3AAgTIILnNpaXJyYQAlCwCBIhh0AIE9CC5zZXVyYWF2YUthYW5ub3MAgkkHAIFcBQCCBw9yZXR1cm4gdHVsb3MAggUOAIIwC29ua29UaWxhYSgAIwUsIHgsIHkAgjMPAIEvDG9pc3RhAII4DABBGHgrKwBcGW1lcmtpdHNlACQkcmVwYWludACDQhQAhE4FAIFeBwCDXQg&s=napkin)

title Käyttötapaus: Palan siirtäminen oikealle
Main -> Tetris: new Tetris()
Main -> Tetris: run()
Tetris -> NappaimistonKuuntelija: new NappaimistonKuuntelija
Tetris -> Pelilauta: new Pelilauta()
Pelilauta -> Tetromino: new Tetromino()
Main -> NappaimistonKuuntelija: VK_UP
NappaimistonKuuntelija -> Tetris: tetris.liikuOikealle()
Tetris -> Pelilauta: pelilauta.siirraOikealle()
Pelilauta -> Tetromino: tetromino.seuraavaKaannos()
Tetromino -> Pelilauta: return tulos
Pelilauta -> Pelilauta: onkoTilaa(tulos, x, y)
Pelilauta -> Pelilauta: poistaTetromino()
Pelilauta -> Pelilauta: x++
Pelilauta -> Pelilauta: merkitseTetromino()
Pelilauta -> Pelilauta: repaint()
Pelilauta -> Tetris: return tetromino

title Käyttötapaus: Palan kääntäminen
Main -> Tetris: new Tetris()
Main -> Tetris: run()
Tetris -> NappaimistonKuuntelija: new NappaimistonKuuntelija
Tetris -> Pelilauta: new Pelilauta()
Pelilauta -> Tetromino: new Tetromino()
Main -> NappaimistonKuuntelija: VK_RIGHT
NappaimistonKuuntelija -> Tetris: tetris.kaanna()
Tetris -> Pelilauta: pelilauta.kaanna()
Tetris -> Pelilauta: new Pelilauta()
Pelilauta -> Tetromino: new Tetromino()
Tetris -> Pelilauta: pelilauta.kaanna()
Pelilauta -> Tetromino: tetromino.seuraavaKaannos()
Tetromino -> Pelilauta: return tulos
Pelilauta -> Pelilauta: onkoTilaa(tulos, x, y)
Pelilauta -> Pelilauta: poistaTetromino()
Pelilauta -> Pelilauta: tetromino.kaanna()
Pelilauta -> Pelilauta: merkitseTetromino()
Pelilauta -> Pelilauta: repaint()
