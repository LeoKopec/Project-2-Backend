# Project-2-Backend

## URI Scheme

### DTOs

#### `ReservationDTO`

```json
{
    reservation: {}
    room: {}
}
```

#### `RoomDTO`

```json
{
room: {}
prices: []
}
```



### URIs

#### Guests

##### `POST`—`createGuest(Guest)`—`/guests`

#### Hotels

##### `GET`—`Hotel findByCity()`—

##### `/hotels?start=date&end=date&location=string&size=int`

All are required. Sorted by lowest price.

#### Reservations

##### `GET`—`List<ReservationDTO> findByEmail()`—`/reservations/{email}`

##### `POST`—`create(Reservation)`—`/reservations`

##### `PUT`—`update(Reservation)`—`/reservations/{id}`

##### `DELETE`—`cancel()`—`/reservations/{id}`

#### Rooms

##### `GET`—`RoomDTO findByHotel()`—

##### `/hotel/{id}/rooms?start=date&end=date&size=int`