# Thearter-API
Repository for Service Oriented Programming | ITKMITL 2019

## Business Flow

<p align="center">
    <img src="ReadmeSrc/BusinessFlow.png" >
</p>

## Usage

# Showtime Service

### Get all Showtimes
URL : `/showtime`

Method : `GET`

Response example

```json
[
  {
    "id": "5da32f48accef147705f4dd4",
    "movieId": "5db3fcfcaccef102e44d75f4",
    "theaterId": "5db1280f084af14cc0590c92",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "11.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fc4accef147705f4dd5",
    "movieId": "5db3fcfcaccef102e44d75f4",
    "theaterId": "5db1280f084af14cc0590c92",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "14.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fcfaccef147705f4dd6",
    "movieId": "5db3fcfcaccef102e44d75f4",
    "theaterId": "5db12821084af14cc0590c93",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "12.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fd8accef147705f4dd7",
    "movieId": "5db3fcfcaccef102e44d75f4",
    "theaterId": "5db12821084af14cc0590c93",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "17.00",
    "date": "04-10-2019",
    "status": true
  }
]
```

### Get all Showtimes by TheaterId
URL : `/showtime?theater={theaterId}`

Method : `GET`

Response example

```json
[
  {
    "id": "5da32f48accef147705f4dd4",
    "movieId": "5db3fcfcaccef102e44d75f4",
    "theaterId": "5db1280f084af14cc0590c92",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "11.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fc4accef147705f4dd5",
    "movieId": "5db3fcfcaccef102e44d75f4",
    "theaterId": "5db1280f084af14cc0590c92",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "14.00",
    "date": "04-10-2019",
    "status": true
  }
]
```

### Get all Showtimes by MovieId

URL : `/showtime?movie={movieId}`

Method : `GET`

Response example

```json
[
  {
    "id": "5da32f48accef147705f4dd4",
    "movieId": "5da32fc4accef147705f4dd5",
    "theaterId": "5db1280f084af14cc0590c92",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "11.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fc4accef147705f4dd5",
    "movieId": "5da32fc4accef147705f4dd5",
    "theaterId": "5db1280f084af14cc0590c92",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "14.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fcfaccef147705f4dd6",
    "movieId": "1",
    "theaterId": "2",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "12.00",
    "date": "04-10-2019",
    "status": true
  },
  {
    "id": "5da32fd8accef147705f4dd7",
    "movieId": "1",
    "theaterId": "2",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "03-10-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film",
    "time": "17.00",
    "date": "04-10-2019",
    "status": true
  }
]
```

### Get Showtime by Id
URL : `/showtime?id={id}`

Method : `GET`

Response example

```json
{
    "_id": "5da32f48accef147705f4dd4",
    "movieId": "5da32f48accef147705f4dd4",
    "theaterId": "5da32f48accef147705f4dd4",
    "date": "04-10-2019",
    "time": "11.00",
    "status": true,
    "availableSeats": ["A3", "A4", ..., "B10"]
}
```

### Delete Showtime by Date
URL : `/showtime?date={date}`

Method : `DELETE`

Response Example

```json
Delete showtime date: {date} Complete
```

### Add Showtime
URL : `/showtime`

Method : `POST`

Request example

```json
{
  "movieId": "5da32f48accef147705f4dd4",
  "theaterId": "5da32fcfaccef147705f4dd6",
  "date": "04-10-2019",
  "time": "11.00",
  "status": true
}
```

Response example

```json
{
  "id": "5da32f48accef147705f4dd4",
  "movieId": "5da32f48accef147705f4dd4",
  "theaterId": "5da32f48accef147705f4dd4",
  "date": "04-10-2019",
  "time": "11.00",
  "status": true,
  "availableSeats": ["A1", "A2", ..., "B10"]
}
```

### Delete Showtime by Id
URL : `/showtime?id={id}`

Method : `DELETE`

Response Example

```json
Delete showtime _id: {_id} Complete
```

# Movie Service

### Get all Movie Information
URL : `/movie`

Method : `GET`

Response example

```json
[
  {
    "_id": "5da321b7accef147705f4dd0",
    "movieName": "JOKER",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "3-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film"
  },
  {
    "_id": "5da326b8accef147705f4dd2",
    "movieName": "The Matrix",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "24-OCT-2019",
    "movieLength": "120",
    "movieDescription": "This is Short Description of This Film"
  }
]
```

### Get all Movies Information by id
URL : `/movie/{_id}`

Method : `GET`

Response example

```json

{
  "_id": "5da321b7accef147705f4dd0",
  "movieName": "JOKER",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "3-OCT-2019",
  "movieLength": "120",
  "movieDescription": "This is Short Description of This Film"
}

```

### Add Movie
URL : `/movie`

Method : `POST`

Request example

```json
{
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-10-2019",
  "movieLength": "104",
  "movieDescription": "This is Short Description of This Film"
}
```

Response example

```json
{
    "_id": "5db2fab7accef10da071ca0d",
    "movieName": "The Matrix",
    "movieThumbnail": "picpath",
    "movieReleaseDate": "24-10-2019",
    "movieLength": "104",
    "movieDescription": "This is Short Description of This Film"
}
```

### Edit Movie
URL : `/movie/{id}`

Method : `PUT`

Request example

```json
{
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-10-2019",
  "movieLength": "120",
  "movieDescription": "This is Short Description of This Film"
}
```

Response example

```json
{
  "_id": "5db2fb23accef10da071ca0e",
  "movieName": "The Matrix",
  "movieThumbnail": "picpath",
  "movieReleaseDate": "24-10-2019",
  "movieLength": "120",
  "movieDescription": "This is Short Description of This Film"
}
```

### Delete Movie
URL : `/movie/{id}`

Method : `DELETE`


# Theater Service

### Add Theater
URL : `/theater`

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
  "_id": "5da32a9eaccef147705f4dd3",
  "theaterId": "3",
  "seats": ["A1", "A2", ..., "B10"]
}
```

### Get Theater
URL : `/theater`

Method : `Get`

Response example

```json
[
  {
  "_id": "5db1280f084af14cc0590c92",
  "theaterId": "1",
  "seats": ["A1", "A2", ..., "B10"]
  },
  {
  "_id": "5db12821084af14cc0590c93",
  "theaterId": "2",
  "seats": ["A1", "A2", ..., "B10"]
  }
]
```

### Get Theater detail by id
URL : `/theater/{_id}`

Method : `GET`

Response example

```json
{
  "_id": "5da32a9eaccef147705f4dd3",
  "theaterId": "3",
  "seats": ["A1", "A2", ..., "B10"]
}
```

### Delete Theater
URL : `/theater/{_id}`

Method : `DELETE`

Response example

```json
Delete theater _id: {_id} Complete
```

# User Service

### Get User's information
URL : `/u`

Method : `GET`

Response example

```json
[
  {
    "username": "user1",
    "tickets": [
      "5db43d8daccef1020cb470ed",
      "5db43d9caccef1020cb470ee"
    ]
  },
  {
    "username": "user2",
    "tickets": [
      "5db43dabaccef1020cb470ef",
      "5db43db8accef1020cb470f0"
    ]
  }
]
```

### Get User's Ticket
URL : `/u/{username}`

Method : `GET`

Response example

```json
[
  {
    "_id": "5db43d8daccef1020cb470ed",
    "username": "user1",
    "showtimeId": "5db3fd80accef102e44d75f6",
    "seats": [
      "A1",
      "A2"
    ]
  },
  {
    "_id": "5db43d9caccef1020cb470ee",
    "username": "user1",
    "showtimeId": "5db3fd8daccef102e44d75f7",
    "seats": [
      "A1",
      "A2"
    ]
  }
]
```

### Reserve
URL : `/u`

Method : `POST`

Request example

```json
{
  "username": "user2",
  "showtimeId": "5db3fd80accef102e44d75f6",
  "seats": ["A3", "A4"]
}
```

Response example

```json
{
  "username": "user2",
  "tickets": [
      "5db43dabaccef1020cb470ef",
      "5db43db8accef1020cb470f0"
  ]
}
```

### Get all Ticket
URL : `/u/ticket`

Method : `GET`

Response example

```json
[
  {
    "_id": "5db43d8daccef1020cb470ed",
    "username": "user1",
    "showtimeId": "5db3fd80accef102e44d75f6",
    "seats": [
      "A1",
      "A2"
    ]
  },
  {
    "_id": "5db43d9caccef1020cb470ee",
    "username": "user1",
    "showtimeId": "5db3fd8daccef102e44d75f7",
    "seats": [
      "A1",
       "A2"
    ]
  },
  {
    "_id": "5db43dabaccef1020cb470ef",
    "username": "user2",
    "showtimeId": "5db3fd8daccef102e44d75f7",
    "seats": [
      "A3",
      "A4"
    ]
  },
  {
    "_id": "5db43db8accef1020cb470f0",
    "username": "user2",
    "showtimeId": "5db3fd80accef102e44d75f6",
    "seats": [
      "A3",
      "A4"
    ]
  }
]
```

### Delete Ticket
URL : `/u/ticket/{id}`

Method : `DELETE`

# Wep Appilcation DionCineplex

go to website

[DionCineplex](http://34.87.24.186/)

## Page

### Main Page : /

### Method used
> GET /movie

![](https://lh3.googleusercontent.com/LIrqxrgMMQNcNwVlS3w7B8ldxw-IzXVaFWmhwkvZgXA0ikIAHHR_nujjmqCNBKJIhx3Clkih4XId1nw8WWC6AVmoYm9AO-UuN_eUcF63tC0pMyO-En_WA1skDOmsFp-6Y6rvmiFJXWKLsKHyD6QXVy9_z_JXo3bLGbI798S9ai_6BJxGKtU7CC8mMfCJiCeSTVZUgYUgh0-Yip6KvYQikEKJEFPNb0Kfr0Fbo9JmTjw7MMF1MWDOmFtSCFlOFtqvE0hgdDEpCPbWpJSlgQx8TxWK1D3Vr2dwwoDP7JWC1rAbT3Yfj0o41HvegPrwVTZw_FrDIa8CBK8_2B30dEsTpt-Eau9zAAK7TfDfNDrQeCqYSOY5s1HefUS4rN3xDEzyYOhjn1KdXPcTvRO7kP3yPqVAbYl-px8saRLfXdj5-6cGyCua5vDPVCSpzxJnXqB-3gK0ropWwglIt8FKe_GiIwWLuG9CkydxP2WwGNdViJTwbPCmI11Ec86yB9yY0xH76ivHUM34vKHrDGtGXXsC5iT2UqpIIH5YDUTP60WzZIS5CsScySOF0qW-tbn_zi3EmYWIDUilT4sSFfPKYaMCykOgG5qN1nqjAgvs3Ar7_7ZTe_CPKOGeuKZ4wx4i6BN7CNfOy4638qmO7x_maGosI0LNWhbmuyZkuA2l2S-1FxnD6bXFslhgFcU=w1918-h903-no)

### Main Page : /nowshowing/5db453357291ea21c84d1be8

### Method used
> GET /showtime?movie={movie_id}
> GET /movie

![](https://lh3.googleusercontent.com/rijozHVnS-wUNCPl0N_2of5U_0Bazy2nnnIiWhwCKk41wwx_K0USDyFHX9wzSYV6jZKVXu4Dtkcw6kr4Nq0qwomNdYvNibPpkvjXJp1JOq4b6VO_H8q8h9yL82E68PKdBKHUOGny9KMXLUeF8sD-9xeM0cfOuxN2WIhVRPFSc5WEOEoogs8o3SOKM-oNoScH229WHyqn-WvOTuG0U6cKGwMy7RAWkBp0SF19QNlWiO-5qpUh-bQlvUbBRqVgYoG4uMgKQZzA6vrdhLgXRm-bYVj8oW1cbf6eNWDbY8vGmZl0IhvFoxYd96nXU4F1N8nGYkV3mzHHTixF4gn2T0PR_jCHe3B-l4ulWx5xB8cnLPJaiJaoiV3ExTmkEeXabw-UkST2JnhPSif8lV9_-dqnqKC28CxiuB4jHXIXXhI39vMun8I75M9nnuLlOp91i6o-Yyp4VKHEBqjK6QDLc7gFckPiYqCHt8w6japXbSDSywE42oUyzI992UnRUomJ82kx3VmnQJzjjguoLythSz2aTpYBeWangafM_1-yGnDYJdQpb2ADNcFttgxHmtXuYpExTytNqBSkj_ZwM2OUEUdAhbC5ddWwZLDjtBNWkvx2-4ZfgPYtrB_82Sn1lBjR9cqN9tV9GLOchQ1FGNRlQa3VxP2W5bvzpheOLMeXi2XYcMM1PbTzfiIHxVQ=w1900-h901-no)

### Main Page : /selectseat/5db599c37291ea1b719c0b89

### Method used
> GET /showtime?id={showtime_id}
> GET /theater
> GET /movie

![](https://lh3.googleusercontent.com/Y9CDFphsDuRz0FrKHcRKerTP-gSOvYuRVG4OfTygkCaq3A3rtR20iGT1WtJWw29ByegCQTbV4_zHag6khy3qwoHS5VMJpVS0tPjmAUhDVMiy1sPc5oR9sryXUM3pHgqkmc8_B9wX4DBWch4eawuoQxYxH4vVEa05uCN8t9I61I34ALvHn-hc1015svWMMELhkVyDmxTXshgrKewzwCB_MwZbHY8PjPgP0OZXhEUw_rKJ77o8VeVi0Wz_Pxl-6Vcf-ok1C9ikUcJKNOrCbMCtUoFXTHiikEmslgND5WHGxnGlitFvlYYP0JOIAOl7j16HjOKFwGZPuwbBUlFoUKv54YCIlQk_mfbGAQZRuZNAXmQXZYWv-1w-zGYLvK-nvTsx0iUEGuKI4CwYNsjbfxWj-Guuu6LU-SMNS9qnL_EQmYXMFdN4twytz6f_D_hGyZSlnzF9atbKTTQQOQKHrQiJn4mzRmkqRvLk3aK2nw6E3HJnEAhzVR7mbo-7fyQfU_j74UzirEXO0IB4rDublSqqhAVVF4lS5Ngo2wFcHpX4jIrwy7ZSFX-XYYT_WZ1A7tmpYvSv2g7YrlGEMnfOIQHo6MlIIBK_qF_19bCEz-Z5kWugtRlD-BBizzc5DYFe352WoJQF2F0pm8ovAnSm1rh_GSsVPrFoARxN5kq5R2q9i0rxczklPT-TrZ0=w1920-h900-no)

### Main Page : /payment

### Method used
> GET /showtime?id={showtime_id}
> GET /movie
> PUT /showtime/{showtime_id}  ( Remove selected seat when booking sucess )
> POST /u/ ( Add new ticket in database )

![](https://lh3.googleusercontent.com/viMdhGeQ5wt_x9bNm4pGGc-53jfbbSuSa0ijD6ksa_Yi8xU3DPt1KXJyavo-vg55VsDv7M3-Hi0w4yfDVx7WrHzPfXsLXgn-iUvLsaTwlm96wHOiU14JLNn_YlkSYgIUQ6Ch3MSftef5-UfZoTyz5eX4TPZtpSP00d0eC698aiYnjLD8syFb2Y2K-ldZvk7_l8377wOdmI7j1mOwCH7n_e1vlz6fzjkctGzc_8YpZgCvtlpOVUmDA-j5zBowKL17_4Z2Nx6a1I8rxawWKOGZ2tGsSyhl8Tne0L1B7c-1He-nYi6Evtt8LKvD4nkmpHQyE3zVIsAfxgl7GagtGshR0tQ6_gTmVCf4eqvTXS3A3NZP0_9vci_bddk_TxG8BiNEvDHyP3uhjT5ohvpEfeOcsxZQt1Jf9G46XfeDESev9rxACqfyPTelRrgH1xpxu3NPU_LR8Nw0AZznJxxrwRHa3NVV0NbYQ2Volgeaj5prPv8NW9-xKDTsB6l1eQ8cBESTaebKEvyLS70jfAN01FV9mP5FTHT2IFU1uRJmEVUjg5R53RwK5KzcPNUBltjGab_7i5qFg98AIfqHdqD6esv98MTTy35P3bN155SHkJlDuD_Dm4ySQlH9zZWBJ4Myrr67fZDPaK5NEpcvH551GJGkz2gaGz71cT4EVM5AQktSMx_Tnya5_kfgqAo=w1920-h900-no)

### Main Page : /profile

### Method used
> GET /u/{username} ( Get ticket by username )

![](https://lh3.googleusercontent.com/-rxq1jHSjIW1Y9zk87dkkmuKgfIUjsP6O1xzgNXRL5nQp39NVplRSQhWgQvnY1gvnY7Xw0KC2_Q3Lc1etp7bX0mQBTLnvgTzwbtbNY2Xd6FVPs65Rl1mOXrwV1lHdLAqzNYjp8IgSbceekrretskJGyd5HmXyQioYui3o7nL0U4W9m98VVSVWuS0K93hoK7GCSI1wuTcxa9wNReXVadkHWgigDWIwPP5zVOm9eL5UAfk_LC2aZA3lO5bclC_re-T8eU0WxlhEWhP0yYIXP_bjZTSyhXEkVvfO7Qx2odBCZQ0H2TpwcqNHIQFJRCzIRz1g_P1MDYDTbrdKXPW7lporoVLeHq72M6fJ0aJSINOWvKOI2k31M_-6sAp0WpfzyF1T8v2bgGwYVeyvdUKBV-WrpJcRiS4NTCwGc6BRFVVnPNRqIhUkf-3EL79NscnTkJFedesRJNXSpmfk2wdqpdYm0pUP0hUnCJ7nwUVrE8lGWOCmgqcMjcYVE5gOv2RllUsqVgx3nWTT2sszCZ-nPYTNraH3qFBT4dsLo8RrrMg2oTugUGlYL_kgdyGkbq3d1t2ijHVYKM_OwjuCHkLrl8fnAezDunG3nOaXV5QNCbLxvcExHcyqzvx6EUYYMihpDpxRLJzrRJeZSJBQ0HSeKSF9EC3P7k0KLhUcm28O7OeJKQZDmyCv_r7j1s=w1920-h900-no)

![](https://lh3.googleusercontent.com/ao-0m9RC7mMBKVT5madu8W8nPtsFcujkJayo9ZTVp1pI9rSZpQYDGwr0zyNYkID9KFSAygxuS-nS5gCB1AucqLoDo64EY8y7wVsAlv3tEaMDQ4nF3KmP7I79oijAS8_oYNKSdGDu4-YLtoy6GCc2uNF9ZQVkG-Kc-lDT7HVWyPA86mQK_As9FZcMaYCC0-BWcViPa-23WaFnWIfhIIsR6XUnePPXuzFpck4G_TDvxtY2q2On4xyIZLBKFxvSs_id76DE8zhPVhcBA3pQLpiQL4z3Y7YsPeP21Vm10ASXB0wssg3nCnDJoYxmJSuJ6XKroiET2UFWqiotVrPeCMW4TjjML1aKre0ujCQqz1Vz7mK2KjRsjECToEswVVtQGpKeItkAM1DbFVl3wGqinWFiUCShDCCUCzsyr9rUe-rCNmyDXeGIHtWa0X4Msx7dO76P2D9Sxf2UEaxXg9J85WPhZqJqb37Mo8QGxeo7lc5_yyDtM_7Nqi9zi9bmMjVn2kzrptAF-cpraEhFgnSQ2UF8CPLnTSGrtzF8613hnRyN4foF5XitY43KZS985lj9Dp1atuqrBz_7ANf79tzsA6Stysrv7AwwkBA0yQlFHOmWHUIHPVdbbDSzrMtpOrnRZdlk9xmdQEZ4KGaVY9av3C8hrqV0MtPNJFfyvvwE8zGnHmH9FjgMiVIWQYI=w1920-h902-no)

### Main Page : /moviemanage

### Method used
> GET /movie
> POST /movie
> PUT /movie/{movie_id}
> DELETE /movie/{movie_id}

![](https://lh3.googleusercontent.com/JUG83cVDi2pjOOuZLx6UTl8yLU47pk2_fNI6s0FfRd62_nPajF7ISlzRDBVyWyzN9RMCXA4TPALK_d548QLx_B9wTXIiIASfDMlMXgyg1XkNMpVrI7AwwgQd66PFBLCArSbDQCbJGRXj73ges9-ogFS5BHVlfTz524NogPCq9DisEgdqKpuwWQq4_KfaqiWlizT9-O5s1UIagZyHqa8eqnX4OBUlMPAX_2gCdl5euRNKx_o80beqcg8QQGC0VRmGBZ2XkSyYnY2yfWT2W83z1bobN5AVaHEiIDBIAlDDSk_i5C9kkMmdttSuzqb1OKBSAgSDglCcADVzXNe6yPzHHCpIqSeu5hEyHHPBXNzoyGLalY3BptdDFdqTQPAvwkhzvRcIEuDcSJ4mIx4Y_FrA0EFMSs64Xvp7sjUL7y-ImZt5P-YljOZZNj8OzZxYw6_QkpkfAQmbNg3iQthcI3rtF9s1bocogoLguwefQiGqTtBPmMm33Wv4ESqSbkbVxODZDg4JOjAjUSc5EaAKbw70XGLvtZcxl66dTfNIUsF3Rbq3lMdKhGJ-8YVTDji87eIBeUpJfJLdovN-mUwPT6pqywVrZYOiETkQR3O464DqAYcpEesSG-f2RXA3Vpnas1rVR255QjrEsKw1YjgYMcy3upfnQ7R3yPy6rmfv5sc6yqA4CcgS3vphXNM=w1920-h900-no)

### Main Page : /theaterManager

### Method used
> GET /theater
> POST /theater
> PUT /theater/{theater_id}
> DELETE /theater/{theater_id}

![](https://lh3.googleusercontent.com/WnOHT9-LaX9a-xewb-E3K-bEE1uQ3gUPhdRUMh-3mFaJUMcEij7SgVDkJQivxhYC_VEhaEl87xjkNn5ZpHz0U3_SkvwVdQAP3nDvCsPLiM8gPZ6acR1FK2wzETjI6dPPILMtTsPFHEbfoDdaiGoRYTLfFewZwQ-bYUE6TQ00-ixtUb6P1YqmURA_3dyDTzEGS9oJzdY4lfxjx60YyWxICASWW8bWoQA16M7W6PqN_F6WE8YB3ACnhYzf9PNgsgusmS0O1Xqt63kHqoWFiH9GsQ7kUIe54oNyTxxJ7SymLxX44oh6vZGxRR5myT3AxWdrfn_nyrYkg3Bzfcy1kOBAPqJ6904T0FwSW3CYvdG7Se1AgiT-dFAX_Jz7Q50E9qQxnHTtquI9WS2avNPI7JL4JVYOuchFA2WoHaZJMUxUFlT8L-_WWLSeiEnOZADDU0dhcTOL5sbrheb1rGhbGGwsA3VgArSvaIYMzNfn5js2VPXYGnIJ4k673SjwVKSr0mo2-kFLZ73DQFNJmzSLL9hz_athsOXviTRI1jSXps9LkC2C2K6EFLdk3nRSfBnCm3XRUThZ7EuzXcnOCt6S1M9sVzYClmNWzeaPpoxwlFUJ_4_JHOIpPxVn52lBEamIOS2hIu72P_qaPW4GTzhgBnmRn4-8Z5zDVMbMraQZPbNZ8Whyqc1t03ByacI=w1918-h900-no)

### Main Page : /showtimemanage

### Method used
> GET /showtime
> POST /showtime
> DELETE /showtime/{showtime_id}

![](https://lh3.googleusercontent.com/jMWY3iJK3flKrYMvPDSVv1Bfq_o_ytLLvjVvA084x7JYVQHkyqTcAPC4Ad2eaC6UCOGIlxtL_-sdRLFDUFdF4s5Y0phEjr5mq6co2mfchDADecyWB-H6DyZkYiNOAlnVCsMpDtHEAskOkQ7nMEEYpozK4Y4A2GvI1ye2ucrSsIx2gPVfgPwhWNG7aFbW1a0L83LRfxl7vXgkImoc1O_KdnHkd0BGdfT4AqFstzyIf-ZDzTlbW5R7Q4lBIsXjrOaCfUSSPkHkRIoi1-SwgP14FVis3If0jxC4B8wStZNEdabvNKUQcGa7iNVdTKcU39gPNBu59uhOGEDYucyfG7MrphVAGbcNLyw71oyBsCrHUTC4xk6UeVerUglVKNOr2uyNGAT-DtxkOO6CsgeT5AjYshzr4N1kNHlKLLHxDID5EOmxSBan1rekLtfnB7o131w9tNIw2s--8bG90tnc5QFzrjao-UhTD8jQ5Xn_NngHfIP3kwK0kzcMWMei8FAXxvLxaqAF2LcAZriwHjDh5vPM1K51kk8jloFheZXF9W29L3z90QkJqjjEzxCn0hO_ayGkTn-9z4HIp6c0i6Z26i5o3FUxtycRD4p3E3ugGT4453BdVOK87SesirWS_TfBvQLMoTSxndkCeHaIsGGmtnpYCF67zD-8I4yVW5Rb0yCSzdM9xJnfRSXm1Yo=w1920-h900-no)

### Main Page : /ticket-all

### Method used
> GET /u

![](https://lh3.googleusercontent.com/MmpYM3ag3CBjiA49XL5dnVvVycfC5ZVy3EdakeSq9C6qpqSlMSH27Uzr3_4Irnhz5hD4f6lr_ZBK2TC-dzYmgQpmWYBGOyHhfXXpC-rvTQGu3llplEM8XrNC3NN_yd1uLY6XUWwkRkAqT9gBobNjUACEcttuBxfBeuZPwSyWOAjSNlqz9TR7mJCBgnaUzeXtLO8BA8k6hStYkDclPZihBpYvVnmiZ_vykw8MAyZv0oBTGJxR5SFPGGdCLlJIoPKx82zokrT8vXoxz09q2vo-_uoxANJw_hUmKwI5mV4zmhrthTqRmMsQdPz8t9L8pBiZv7xq6GWMF5lYMINxIXj-Af0GiBln1B0JBXQVXWt6eoogl9e_o_cbB8YXoZ0abklK8LVlyz7aOzG5oavTqGMnVEHqzu48YowkCUSZ-FyBdDgpI8CIoO-SpPAjFeop8cCUv5G1X1_O0Ds2hoeiYiMF2B4BGsfNeqX-3eGAopHzg9nmWFVoxBqTx8mAYjO6y20dZzmmE461UBdiLtX2DLYiaZWo_KmWWyd4Hl6N1Ta4dahKiL3C62EujnSLN8Tlo2iInFRcrpj5oW5Oe4jyZ5cOX_giOJdfjXwwh7jlsVpXYx_9LnrCT_qXac9xOH8cvO-AbKvYiiwwTAbQ8oU1KYdHTMJH5M40fjZuxjVw-mdGIPNU41YES-H6MSU=w1920-h901-no)
