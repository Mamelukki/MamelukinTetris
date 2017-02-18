# Aiheen kuvaus ja rakenne

### Luokkakaavio

![Luokkakaavio](https://yuml.me/bf80dc51)


### Sekvenssikaavioita käyttötapauksista

![Käyttötapaus: Palan kääntäminen](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IFBhbGFuIGvDpMOkbnTDpG1pbmVuCk1haW4gLT4gVGV0cmlzOiBuZXcABQcoKQAMEXJ1bigpCgAlBiAtPiBOYXBwYWltaXN0b25LdXVudGVsaWphAD8GAAYWADILUGVsaWxhdXQAKQcABgkoKQoAEgkAgRIIb21pbm8AgRMKAAoFAIEVCwBwGFZLX1JJR0hUCgCBExYAgWwMdACBewUua2Fhbm5hAIFYDQCBHQtwAIErCAAJHwCBGDgATSgAgggYdACCIwguc2V1cmFhdmFLYWFubm9zAIMvBwCCQgUAgm0PcmV0dXJuIHR1bG9zAIJrDgCDFgtvbmtvVGlsYWEoACMFLCB4LCB5AIMZDwCCHAxvaXN0YQCDHgwAQRgAgSgKAIFHFgCEGgttZXJraXRzZQAzJHJlcGFpbnQoKQ&s=napkin)

![Käyttötapaus: Palan siirtäminen oikealle](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=CnRpdGxlIEvDpHl0dMO2dGFwYXVzOiBQYWxhbiBzaWlydMOkbWluZW4gb2lrZWFsbGUKTWFpbiAtPiBUZXRyaXM6IG5ldwAFBygpAAwRcnVuKCkKACUGIC0-IE5hcHBhaW1pc3Rvbkt1dW50ZWxpamEAPwYABhYAMgtQZWxpbGF1dAApBwAGCSgpCgASCQCBEghvbWlubwCBEwoACgUAgRULAHAYVktfVVAKAIEQFgCBaQx0AIF4BS5saWlrdU8AghMHAIFcDQCBIQtwAIEvCC5zaWlycmEAJQsAgR8YdACBOgguc2V1cmFhdmFLYWFubm9zAIJGBwCBWQUAggQPcmV0dXJuIHR1bG9zAIICDgCCLQtvbmtvVGlsYWEoACMFLCB4LCB5AIIwDwCBLwxvaXN0YQCCNQwAQRh4KysAXBltZXJraXRzZQAkJHJlcGFpbnQAgz8UAIRLBQCBXgcAg1oI&s=napkin)

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
