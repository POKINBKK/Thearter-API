# Thearter-API
Repository for Service Oriented Programming | ITKMITL 2019

## Usage

### List all Showtimes
URL : `/showtimes`

Method : `GET`

**Success Response**

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
