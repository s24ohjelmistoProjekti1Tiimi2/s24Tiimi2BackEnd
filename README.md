# Ohjelmistoprojekti 1 - Back end

Tämä projekti on osa ohjelmistoprojekti 1 -kurssia ja sen tarkoituksena on tarjota kauppiaalle back end, 
jolla hän voi hallita kaupassa olevia tuotteita, valmistajia ja asiakkaita. Tietoja voidaan hakea, lisätä, muokkaa ja poistaa REST-rajapinnan kautta.

Saatavilla 

**https://s24-tiimi2-backend-s24tiimi2backend.2.rahtiapp.fi/**

## Ominaisuudet

- **Tuotteet:**  
  - Tuotteiden lisääminen, muokkaaminen, lukeminen ja poistaminen.  

- **Valmistajat:**  
  - Valmistajien lisääminen, muokkaaminen, lukeminen ja poistaminen.  

- **Asiakkaat:**  
  - Asiakkaiden lisääminen, muokkaaminen, lukeminen ja poistaminen.  

## REST API -toiminnot

- **GET /api/products:** Hakee kaikki tuotteet.
- **GET /api/manufacturers:** Hakee kaikki valmistajat.
- **GET /api/customers:** Hakee kaikki asiakkaat.
- **POST /api/customers:** Lisää uuden asiakkaan.
- **PUT /api/customers/{customerId}:** Päivittää asiakkaan tietoja,

## Teknologiat

- **Backend:**  
  - Spring Boot  
  - Spring Data JPA  
  - H2/PostgreSQL-tietokanta
  - Bootstrap  

   
