### Exemplos de POST

Nesse projeto estamos usando o Swagger e lombok para facilitar as coisas. Abaixo exemplo de payloads POST

* POST USUARIO

```json
{
  "storeUserId": 0,
  "storeUserName": "Usuário 1",
  "storeUserLastName": "Sobrenome 1",
  "storeUserPhoneNumber": "98765-4321",
  "storeUserEmail": "usuario1@example.com",
  "storeUserPassword": "senha1",
  "storeUserCPF": "123.456.789-00",
  "storeUserBirthDate": "1990-01-01",
  "storeUserAddress": 1
}
```
* POST SERVICO
```json
{
  "storeServicesId": 0,
  "storeWifi": true,
  "storeAr": false,
  "storePet": true,
  "storeCouvert": true,
  "storeEstacionamento": false,
  "storKids": true,
  "storeArLivre": false,
  "storeDeficiente": true,
  "storeFumante": false,
  "storeSelfService": true,
  "storeRodizio": false
}
```
* POST ENDERECO
```json
{
  "storeAddressId": 0,
  "storeAddressRoad": "Rua A",
  "storeAddressNumber": "123",
  "storeAddressNeighborhood": "Bairro A",
  "storeAddressCounty": "Cidade A",
  "storeAddressCEP": "12345-678",
  "storeAddressTypeUser": false
}
```
* POST ESTABELECIMENTO
```json
{
  "storeEstablishmentId": 0,
  "storeEstablishmentAddressId": 5,
  "storeEstablishmentCookingId": 1,
  "storeEstablishmentServiceId": 1,
  "storeEstablishmentSubscribeNumber": "123456",
  "storeEstablishmentEmp": "Restaurante A",
  "storeEstablishmentFantasyName": "Restaurante do João",
  "storeEstablishmentResp": "João",
  "storeEstablishmentEmail": "restaurantea@example.com",
  "storeEstablishmentPhone": "1111-1111",
  "storeEstablishmentSeats": "100"
}
```
* POST CULINARIA
```json
{
  "storeCookingId": 1,
  "storeItaliana": true,
  "storeJaponesa": false,
  "storeNordestina": false,
  "storeMexicana": true,
  "storePizzaria": false,
  "storeMineira": false,
  "storeChinesa": true,
  "storeArabe": false,
  "storeGrega": false,
  "storeFrancesa": true,
  "storeCoreana": false
}
```
* POST RESERVA
```json
{
  "storeReservationId": 0,
  "storeReservationUserId": 1,
  "storeReservationEstablishmentId": "1",
  "storeReservationCountPeople": "2",
  "storeReservationTime": "19:00",
  "storeReservationName": "Reserva para 2 pessoas",
  "storeReservationDate": "2024-05-11",
  "storeReservationRating": "4",
  "storeReservationObs": "Nenhuma observação",
  "storeReservationConfirm": "p",
  "storeReservationEnd": "0"
}
```