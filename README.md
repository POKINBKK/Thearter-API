# Thearter-API
Repository for Service Oriented Programming | ITKMITL 2019

## Usage

### List all Showtimes
URL : `/showtimes`

Method : `GET`

Response example

```json
[
  {
    "movieId": "1",
    "movieName": "The Avengers",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "1",
    "times": ["10.30", "13.00"],
    "date": "12-sep-2019"
  },
  {
    "movieId": "1",
    "movieName": "The Avengers",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "2",
    "time": ["11.00", "14.00"],
    "date": "12-sep-2019"
  },
  {
    "movieId": "2",
    "movieName": "The Terminal",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "3",
    "time": ["10.30", "13.00"],
    "date": "12-sep-2019"
  }
]
```

### List all Showtimes by Theater
URL : `/showtimes/{theaterId}`

Method : `GET`

Response example

```json
[
  {
    "movieId": "1",
    "movieName": "The Avengers",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "1",
    "times": ["10.30", "13.00"],
    "date": "12-sep-2019"
  },
  {
    "movieId": "2",
    "movieName": "The Terminal",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "1",
    "time": ["16.20", "19.00"],
    "date": "12-sep-2019"
  }
]
```

### List all Showtimes by Movie
URL : `/showtimes/{movieId}`

Method : `GET`

Response example

```json
[
  {
    "movieId": "1",
    "movieName": "The Avengers",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "1",
    "times": ["10.30", "13.00"],
    "date": "12-sep-2019"
  },
  {
    "movieId": "1",
    "movieName": "The Avengers",
    "movieThumbnail": "img.thumbnails",
    "movieDescription": "It's story",
    "theaterId": "2",
    "time": ["11.00", "14.00"],
    "date": "12-sep-2019"
  }
]
```

### Add Movie
URL : `/add-movie`

Method : `POST`

Request example

```json
{
  "movieName": "The Amazing Spider-Man"
}
```

### Edit Movie
URL : `/edit-movie`

Method : `POST`

Request example

```json
{
  "movieId": "3",
  "movieName": "The Amazing Spider-Man"
}
```

### Delete Movie
URL : `/delete-movie`

Method : `POST`

Request example

```json
{
  "movieId": "3"
}
```

### Add Showtime
URL : `/add-showtime`

Method : `POST`

Request example

```json
{
  "movieId": "1",
  "theaterId": "1",
  "times": ["13.00", "17.00"],
  "date": "13-sep-2019"
}
```

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

### Reserve
URL : `/cancel`

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

