# Thearter-API
Repository for Service Oriented Programming | ITKMITL 2019

## Business Flow

<p align="center">
    <img src="ReadmeSrc/BusinessFlow.png" >
</p>

## Usage

### List all Showtimes
URL : `/api/showtime`

Method : `GET`

Response example

```json
[
  {
    "id": "5da32f48accef147705f4dd4",
    "movieId": "1",
    "theaterId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "11.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fc4accef147705f4dd5",
    "movieId": "1",
    "theaterId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "14.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fcfaccef147705f4dd6",
    "movieId": "1",
    "theaterId": "2",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "12.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fd8accef147705f4dd7",
    "movieId": "1",
    "theaterId": "2",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "17.00",
    "date": "4-OCT-2019",
    "status": true
  }
]
```

### List all Showtimes by TheaterId
URL : `/api/showtimes?theater={theaterId}`

Method : `GET`

Response example

```json
[
  {
    "id": "5da32f48accef147705f4dd4",
    "movieId": "1",
    "theaterId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "11.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fc4accef147705f4dd5",
    "movieId": "1",
    "theaterId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "14.00",
    "date": "4-OCT-2019",
    "status": true
  }
]
```

### List all Showtimes by MovieId

URL : `/api/showtime?movie={movieId}`

Method : `GET`

Response example

```json
[
  {
    "id": "5da32f48accef147705f4dd4",
    "movieId": "1",
    "theaterId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "11.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fc4accef147705f4dd5",
    "movieId": "1",
    "theaterId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "14.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fcfaccef147705f4dd6",
    "movieId": "1",
    "theaterId": "2",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "12.00",
    "date": "4-OCT-2019",
    "status": true
  },
  {
    "id": "5da32fd8accef147705f4dd7",
    "movieId": "1",
    "theaterId": "2",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "17.00",
    "date": "4-OCT-2019",
    "status": true
  }
]
```

### List all Movie Information
URL : `/api/movie`

Method : `GET`

Response example

```json
[
  {
    "id": "5da321b7accef147705f4dd0",
    "movieId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film"
  },
  {
    "id": "5da326b8accef147705f4dd2",
    "movieId": "2",
    "movieName": "The Matrix",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "24-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film"
  }
]
```

### Show Movie Information by MovieId
URL : `/api/movie/{movieId}`

Method : `GET`

Response example

```json
[
  {
    "id": "5da321b7accef147705f4dd0",
    "movieId": "1",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film"
  }
]
```

### Add Movie Information
URL : `/api/movie`

Method : `POST`

Request example

```json
{
  "movieId": "2",
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-OCT-2019",
  "movieLength": "104",
  "movieDescription": "This is Short Description of This Film"
}
```

Response example

```json
{
  "id": "5da32334accef147705f4dd1",
  "movieId": "2",
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-OCT-2019",
  "movieLength": "104",
  "movieDescription": "This is Short Description of This Film"
}
```

### Edit Movie Information
URL : `/api/movie/{id}`

Method : `PUT`

Request example

```json
{
  "movieId": "2",
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-OCT-2019",
  "movieLength": "120",
  "movieDescription": "This is Short Description of This Film"
}
```

Response example

```json
{
  "id": "5da32334accef147705f4dd1",
  "movieId": "2",
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-OCT-2019",
  "movieLength": "120",
  "movieDescription": "This is Short Description of This Film"
}
```

### Delete Movie Information
URL : `/api/movie/{id}`

Method : `DELETE`



### Add Theater
URL : `/api/theater`

Method : `POST`

Request example

```json
{
  "theaterId": "3",
  "seats": ["A1", "A2", ..., "B10"]
}
```

Response example

```json
{
  "id": "5da32a9eaccef147705f4dd3",
  "theaterId": "3",
  "seats": ["A1", "A2", ..., "B10"]
}
```

### Add Showtime
URL : `/api/showtime`

Method : `POST`

Request example

```json
{
  "movieId": "1",
  "theaterId": "1",
  "date": "4-OCT-2019",
  "time": "11.00",
  "status": true
}
```

Response example

```json
{
  "id": "5da32f48accef147705f4dd4",
  "movieId": "1",
  "theaterId": "1",
  "date": "4-OCT-2019",
  "time": "11.00",
  "status": true,
  "availableSeats": ["A1", "A2", ..., "B10"],
  "unavailableSeats": null
}
```

## Under Development Function

### Delete Showtime
URL : `/delete-showtime`

Method : `POST`

Request example

```json
{
  "theaterId": "1",
  "times": ["13.00", "17.00"],
  "date": "13-sep-2019"
}
```

### Delete All Showtime by Date
URL : `/delete-all-showtime`

Method : `POST`

Request example

```json
{
  "date": "13-sep-2019"
}
```

### Reserve
URL : `/reserve`

Method : `POST`

Request example

```json
{
  "username": "username",
  "movieId": "1",
  "theaterId": "1",
  "time": "13.00",
  "date": "12-sep-2018",
  "seats": ["A1", "A2"]
}
```

### User History
URL : `/history`

Method : `POST`

Request example

```json
{
  "username": "username"
}
```

Response example

```json
[
  {
    "movieId": "1",
    "theaterId": "1",
    "time": "13.00",
    "date": "12-sep-2018",
    "seats": ["A1", "A2"]
  },
    {
    "movieId": "2",
    "theaterId": "1",
    "time": "19.00",
    "date": "12-sep-2018",
    "seats": ["A1", "A2"]
  }
]
```

