# Car Control System

---

## Funções do carro

* Ligar o carro;
* Desligar o carro;
* Acelerar;
* Diminuir a velocidade;
* Virar para esquerda/direita;
* Verificar velocidade;
* Trocar a marcha.

---

## Regras do programa

* O carro começa desligado, em ponto morto e com velocidade em 0;
* O carro desligado não realiza nenhuma função;
* O carro aumenta sua velocidade de 1 em 1km/h (máximo de 120km/h);
* O carro diminui sua velocidade de 1 em 1km/h (mínimo de 0km/h);
* O carro tem 6 marchas e não pode pular uma marcha;
* A velocidade do carro deve respeitar os seguintes limites para cada velocidade:
  - se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar;
  - se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km;
  - se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km;
  - se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km;
  - se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km;
  - se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km;
  - se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km.
* O carro poderá ser desligado se estiver no ponto morto (marcha 0) e sua velocidade em 0km/h;
* O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km/h e no máximo 40km/h.